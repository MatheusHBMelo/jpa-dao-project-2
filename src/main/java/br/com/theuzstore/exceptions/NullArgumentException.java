package br.com.theuzstore.exceptions;

import java.io.Serial;

public class NullArgumentException extends IllegalArgumentException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NullArgumentException(String msg){
        super(msg);
    }
}
