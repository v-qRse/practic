package org.example;

public class ModifyIncreaser extends Thread {
   @Override
   public void run () {
      ResourceProcessor resourceProcessor = new ResourceProcessor();
      for (int runNumber = 0; runNumber < 10; runNumber++) {
         resourceProcessor.modifyIncrease();
      }
   }
}
