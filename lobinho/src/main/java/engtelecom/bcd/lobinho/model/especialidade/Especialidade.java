package engtelecom.bcd.lobinho.model.especialidade;

import engtelecom.bcd.lobinho.enums.Modalidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"areaDoConhecimento", "requisitos"})
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidade;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Modalidade modalidade;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_area")
    private AreaDoConhecimento areaDoConhecimento;

    @OneToMany(mappedBy = "especialidade", fetch = FetchType.EAGER)
    private List<RequisitoEspecialidade> requisitos;

    public Especialidade(String nome, Modalidade modalidade, AreaDoConhecimento areaDoConhecimento) {
        this.nome = nome;
        this.modalidade = modalidade;
        this.areaDoConhecimento = areaDoConhecimento;
    }
}
