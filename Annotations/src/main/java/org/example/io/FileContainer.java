package org.example.io;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.DataContainer;

import java.io.*;

@AllArgsConstructor
@Getter
public class FileContainer {
   private String path;

   public void output (DataContainer dataContainer) throws IOException {
      File file = new File(path);
      if (file.createNewFile()) {
         try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write((dataContainer.getValue() + "\n").getBytes());
            fileOutputStream.write(dataContainer.getName().getBytes());
         } catch (IOException e) {
            throw new Error("Ожибка формирования файла");
         }
      } else {
         throw new Error("Файл уже существует");
      }
   }

   public DataContainer input (){
      try (BufferedReader in = new BufferedReader(new FileReader(path))) {
         int bufValue = Integer.parseInt(in.readLine());
         String bufName = in.readLine();
         return new DataContainer(bufValue, bufName);
      } catch (IOException e) {
         throw new Error(e.getMessage());
      }
   }
}
