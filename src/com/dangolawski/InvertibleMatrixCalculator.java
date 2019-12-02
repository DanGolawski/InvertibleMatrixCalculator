package com.dangolawski;


public class InvertibleMatrixCalculator {


    private static int MATRIX_SIZE;

    public double[][] decomposite(double[][] matrix){
        MATRIX_SIZE = matrix.length;
        return createInvertibleMatrix(matrix, MatrixOperationsService.generateIdentityMatrix(MATRIX_SIZE));
    }

    private double[][] createInvertibleMatrix(double[][] matrix, double[][] identityMatrix){
        double[][] invertedMatrix = new double[MATRIX_SIZE][MATRIX_SIZE];
        for(int i = 0; i < MATRIX_SIZE; i++) {
            double[] identityColumn = new double[MATRIX_SIZE];
            for(int j = 0; j < MATRIX_SIZE; j++){
                identityColumn[j] = identityMatrix[j][i];
            }
            double[] calculatedColumn = calculate(matrix, identityColumn);
            for(int k = 0; k < MATRIX_SIZE; k++) {
                invertedMatrix[k][i] = calculatedColumn[k];
            }
        }
        return invertedMatrix;
    }

    private double[] calculate(double[][] matrix, double[] vector){
        double[] column = new double[MATRIX_SIZE];
        column[0] = vector[0] / matrix[0][0];
        for(int i = 1; i < MATRIX_SIZE; i++) {
            column[i] = (vector[i] - calculateSum(matrix[i], column, i)) / matrix[i][i];
        }
        return column;
    }

    private double calculateSum(double[] row, double[] vector, int stopIndex){
        double sum = 0.0;
        for(int i = 0; i < stopIndex; i++){
            sum += row[i] * vector[i];
        }
        return sum;
    }

}
