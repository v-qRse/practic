package org.example.Pizza_Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTest {
   @Test
   public void setBookEqualsGet () {
      PizzaOrder order = new PizzaOrder(null, null, false, null);
      order.setName("pizza");

      String name = order.getName();
      assertEquals("pizza", name);
   }

   @Test
   public void setWithSauseEqualsGet () {
      PizzaOrder order = new PizzaOrder(null, null, false, null);
      order.setWithSauce(true);

      boolean withSauce = order.isWithSauce();
      assertEquals(true, withSauce);
   }

   @Test
   public void setSizeEqualsGet () {
      PizzaOrder order = new PizzaOrder(null, null, false, null);
      order.setSize(Size.SMALL);

      Size name = order.getSize();
      assertEquals(Size.SMALL, name);
   }

   @Test
   public void setDeliveryAddressEqualsGet () {
      PizzaOrder order = new PizzaOrder(null, null, false, null);
      order.setDeliveryAddress("Street");

      String deliveryAddress = order.getDeliveryAddress();
      assertEquals("Street", deliveryAddress);
   }

   @Test
   public void testOrderAlert () {
      PizzaOrder order = new PizzaOrder("pizza", Size.MEDIUM, false, "street");
      order.order();
      order.order();

      order = new PizzaOrder("Pi", Size.SMALL, true, "3.1415926 street");
      order.order();
      order.order();

      order = new PizzaOrder("e", Size.BIG, false, "streeeeeet");
      order.order();
      order.order();
   }

   @Test
   public void testCansel () {
      PizzaOrder order = new PizzaOrder(null, null, false, null);
      order.cancel();
   }

   @Test
   public void toStringEquals () {
      PizzaOrder order = new PizzaOrder("name", Size.BIG, false, "delivery address");
      assertEquals("Название: name, размер: Большая пицца , адрес доставки: delivery address", order.toString());

      order.setSize(Size.MEDIUM);
      assertEquals("Название: name, размер: Средняя пицца , адрес доставки: delivery address", order.toString());

      order.setSize(Size.SMALL);
      assertEquals("Название: name, размер: Маленькая пицца , адрес доставки: delivery address", order.toString());
   }
}
