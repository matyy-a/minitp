package relacionamiento.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoDelegaciones extends CrudRepository<Delegacion, Long> {
    List<Delegacion> findByAutorizante(Persona persona);
    List<Delegacion> findByAutorizado(Persona persona);
}
