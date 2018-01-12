package lv.prog.lesson16.exceptions;

public abstract class QuadExceptions extends RuntimeException {
    protected QuadExceptions(String message) {
        super(message);
    }
}
