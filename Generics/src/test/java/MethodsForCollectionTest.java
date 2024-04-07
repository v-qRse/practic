import org.example.MethodsForCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodsForCollectionTest {

   final private Number[] elementArray = new Integer[] {0, 1, 2, 3, 4, 5, 6};
//   private Collection<Number> collection;
//   @BeforeEach
//   public void createCollection () {
//      collection = new ArrayList<>(Arrays.asList(elementArray));
//   }

   @Test
   public void oddNumbersCountTest () throws Exception {
      Collection<Number> collection = new ArrayList<>(Arrays.asList(elementArray));
      int number = MethodsForCollection.oddNumbersCount(collection);

      assertEquals(3, number);
   }

   @Test
   public void oddNumbersCountExceptionTest () throws Exception {
      try {
         int number = MethodsForCollection.oddNumbersCount(null);
      } catch (Exception e) {
         assertEquals("Коллекция пустая", e.getMessage());
      }
   }

   @Test
   public void swapElementsCollectionTest () throws Exception {
      Collection<Number> collection = new ArrayList<>(Arrays.asList(elementArray));

      int firstSwapIndex = 0;
      int secondSwapIndex = 6;

      MethodsForCollection.swapElementsCollection(collection, firstSwapIndex, secondSwapIndex);

      int arrayIndex = 0;
      for (Number elementCollection: collection) {
         if (arrayIndex == firstSwapIndex) {
            assertEquals(elementArray[secondSwapIndex], elementCollection);
         } else if (arrayIndex == secondSwapIndex) {
            assertEquals(elementArray[firstSwapIndex], elementCollection);
         } else {
            assertEquals(elementArray[arrayIndex], elementCollection);
         }
         arrayIndex++;
      }

      collection = new ArrayList<>(Arrays.asList(elementArray));

      MethodsForCollection.swapElementsCollection(collection, 3, 3);

      for (Number elementCollection: collection) {
         assertEquals(elementArray[arrayIndex], elementCollection);
      }
   }

   @Test
   public void swapElementsCollectionExceptionTest () throws Exception {
      try {
         MethodsForCollection.swapElementsCollection(null, 3, 3);
      } catch (Exception e) {
         assertEquals("Попытка поменять элементы в пустой коллекции", e.getMessage());
      }

      Collection<Number> collection = new ArrayList<>();
      collection.add(0);
      try {
         MethodsForCollection.swapElementsCollection(collection, 3, 3);
      } catch (Exception e) {
         assertEquals("Индекс находится вне границ коллекции", e.getMessage());
      }
   }
}
