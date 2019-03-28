/**
 * This program is used to find the calculator operations
 * @author Ashitha
 *class name Arithmetic
 */
public class Arithmetic {
/**
 * This method is used to find addition of numbers
 * @param number1
 * @param number2
 * @return
 */
	public double Add(double number1,double number2)
	{
	return number1+number2;
	}
	/**
	 * This method is used to find multiplication of numbers
	 * @param number1
	 * @param number2
	 * @return
	 */
	public double Mul(double number1,double number2)
	{
	return number1*number2;
	}
	/**
	 * This method is used to find division of numbers
	 * @param number1
	 * @param number2
	 * @return
	 */
	public double Div(double number1,double number2)
	{
		try
		{
			return (number1/number2);
		}
		catch(Exception e)
		{
			return Integer.parseInt(e.getMessage());
		}
	}
}
