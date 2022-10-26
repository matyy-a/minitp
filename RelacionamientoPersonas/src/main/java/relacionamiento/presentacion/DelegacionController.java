package relacionamiento.presentacion;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import relacionamiento.domain.Persona;
import relacionamiento.domain.RepoPersonas;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DelegacionController {

    private final Handlebars handlebars;

    public DelegacionController() {
        this.handlebars = new Handlebars();

    }

    @GetMapping(value = "/delegaciones", produces = MediaType.TEXT_HTML_VALUE) //-> importante en Spring
    //public ResponseEntity<String> obtenerVistaDeTodas(@RequestParam("sesion") String idSesion) throws IOException {
    public ResponseEntity<String> obtenerVistaDeTodasDelegaciones() throws IOException {
        //validar accion en capa modelo según roles o usuario asociados al idSesion
        Template template = handlebars.compile("/templates/Plantillas/listadelegaciones");
        List<Persona> personas = RepoPersonas.getPersonas();

        Map<String, Object> model = new HashMap<>();
        model.put("listadelegaciones", personas);

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);

    }
}