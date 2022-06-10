package click.boardexam.exception;

public class UidNotFoundException extends RuntimeException{

    public UidNotFoundException() {
    }
    public UidNotFoundException(String message) {
        super(message);
    }
}
