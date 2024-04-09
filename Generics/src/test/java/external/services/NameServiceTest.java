package external.services;

import org.example.external.services.NameService;
import org.example.external.services.RequestResponseValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameServiceTest {
   @Test
   public void requestExceptionTest () {
      RequestResponseValidator<String, String> nameService = new NameService<>();
      try {
         nameService.requestValidator(null);
      } catch (Exception e) {
         assertEquals("Неверный запрос", e.getMessage());
      }

      try {
         nameService.requestValidator("9wtrgdfb");
      } catch (Exception e) {
         assertEquals("Запрос не является именем", e.getMessage());
      }
   }

   @Test
   public void responseExceptionTest () {
      RequestResponseValidator<String, String> nameService = new NameService<>();
      try {
         String response = nameService.interaction("r");
         nameService.responseValidator(response);
      } catch (Exception e) {
         assertEquals("Недопустимый ответ", e.getMessage());
      }
   }
}
