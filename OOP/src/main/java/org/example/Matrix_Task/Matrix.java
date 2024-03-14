package org.example.Matrix_Task;

class Matrix {
   static final int ROW = 5;
   static final int COLUMN = 5;
   double[][] matrix = new double[ROW][COLUMN];

   void setValue (int i, int j, double value) {
      matrix[i][j] = value;
   }

   void print () {
      for (double[] valueRow: matrix) {
         for (double value: valueRow) {
            System.out.printf("%10s", value);
         }
         System.out.println();
      }
   }

   void additionMatrix (Matrix matrix) {
      for (int row = 0; row < ROW; row++) {
         for (int column = 0; column < COLUMN; column++) {
            setValue(row, column, this.matrix[row][column] + matrix.matrix[row][column]);
         }
      }
   }

   void multiplyNumber (double number) {
      for (int row = 0; row < ROW; row++) {
         for (int column = 0; column < COLUMN; column++) {
            setValue(row, column, this.matrix[row][column] * number);
         }
      }
   }

   static Matrix multiplyMatrix (Matrix matrix1, Matrix matrix2) {
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
