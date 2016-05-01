package org.digitalpanda.springlab.spittr;

public class DuplicateSpittleException extends RuntimeException {
   private static final long serialVersionUID = -7833232980290034211L;

   public DuplicateSpittleException(){}

   public DuplicateSpittleException(String exceptionMessage){
       super(exceptionMessage);
   }
}

