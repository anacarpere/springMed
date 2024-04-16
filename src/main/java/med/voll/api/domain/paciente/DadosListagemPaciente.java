package med.voll.api.domain.paciente;

public record DadosListagemPaciente(
        Long id,
        String nome,
        String sobrenome,
        String email,
        Convenio convenio,
        String telefone) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getSobrenome(), paciente.getEmail(), paciente.getConvenio(), paciente.getTelefone());
    }
}
