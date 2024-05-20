package org.example;

public class BankOnlineException extends Exception {
   public BankOnlineException (String message) {
      super("Исключение банка онлайн: \n" + message);
   }
}
