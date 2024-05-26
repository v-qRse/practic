package org.example.reflection;

import org.example.AnnotatedMethodAndClass;
import org.example.DataContainer;
import org.example.TimePriorities;
import org.example.TimePriority;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Reflection {
   public static void annotatedClassCreated (int day, int value, String name) {
      DataContainer dataContainer;
      try {
         dataContainer = DataContainer.class.getConstructor(int.class, String.class).newInstance(value, name);
      } catch (Exception e) {
         throw new Error(e.getMessage());
      }

      Queue<Method> methodQueue = new PriorityQueue<>((x, y) -> {
         int priorityX = x.getAnnotation(TimePriority.class).priority();
         int priorityY = y.getAnnotation(TimePriority.class).priority();
         return Integer.compare(priorityX, priorityY);
      });

      try {
         Method[] classMethod = AnnotatedMethodAndClass.class.getMethods();
         for (Method method: classMethod) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation: annotations) {
               System.out.println(annotation);
               if (annotation instanceof TimePriorities) {
                  methodQueue.add(method);
               }
            }
         }

         System.out.println(methodQueue.isEmpty());
         for (Method method: methodQueue) {
            System.out.println(method.getName());
            method.invoke(dataContainer, dataContainer);
         }

         ///////////////////////////////

//         methodQueue.add(AnnotatedMethodAndClass.class
//               .getDeclaredMethod("dataContainerMerge", DataContainer.class, DataContainer.class));
//
//         methodQueue.add(AnnotatedMethodAndClass.class
//               .getDeclaredMethod("isEmptyDataContainer", DataContainer.class));
//
//         System.out.println(methodQueue.isEmpty());

      } catch (Exception e) {
         throw new Error(e.getMessage());
      }


      try {
         Field valueField = dataContainer.getClass().getDeclaredField("value");
         valueField.setAccessible(true);
         int classValue = (int) valueField.get(dataContainer);
         System.out.println(value);
         System.out.println(classValue);
      } catch (Exception e) {
         throw new Error(e.getMessage());
      }

      try {
         Field nameField = dataContainer.getClass().getDeclaredField("name");
         nameField.setAccessible(true);
         String className = (String) nameField.get(dataContainer);
         System.out.println(name);
         System.out.println(className);
      } catch (Exception e) {
         throw new Error(e.getMessage());
      }
   }
}
