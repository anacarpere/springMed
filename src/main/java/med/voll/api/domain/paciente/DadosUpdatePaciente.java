package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.DadosEndereco;

public record DadosUpdatePaciente(
        Long id,
        String nome,
        String sobrenome,
        String email,
        String telefone,
        Convenio convenio,
        DadosEndereco dadosEndereco
) {
}
