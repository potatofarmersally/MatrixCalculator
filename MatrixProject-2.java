import java.util.Scanner;

/*
 * MatrixProject.java
 *
 * Math 308 - Spring 2017
 * Matrix Project
 */

/**
 * This program performs adding, subtracting, transpose and multiplying
 *  operations on various matrices. As well as finding the dot product,
 *   cross product, magnitude, area of triangle and angle between vectors,
 *
 * @author Giovanni Tang, Terence Caiga, Joshua Atherton, Sally Ho
 * @version 2/20/2018
 */ 
public class MatrixProject {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.println("Choose which operation you wish to perform:\n"
					+ "Matrix Operations:\n\t1. Addition\n\t2. Subtraction\n\t3. Multiplication\n\t"
					+ "4. Transpose\nVector Operations:\n\t5. Dot Product\n\t6. Cross Product \n\t7. Magnitude"
					+ "\n\t8. Angle bewteen vectors\n\t9. Area of a Triangle\n10. Exit Program");
			choice = sc.nextInt();
			if (choice == 1) {
				addMatrices();
			} else if (choice == 2) {
				subtractMatrices();
			} else if (choice == 3){
				multiplyMatrices();
			} else if (choice == 4) {
				transpose();
			} else if (choice == 5) {
				dotProduct();
			} else if (choice == 6) {
				crossProduct();
			} else if (choice == 7) {
				magnitude();
			} else if (choice == 8) {
				angleBetweenVectors();
			} else if (choice == 9) {
				areaOfATriangle();
			}
		} while(choice != 10);
		sc.close();
	}

	/**
	 * Adds user inputed matrics A and B. This method assumes user will
	 *  only enter in numbers, and the correct amount of numbers as well.
	 *  @return the resulting matrix after adding matrix A and B
	 */
	public static double[][] addMatrices() {
		double[][] matrix1;
		double[][] matrix2;
		double[][] resultMatrix;
		int size;
		size = getMatrixSize();
		matrix1 = new double[size][size];
		matrix2 = new double[size][size];
		matrix1 = fillMatrix(size, size,  matrix1);
		matrix2 = fillMatrix(size, size, matrix2);
		resultMatrix = new double[size][size];
		System.out.println("\nResult matrix:");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
		return resultMatrix;
	}

	/**
	 * Adds matrices A and B. This method assumes
	 *  the matrices sent in are the same size.
	 *  @param matrix1 the first matrix to be added
	 *  @param matrix2 the second matrix to be added  
	 *  @return the resulting matrix after adding matrix A and B
	 */
	public double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
		int size = matrix1.length;
		double[][] resultMatrix = new double[size][size];
		for (int x =0; x < size; x++) {
			for (int y = 0; y < size; y++) {

			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return resultMatrix;
	}

	/**
	 * Subtracts user inputed matrices A and B. This method assumes user will
	 * only enter in numbers, and the correct amount of numbers as well.
	 * @return The resulting matrix after subtracting matrix A and B
	 */
	public static double[][] subtractMatrices() {
		double[][] matrix1;
		double[][] matrix2;
		double[][] resultMatrix;
		int size;
		size = getMatrixSize();
		matrix1 = new double[size][size];
		matrix2 = new double[size][size];
		matrix1 = fillMatrix(size, size, matrix1);
		matrix2 = fillMatrix(size, size, matrix2);
		resultMatrix = new double[size][size];
		System.out.println("\nResult matrix:");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("\n");
		return resultMatrix;
	}
	
	/**
	 * Subtracts matrices A and B. This method assumes
	 *  the matrices sent in are the same size.
	 *  @param matrix1 the first matrix to be subtracted
	 *  @param matrix2 the second matrix to be subtracted 
	 *  @return The resulting matrix after subtracting matrix A and B
	 */
	public double[][] subtractMatrices(double[][] matrix1, double[][] matrix2) {
		int size = matrix1.length;
		double[][] resultMatrix = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
			}
		}
		return resultMatrix;
	}

	/**
	 * Multiplies user inputed matrices A and B. This method assumes the
	 *  user will only enter numbers and the correct amount of numbers.
	 *
	 * @return the resulting 2D matrix from matrix A X matrix B.
	 */
	public static double[][] multiplyMatrices() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double[][] matrix1;
		double[][] matrix2;
		int row1 = 0, row2 = 0;
		int col1 = 0, col2 = 0;
		boolean okM1 = false;
		boolean okM2 = false;
		boolean canMultiply = false;
		do {
			while(okM1 == false) {
				System.out.printf("Enter the dimensions of the 1st matrix"
						+ " (row col), row and col must be"
						+ " in the range 1-4: ");
				row1 = sc.nextInt();
				col1 = sc.nextInt();
				if (row1 < 1 || row1 > 4 || col1 < 1 || col1 > 4) {
					System.out.println("Error row and col must be in range 1-4.\n");
				} else
					okM1 = true;
			}
			while (okM2 == false) {
				System.out.printf("Enter the dimensions of the 2nd matrix"
						+ " (row col). row and col must be"
						+ " in the range 1-4: ");
				row2 = sc.nextInt();
				col2 = sc.nextInt();
				if (row2 < 1 || row2 > 4 || col2 < 1 || col2 > 4) {
					System.out.println("Error row and col must be in range 1-4.\n");
				} else
					okM2 = true;
			} 
			if (col1 != row2) {
				System.out.println("Error, the columns of matrix 1 must"
						+ " equal the rows of matrix 2.\n");
				okM1 = false;
				okM2 = false;
			}
			else
				canMultiply = true;	
		} while(canMultiply == false);
		matrix1 = new double[row1][col1]; 
		matrix2 = new double[row2][col2];
		fillMatrix(row1, col1, matrix1);
		fillMatrix(row2, col2, matrix2);

		/* Creates a 2D matrix with row size from rows from array C 
         and column size from array D.                           */                                   
		double[][] resultMatrix = new double[matrix1.length]
				[matrix2[0].length];

		System.out.println("\nResult Matrix:");
		/* For-loop to process each element of the array C and array D  
         and multiplies to arrayProduct.                             */
		for (int cRow = 0; cRow < matrix1.length; cRow++) {
			for (int dCol = 0; dCol < matrix2[0].length; dCol++) {
				for (int index = 0; index < matrix1[0].length; index++) {
					resultMatrix[cRow][dCol] += matrix1[cRow][index] * 
							matrix2[index][dCol];
				}					
				System.out.print(resultMatrix[cRow][dCol] + " ");
			}
			System.out.println();
		}
		System.out.println();
		return resultMatrix;
	}
	
	/**
	 * Multiplies user inputed matrices A and B. This method assumes the
	 *  user will only enter numbers and the correct amount of numbers.
	 *
	 * @param matrix1 the first matrix to be multiplied
	 * @param matrix2 the first matrix to be multiplied
	 * @return the resulting 2D array from Array C X Array D.
	 */
	public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
		/* Creates a 2D array with row size from rows from array C 
        and column size from array D.                           */                                   
		double[][] resultMatrix = new double[matrix1.length]
				[matrix2[0].length];

		/* For-loop to process each element of the array C and array D  
        and multiplies to arrayProduct.                             */
		for (int cRow = 0; cRow < matrix1.length; cRow++) {
			for (int dCol = 0; dCol < matrix2[0].length; dCol++) {
				for (int index = 0; index < matrix1[0].length; index++) {
					resultMatrix[cRow][dCol] += matrix1[cRow][index] * 
							matrix2[index][dCol];
				}
			}
		}
		return resultMatrix;
	}
	
	/** 
		This will transpose one matrix of the specified size into its transpose

		@return the transposed matrix
	 */
	public static double[][] transpose() {
		double[][] matrix;
		int size;
		size = getMatrixSize();

		matrix = new double[size][size];
		fillMatrix(size, size, matrix);

		System.out.println("\nInitial matrix:");
		for (int k = 0; k < size; k++) {
			for (int l = 0; l < size; l++) {
				System.out.print(matrix[k][l] + " ");
			}
			System.out.print("\n");
		}
		double[][] resultMatrix = new double[size][size];
		System.out.println("\nResult matrix:");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				resultMatrix[i][j] = matrix[j][i];
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("\n");
		return resultMatrix;
	}

	/*
	 * Transposes the matrix.
	 * 
	 * @return the transposed matrix
	 */
	public static double[][] transpose(double[][] matrix) {
		int size;
		size = matrix.length;
		fillMatrix(size, size, matrix);
		double[][] resultMatrix = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				resultMatrix[i][j] = matrix[j][i];
			}
		}
		return resultMatrix;
	}
	/**
	 * This method performs dot product calculation based on user
	 * entered vectors on a x y z plane.
	 * The method handles user input error to make sure that user
	 * input is always valid.
	 * 
	 * @return the dot product of the two vectors
	 */
	public static double dotProduct() {
		double[] vector1 = new double[3];
		double[] vector2 = new double[3];
		int count = 0;
		int run = 1;
		do {
			System.out.print("\nEnter 3 numbers for vector " + run + ", separated by spaces (Type 0 "
					+ "for specific coordinate that is not present): ");
			count = 0;
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			Scanner lineCheck = new Scanner(line);

			// Counts the amount of numbers the user entered.
			while(lineCheck.hasNextDouble()) {
				lineCheck.nextDouble();
				count++;
			}
			lineCheck.close();

			// Checks to make sure user enters 3 numbers ONLY.
			if (count != 3) {
				System.out.println("Error: User input invalid! Try again.");
			} else {
				int index = 0;
				Scanner value = new Scanner(line);
				if (run == 1) {
					while (value.hasNextDouble()) {	
						vector1[index] = value.nextDouble();
						index++;
					}
				} else if (run == 2) {
					while (value.hasNextDouble()) {
						vector2[index] = value.nextDouble();
						index++;
					}
				}
				value.close();
				run++;
			}
		} while (run < 3 || count != 3);

		// Calculating dot product of the two vectors.
		double first = (vector1[0] * vector2[0]);
		double second = (vector1[1] * vector2[1]);
		double third = (vector1[2] * vector2[2]);
		double result = (vector1[0] * vector2[0]) + (vector1[1] * vector2[1]) +
				(vector1[2] * vector2[2]);

		// Prints out the result.
		System.out.print("\nResult: <");
		for (int i = 0; i < vector1.length - 1; i++) {
			System.out.print(vector1[i] + ", ");
		}
		System.out.print(vector1[vector1.length - 1] + "> * <");
		for (int i = 0; i < vector2.length - 1; i++) {
			System.out.print(vector2[i] + ", ");
		}
		System.out.print(vector2[vector1.length - 1] + "> = ");
		System.out.printf("%.2f + %.2f + %.2f = %.2f\n\n", first, second, third, result);
		return result;
	}

	/**
	 * This method performs dot product calculation based on two vectors passed in.
	 * 
	 * @param vector1 the first vector
	 * @param vector2 the second vector
	 * @return the dot product of the two vectors
	 */
	public static double dotProduct(double[] vector1, double[] vector2) {
		double result = (vector1[0] * vector2[0]) + (vector1[1] * vector2[1]) +
				(vector1[2] * vector2[2]);
		return result;
	}
	/**
	 * This method performs cross product calculation based on user
	 * entered vectors on a x y z plane.
	 * The method handles user input error to make sure that user
	 * input is always valid.
	 * 
	 * @return the cross product of the two vectors
	 */
	public static double[] crossProduct() {
		double[] vector1 = new double[3];
		double[] vector2 = new double[3];
		int count = 0;
		int run = 1;
		do {
			System.out.print("\nEnter 3 numbers for vector " + run + ", separated by spaces (Type 0 "
					+ "for specific coordinate that is not present): ");
			count = 0;
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			Scanner lineCheck = new Scanner(line);

			// Counts the amount of numbers the user entered.
			while(lineCheck.hasNextDouble()) {
				lineCheck.nextDouble();
				count++;
			}
			lineCheck.close();

			// Checks to make sure user enters 3 numbers ONLY.
			if (count != 3) {
				System.out.println("Error: User input invalid! Try again.");
			} else {
				int index = 0;
				Scanner value = new Scanner(line);
				if (run == 1) {
					while (value.hasNextDouble()) {	
						vector1[index] = value.nextDouble();
						index++;
					}
				} else if (run == 2) {
					while (value.hasNextDouble()) {
						vector2[index] = value.nextDouble();
						index++;
					}
				}
				value.close();
				run++;
			}
		} while (run < 3 || count != 3);

		// Calculating cross product.
		double iVector = (vector1[1] * vector2[2]) - (vector1[2] * vector2[1]);
		double jVector = (vector1[2] * vector2[0]) - (vector1[0] * vector2[2]);
		double kVector = (vector1[0] * vector2[1]) - (vector1[1] * vector2[0]);
		double[] resultVector = {iVector, jVector, kVector};
		// Prints out the result.
		System.out.print("\nResult: <");
		for (int i = 0; i < vector1.length - 1; i++) {
			System.out.print(vector1[i] + ", ");
		}
		System.out.print(vector1[vector1.length - 1] + "> X <");
		for (int i = 0; i < vector2.length - 1; i++) {
			System.out.print(vector2[i] + ", ");
		}
		System.out.print(vector2[vector1.length - 1] + "> = ");
		System.out.printf("<%.2f %.2f %.2f>\n\n", iVector, jVector, kVector);
		return resultVector;
	}

	/**
	 * This method performs cross product calculation based on two vectors passed in.
	 * 
	 * @param vector1 the first vector
	 * @param vector2 the second vector
	 * @return the cross product of the two vectors
	 */
	public static double[] crossProduct(double[] vector1, double[] vector2) {
		// Calculating cross product.
		double iVector = (vector1[1] * vector2[2]) - (vector1[2] * vector2[1]);
		double jVector = (vector1[2] * vector2[0]) - (vector1[0] * vector2[2]);
		double kVector = (vector1[0] * vector2[1]) - (vector1[1] * vector2[0]);
		double[] resultVector = {iVector, jVector, kVector};
		return resultVector;
	}

	/*
	 * Gets the magnitude of the vector
	 * 
	 * @return the magnitude of the vector
	 */
	public static double magnitude() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		System.out.print("\nEnter 3 numbers for the vector , separated by spaces (Type 0 "
				+ "for specific coordinate that is not present): ");
		for (int i = 0; i < 3; i++) {
			sum += Math.pow(sc.nextInt(), 2);
		}
		System.out.printf("The magnitude of the vector is: sqrt(%d" + 
				") or %.3f\n\n", sum, Math.sqrt(sum));
		return sum;
	}

	/*
	 * Gets the magnitude of the vector
	 * 
	 * @param vector the vector
	 * @return the magnitude of the vector
	 */
	public static double magnitude(double[] vector) {
		double magnitude = 0;
		for (int i= 0; i < 3; i++) {
			magnitude += Math.pow(vector[i], 2);
		}
		magnitude = Math.sqrt(magnitude);
		return magnitude;
	}

	/*
	 * Gets the angle between the two vectors. This method assumes
	 *  only numbers will be inputed and the correct amount of numbers will be inputed.
	 *  
	 *  @return the angle between the vectors
	 */
	public static double angleBetweenVectors() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double[] vector1 = new double[3];
		double[] vector2 = new double[3];
		int dotProduct = 0;
		double magnitude1 = 0;
		double magnitude2 = 0;
		double result;
		String degree  = "\u00b0";
		System.out.print("\nEnter 3 numbers for vector 1, separated by spaces (Type 0 "
				+ "for specific coordinate that is not present): ");
		for(int i = 0; i < 3; i++) {
			vector1[i] = sc.nextDouble();
		}
		System.out.print("\nEnter 3 numbers for vector 2, separated by spaces (Type 0 "
				+ "for specific coordinate that is not present): ");
		for(int j = 0; j < 3; j++) {
			vector2[j] = sc.nextDouble();
		}
		if ((vector1[0] == vector1[1] && vector1[0] == vector1[2]) 
				&& (vector2[0] == vector2[1] && vector2[0] == vector2[2])) {
			result = 0.0;
		} else {
			for (int k= 0; k < 3; k++) {
				dotProduct += vector1[k] * vector2[k];
			}
			magnitude1 = magnitude(vector1);
			magnitude2 = magnitude(vector2);
			result = Math.toDegrees(Math.acos(dotProduct / (magnitude1 * magnitude2)));
		}
		System.out.printf("\nThe angle between <%.2f, %.2f, %.2f> and"
				+ " <%.2f, %.2f, %.2f> is %.3f%s\n\n",
				vector1[0], vector1[1], vector1[2], vector2[0],
				vector2[1], vector2[2], result, degree);
		return result;
	}
	
	/*
	 * Gets the angle between the two vectors.
	 *  
	 * @param vector1 the first vector
	 * @param vector2 the second vector
	 * @return the angle between the vectors
	 */
	public static double angleBetweenVectors(double[] vector1, double[] vector2) {
		int dotProduct = 0;
		double magnitude1 = 0;
		double magnitude2 = 0;
		double result;
		if ((vector1[0] == vector1[1] && vector1[0] == vector1[2]) 
				&& (vector2[0] == vector2[1] && vector2[0] == vector2[2])) {
			result = 0.0;
		} else {
			for (int k= 0; k < 3; k++) {
				dotProduct += vector1[k] * vector2[k];
			}
			magnitude1 = magnitude(vector1);
			magnitude2 = magnitude(vector2);
			result = Math.toDegrees(Math.acos(dotProduct / (magnitude1 * magnitude2)));
		}
		return result;
	}

	/*
	 * Calculates the area of the triangle.
	 * 
	 * @return the area of the triangle
	 */
	public static double areaOfATriangle() {
		double[] point1 = createPoint();
		double[] point2 = createPoint();
		double[] point3 = createPoint();
		double[] vector1 = createVector(point1, point2);
		double[] vector2 = createVector(point1, point3);
		double[] crossProduct = crossProduct(vector1, vector2);
		double area = magnitude(crossProduct) / 2;
		System.out.printf("The area of the triangle is: %.2f\n\n", area);
		return area;
	}
	
	/*
	 * Calculates the area of the triangle.
	 *
	 * @param point1 the first point
	 * @param point2 the second point
	 * @param point3 the third point
	 * @return the area of the triangle
	 */
	public static double areaOfATriangle(double[] point1, double[] point2, double[] point3) {
		double[] vector1 = createVector(point1, point2);
		double[] vector2 = createVector(point1, point3);
		double[] crossProduct = crossProduct(vector1, vector2);
		double area = magnitude(crossProduct) /2;
		return area;
	}
	
	/* HELPER METHODS */
	
	/*
	 * Fills the matrix with user inputed values. This method
	 *  assumes only numbers will be inputed and the correct amount of numbers will be inputed.
	 *  
	 *  @param row the amount of rows the matrix has
	 *  @param col the amount of cols the matrix has
	 *  @return the matrix after it was filled with values
	 */
	public static double[][] fillMatrix(int row, int col,  double[][] matrix) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int count = 1;
		for (int x = 0; x < row; x++) {
			System.out.printf("Enter the %d row of numbers for "
					+ "the matrix (%d X %d), seperated by spaces: ", count, row, col);
			for(int y = 0; y < col; y++) {
				matrix[x][y] = sc.nextInt();
			}
			count++;
		}
		return matrix;
}
	/*
	 * Gets the size of the matrix
	 * 
	 * @return the size of the matrix
	 */
	public static int getMatrixSize() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int size = 0;
		int choice;
		do {
			System.out.println("Enter the size of the matrix that you want to perform operations on:\n"
					+ "1. 2 x 2\n2. 3 x 3\n3. 4 x 4");
			choice = sc.nextInt();
			if (choice < 1 || choice > 3)
				System.out.println("Error, must choose one of the given options.\n");
		} while(choice < 1 || choice > 3);
		if (choice == 1) {
			size = 2;
		} else if (choice == 2) {
			size = 3;
		} else if (choice == 3) {
			size = 4;
		}
		return size;
	}
	
	/*
	 * Gets the user inputed point for the triangle.
	 *  This method assumes the user will only input
	 *   numbers and also the correct amount of numbers.
	 * 
	 * @return the point of the triangle
	 */
	private static double[] createPoint() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double[] point = new double[3];
		System.out.printf("Enter a point for the triangle (x y z), seperated by spaces. (Type 0 "  
				+ "for specific coordinate that is not present): ");
		for (int i = 0; i < 3; i++) {
			point[i] = sc.nextInt();
		}
		return point;
	} 

	/*
	 * Creates a vector from two points.
	 * 
	 * @param point1 the first point
	 * @param point2 the second point
	 * @return the vector created from two points
	 */
	public static double[] createVector(double[] point1, double[] point2) {
		double[] vector = new double[3];
		for (int i = 0; i < 3; i++) {
			vector[i] = point2[i] - point1[i];
		}
		return vector;
	}
}
