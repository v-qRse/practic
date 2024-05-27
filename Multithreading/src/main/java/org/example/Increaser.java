package org.example;

public class Increaser extends Thread {
   @Override
   public void run () {
      for (int runValue = 0; runValue < 6; runValue++) {
         ResourceProcessor.increase();
      }
   }
}
