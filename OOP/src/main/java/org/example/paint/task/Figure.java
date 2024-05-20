package org.example.paint.task;

abstract class Figure  implements Drawable {
   protected Point point = new Point();

   public double area () {
      return 0;
   }

   public double perimeter () {
      return 0;
   }
}
