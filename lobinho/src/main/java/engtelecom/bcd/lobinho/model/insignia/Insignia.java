package engtelecom.bcd.lobinho.model.insignia;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"requisitos"})
public class Insignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInsignia;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "insignia", fetch = FetchType.EAGER)
    List<RequisitoInsignia> requisitos;
}
