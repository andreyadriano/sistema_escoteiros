package engtelecom.bcd.lobinho.repository;

import engtelecom.bcd.lobinho.model.Alergia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlergiaRepository extends CrudRepository<Alergia, Long> {

    Optional<Alergia> findByAlergia(String alergia);

}
