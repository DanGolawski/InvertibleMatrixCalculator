package com.dangolawski;

import java.lang.Math;

public class Solver {

    private static int MIN_OF_SCOPE = 1;
    private static int MAX_OF_SCOPE = 20;
    private static int MATRIX_SIZE = 3;

    public void decomposite(){
        double[][] matrix = generateMatrix();
        double[][] identityMatrix = generateIdentityMatrix(MATRIX_SIZE);
        double[][] invertedMatrix = new double[MATRIX_SIZE][MATRIX_SIZE];
        for(int i = 0; i < MATRIX_SIZE; i++) {
            double[] identityColumn = new double[MATRIX_SIZE];
            for(int j = 0; j < MATRIX_SIZE; i++){
                identityColumn[j] = identityMatrix[j][i];
            }
            double[] calculatedColumn = calculate(matrix, identityColumn);
            for(int k = 0; k < MATRIX_SIZE; k++) {
                invertedMatrix[k][i] = calculatedColumn[k];
            }
        }

        displayMatrix(matrix);
        displayMatrix(invertedMatrix);
        displayMatrix(myltiplyMatrices(matrix, invertedMatrix));
    }

    private double[] calculate(double[][] matrix, double[] vector){
        double[] column = new double[MATRIX_SIZE];
        column[0] = vector[0] / matrix[0][0];
        for(int i = 1; i < MATRIX_SIZE; i++) {
            column[i] = (vector[i] - calculateSum(matrix[i], vector, i)) / matrix[i][i];
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

    private double[][] generateIdentityMatrix(int matrixSize){
        double[][] identityMatrix = new double[matrixSize][matrixSize];
        for(int i=0; i<matrixSize; i++){
            for(int j=0; j<matrixSize; j++){
                if(j != i){
                    identityMatrix[i][j] = 0.0;
                }
                else{
                    identityMatrix[i][j] = 1.0;
                }
            }
        }
        return identityMatrix;
    }

    private double[][] generateMatrix(){
        double[][] generatedMatrix = new double[MATRIX_SIZE][MATRIX_SIZE];
        for(int i=0; i<MATRIX_SIZE; i++){
            for(int j=0; j<MATRIX_SIZE; j++){
                generatedMatrix[i][j] = (Math.random()*((MAX_OF_SCOPE-MIN_OF_SCOPE)+1))+MIN_OF_SCOPE;
            }
        }
        return generatedMatrix;
    }

    private void displayMatrix(double[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private double[][] myltiplyMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] product = new double[MATRIX_SIZE][MATRIX_SIZE];
        for(int i = 0; i < MATRIX_SIZE; i++) {
            for(int j = 0; j < MATRIX_SIZE; j++) {
                double sum = 0.0;
                for(int k = 0; k < MATRIX_SIZE; k++) {
                    sum += matrix1[i][k] * matrix2[j][k];
                }
            }
        }
    }

}
