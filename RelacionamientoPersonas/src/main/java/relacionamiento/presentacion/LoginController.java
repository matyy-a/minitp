package relacionamiento.presentacion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import relacionamiento.domain.Persona;
import relacionamiento.domain.RepoPersonas;
import relacionamiento.presentacion.dto.LoginRequest;
import relacionamiento.presentacion.dto.LoginResponse;

import javax.xml.ws.soap.Addressing;
import java.util.Date;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private RepoPersonas repoPersonas;

    public LoginController() {
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        //validamos user/pass y buscamos datos de ese usuario para agregar en la sesión

        Persona persona = repoPersonas.findByUserAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        System.out.println("Login: " + loginRequest);
        System.out.println("Login: " + persona);

        SesionManager sesionManager = SesionManager.get();
        String idSesion = sesionManager.crearSesion("persona", persona);

//        sesionManager.agregarAtributo("fechaInicio", new Date());
//        sesionManager.agregarAtributo("rol", repoRoles.getByUser(idUser));

        return new LoginResponse(idSesion);
    }

}