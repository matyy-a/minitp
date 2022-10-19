package relacionamiento.presentacion;

import relacionamiento.domain.RepoPersonas;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PersonaController {

  private final RepoPersonas repoPersonas;
}
