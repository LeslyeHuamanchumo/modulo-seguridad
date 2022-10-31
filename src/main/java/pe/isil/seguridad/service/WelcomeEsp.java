package pe.isil.seguridad.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeEsp implements Welcome{
    @Override
    public String sayHello() {
        return "Hola";
    }

    @Override
    public String sayGoodbye() {
        return "Adios";
    }
}
