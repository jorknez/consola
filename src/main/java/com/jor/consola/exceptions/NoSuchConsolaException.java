package com.jor.consola.exceptions;

public class NoSuchConsolaException extends RuntimeException {
    private static final long serialVersionUID = -6063212819282349160L;
	private String message;

    public NoSuchConsolaException() {}

    public NoSuchConsolaException(String msg) {
        super(msg);
        this.message = msg;
    }

}
