package pe.isil.seguridad.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("WelcomeEnglish")
public class WelcomeEng implements Welcome{

    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public String sayGoodbye() {
        return "Goodbye";
    }
}
