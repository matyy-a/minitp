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
import relacionamiento.domain.RepoPersonas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Controller
public class DelegacionController {
    private final Handlebars handlebars = new Handlebars();
    @Autowired
    private RepoPersonas repoPersonas;

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
        List<Delegacion> delegaciones = new ArrayList<>();
        delegaciones.addAll(personaSesion.getDelegacionesAAceptarDeOtros());
        delegaciones.addAll(personaSesion.getDelegacionesAAceptarMias());
        delegaciones.addAll(personaSesion.getDelegacionesAprobadasDeOtros());
        delegaciones.addAll(personaSesion.getDelegacionesAprobadasMias());
        model.put("DelegacionesRegistradas", delegaciones);

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);

    }

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
        List<Persona> personas = RepoPersonas.getPersonas();

        Map<String, Object> model = new HashMap<>();
        model.put("DelegacionesRegistradas", personas);

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);

    }*/
}