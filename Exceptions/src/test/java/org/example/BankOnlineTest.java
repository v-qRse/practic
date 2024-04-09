package org.example;

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
      try {
         bankOnline.send(null, null);
      } catch (BankOnlineException e) {
         assertEquals("Исключение банка онлайн: \nВстречен пустой аргумент", e.getMessage());
      }
   }

   @Test
   public void invadingCardNumberExceptionTest () {
      Double money = 50.0;
      try {
         bankOnline.send("null", money);
      } catch (BankOnlineException e) {
         assertEquals("Исключение банка онлайн: \nНеверная длина номера карты", e.getMessage());
      }

      try {
         bankOnline.send("123456abcd123456", money);
      } catch (BankOnlineException e) {
         assertEquals("Исключение банка онлайн: \nНедопустимый символ номера корты", e.getMessage());
      }
   }

   @Test
   public void transferToBlockedCardExceptionTest () {
      Double money = 50.0;
      try {
         bankOnline.send("1111111111111111", money);
      } catch (BankOnlineException e) {
         assertEquals("Исключение банка онлайн: \nПопытка перевода на заблокированную карту", e.getMessage());
      }
   }

   @Test
   public void outOfLimitTransferExceptionTest () {
      Double money = -1.0;
      try {
         bankOnline.send("1234567812345678", money);
      } catch (BankOnlineException e) {
         assertEquals("Исключение банка онлайн: \nОтрицательная сумма перевода недопустима", e.getMessage());
      }

      money = bankOnline.TRANSFER_LIMIT * 2;
      try {
         bankOnline.send("1234567812345678", money);
      } catch (BankOnlineException e) {
         assertEquals("Исключение банка онлайн: \nПревышен лимит перевода", e.getMessage());
      }
   }
}
