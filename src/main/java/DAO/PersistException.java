package DAO;

/**
 * Created by Alexander on 23.03.2015.
 */
public class PersistException extends Exception {
    public PersistException() {

    }

    public PersistException(String message) {
        super(message);
    }

    public PersistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistException(Throwable cause) {
        super(cause);
    }

    public PersistException(String message, Throwable cause, boolean enableSuppression, boolean writabeStackTrace) {
        super(message, cause, enableSuppression, writabeStackTrace);
    }
}
