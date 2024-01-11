package engtelecom.bcd.lobinho.model.insignia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgressaoInsigniaId implements Serializable {

    private Long jovem;

    private Long requisito;

}
