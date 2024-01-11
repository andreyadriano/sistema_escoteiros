package engtelecom.bcd.lobinho.repository.insignia;

import engtelecom.bcd.lobinho.model.Jovem;
import engtelecom.bcd.lobinho.model.insignia.ProgressaoInsignia;
import engtelecom.bcd.lobinho.model.insignia.ProgressaoInsigniaId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProgressaoInsigniaRepository extends CrudRepository<ProgressaoInsignia, ProgressaoInsigniaId> {

    List<ProgressaoInsignia> findAllByJovem(Jovem jovem);

}
