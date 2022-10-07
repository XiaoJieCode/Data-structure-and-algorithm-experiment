package ch01;

public class StudentAddException extends Exception{
    public StudentAddException() {
        super();
    }

    public StudentAddException(String message) {
        super(message);
    }

    public StudentAddException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentAddException(Throwable cause) {
        super(cause);
    }

    protected StudentAddException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
