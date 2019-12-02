package com.dangolawski;

public class MatrixOperationsService {

    public static double[][] generate_L_Matrix(int size, int minOfScope, int maxOfScope){
        double[][] generatedMatrix = new double[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(j <= i){
                    generatedMatrix[i][j] = (Math.random()*((maxOfScope-minOfScope)+1))+minOfScope;
                }
                else{
                    generatedMatrix[i][j] = 0.0;
                }

            }
        }
        return generatedMatrix;
    }

    public static void displayMatrix(double[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        int matrixSize = matrix1.length;
        double[][] product = new double[matrixSize][matrixSize];
        for(int i = 0; i < matrixSize; i++) {
            for(int j = 0; j < matrixSize; j++) {
                double sum = 0.0;
                for(int k = 0; k < matrixSize; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                product[i][j] = sum;
            }
        }
        return product;
    }

    public static double[][] generateIdentityMatrix(int matrixSize){
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
}
