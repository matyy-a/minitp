package relacionamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import relacionamiento.domain.*;

import java.time.LocalDate;

import static java.util.Arrays.asList;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    private RepoDelegaciones repoDelegaciones;
    @Autowired
    private RepoPersonas repoPersonas;

    @Override
    public void run(String... args) throws Exception {
        if(repoDelegaciones.count() == 0) {
            Persona juan = new Persona();
            juan.setNombre("Juan");
            juan.setApellido("Gomez");
            juan.setUser("juan");
            juan.setPassword("1234");
            juan.setDni("11222333");
            Persona carlos = new Persona();
            carlos.setNombre("Carlos");
            carlos.setApellido("Gomez");
            carlos.setDni("22333444");
            Persona mati = new Persona();
            mati.setNombre("Mati");
            mati.setApellido("Perez");
            mati.setDni("555888409");
            Persona juli = new Persona();
            juli.setNombre("juli");
            juli.setApellido("Amadeo");
            juli.setDni("45670978");
            juli.setUser("juli");
            juli.setPassword("1234");
            Delegacion delegacion1 = new Delegacion(juli, mati, Estado.ACTIVADO, LocalDate.now(), LocalDate.now());
            Delegacion delegacion2 = new Delegacion(mati, null, Estado.EN_ESPERA, LocalDate.now(), null);
            repoDelegaciones.saveAll(asList(delegacion1,delegacion2));

            juli.agregarDelegacionesAprobadasMias(delegacion1);
            juli.agregarDelegacionesAAceptarDeOtros(delegacion2);
            mati.agregarDelegacionesAprobadasDeOtros(delegacion1);
            mati.agregarDelegacionesAAceptarMias(delegacion2);

            repoPersonas.saveAll(asList(mati, carlos, juan,juli));

        }
    }
}
