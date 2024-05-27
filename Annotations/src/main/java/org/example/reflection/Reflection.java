package org.example.reflection;

import org.example.AnnotatedMethodAndClass;
import org.example.DataContainer;
import org.example.TimePriorities;
import org.example.TimePriority;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
         int priorityX = 0;
         if (x.isAnnotationPresent(TimePriority.class)) {
            priorityX = x.getAnnotation(TimePriority.class).priority();
         } else if (x.isAnnotationPresent(TimePriorities.class)) {
            TimePriority[] timePriorities = x.getAnnotation(TimePriorities.class).value();
            int min = timePriorities[0].priority();
            for (int timePriorityNumber = 1; timePriorityNumber < timePriorities.length; timePriorityNumber++) {
               min = Math.min(min, timePriorities[timePriorityNumber].priority());
            }
            priorityX = min;
         }
         int priorityY = 0;
         if (y.isAnnotationPresent(TimePriority.class)) {
            priorityY = y.getAnnotation(TimePriority.class).priority();
         } else if (y.isAnnotationPresent(TimePriorities.class)) {
            TimePriority[] timePriorities = y.getAnnotation(TimePriorities.class).value();
            int min = timePriorities[0].priority();
            for (int timePriorityNumber = 1; timePriorityNumber < timePriorities.length; timePriorityNumber++) {
               min = Math.min(min, timePriorities[timePriorityNumber].priority());
            }
            priorityY = min;
         }
         return Integer.compare(priorityX, priorityY);
      });

      try {
         Method[] classMethod = AnnotatedMethodAndClass.class.getMethods();
         for (Method method: classMethod) {
            if (method.isAnnotationPresent(TimePriority.class) || method.isAnnotationPresent(TimePriorities.class)) {
               methodQueue.add(method);
            }
         }

         for (Method method: methodQueue) {
            if (method.getParameters().length == 2) {
               method.invoke(dataContainer, dataContainer, dataContainer);
            } else if (method.getParameters().length == 1) {
               method.invoke(dataContainer, dataContainer);
            }
         }

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
