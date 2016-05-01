package org.digitalpanda.springlab.spittr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -3062435766837674731L;

    public SpittleNotFoundException(){}
        
    public SpittleNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
