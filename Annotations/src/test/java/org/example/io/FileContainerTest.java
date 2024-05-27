package org.example.io;

import org.example.DataContainer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileContainerTest {
   @Test
   public void inputOutputTest () throws IOException {
      DataContainer testDateContainer = new DataContainer(5, "abc");

      FileContainer fileContainer = new FileContainer("src\\test\\java\\org\\example\\io\\containers\\test.txt");
      fileContainer.output(testDateContainer);
      DataContainer inputDataContainer = fileContainer.input();

      assertEquals(testDateContainer.getValue(), inputDataContainer.getValue());
      assertEquals(testDateContainer.getName(), inputDataContainer.getName());
   }
}
