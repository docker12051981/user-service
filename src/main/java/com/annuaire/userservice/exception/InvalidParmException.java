package com.annuaire.userservice.exception;

/**
 * @author karim hmadi

 * @description exception invalid param

 */
public class InvalidParmException extends Exception {

    private static final long serialVersionUID = 1L;

    private Object obj;

    public InvalidParmException(Object ob, String message) {

        super(message);
        obj = ob;
    }

    public Object getObj() {

        return obj;
    }
}
