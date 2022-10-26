package relacionamiento.domain;

import java.util.List;

import static java.util.Arrays.asList;

public class RepoPersonas {
    private static List<Persona> personas;

    private static final RepoPersonas INSTANCE = new RepoPersonas();

    public static RepoPersonas getInstance() {
        return INSTANCE;
    }

    public static List<Persona> obtenerTodas(){
        Persona juan = new Persona();
        juan.setNombre("Juan");
        juan.setApellido("Gomez");
        juan.setDni("11222333");
        Persona carlos = new Persona();
        carlos.setNombre("Carlos");
        carlos.setApellido("Gomez");
        carlos.setDni("22333444");
        return asList(juan, carlos);
    }

    public Persona findByDniAndNombreCompleto(Persona persona){
        return personas.stream().filter(p -> p.getDni().equals(persona.getDni())).findFirst().get();
    }

    public static List<Persona> getPersonas() {
        return personas;
    }
}
