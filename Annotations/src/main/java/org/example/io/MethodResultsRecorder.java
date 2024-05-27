package org.example.io;

import org.example.AnnotatedMethodAndClass;
import org.example.DataContainer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.io.File;

public class MethodResultsRecorder {
   public static final String PATH_TO_LOG = "src\\main\\java\\org\\example\\io\\log";

   public static void resultRecord (DataContainer firstDataContainer, DataContainer secondDataContainer) {
      File logPackage = new File(PATH_TO_LOG);

      folderCleaning(logPackage);

      Date crateData = new Date();
      File resultFile = new File(logPackage.getAbsolutePath() + "\\"
            + crateData.toString().replaceAll(":", "_") + ".txt");

      try {
         resultFile.createNewFile();
      } catch (IOException e) {
         throw new Error(e.getMessage());
      }

      try (FileOutputStream reader = new FileOutputStream(resultFile)) {
         reader.write(AnnotatedMethodAndClass.isEmptyDataContainer(firstDataContainer)
               ? "Первый DataContainer пуст".getBytes()
               : "Первый DataContainer непустой".getBytes());

         reader.write("\n".getBytes());

         reader.write(AnnotatedMethodAndClass.isEmptyDataContainer(secondDataContainer)
               ? "Второй DataContainer пуст".getBytes()
               : "Второй DataContainer непустой".getBytes());

         reader.write("\n".getBytes());

         DataContainer resultDataContainer = AnnotatedMethodAndClass
               .dataContainerMerge(firstDataContainer, secondDataContainer);

         reader.write(Integer.toString(resultDataContainer.getValue()).getBytes());
         reader.write("\n".getBytes());
         reader.write(resultDataContainer.getName().getBytes());
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   private static void folderCleaning (File folder) {
      if (folder.isDirectory()) {
         File[] filesInLog = folder.listFiles();
         if (filesInLog != null) {
            if (filesInLog.length >= 2) {
               for (File file : filesInLog) {
                  file.delete();
               }
            }
         }
      } else {
         throw new Error("Ожидается папка");
      }
   }
}
