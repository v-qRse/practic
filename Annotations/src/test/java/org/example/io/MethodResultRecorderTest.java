package org.example.io;

import org.example.DataContainer;
import org.junit.jupiter.api.Test;

public class MethodResultRecorderTest {
   @Test
   public void resultRecordTest () {
      DataContainer dataContainer = new DataContainer(5, "abc");
      MethodResultsRecorder.resultRecord(dataContainer, dataContainer);
   }
}
