package org.example.external.services;

public abstract class GeneralizedService<T extends RequestResponseValidator> {
   public Object sequenceInteractionForService(T service, Object request) throws Exception {
      service.requestValidator(request);
      Object result = service.interaction(request);
      service.responseValidator(result);
      return result;
   }
}