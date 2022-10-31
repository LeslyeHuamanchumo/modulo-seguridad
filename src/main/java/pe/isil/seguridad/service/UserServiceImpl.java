package pe.isil.seguridad.service;

import org.springframework.stereotype.Service;
import pe.isil.seguridad.model.User;

import java.time.LocalDate;
import java.util.List;

@Service("userServiceLocal")
public class UserServiceImpl implements UserService{
    @Override
    public List<User> getUsers() {
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

        User user4 = new User(
                1,
                "Kevin",
                "Smith",
                "kevin@isil.pe",
                "123456",
                LocalDate.of(1984, 8, 18)
        );

        return List.of(user1,user2,user3,user4);
    }
}
