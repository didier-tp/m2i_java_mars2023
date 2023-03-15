package eu.luminess.indus.exception;

//public class AgeInvalideException extends Exception {
public class AgeInvalideException extends RuntimeException {


    public AgeInvalideException() {
    }

    public AgeInvalideException(String message) {
        super(message);
    }

    public AgeInvalideException(String message, Throwable cause) {
        super(message, cause);
    }
}
