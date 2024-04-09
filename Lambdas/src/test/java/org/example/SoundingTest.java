package org.example;

import org.example.animals.Cat;
import org.example.animals.Chinchilla;
import org.example.animals.Hyena;
import org.example.animals.Zebra;

import java.util.ArrayList;
import java.util.List;

public class SoundingTest {
   public void list () {
      List<Sounding> soundingList = new ArrayList<>();
      soundingList.add(new Cat());
      soundingList.add(new Chinchilla());
      soundingList.add(new Cat());
      soundingList.add(new Zebra());
      soundingList.add(new Hyena());
      soundingList.add(new Cat());
      soundingList.add(new Chinchilla());

      for (Sounding animalsSounding: soundingList) {
         System.out.println(animalsSounding.sound());
      }

      soundingList.add(new Sounding() {
         @Override
         public String sound() {
            return "sing";
         }
      });

      for (Sounding animalsSounding: soundingList) {
         System.out.println(animalsSounding.sound());
      }

      soundingList.add(() -> "gobble");
      for (Sounding animalsSounding: soundingList) {
         System.out.println(animalsSounding.sound());
      }

      Sounding cat = new Cat();
      soundingList.add(cat::sound);

      soundingList.forEach(System.out::println);
   }
}
