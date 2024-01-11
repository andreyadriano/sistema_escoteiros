package engtelecom.bcd.lobinho.model.distintivo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgressaoDistintivoId implements Serializable {

    private Long jovem;

    private Long requisito;
}
