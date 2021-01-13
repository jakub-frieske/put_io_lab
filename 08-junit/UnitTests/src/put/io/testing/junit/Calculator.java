package put.io.testing.junit;

/**
 * Performs basic arithmetic operations
 * 
 */
public class Calculator {

	/**
	 * Adds two integer numbers
	 * 
	 * @param x
	 *            first number to be added
	 * @param y
	 *            second number to be added
	 * @return sum of the arguments
	 */
	public int add(int x, int y) {
		return x + y;
	}

	/**
	 * Multiplies two integer numbers
	 * 
	 * @param x
	 *            first number to be multiplied
	 * @param y
	 *            second number to be multiplied
	 * @return product of the arguments
	 */
	public int multiply(int x, int y) {
		return x * y;
	}

	/**
	 * Adds two positive integer numbers
	 * 
	 * @param x
	 *            first number to be added (must be positive)
	 * @param y
	 *            second number to be added (must be positive)
	 * @return sum of the arguments
	 * @throws IllegalArgumentException
	 *             when at least one of the arguments is less or equal 0
	 */
	public int addPositiveNumbers(int x, int y) throws IllegalArgumentException {
		if (x <= 0 || y <= 0) {
			throw new IllegalArgumentException("The arguments must be positive");
		} else {
			return add(x, y);
		}
	}
}
