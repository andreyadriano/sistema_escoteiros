package engtelecom.bcd.lobinho.repository.especialidade;

import engtelecom.bcd.lobinho.model.especialidade.Especialidade;
import engtelecom.bcd.lobinho.model.especialidade.RequisitoEspecialidade;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RequisitoEspecialidadeRepository extends CrudRepository<RequisitoEspecialidade,Long> {

    Iterable<RequisitoEspecialidade> findByEspecialidade(Especialidade especialidade);

}
