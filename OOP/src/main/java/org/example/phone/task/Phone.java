package org.example.phone.task;

public class Phone {
   public static final String MY_PHONE_NUMBER = "+79005004031";
   public static final String WORK_PHONE_NUMBER = "+79006005042";
   public static final String BEST_PHONE_NUMBER = "+79005004321";
   public static final String RANDOM_PHONE_NUMBER = "+79008634034";

   private String number;
   private String model;
   private String weight;

   Phone () {
   }

   Phone (String number, String model) {
      this.number = number;
      this.model = model;
   }

   Phone (String number, String model, String weight) {
      this(number, model);
      this.weight = weight;
   }

   public String getNumber () {
      return number;
   }

   void receiveCall (String nameCall) {
      System.out.println("Звонит " + nameCall);
   }

   void receiveCall (String nameCall, String numberCall) {
      receiveCall(nameCall);
      System.out.println("номер: " + numberCall);
   }

   void sendMessage () {
      String[] notebook = {MY_PHONE_NUMBER, WORK_PHONE_NUMBER, BEST_PHONE_NUMBER, RANDOM_PHONE_NUMBER};
      for (String number: notebook) {
         System.out.print(number + " ");
      }
      System.out.println();
   }

   @Override
   public String toString() {
      return "Номер : " + number + " модель: " + model + " вес: " + weight;
   }
}
