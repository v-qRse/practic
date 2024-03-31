package org.example.Paint_Task;

public class Rectangle extends Figure implements Drawable {

   @Override
   public void draw() {
      System.out.println("Нарисован прямоугольник с координатами " +
            "( " + point.getX() + "; " + point.getY() + ") с черным цветом");
   }

   @Override
   public void draw(Color color) {
      System.out.println("Нарисован прямоугольник с координатами " +
            "( " + point.getX() + "; " + point.getY() + ") с " + color + " цветом");
   }
}
