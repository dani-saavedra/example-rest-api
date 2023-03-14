package co.edu.unisabana.usuario.service.user;

import co.edu.unisabana.usuario.service.model.User;
import co.edu.unisabana.usuario.service.user.port.MongoPort;
import co.edu.unisabana.usuario.service.user.port.RegisterUserPort;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

  private final RegisterUserPort registerUserPort;
  private final MongoPort mongoPort;

  RegisterUserService(RegisterUserPort registerUserPort, MongoPort mongoPort) {
    this.registerUserPort = registerUserPort;
    this.mongoPort = mongoPort;//shadowing Como es en c#?
  }

  //Tenemos el registro de usuario y ahora nos piden que si son VIP debemos registrarlos es
  //en el mongo y sino, registrarlos en lo que se hace actualmente que es el SQL Server.
  public int registerUser(User user) {
    if (user.getName() == null || user.getName().isEmpty()) {
      throw new IllegalArgumentException("The name cannot be empty");
    }
    if (user.getAge() < 18) {
      throw new RuntimeException("The age cannot be minior 18");
    }

    boolean result;
    if (user.isVip()) {
      result = mongoPort.addNewUser(user);
    } else {
      result = registerUserPort.addNewUser(user);
    }
    // envio correo electronico

    if (result) {
      return 10;
    } else {
      return 3;
    }
  }
}