package org.example.Matrix_Task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
   public void CreateMatrix () {
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
      matrix1.print();
      System.out.println();
      matrix2.print();
   }

   @Test
   public void multiplyNumberEquals () {
      matrix1.print();
      System.out.println("* 0 =");
      matrix1.multiplyNumber(0);
      matrix1.print();
   }

   @Test
   public void matrixAdditionTest () {
      matrix1.print();
      System.out.println("+");
      matrix2.print();
      System.out.println("=");
      matrix1.additionMatrix(matrix2);
      matrix1.print();
   }

   @Test
   public void matrixMultiplication () {
      matrix1.print();
      System.out.println("*");
      matrix2.print();
      System.out.println("=");
      matrix3 = Matrix.multiplyMatrix(matrix1, matrix2);
      matrix3.print();
   }
}
