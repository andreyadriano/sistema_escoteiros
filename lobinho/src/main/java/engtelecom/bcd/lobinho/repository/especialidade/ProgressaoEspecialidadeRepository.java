package engtelecom.bcd.lobinho.repository.especialidade;

import engtelecom.bcd.lobinho.model.Jovem;
import engtelecom.bcd.lobinho.model.especialidade.ProgressaoEspecialidade;
import engtelecom.bcd.lobinho.model.especialidade.ProgressaoEspecialidadeId;
import engtelecom.bcd.lobinho.model.especialidade.RequisitoEspecialidade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProgressaoEspecialidadeRepository extends CrudRepository<ProgressaoEspecialidade, ProgressaoEspecialidadeId> {

    List<ProgressaoEspecialidade> findAllByJovem(Jovem j);

    Optional<ProgressaoEspecialidade> findByJovemAndRequisito(Jovem j, RequisitoEspecialidade r);

}
