package pe.isil.seguridad.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.seguridad.model.User;
import pe.isil.seguridad.service.UserService;
import pe.isil.seguridad.service.Welcome;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller //cuando se haga llamados http lo primero que va a buscar son los controladores.
public class IndexController {

    @GetMapping({ "/", "/inicio", "/index"})
    public String index(Model model){

        model.addAttribute("name", "Eduardo");
        return "index";  // retornamos la vista index
    }

    /*
    Cómo envío información desde mi proyecto java a mi vista?
    Eso lo hacemos con el objeto Model
    Recibe 2 parámetros:
    - key: es un identificador del objeto que le voy a pasar (alias)
    - objeto
    */

    @GetMapping( "/home")
    public String home(){
        return "home";  // retornamos la vista home. (no es necesario poner home.html)
    }

    @GetMapping( "/lista")
    public String lista(Model model){

        List<String> list =new ArrayList<>();
        list.add("primer elemento");
        list.add("segundo elemento");

        String name = "Juan";

        model.addAttribute("list", list);
        model.addAttribute("name", name);
        return "lista";
    }

    @GetMapping( "/usarif")
    public String usarif(Model model){

        List<String> list =new ArrayList<>();
        list.add("primer elemento");
        list.add("segundo elemento");

        model.addAttribute("list", list);

        return "usarif";
    }

    //***************************************************************************************

    @GetMapping( "/random")
    public String randomNumber(Model model){

        int number=getRandomNumber();

        model.addAttribute("num", number);
        return "randomnumber";
    }

    public int getRandomNumber(){
        return (int) (Math.random() * 100);
    }

    //****************************************************************************************

    //Recorrer una lista

    @GetMapping( "/recorrer")
    public String recorrerLista(Model model){

       model.addAttribute("lstusers", getUsers());

       return "recorrerlista";
    }

    public List<User> getUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User(
                1,
                "Andres",
                "Carrion",
                "andreita@isil.pe",
                "123456",
                LocalDate.of(1990, 05, 4)
        );

        User user2 = new User(
                1,
                "Jose",
                "Suarez",
                "joselito@isil.pe",
                "123456",
                LocalDate.of(1978, 12, 18)
        );

        User user3 = new User(
                1,
                "Martha",
                "Sanchez",
                "martina@isil.pe",
                "123456",
                LocalDate.of(1980, 9, 23)
        );

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }

    //*************************************************************************************

    //con @Autowired le estamos diciendo a Spring que al inicializar la aplicación inyecte un bin (componente) que se llama "welcome" siempre y cuando yo le diga.
    //con @Qualifier y con un alias vamos a identificar q componente vamos a llamar. El alias lo ponemos al lado del servicio que queremos que llame.
    //con @Qualifier estoy diciendo que esta interfaz me va a inyectar la implementación de "WelcomeEng"
    //otra forma de  hacerlo es poniendo @Primary. Con esta notación automaticamente va a tomar por defecto el bin que tenga el @primary
    //@Qualifier("WelcomeEnglish")
    @Autowired
    private Welcome welcome;    //estamos creando un objeto de tipo welcome y queremos usar sus implementaciones.

    @GetMapping( "/welcome")
    public String welcome(Model model){

        // Welcome welcome = new WelcomeEsp();      con spring no es necesario crear una nueva instancia del objeto. para ello utilizamos @Autowired

        model.addAttribute("saludo", welcome.sayHello());
        model.addAttribute("despedida", welcome.sayGoodbye());

        return "welcome";
    }

    //***************************************************************************************

    //Para ver la tabla de nuestra base de datos
    //en @Qualifier utilizamos "userServiceDao"
    @Qualifier("userServiceDao")
    @Autowired
    private UserService userService;

    @GetMapping( "/user")
    public String user(Model model){

        model.addAttribute("lstusers", userService.getUsers());

        return "recorrerlista";
    }
}

