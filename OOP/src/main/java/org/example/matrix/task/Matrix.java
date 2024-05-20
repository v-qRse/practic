package org.example.matrix.task;

public class Matrix {
   private static final int ROW = 5;
   private static final int COLUMN = 5;
   private double[][] matrix = new double[ROW][COLUMN];

   public void setValue (int i, int j, double value) {
      matrix[i][j] = value;
   }

   public String[] getForPrint () {
      String[] out = new String[ROW];

      for (int rowIndex = 0; rowIndex < ROW; rowIndex++) {
         StringBuilder buffer = new StringBuilder();
         for (int columnIndex = 0; columnIndex < COLUMN; columnIndex++) {
            buffer.append(" ").append(matrix[rowIndex][columnIndex]);
         }
         out[rowIndex] = buffer.toString();
      }

      return out;
   }

   public void additionMatrix (Matrix matrix) {
      for (int row = 0; row < ROW; row++) {
         for (int column = 0; column < COLUMN; column++) {
            setValue(row, column, this.matrix[row][column] + matrix.matrix[row][column]);
         }
      }
   }

   public void multiplyNumber (double number) {
      for (int row = 0; row < ROW; row++) {
         for (int column = 0; column < COLUMN; column++) {
            setValue(row, column, this.matrix[row][column] * number);
         }
      }
   }

   public static Matrix multiplyMatrix (Matrix matrix1, Matrix matrix2) {
      Matrix resultMatrix = new Matrix();
      for (int row = 0; row < ROW; row++) {
         for (int column = 0; column < COLUMN; column++) {
            resultMatrix.setValue(row, column,
                  resultMatrix.matrix[row][column] +
                        matrix1.matrix[row][0] * matrix2.matrix[0][column]);
            for (int index = 1; index < COLUMN; index++) {
               resultMatrix.setValue(row, column,
                     resultMatrix.matrix[row][column] +
                           matrix1.matrix[row][index]*matrix2.matrix[index][column]);
            }
         }
      }
      return resultMatrix;
   }
}
