package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Convenio convenio;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome= dados.nome();
        this.sobrenome = dados.sobrenome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.convenio = dados.convenio();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarCadastro(DadosUpdatePaciente dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.sobrenome() != null){
            this.sobrenome = dados.sobrenome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.convenio() != null){
            this.convenio = dados.convenio();
        }
        if(dados.dadosEndereco() != null){
            this.endereco.atualizarEndereco(dados.dadosEndereco());
        }

    }
}
