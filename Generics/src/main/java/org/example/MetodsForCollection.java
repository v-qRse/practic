package org.example;

import java.util.Collection;

public class MetodsForCollection {

   public static <N extends Number> int oddNumbersCount (Collection<N> collection) throws Exception {
      if (!collection.isEmpty()) {
         int counter = 0;
         for (N number : collection) {
            if (number.doubleValue() % 2 == 1) {
               counter++;
            }
         }
         return counter;
      } else {
         throw new Exception("Коллекция пустая");
      }
   }

   public static void swapElementsCollection (Collection<?> collection, int firstIndex, int secondIndex)
         throws Exception
   {
      if (!collection.isEmpty()) {
         int firstIndexCount = 0;
         for (Object firstElement : collection) {
            if (firstIndexCount == firstIndex) {
               int secondIndexCount = 0;
               for (Object secondElement : collection) {
                  if (secondIndexCount == secondIndex) {
                     Object buffer = firstElement;
                     firstElement = secondElement;
                     secondElement = buffer;
                     break;
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
         }
      } else {
         throw new Exception("Попытка поменять элементы в пустой коллекции");
      }
   }
}
