package pe.isil.seguridad.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("WelcomeFrench")
public class WelcomeFr implements Welcome{
    @Override
    public String sayHello() {
        return "Bonjour";
    }

    @Override
    public String sayGoodbye() {
        return "Au revoir";
    }
}
