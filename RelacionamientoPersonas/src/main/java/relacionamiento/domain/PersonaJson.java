package relacionamiento.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersonaJson {
    private String dni;
    private String nombre;
    private String apellido;

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    String jsonPrueba =
    "{'data':[{ 'Nombre': 'Ignacio',"
            +  "'Apellido': 'askjsa',"
            +  "'DNI': '11111111'},"
            + "{'Nombre': 'Mercedes',"
            +  "'Apellido': 'askjsa',"
            +   "'DNI': '22222222'}]}";

    public PersonaJson(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    PersonaJson[] listaDePersonas = gson.fromJson(jsonPrueba, PersonaJson[].class);

    public void imprimirListaDePersonasJson(){

        for(PersonaJson persona : listaDePersonas) {
            System.out.println(persona);
        }
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
