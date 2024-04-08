package external.services;

import org.example.external.services.GeneralizedService;
import org.example.external.services.NameService;
import org.example.external.services.PhoneNumberService;
import org.junit.jupiter.api.Test;

public class GeneralizedServiceTest {
   @Test
   public void nameServiceTest () throws Exception {
      GeneralizedService service = new GeneralizedService();
      service.sequenceInteractionForService(new NameService<>(), "request");
      service.sequenceInteractionForService(new PhoneNumberService<>(), "01234567890");
   }
}
