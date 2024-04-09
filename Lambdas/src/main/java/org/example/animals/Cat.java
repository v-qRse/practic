package org.example.animals;

import org.example.Sounding;

public class Cat implements Sounding {
   @Override
   public String sound() {
      return "meow";
   }
}
