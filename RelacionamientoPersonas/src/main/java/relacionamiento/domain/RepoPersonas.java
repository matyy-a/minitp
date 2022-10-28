package relacionamiento.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Arrays.asList;

@Repository
public interface RepoPersonas extends CrudRepository<Persona, Long> {
    Persona findByUserAndPassword(String user,String password);

}
