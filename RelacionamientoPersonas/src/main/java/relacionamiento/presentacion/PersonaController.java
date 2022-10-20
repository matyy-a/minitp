package relacionamiento.presentacion;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import relacionamiento.domain.Persona;
import relacionamiento.domain.RepoPersonas;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonaController {

 // private final RepoPersonas repoPersonas;
 private final Handlebars handlebars;
 public PersonaController() {
  this.handlebars = new Handlebars();
 }

//    Rest API controller:

//    @GetMapping("/mascotas")
//    public ResponseEntity<List<Mascota>> obtenerTodas() {
//        return ResponseEntity.status(200).body(repoMascotas.obtenerTodas());
//    }

 @GetMapping(value = "/personas", produces = MediaType.TEXT_HTML_VALUE) //-> importante en Spring
 public ResponseEntity<String> obtenerVistaDeTodas(@RequestParam("sesion") String idSesion) throws IOException {

  //validar accion en capa modelo según roles o usuario asociados al idSesion
  Template template = handlebars.compile("/templates/TempladePersoRegistradas/listapersonas");
  List<Persona> personas = RepoPersonas.getPersonas();

  Map<String, Object> model = new HashMap<>();
  model.put("listapersonas", personas);

  String html = template.apply(model);

  return ResponseEntity.status(200).body(html);

 }
}
