package relacionamiento.presentacion;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.springframework.web.bind.annotation.*;
import relacionamiento.domain.Delegacion;
import relacionamiento.domain.Persona;
import relacionamiento.domain.RepoPersonas;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class PersonaController {
  private RepoPersonas repoPersonas;
  private Handlebars handlebars = new Handlebars();

  @GetMapping(value = "/misDatos/personas", produces = MediaType.TEXT_HTML_VALUE)
  public ResponseEntity<String> mostrarPantalla (@RequestParam("sesion") String idSesion) throws Exception {
    Map<String, Object> atributosSesion = SesionManager.get().obtenerAtributos(idSesion);

    Persona personaSesion = (Persona) atributosSesion.get("persona");
    System.out.println("Obteniendo datos de: " + personaSesion);

    if (personaSesion == null) {
      return ResponseEntity.status(404).build();
    }
    Template template = handlebars.compile("/templates/actualizarDatos");

    Map<String, Object> model = new HashMap<>();

    String html = template.apply(model);

    return ResponseEntity.status(200).body(html);
  }

  @PostMapping (value = "/misDatos/personas")
  @Transactional
  public ResponseEntity<String> actualizarMisDatos (@RequestParam("sesion") String idSesion, Persona persona) throws Exception{
    Map<String, Object> atributosSesion = SesionManager.get().obtenerAtributos(idSesion);

    Persona personaSesion = (Persona) atributosSesion.get("persona");
    System.out.println("Obteniendo datos de: " + personaSesion);

    if (personaSesion == null) {
      return ResponseEntity.status(404).build();
    }

    //validar accion en capa modelo según roles o usuario asociados al idSesion -- validar persona/admin

    Template template = handlebars.compile("/templates/actualizarDatos");

    Map<String, Object> model = new HashMap<>();

    personaSesion.setFoto(persona.getFoto());
    personaSesion.setNacimiento(persona.getNacimiento());
    personaSesion.setCiudad(persona.getCiudad());
    personaSesion.setLocalidadResidencia(persona.getLocalidadResidencia());

    System.out.println("Obteniendo datos de: " + personaSesion.getNacimiento());
    repoPersonas.save(personaSesion);
    String html = template.apply(model);

    return ResponseEntity.status(200).body(html);
  }

/*
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
 //public ResponseEntity<String> obtenerVistaDeTodas(@RequestParam("sesion") String idSesion) throws IOException {
 public ResponseEntity<String> obtenerVistaDeTodas() throws IOException {
  //validar accion en capa modelo según roles o usuario asociados al idSesion
  Template template = handlebars.compile("/templates/listapersonas");
  List<Persona> personas = RepoPersonas.obtenerTodas();

  Map<String, Object> model = new HashMap<>();
  model.put("listapersonas", personas);

  String html = template.apply(model);

  return ResponseEntity.status(200).body(html);

 }*/
}
