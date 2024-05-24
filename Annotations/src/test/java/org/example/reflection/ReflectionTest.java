package org.example.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
   @Test
   public void useMethodTest () throws InvocationTargetException, IllegalAccessException {
      Reflection.annotatedClassCreated(0, 5, "abc");
   }
}
