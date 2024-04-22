package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankOnlineTest {
   private BankOnline bankOnline;

   @BeforeEach
   public void createBankOnline () {
      bankOnline = new BankOnline();
   }

   @Test
   public void nullPointerExceptionTest () {
      Exception sendException = Assertions.assertThrows(BankOnlineException.class, () -> {
         bankOnline.send(null, null);
      });
      assertEquals("Исключение банка онлайн: \nВстречен пустой аргумент", sendException.getMessage());
   }

   @Test
   public void invadingCardNumberExceptionTest () {
      Double money = 50.0;

      Exception sendException = Assertions.assertThrows(BankOnlineException.class, () -> {
         bankOnline.send("null", money);
      });
      assertEquals("Исключение банка онлайн: \nНеверная длина номера карты", sendException.getMessage());

      sendException = Assertions.assertThrows(BankOnlineException.class, () -> {
         bankOnline.send("123456abcd123456", money);
      });
      assertEquals("Исключение банка онлайн: \nНедопустимый символ номера корты", sendException.getMessage());
   }

   @Test
   public void transferToBlockedCardExceptionTest () {
      Double money = 50.0;

      Exception sendException = Assertions.assertThrows(BankOnlineException.class, () -> {
         bankOnline.send("1111111111111111", money);
      });
      assertEquals("Исключение банка онлайн: \nПопытка перевода на заблокированную карту", sendException.getMessage());
   }

   @Test
   public void outOfLimitTransferExceptionTest () {

      Exception sendException = Assertions.assertThrows(BankOnlineException.class, () -> {
         bankOnline.send("1234567812345678", -1.0);
      });
      assertEquals("Исключение банка онлайн: \nОтрицательная сумма перевода недопустима", sendException.getMessage());

      sendException = Assertions.assertThrows(BankOnlineException.class, () -> {
         bankOnline.send("1234567812345678", bankOnline.TRANSFER_LIMIT * 2);
      });
      assertEquals("Исключение банка онлайн: \nПревышен лимит перевода", sendException.getMessage());
   }
}
