package relacionamiento.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDelegaciones extends CrudRepository<Delegacion, Long> {

}
