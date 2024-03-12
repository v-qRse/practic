package org.example.Circle_Task;

class Circle {
   private double radius;
   private String color;

   Circle(double radius, String color) {
      this.radius = radius;
      this.color = color;
   }

   double area () {
      return Math.PI*radius*radius;
   }

   double perimeter () {
      return 2*Math.PI*radius;
   }

   @Override
   public String toString() {
      return "Радиус: " + radius + "; цвет: " + color + "; площадь: " + area() +
            "; периметр: " + perimeter();
   }
}
