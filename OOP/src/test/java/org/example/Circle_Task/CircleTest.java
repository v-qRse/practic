package org.example.Circle_Task;

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
      assertEquals("Радиус: 1.0; цвет: Black; площадь: " + Math.PI +
            "; периметр: " + 2*Math.PI, circle.toString());

      circle = new Circle(0, "Yellow");
      assertEquals("Радиус: 0.0; цвет: Yellow; площадь: 0.0; периметр: 0.0", circle.toString());

      circle = new Circle(10, null);
      assertEquals("Радиус: 10.0; цвет: null; площадь: " + Math.PI*10*10 +
            "; периметр: " + 2*Math.PI*10, circle.toString());
   }
}
