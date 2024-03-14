package org.example.Pizza_Task;

class PizzaOrder {
   private String name;
   private Size size;
   private boolean withSauce;
   private String deliveryAddress;
   private boolean isAccepted;

   PizzaOrder (String name, Size size, boolean withSauce, String deliveryAddress) {
      this.name = name;
      this.size = size;
      this.withSauce = withSauce;
      this.deliveryAddress = deliveryAddress;
   }

   void order () {
      if (isAccepted) {
         System.out.println("Заказ уже принят");
      } else {
         isAccepted = true;
         String order = "Заказ принят. ";
         switch (size) {
            case SMALL -> order += "Маленькая пицца ";
            case MEDIUM -> order += "Средняя пицца ";
            case BIG -> order += "Большая пицца ";
         }
         order += "\"" + name + "\" ";
         if (withSauce) {
            order += "с соусом ";
         } else {
            order += "без соуса ";
         }
         order += "на адрес " + deliveryAddress;
         System.out.println(order);
      }
   }

   void cancel () {
      System.out.println("Заказ отменен");
   }

   void setName (String name) {
      this.name = name;
   }

   void setSize (Size size) {
      this.size = size;
   }

   void setWithSauce (boolean withSauce) {
      this.withSauce = withSauce;
   }

   void setDeliveryAddress (String deliveryAddress) {
      this.deliveryAddress = deliveryAddress;
   }

   String getName () {
      return name;
   }

   Size getSize () {
      return size;
   }

   boolean isWithSauce() {
      return withSauce;
   }

   String getDeliveryAddress () {
      return deliveryAddress;
   }

   @Override
   public String toString () {
      String order = "Название: " + name + ", размер: ";
      switch (size) {
         case SMALL -> order += "Маленькая";
         case MEDIUM -> order += "Средняя";
         case BIG -> order += "Большая";
      }
      order += ", адрес доставки: " + deliveryAddress;
      return order;
   }
}