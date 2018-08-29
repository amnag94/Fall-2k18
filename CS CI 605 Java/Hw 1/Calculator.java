import java.util.Vector;
import java.util.Stack;

/*
Program uses 3 main data points
1. Operand Stack 
2. Operator Stack 
3. string accessed as char array to provide order to the precedence to the operator

The main method of the program simply calls the performCalculation method and passes a string array 
performCalculation method uses vector, traverses the string array and adds to the vector  {why is the string array converted to Vector ?}
performCalculation only converts the string array to vector and prints the input string and makes call to the calculate method and passes the generated vector of input



*/

public class Calculator {

	// See https://docs.oracle.com/javase/10/docs/api/java/util/Stack.html
    static Stack<Double> numberStack = new Stack<Double>();
    static Stack<String> operatorStack = new Stack<String>();
	// See https://docs.oracle.com/javase/10/docs/api/java/lang/String.html
    static String operators =  "+-%*/^" ;	

    public static void main (String args []) {
	performCalculation("2", "+", "3");
	performCalculation("2", "+", "3", "*", "3");
	performCalculation("2", "*", "3", "+", "3");
	performCalculation("2", "+", "3", "^", "4");
	performCalculation("2", "^", "3", "+", "4");
	performCalculation("2", "^", "3", "^", "4");
    }

    // See https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
    public static void performCalculation (String ... valuesAndOperators)	{
	Vector<String> aLine = new Vector<String>();
	for ( String valuesAndOperator: valuesAndOperators )	{
		aLine.add(valuesAndOperator);
		System.out.print(valuesAndOperator + " ");
	}
	System.out.println(" =  " + calculate(aLine) );
    }
    /** drives the calculation and returns the result
     */

     /*
     iterate through the vector, character by character by character
     if the current character is operator then call the performOperator method and pass the operator
     else the current character must be an operand so call performNumber method and pass the operand
     then remove 
     while something is left in the vector, ei
     */
    public static double calculate (Vector<String> inputLine) {
	while ( inputLine.size() >= 1 )	{
		if ( operator( inputLine.firstElement() )	)
			performOperator(inputLine.firstElement());
		else
			performNumber(inputLine.firstElement());

		inputLine.removeElementAt(0);
	}
	while ( !  operatorStack.empty() )	{
		if ( numberStack.size() > 1 )
			evaluate();
		else	{
			System.out.println("dangling operand ....");
			System.out.println(numberStack);
			System.exit(1);
		
		}
	}

	return numberStack.pop();
    }

    /** perform the required operation based on precedence of the operators on the stack
     */
    public static boolean operator (String op) {
	return ( operators.indexOf(op) >= 0 );
    }

    /** deteremence a precedence level for the operator
     */
    public static int precedence (String op) {
	return operators.indexOf(op);
    }

    /** perform the required operation based on precedence on the stack
     */
    public static void performOperator (String op) {
		while (! operatorStack.empty()  &&
			(  precedence(op) < precedence(operatorStack.peek() ) )
		      )
				evaluate();
		operatorStack.push(op);
    }

    /** pushes the number on the number stack
     */
    public static void performNumber (String number) {
		numberStack.push(Double.valueOf(number));
    }

    /** get the number of the stack, if a number is available, else RIP
     */
    public static double  getNumber () {
	if ( numberStack.empty() ){
		System.out.println("not enough numbers ...");
		System.exit(2);
	} 
	return numberStack.pop();
    }

    /** perform the required ovperation based on the operator in the stack
     */
    public static void evaluate () {
		String currentOp = operatorStack.pop();
		double right = getNumber();
		double left = getNumber();
		if ( currentOp.equals("+") )
			numberStack.push( left + right );
		else if ( currentOp.equals("-") )
			numberStack.push( left - right );
		else if ( currentOp.equals("*") )
			numberStack.push( left * right );
		else if ( currentOp.equals("%") )
			numberStack.push( left % right );
		else if ( currentOp.equals("/") )
			numberStack.push( left / right );
		else if ( currentOp.equals("^") )
			numberStack.push( Math.pow(left , right ) );
		else
			System.out.println("Unknow Operator");
    }
}