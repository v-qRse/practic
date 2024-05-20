package org.example.paint.task;

public class Cube extends Rectangle implements Drawable{

   @Override
   public void draw() {
      System.out.println("Нарисован квадрат с координатами " +
            "( " + point.getX() + "; " + point.getY() + ") с черным цветом");
   }

   @Override
   public void draw(Color color) {
      System.out.println("Нарисован квадрат с координатами " +
            "( " + point.getX() + "; " + point.getY() + ") с " + color + " цветом");
   }
}
