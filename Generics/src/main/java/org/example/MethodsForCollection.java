package org.example;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class MethodsForCollection {

   public static <N extends Number> int oddNumbersCount (Collection<N> collection) throws Exception {
      try {
         int counter = 0;
         for (N number : collection) {
            if (number.doubleValue() % 2 == 1) {
               counter++;
            }
         }
         return counter;
      } catch (Exception e) {
         throw new Exception("Коллекция пустая");
      }
   }

   public static void swapElementsCollection (Collection<?> collection, int firstIndex, int secondIndex)
         throws Exception
   {
      if (collection != null && !collection.isEmpty()) {
         if (firstIndex > collection.size() || secondIndex > collection.size()) {
            throw new Exception("Индекс находится вне границ коллекции");
         } else {
            Collections.swap((List<?>) collection, firstIndex, secondIndex);
         }
//         Object buffer1 = collection.toArray()[firstIndex];
//         Object buffer2 = collection.toArray()[secondIndex];
//
//         collection.toArray()[firstIndex] = buffer2;
//         collection.toArray()[secondIndex] = buffer1;

         /*int firstIndexCount = 0;
         for (Object firstElement : collection) {
            if (firstIndexCount == firstIndex) {
               int secondIndexCount = 0;
               for (Object secondElement : collection) {
                  if (secondIndexCount == secondIndex) {
                     Object buffer = firstElement;
                     firstElement = secondElement;
                     secondElement = buffer;
                     return;
                  }
                  secondIndexCount++;
               }
               if (secondIndexCount > secondIndex) {
                  throw new Exception("Индекс находится вне границ коллекции");
               }
               break;
            }
            firstIndexCount++;
         }
         if (firstIndexCount > firstIndex) {
            throw new Exception("Индекс находится вне границ коллекции");
         }*/
      } else {
         throw new Exception("Попытка поменять элементы в пустой коллекции");
      }
   }
}
