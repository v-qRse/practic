package org.example;

public class OutOfLimitTransferException extends BankOnlineException {
   public OutOfLimitTransferException(String message) {
      super(message);
   }
}
