package org.example;

import java.util.List;

public class RepoPersonas {
    private List<Persona> personas;

    private static final RepoPersonas INSTANCE = new RepoPersonas();

    public static RepoPersonas getInstance() {
        return INSTANCE;
    }

    public Persona findByDniAndNombreCompleto(Persona persona){
        return personas.stream().filter(p -> p.getDni().equals(persona.getDni())).findFirst().get();
    }
}
