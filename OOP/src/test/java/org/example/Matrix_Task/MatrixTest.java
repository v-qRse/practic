package org.example.Matrix_Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {
   private Matrix matrix1;
   private Matrix matrix2;
   private Matrix matrix3;

   private final double[][] exampleMatrix1 = {
         {1, 1, 1, 1, 1},
         {1, 1, 1, 1, 1},
         {1, 1, 1, 1, 1},
         {1, 1, 1, 1, 1},
         {1, 1, 1, 1, 1}
   };

   private final double[][] exampleMatrix2 = {
         {1, 0, 0, 0, 0},
         {0, 1, 0, 0, 0},
         {0, 0, 1, 0, 0},
         {0, 0, 0, 1, 0},
         {0, 0, 0, 0, 1}
   };

   @BeforeEach
   public void createMatrix () {
      matrix1 = new Matrix();
      for (int row = 0; row < exampleMatrix1.length; row++) {
         for (int column = 0; column < exampleMatrix1[row].length; column++) {
            matrix1.setValue(row, column, exampleMatrix1[row][column]);
         }
      }

      matrix2 = new Matrix();
      for (int row = 0; row < exampleMatrix1.length; row++) {
         for (int column = 0; column < exampleMatrix1[row].length; column++) {
            matrix2.setValue(row, column, exampleMatrix2[row][column]);
         }
      }
   }

   @Test
   public void printTest () {
      String[] out = matrix1.getForPrint();
      for (int index = 0; index < out.length; index++) {
         assertEquals(String.format(" %s %s %s %s %s",
               exampleMatrix1[index][0], exampleMatrix1[index][1], exampleMatrix1[index][2],
               exampleMatrix1[index][3], exampleMatrix1[index][4]),
               out[index]);
      }
      out = matrix2.getForPrint();
      for (int index = 0; index < out.length; index++) {
         assertEquals(String.format(" %s %s %s %s %s",
                     exampleMatrix2[index][0], exampleMatrix2[index][1], exampleMatrix2[index][2],
                     exampleMatrix2[index][3], exampleMatrix2[index][4]),
               out[index]);
      }
   }

   @Test
   public void multiplyNumberEquals () {
      matrix1.multiplyNumber(0);
      String[] out = matrix1.getForPrint();
      for (int index = 0; index < out.length; index++) {
         assertEquals(String.format(" %s %s %s %s %s", 0.0, 0.0, 0.0, 0.0, 0.0), out[index]);
      }
   }

   @Test
   public void matrixAdditionTest () {
      matrix1.additionMatrix(matrix2);
      String[] out = matrix1.getForPrint();
      for (int index = 0; index < out.length; index++) {
         assertEquals(String.format(" %s %s %s %s %s",
                     exampleMatrix1[index][0] + exampleMatrix2[index][0],
                     exampleMatrix1[index][1] + exampleMatrix2[index][1],
                     exampleMatrix1[index][2] + exampleMatrix2[index][2],
                     exampleMatrix1[index][3] + exampleMatrix2[index][3],
                     exampleMatrix1[index][4] + exampleMatrix2[index][4]),
               out[index]);
      }
   }

   @Test
   public void matrixMultiplication () {
      matrix3 = Matrix.multiplyMatrix(matrix1, matrix2);
      String[] out = matrix3.getForPrint();
      for (int index = 0; index < out.length; index++) {
         assertEquals(String.format(" %s %s %s %s %s",
                     exampleMatrix1[index][0], exampleMatrix1[index][1], exampleMatrix1[index][2],
                     exampleMatrix1[index][3], exampleMatrix1[index][4]),
               out[index]);
      }
   }
}
