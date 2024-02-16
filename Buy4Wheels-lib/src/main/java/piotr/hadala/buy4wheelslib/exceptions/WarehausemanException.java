package piotr.hadala.buy4wheelslib.exceptions;

public class WarehausemanException extends RuntimeException {
    public WarehausemanException(String message) {
        super(message);
    }

    public WarehausemanException(String message, Throwable cause) {
        super(message, cause);
    }

    public WarehausemanException(Throwable cause) {
        super(cause);
    }

    public WarehausemanException() {
    }
}
