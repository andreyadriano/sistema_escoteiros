package engtelecom.bcd.lobinho.repository;

import engtelecom.bcd.lobinho.model.TipoSanguineo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TipoSanguineoRepository extends CrudRepository<TipoSanguineo, Long> {

    Optional<TipoSanguineo> findByTipo(String tipo);

}
