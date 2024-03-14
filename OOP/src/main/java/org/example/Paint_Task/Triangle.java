package org.example.Paint_Task;

public class Triangle extends Figure {

   @Override
   public void draw() {
      System.out.println("Нарисован треугольник с координатами " +
            "( " + point.getX() + "; " + point.getY() + ") с черным цветом");
   }

   @Override
   public void draw(Color color) {
      System.out.println("Нарисован треугольник с координатами " +
            "( " + point.getX() + "; " + point.getY() + ") с " + color + " цветом");
   }
}
