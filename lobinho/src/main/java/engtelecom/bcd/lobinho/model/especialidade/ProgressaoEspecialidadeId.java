package engtelecom.bcd.lobinho.model.especialidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgressaoEspecialidadeId implements Serializable {

    private Long jovem;

    private Long requisito;

}
