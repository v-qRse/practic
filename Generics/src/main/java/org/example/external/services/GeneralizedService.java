package org.example.external.services;

public class GeneralizedService {
   public void sequenceInteractionForService(RequestResponseValidator service, Object request) throws Exception {
      service.requestValidator(request);
      Object result = service.interaction(request);
      service.responseValidator(result);
   }
}
