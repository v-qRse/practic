package external.services;

import org.example.external.services.GeneralizedService;
import org.example.external.services.NameService;
import org.example.external.services.PhoneNumberService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneralizedServiceTest {
   @Test
   public void nameServiceTest () throws Exception {
      GeneralizedService service = new GeneralizedService();
      Object nameServiceResult = service.sequenceInteractionForService(new NameService<>(), "request");
      assertEquals("equest", nameServiceResult);

      Object phoneNumberServiceResult = service.sequenceInteractionForService(new PhoneNumberService<>(), "01234567890");
      assertEquals(45, phoneNumberServiceResult);
   }
}
