package engtelecom.bcd.lobinho.repository;

import engtelecom.bcd.lobinho.model.Responsavel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResponsavelRepository extends CrudRepository<Responsavel, Long> {

    Optional<Responsavel> findByCPF(String cpf);

}
