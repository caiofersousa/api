package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name="medico")
@Entity(name = "Medico")
@Getter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    @Enumerated
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(Object o, DadosCadastroMedico dados) {
        this.crm = dados.crm();
        this.email = dados.email();;
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }
}
