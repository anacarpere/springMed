package med.voll.api.infra.exception;

public class EmailConstraintException extends RuntimeException{
    public EmailConstraintException(String message) {
        super(message);
    }
}
