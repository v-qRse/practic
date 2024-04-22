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
      try {
         Collections.swap((List<?>) collection, firstIndex, secondIndex);
      } catch (NullPointerException e) {
         throw new Exception("Попытка поменять элементы в пустой коллекции");
      } catch (IndexOutOfBoundsException e) {
         throw new Exception("Индекс находится вне границ коллекции");
      }
   }
}
