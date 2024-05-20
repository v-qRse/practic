package org.example.reflection;

import org.example.AnnotatedMethodAndClass;
import org.example.DataContainer;

import java.util.Arrays;

public class Reflection {
   public void annotatedClassCreated (int day, int value, String name) {
      DataContainer dataContainer = new DataContainer(value, name);
      AnnotatedMethodAndClass.class.getMethods()[0].getAnnotations();
      Arrays.stream(AnnotatedMethodAndClass.class.getMethods());
   }
}
