package co.edu.unisabana.usuario.service;

import co.edu.unisabana.usuario.service.model.User;
import co.edu.unisabana.usuario.service.user.port.MongoPort;
import co.edu.unisabana.usuario.service.user.port.RegisterUserPort;
import co.edu.unisabana.usuario.service.user.RegisterUserService;
import co.edu.unisabana.usuario.util.FactoryTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RegisterUserServiceTest {

  @InjectMocks
  private RegisterUserService service;

  @Mock
  private RegisterUserPort registerUserPort;

  @Mock
  private MongoPort mongoPort;

  @Test
  public void Given_name_isEmpty_When_RegisterUser_Then_throwException() {
    User user = new User();
    user.setName("");
    assertThrows(IllegalArgumentException.class, () -> {
      service.registerUser(user);
    });
  }

  @Test
  public void Given_age_is_minior_18_When_RegisterUser_Then_RuntimeException() {
    User user = new User();
    user.setName("Daniel");
    user.setAge(17);
    assertThrows(RuntimeException.class, () -> {
      service.registerUser(user);
    });
  }

  /**
   * Preparar la data Invocar la prueba Verificar resultados
   * :Asserts(assertEquals,assertTrue,assertFalse,assertThrows) Verify(Garantizar que se invoco
   * algo, adicional, verifican que se invoco con la data correcta)
   */
  @Test
  public void Given_data_ok_When_RegisterUser_Then_successful() {
    User user = FactoryTest.createUser(false);
    Mockito.when(registerUserPort.addNewUser(user)).thenReturn(true);
    int result = service.registerUser(user);

    Mockito.verify(registerUserPort).addNewUser(user);
    assertEquals(10, result);
  }


  /**
   * ¿Cuantas pruebas unitarias debe tener un metodo? Cuantas salidas /variaciones tiene su codigo
   */
  @Test
  public void Give_dontSendCorrectIinformantion_When_Registeruser_Then_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> {
      service.registerUser(new User());
    });
  }

  @Test
  public void Give_SendCorrectIinformantion_When_Registeruser_Then_throwRuntime() {
    User user = new User();
    user.setName("Daniel");

    assertThrows(RuntimeException.class, () -> {
      service.registerUser(user);
    });
  }

  //Tenemos el registro de usuario y ahora nos piden que si son VIP
  // debemos registrarlos es
  //en el mongo y sino, registrarlos en lo que se hace actualmente que es el
  // SQL Server.

  @Test
  void given_usuario_premium_when_registerUser_then_saveinmongo_and_return_10() {
    User user = FactoryTest.createUser(true);
    Mockito.when(mongoPort.addNewUser(user)).thenReturn(true);
    int result = service.registerUser(user);
    assertEquals(11, result);
    Mockito.verify(mongoPort).addNewUser(user);
  }


}
