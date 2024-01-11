package engtelecom.bcd.lobinho.repository;

import engtelecom.bcd.lobinho.model.Jovem;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JovemRepository extends CrudRepository<Jovem, Long> {

    Optional<Jovem> findByCPF(String cpf);

}