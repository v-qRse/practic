package org.example.external.services;

public class PhoneNumberService<Q extends String, S extends Number> implements RequestResponseValidator<Q, S> {

   @Override
   public S interaction (Q request) {
      Integer result = 0;
      for (int index = 0; index < request.length(); index++) {
         result = result + (int) request.charAt(index) - (int) '0';
      }
      return (S) result;
   }

   @Override
   public void requestValidator(Q request) throws Exception {
      if (request != null) {
         if (request.length() != 11) {
            throw new Exception("Неверная длина запроса");
         }
      } else {
         throw new Exception("Неверный запрос");
      }
   }

   @Override
   public void responseValidator(S response) throws Exception {
      if (response.doubleValue() <= 0) {
         throw new Exception("Маленькое значение ответа");
      } else if (response.doubleValue() > 99) {
         throw new Exception("Большое значение ответа");
      }
   }
}
