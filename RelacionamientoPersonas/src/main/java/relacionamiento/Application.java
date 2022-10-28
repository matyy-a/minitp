package relacionamiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import relacionamiento.domain.PersonaJson;

import java.io.IOException;

@SpringBootApplication
public class Application{

  public static void main(String[] args) throws IOException {
    SpringApplication.run(Application.class, args);

    PersonaJson personita = new PersonaJson("aa", " ", "");

    personita.imprimirListaDePersonasJson();
  }

}