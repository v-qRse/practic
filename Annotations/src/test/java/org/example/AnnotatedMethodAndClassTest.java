package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnnotatedMethodAndClassTest {

   @Test
   public void dataContainerMergeTest () {
      DataContainer firstDataContainer = new DataContainer(1, "first name");
      DataContainer secondDataContainer = new DataContainer(2, "second name");

      DataContainer merdgeDataContainer = AnnotatedMethodAndClass.dataContainerMerge(firstDataContainer,
            secondDataContainer);

      assertEquals(3, merdgeDataContainer.getValue());
      assertEquals("first name second name", merdgeDataContainer.getName());
   }

   @Test
   public void dataContainerMergeExceptionTest () {
      Exception mergeException = assertThrows(Exception.class, () -> {
         AnnotatedMethodAndClass.dataContainerMerge(null, null);
      });

      assertTrue(mergeException instanceof NullPointerException);
   }

   @Test
   public void EmptyDataContainerTest () {
      DataContainer emptyDataContainer = new DataContainer(0, "");

      boolean isEmptyDataContainer = AnnotatedMethodAndClass.isEmptyDataContainer(emptyDataContainer);
      assertTrue(isEmptyDataContainer);
   }

   @Test
   public void EmptyDataContainerExceptionTest () {
      Exception emptyDataContainerException = assertThrows(Exception.class, () -> {
         AnnotatedMethodAndClass.isEmptyDataContainer(null);
      });

      assertTrue(emptyDataContainerException instanceof NullPointerException);
   }
}
