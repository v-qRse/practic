package org.example;

public class BankOnline {
   public final static int CARD_LENGTH = 16;
   public final static double TRANSFER_LIMIT = 50000;

   private final String[] blockedCards = new String[] {
         "1111111111111111",
         "2222222222222222",
         "3333333333333333"
   };

   public void send (String cardNumber, Double money) throws BankOnlineException {
      if (cardNumber == null || money == null) {
         throw new NullPointerException("Встречен пустой аргумент");
      }
      if (cardNumber.length() != CARD_LENGTH) {
         throw new InvadingCardNumberException("Неверная длина номера карты");
      }
      for (char ch: cardNumber.toCharArray()) {
         if (!(ch >= '0' && ch <= '9')) {
            throw new InvadingCardNumberException("Недопустимый символ номера корты");
         }
      }
      for (String blockedCard: blockedCards) {
         if (cardNumber.equals(blockedCard)) {
            throw new TransferToBlockedCardException("Попытка перевода на заблокированную карту");
         }
      }
      if (money > TRANSFER_LIMIT) {
         throw new OutOfLimitTransferException("Превышен лимит перевода");
      } else if (money < 0) {
         throw new OutOfLimitTransferException("Отрицательная сумма перевода недопустима");
      }
      // Реализация метода
   }
}
