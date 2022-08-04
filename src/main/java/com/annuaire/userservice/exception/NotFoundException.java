package com.annuaire.userservice.exception;

import java.util.function.Supplier;

/**
 * @author karim hmadi

 * @description exception not found

 */
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Supplier<String> supplier) {
        super(supplier.get());
    }

    public static void when(boolean expression, String message) {
        if (expression) throw new NotFoundException(message);
    }

    public static void whenNot(boolean expression, String message) {
        if (!expression) throw new NotFoundException(message);
    }

}
