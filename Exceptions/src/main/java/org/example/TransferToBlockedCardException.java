package org.example;

public class TransferToBlockedCardException extends BankOnlineException {
   public TransferToBlockedCardException(String message) {
      super(message);
   }
}
