package engtelecom.bcd.lobinho.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"jovens"})
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsavel;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false, unique = true)
    private String CPF;

    @NonNull
    @Column(nullable = false)
    private String telefone;

    @NonNull
    @Column(nullable = false)
    private String email;

    @ManyToMany(mappedBy = "responsaveis", fetch = FetchType.EAGER)
    private List<Jovem> jovens = new ArrayList<>();
}
