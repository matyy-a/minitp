package relacionamiento;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import relacionamiento.domain.PersonaJson;
import relacionamiento.domain.RepoPersonaJson;

import java.io.IOException;

@SpringBootApplication
public class Application{

  public static void main(String[] args) throws IOException, ParseException {
    SpringApplication.run(Application.class, args);

}

}