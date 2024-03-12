package org.example.Phone_Task;

class Phone {
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

   String getNumber () {
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
      String[] notebook = {"+79005004031", "+79006005042", "+79009001033", "+79008634034", "+79004324035"};
      for (String number: notebook) {
         System.out.println(number);
      }
   }

   @Override
   public String toString() {
      return "Номер : " + number + "модель: " + model + "вес: " + weight;
   }
}
