package org.example.external.services;

public class NameService<Q extends String, S extends String> implements RequestResponseValidator<Q, S> {

   @Override
   public S interaction(Q request) {
      return (S) request.substring(1);
   }

   @Override
   public void requestValidator(Q request) throws Exception {
      if (request != null) {
         if (request.charAt(0) >= '0' && request.charAt(0) <= 9) {
            throw new Exception("Запрос не является именем");
         }
      } else {
         throw new Exception("Неверный запрос");
      }
   }

   @Override
   public void responseValidator(S response) throws Exception {
      if (response.isEmpty()) {
         throw new Exception("Недопустимый ответ");
      }
   }
}
