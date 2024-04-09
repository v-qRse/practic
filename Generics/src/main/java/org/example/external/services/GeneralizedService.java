package org.example.external.services;

public class GeneralizedService {
   public Object sequenceInteractionForService(RequestResponseValidator service, Object request) throws Exception {
      service.requestValidator(request);
      Object result = service.interaction(request);
      service.responseValidator(result);
      return result;
   }
}
