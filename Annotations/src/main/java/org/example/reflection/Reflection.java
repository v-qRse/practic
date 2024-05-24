package org.example.reflection;

import org.example.AnnotatedMethodAndClass;
import org.example.DataContainer;
import org.example.TimePriorities;
import org.example.TimePriority;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Reflection {
   public static void annotatedClassCreated (int day, int value, String name) throws InvocationTargetException, IllegalAccessException {
      DataContainer dataContainer = new DataContainer(value, name);
      DataContainer bufContainer = new DataContainer(value, name);

      Method[] methods = AnnotatedMethodAndClass.class.getMethods();
      List<Method> list = Arrays.stream(methods)
            .filter(x -> x.isAnnotationPresent(TimePriority.class))
//            .sorted((x, y) -> Math.min(x.getAnnotation(TimePriority.class).priority(),
//                                       y.getAnnotation(TimePriority.class).priority()))
            .toList();

      for (Method method: list) {
         System.out.println("aaa");
         dataContainer = (DataContainer) method.invoke(dataContainer, dataContainer);
      }

//      AnnotatedMethodAndClass.class.getMethods()[0].getAnnotations();
//
//      Method[] allMethods = AnnotatedMethodAndClass.class.getMethods();
//      for (Method method: allMethods) {
//         for (Annotation annotation: method.getAnnotations()) {
//            if (annotation instanceof TimePriority) {
//               ((TimePriority) annotation).priority();
//            }
//         }
//      }

//      Object[] methods = Arrays.stream(AnnotatedMethodAndClass.class.getMethods())
//            .sorted((x, y) -> Math.min(x.getAnnotation(TimePriorities.class).value()[0].priority(),
//                                       y.getAnnotation(TimePriorities.class).value()[0].priority()))
//            .toArray();

//      for (Object method: methods) {
//         if (method instanceof Method) {
//            dataContainer = (DataContainer) ((Method) method).invoke(dataContainer, dataContainer);
//         }
//      }

      System.out.println(bufContainer.getName());
      System.out.println(dataContainer.getName());
      System.out.println(bufContainer.getValue());
      System.out.println(dataContainer.getValue());
   }
}
