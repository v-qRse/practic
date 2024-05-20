package org.example;

import lombok.NonNull;

public class AnnotatedMethodAndClass  extends AnnotatedClass {

   @TimePriority(hour = 0,
               priority = 0,
               description = "Addition of values")
   @TimePriority(hour = 1,
         priority = 1,
         description = "Name concatenation")
   public static DataContainer dataContainerMerge(@NonNull DataContainer firstDataContainer, @NonNull DataContainer secondDataContainer) {
      return new DataContainer(firstDataContainer.getValue() + secondDataContainer.getValue(),
            firstDataContainer.getName() + " " + secondDataContainer.getName());
   }

   @TimePriority(hour = 2,
         priority = 2,
         description = "value = 0, name = \"\"")
   public static boolean isEmptyDataContainer(@NonNull DataContainer dataContainer) {
      return dataContainer.getValue() == 0
            && dataContainer.getName().isEmpty();
   }
}
