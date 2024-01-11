package engtelecom.bcd.lobinho.model;

import engtelecom.bcd.lobinho.model.distintivo.ProgressaoDistintivo;
import engtelecom.bcd.lobinho.model.especialidade.ProgressaoEspecialidade;
import engtelecom.bcd.lobinho.model.insignia.ProgressaoInsignia;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"alergias", "responsaveis", "progressaoEspecialidades",
        "progressaoInsignias", "progressaoDistintivos", "tipoSanguineo"})
public class Jovem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJovem;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false)
    private Date dataNascimento;

    @NonNull
    @Column(nullable = false, unique = true)
    private String CPF;

    private String telefone;

    private String email;

    @NonNull
    @Column(nullable = false)
    private String endereco;

    private Float peso; // kg

    private Integer altura; // cm

    @OneToMany(mappedBy = "jovem", fetch = FetchType.EAGER)
    private List<ProgressaoEspecialidade> progressaoEspecialidades;

    @OneToMany(mappedBy = "jovem", fetch = FetchType.EAGER)
    private List<ProgressaoInsignia> progressaoInsignias;

    @OneToMany(mappedBy = "jovem", fetch = FetchType.EAGER)
    private List<ProgressaoDistintivo> progressaoDistintivos;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_sanguineo")
    private TipoSanguineo tipoSanguineo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "jovem_alergias", joinColumns = {
            @JoinColumn(name = "id_jovem", referencedColumnName = "idJovem", nullable = false, updatable = false),
    }, inverseJoinColumns = {
            @JoinColumn(name = "id_alergia", referencedColumnName = "idAlergia", nullable = false, updatable = false)
    })
    private List<Alergia> alergias = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "jovem_responsaveis", joinColumns = {
            @JoinColumn(name = "id_jovem", referencedColumnName = "idJovem", nullable = false, updatable = false),
    }, inverseJoinColumns = {
            @JoinColumn(name = "id_responsavel", referencedColumnName = "idResponsavel", nullable = false, updatable = false)
    })
    private List<Responsavel> responsaveis = new ArrayList<>();

    public void adicionarResponsavel(Responsavel responsavel) {
        this.responsaveis.add(responsavel);
    }

    public void adicionarAlergia(Alergia alergia) {
        this.alergias.add(alergia);
    }

    @Override
    public String toString() {
        return "- Nome: " + this.getNome() + "\n" +
                "- Data de nascimento: " + this.getDataNascimento() + "\n" +
                "- CPF: " + this.getCPF() + "\n" +
                "- Endereço: " + this.getEndereco() + "\n" +
                "- Telefone: " + this.getTelefone() + "\n" +
                "- E-mail: " + this.getEmail() + "\n" +
                "- Peso: " + this.getPeso() + "\n" +
                "- Altura " + this.getAltura();
    }

}