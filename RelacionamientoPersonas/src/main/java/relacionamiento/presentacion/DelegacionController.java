package relacionamiento.presentacion;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import relacionamiento.domain.Delegacion;
import relacionamiento.domain.Persona;
import relacionamiento.domain.RepoDelegaciones;
import relacionamiento.domain.RepoPersonas;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DelegacionController {
    private final Handlebars handlebars = new Handlebars();
    @Autowired
    private RepoPersonas repoPersonas;
    @Autowired
    private RepoDelegaciones repoDelegaciones;

    @GetMapping(value = "/delegaciones", produces = MediaType.TEXT_HTML_VALUE) //-> importante en Spring
    public ResponseEntity<String> obtenerVistaDeTodas(@RequestParam("sesion") String idSesion) throws IOException {
        Map<String, Object> atributosSesion = SesionManager.get().obtenerAtributos(idSesion);

        Persona personaSesion = (Persona) atributosSesion.get("persona");
        System.out.println("Obteniendo datos de: " + personaSesion);

        if (personaSesion == null) {
            return ResponseEntity.status(404).build();
        }

        //validar accion en capa modelo según roles o usuario asociados al idSesion -- validar persona/admin

        Template template = handlebars.compile("/templates/DelegacionesRegistradas");

        Map<String, Object> model = new HashMap<>();
        List<Delegacion> delegacionesAutorizantes = repoDelegaciones.findByAutorizante(personaSesion);
        List<Delegacion> delegacionesAutorizadas = repoDelegaciones.findByAutorizado(personaSesion);
        List<Delegacion> delegaciones = new ArrayList<>();

        delegaciones.addAll(delegacionesAutorizadas);
        delegaciones.addAll(delegacionesAutorizantes);
        model.put("DelegacionesRegistradas", delegaciones);

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);
    }

    @GetMapping(value = "/delegaciones/nueva", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> mostrarPantalla (@RequestParam("sesion") String idSesion) throws Exception {
        Map<String, Object> atributosSesion = SesionManager.get().obtenerAtributos(idSesion);

        Persona personaSesion = (Persona) atributosSesion.get("persona");
        System.out.println("Obteniendo datos de: " + personaSesion);

        if (personaSesion == null) {
            return ResponseEntity.status(404).build();
        }
        Template template = handlebars.compile("/templates/nuevaDelegacion");

        Map<String, Object> model = new HashMap<>();

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);
    }


    @Transactional
    @PostMapping(value = "/delegaciones/nueva", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> nuevaDelegacion(@RequestParam("sesion") String idSesion, Persona persona) throws Exception{

        Map<String, Object> atributosSesion = SesionManager.get().obtenerAtributos(idSesion);

        Delegacion delegacionSesion = (Delegacion) atributosSesion.get("persona");
        System.out.println("Obteniendo datos de: " + delegacionSesion);

        if (delegacionSesion == null) {
            return ResponseEntity.status(404).build();
        }

        //validar accion en capa modelo según roles o usuario asociados al idSesion -- validar persona/admin

        Template template = handlebars.compile("/templates/nuevaDelegacion");
        Map<String, Object> model = new HashMap<>();

        delegacionSesion.getAutorizado().setNombre(persona.getNombre());
        delegacionSesion.getAutorizado().setApellido(persona.getApellido());
        delegacionSesion.getAutorizado().setDni(persona.getDni());

        repoDelegaciones.save(delegacionSesion);

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);
    }
    //-> importante en Spring


/*

    private final Handlebars handlebars;

    public DelegacionController() {
        this.handlebars = new Handlebars();

    }

    @GetMapping(value = "/delegaciones", produces = MediaType.TEXT_HTML_VALUE) //-> importante en Spring
    //public ResponseEntity<String> obtenerVistaDeTodas(@RequestParam("sesion") String idSesion) throws IOException {
    public ResponseEntity<String> obtenerVistaDeTodasDelegaciones() throws IOException {
        //validar accion en capa modelo según roles o usuario asociados al idSesion
        Template template = handlebars.compile("/templates/DelegacionesRegistradas");
        Iterable<Persona> personas = repoPersonas.findAll();

        Map<String, Object> model = new HashMap<>();
        model.put("DelegacionesRegistradas", personas);

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);

    }

 */
}