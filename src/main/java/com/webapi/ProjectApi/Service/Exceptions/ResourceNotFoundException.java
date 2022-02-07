package com.webapi.ProjectApi.Service.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(Object id){
    super("Recurso não encontrado ID "+id);
  }

}
