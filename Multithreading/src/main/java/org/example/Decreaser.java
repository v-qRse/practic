package org.example;

public class Decreaser extends Thread {
   @Override
   public void run () {
      ResourceProcessor.decrease();
   }
}
