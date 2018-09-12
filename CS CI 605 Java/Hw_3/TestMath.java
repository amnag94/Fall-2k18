/**
 * @author ketan kokane
 * @author Ameya Nagnur
 */
public class TestMath {
    final static private Double ZERO = 0.0;
    /**
     *
     * @param input
     * @return
     */
    public static Double abs(Double input){

        if (input == ZERO){
            return ZERO;
        }
        if (input < ZERO){
            return input * -1.0;
         }
         else {
             return input;
         }
    }

    /**
     *
     * @param numberOne
     * @param numberTwo
     * @return
     */
    public static int max(int numberOne, int numberTwo){
        if (numberOne >= numberTwo){
            return numberOne;
        }
        else {
            return numberTwo;
        }
    }

    /**
     *
     * @param number
     * @return
     */
    public  static Double sqrt(Double number){
    Double InitialEstimation;
        Double result = getInitialEstimate(number);
        int i =0;
        do{
            InitialEstimation = result;
            result = 0.5 * (result + (number/result));
            i++;
        } while (InitialEstimation - result > 0.000000001 );
        System.out.println(i);
        return result;
    }

    private static Double getInitialEstimate(Double number) {
        return 10000000000000.0;
    }

    public static void main(String args[]){
        double result;
        double aDouble;
        double theDoubles[] = {1, 2, 3, 4, 5 };
        for ( int index = 0; index < theDoubles.length; index ++ ) {
            result = sqrt(theDoubles[index]);
            if ( abs( result * result - theDoubles[index] ) > 0.000000001 )
                System.out.println("Test 5: sqrt failed: " + ( result * result - theDoubles[index] ));
        }
    }

}
