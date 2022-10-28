package relacionamiento.domain;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RepoPersonaJson {

  private List<PersonaJson> personasJson = new ArrayList<>();

  public void cargarRepoPersonas() throws ParseException, IOException {
    JSONParser parser = new JSONParser();
    JSONObject reader = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream("/home/rodri/Escritorio/UTN/3er Año/Diseño de Sistemas/Cursada-2022/minitp/RelacionamientoPersonas/src/main/resources/personas.json")));
    Object obj = parser.parse(String.valueOf(reader));
    JSONObject pJsonObj = (JSONObject)obj;
    JSONArray jsonPrueba = (JSONArray)pJsonObj.get("data");

    for(int i = 0; i < jsonPrueba.size(); i++){
      JSONObject persona = (JSONObject)jsonPrueba.get(i);

      String nombre = (String) persona.get("Nombre");
      String apellido = (String) persona.get("Apellido");
      String dni = (String) persona.get("DNI");

      personasJson.add(new PersonaJson(dni, nombre, apellido));

    }
  }
}