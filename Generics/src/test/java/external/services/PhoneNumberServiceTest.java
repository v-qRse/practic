package external.services;

import org.example.external.services.PhoneNumberService;
import org.example.external.services.RequestResponseValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberServiceTest {
   @Test
   public void requestExceptionTest () {
      RequestResponseValidator<String, Integer> phoneNumberService = new PhoneNumberService<>();
      try {
         phoneNumberService.requestValidator(null);
      } catch (Exception e) {
         assertEquals("Неверный запрос", e.getMessage());
      }

      try {
         phoneNumberService.requestValidator("");
      } catch (Exception e) {
         assertEquals("Неверная длина запроса", e.getMessage());
      }
   }

   @Test
   public void responseExceptionTest () {
      RequestResponseValidator<String, Integer> phoneNumberService = new PhoneNumberService<>();
      try {
         Integer response = phoneNumberService.interaction("0123456789K");
         phoneNumberService.responseValidator(response);
      } catch (Exception e) {
         assertEquals("Большое значение ответа", e.getMessage());
      }

      try {
         Integer response = phoneNumberService.interaction("0123456789,");
         phoneNumberService.responseValidator(response);
      } catch (Exception e) {
         assertEquals("Маленькое значение ответа", e.getMessage());
      }
   }
}
