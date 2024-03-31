package org.example.Paint_Task;

public class Circle extends Figure implements Drawable {

   @Override
   public void draw() {
      System.out.println("Нарисована окружность с координатами " +
            "( " + point.getX() + "; " + point.getY() + ") с черным цветом");
   }

   @Override
   public void draw(Color color) {
      System.out.println("Нарисована окружность с координатами " +
            "( " + point.getX() + "; " + point.getY() + ") с " + color + " цветом");
   }
}
