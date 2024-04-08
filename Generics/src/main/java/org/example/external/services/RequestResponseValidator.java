package org.example.external.services;

public interface RequestResponseValidator<Q, S> {
   void requestValidator(Q request) throws Exception;

   S interaction(Q request);

   void responseValidator (S response) throws Exception;
}