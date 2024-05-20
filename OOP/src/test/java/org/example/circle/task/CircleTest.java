package org.example.circle.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {
   @Test
   public void areaEquals () {
      Circle circle = new Circle(1, "Black");
      assertEquals(Math.PI, circle.area());

      circle = new Circle(0, "Black");
      assertEquals(0, circle.area());

      circle = new Circle(3.5, "Black");
      assertEquals(Math.PI*3.5*3.5, circle.area());
   }

   @Test
   public void perimeterEquals () {
      Circle circle = new Circle(1, "Black");
      assertEquals(2*Math.PI, circle.perimeter());

      circle = new Circle(0, "Black");
      assertEquals(0, circle.perimeter());

      circle = new Circle(7, "Black");
      assertEquals(2*Math.PI*7, circle.perimeter());
   }

   @Test
   public void toStringEquals () {
      Circle circle = new Circle(1, "Black");
      assertEquals(String.format("Радиус: %s; цвет: %s; площадь: %s; периметр: %s",
                  1.0, "Black", Math.PI, 2*Math.PI),
                  circle.toString());

      circle = new Circle(0, "Yellow");
      assertEquals(String.format("Радиус: %s; цвет: %s; площадь: %s; периметр: %s",
            0.0, "Yellow", 0.0, 0.0), circle.toString());

      circle = new Circle(10, null);
      assertEquals(String.format("Радиус: %s; цвет: %s; площадь: %s; периметр: %s",
            10.0, null, Math.PI*10*10, 2*Math.PI*10), circle.toString());
   }
}
