package br.com.theuzstore.exceptions;

import java.io.Serial;

public class ClienteNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ClienteNotFoundException(String msg){
        super(msg);
    }
}
