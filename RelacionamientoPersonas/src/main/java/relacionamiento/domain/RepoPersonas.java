package relacionamiento.domain;

import java.util.List;

public class RepoPersonas {
    private static List<Persona> personas;

    private static final RepoPersonas INSTANCE = new RepoPersonas();

    public static RepoPersonas getInstance() {
        return INSTANCE;
    }

    public Persona findByDniAndNombreCompleto(Persona persona){
        return personas.stream().filter(p -> p.getDni().equals(persona.getDni())).findFirst().get();
    }

    public static List<Persona> getPersonas() {
        return personas;
    }
}
