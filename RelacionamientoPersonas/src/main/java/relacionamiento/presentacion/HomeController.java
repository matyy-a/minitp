package relacionamiento.presentacion;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import relacionamiento.domain.Delegacion;
import relacionamiento.domain.Persona;
import relacionamiento.domain.RepoDelegaciones;
import relacionamiento.domain.RepoPersonas;
import relacionamiento.presentacion.SesionManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

  private final Handlebars handlebars = new Handlebars();

  @GetMapping(value = "/home", produces = MediaType.TEXT_HTML_VALUE) //-> importante en Spring
  public ResponseEntity<String> obtenerVistaDeTodas(@RequestParam("sesion") String idSesion) throws IOException {
    Map<String, Object> atributosSesion = SesionManager.get().obtenerAtributos(idSesion);

    Persona personaSesion = (Persona) atributosSesion.get("persona");
    System.out.println("Obteniendo datos de: " + personaSesion);

    if (personaSesion == null) {
      return ResponseEntity.status(404).build();
    }

    Template template = handlebars.compile("/templates/homePersona");

    Map<String, Object> model = new HashMap<>();

    String html = template.apply(model);

    return ResponseEntity.status(200).body(html);
  }
}
