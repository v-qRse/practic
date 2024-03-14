package org.example.Paint_Task;

class FigureUntil {
   private FigureUntil () { }

   static double area (Figure figure) {
      return figure.area();
   }

   static double perimeter (Figure figure) {
      return figure.perimeter();
   }

   static void draw (Figure figure) {
      figure.draw();
   }

   static void draw (Figure figure, Color color) {
      figure.draw(color);
   }
}
