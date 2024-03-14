package org.example.Phone_Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneTest {
   private Phone phone1;
   private Phone phone2;
   private Phone phone3;

   @BeforeEach
   public void CreatePhone () {
      phone1 = new Phone();
      phone2 = new Phone("+79990003355", "Telephone");
      phone3 = new Phone("+71112223344", "Smartphone", "375 gram");
   }

   @Test
   public void receiveCallTest () {
      phone1.receiveCall("Igor1");
      phone1.receiveCall("Ivan1", "+77771");
      phone2.receiveCall("Igor2");
      phone2.receiveCall("Ivan2", "+77772");
      phone3.receiveCall("Igor3");
      phone3.receiveCall("Ivan3", "+77773");
   }

   @Test
   public void getNumberEqualsNumber () {
      assertNull(phone1.getNumber());
      assertEquals("+79990003355", phone2.getNumber());
      assertEquals("+71112223344", phone3.getNumber());
   }

   @Test
   public void sendMessageTest () {
      phone1.sendMessage();
      phone2.sendMessage();
      phone3.sendMessage();
   }

   @Test
   public void toStringEquals () {
      assertEquals("Номер : null модель: null вес: null", phone1.toString());
      assertEquals("Номер : +79990003355 модель: Telephone вес: null", phone2.toString());
      assertEquals("Номер : +71112223344 модель: Smartphone вес: 375 gram", phone3.toString());
   }
}
