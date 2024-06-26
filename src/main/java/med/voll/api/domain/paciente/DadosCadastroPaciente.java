package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull
        Convenio convenio,
        @NotNull
        @Valid
        DadosEndereco endereco ) {
}
