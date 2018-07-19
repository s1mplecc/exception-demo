package info.s1mple.exceptiondemo.domian.exception;

public class RequestArgsIllegalException extends Exception {
    public RequestArgsIllegalException(String message) {
        super(message);
    }

    public RequestArgsIllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return "Illegal request arguments: " + super.getMessage();
    }
}
