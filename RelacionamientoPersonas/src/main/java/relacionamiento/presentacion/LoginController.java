package relacionamiento.presentacion;


import com.github.jknack.handlebars.Handlebars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import relacionamiento.domain.Persona;
import relacionamiento.domain.RepoPersonas;
import relacionamiento.presentacion.dto.LoginRequest;
import relacionamiento.presentacion.dto.LoginResponse;
import com.github.jknack.handlebars.Template;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private RepoPersonas repoPersonas;
    private final Handlebars handlebars = new Handlebars();
    public LoginController() {
    }

    @GetMapping("/login")
    public ResponseEntity<String> login() throws IOException {
        //validar accion en capa modelo según roles o usuario asociados al idSesion
        Template template = handlebars.compile("/templates/login");

        Map<String, Object> model = new HashMap<>();
        //model.put("listamascotas", mascotas);

        String html = template.apply(model);

        return ResponseEntity.status(200).body(html);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {

        //validamos user/pass y buscamos datos de ese usuario para agregar en la sesión

        //Persona persona = repoPersonas.findByUserAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        //System.out.println("Login: " + loginRequest);
        //System.out.println("Login: " + persona);

        // TODO: Ir a la base de datos y validar usaurio y contraseña

        String nombreUsuario = loginRequest.getUsername();
        String contrasenna = loginRequest.getPassword();

        System.out.println(nombreUsuario);
        System.out.println(contrasenna);
        System.out.println(loginRequest);

        Persona persona = repoPersonas.findByUserAndPassword(nombreUsuario, contrasenna);

        if (persona != null || true) {
            // Guardan en la sesion de Spark como cookie en el lado del cliente y guarda registro en el back
            // /loginRequest.session().attribute("keyUsuarioActual", persona);

            SesionManager sesionManager = SesionManager.get();
            System.out.println(sesionManager);
            String idSesion = sesionManager.crearSesion("persona", persona);
            return new LoginResponse(idSesion);
        }

//        sesionManager.agregarAtributo("fechaInicio", new Date());
//        sesionManager.agregarAtributo("rol", repoRoles.getByUser(idUser));

        throw new Exception("Usuario no valido");
    }

}