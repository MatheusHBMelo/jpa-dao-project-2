package br.com.theuzstore.exceptions;

import java.io.Serial;

public class ForeignKeyConstraintException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ForeignKeyConstraintException(String msg){
        super(msg);
    }
}
