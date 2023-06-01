package br.com.theuzstore.exceptions;

import java.io.Serial;

public class CompraNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public CompraNotFoundException(String msg){
        super(msg);
    }
}
