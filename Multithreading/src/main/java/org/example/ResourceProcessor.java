package org.example;

public class ResourceProcessor {
   public static synchronized void increase () {
      Resource.setValue(Resource.getValue() + 1);
      System.out.println(Resource.getValue());
   }

   public static synchronized void decrease () {
      Resource.setValue(Resource.getValue() - 1);
      System.out.println(Resource.getValue());
   }

   public synchronized void modifyIncrease() {
      while (Resource.getValue() >= 5) {
         try {
            wait();
         } catch (InterruptedException e) {
            throw new Error();
         }
      }
      Resource.setValue(Resource.getValue() + 1);
      System.out.println(Resource.getValue());
      notify();
   }

   public synchronized void modifyDecrease () {
      while (Resource.getValue() < 1) {
         try {
            wait();
         } catch (InterruptedException e) {
            throw new Error();
         }
      }
      Resource.setValue(Resource.getValue() - 1);
      System.out.println(Resource.getValue());
      notify();
   }
}
