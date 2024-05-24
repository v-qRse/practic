package org.example;

public class TaskSolution {
   public static void main(String[] args) {
      increaserTask();

      modifyIncreaserTask();

      modifyDecreaserTask();
   }

   private static void modifyIncreaserTask() {
      Resource.setValue(0);
      ModifyIncreaser modifyIncreaser = new ModifyIncreaser();
      modifyIncreaser.start();
   }

   private static void modifyDecreaserTask() {
      Resource.setValue(5);
      ModifyDecreaser modifyDecreaser = new ModifyDecreaser();
      modifyDecreaser.start();
   }

   private static void increaserTask () {
      Resource.setValue(5);

      for (int increaserNumber = 0; increaserNumber < 3; increaserNumber++) {
         Increaser increaser = new Increaser();
         increaser.start();
      }
   }
}