package org.example.Pizza_Task;

public class PizzaOrder {
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

   public void order () {
      if (isAccepted) {
         System.out.println("Заказ уже принят");
      } else {
         isAccepted = true;
         String order = "Заказ принят. " + size.getDescription() +
               "\"" + name + "\" ";

         if (withSauce) {
            order += "с соусом ";
         } else {
            order += "без соуса ";
         }
         order += "на адрес " + deliveryAddress;
         System.out.println(order);
      }
   }

   public void cancel () {
      System.out.println("Заказ отменен");
   }

   public void setName (String name) {
      this.name = name;
   }

   public void setSize (Size size) {
      this.size = size;
   }

   public void setWithSauce (boolean withSauce) {
      this.withSauce = withSauce;
   }

   public void setDeliveryAddress (String deliveryAddress) {
      this.deliveryAddress = deliveryAddress;
   }

   public String getName () {
      return name;
   }

   public Size getSize () {
      return size;
   }

   public boolean isWithSauce() {
      return withSauce;
   }

   public String getDeliveryAddress () {
      return deliveryAddress;
   }

   @Override
   public String toString () {
      return "Название: " + name + ", размер: " + size.getDescription() +
            ", адрес доставки: " + deliveryAddress;
   }
}