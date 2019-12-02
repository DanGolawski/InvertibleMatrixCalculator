package com.dangolawski;

public class Main {

    private static int MIN_OF_SCOPE = 1;
    private static int MAX_OF_SCOPE = 20;
    private static int MATRIX_SIZE = 3;

    public static void main(String[] args) {
        double[][] matrix = MatrixOperationsService.generate_L_Matrix(MATRIX_SIZE, MIN_OF_SCOPE, MAX_OF_SCOPE);
	    InvertibleMatrixCalculator invertibleMatrixCalculator = new InvertibleMatrixCalculator();
	    double[][] invertibleMatrix = invertibleMatrixCalculator.decomposite(matrix);
	    MatrixOperationsService.displayMatrix(matrix);
	    MatrixOperationsService.displayMatrix(invertibleMatrix);
	    MatrixOperationsService.displayMatrix(MatrixOperationsService.multiplyMatrices(matrix, invertibleMatrix));
    }
}
