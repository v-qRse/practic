package org.example.pizza.task;

public enum Size {
   SMALL("Маленькая "),
   MEDIUM("Средняя "),
   BIG("Большая ");
   private String description;
   private Size(String description) {
      this.description = description + "пицца ";
   }
   public String getDescription() {
      return description;
   }
}
