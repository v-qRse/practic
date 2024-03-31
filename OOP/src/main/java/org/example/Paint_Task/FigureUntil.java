package org.example.Paint_Task;

public class FigureUntil {
   private FigureUntil () { }

   public static double area (Figure figure) {
      return figure.area();
   }

   static double perimeter (Figure figure) {
      return figure.perimeter();
   }

   public static void draw (Figure figure) {
      figure.draw();
   }

   public static void draw (Figure figure, Color color) {
      figure.draw(color);
   }
}
