/**
 * Prime.java
 * 
 * Version :
 *          1
 * Revisions : 
 *          1
 */


 /**
  * This program Finds the sum of the prime factors of a given number 
  *
  * @author Ketan Balbhim Kokane
  * @author Ameya Deepak Nagnur
  */

public class Prime {

    /**
     * The main Program 
     * 
     * @params  args     command Line arguments(ignored) 
     */

    public static void main(String args[]) {
        int internalArrayIndex = 0;
        for (int index = 2; index <= 10; index++)
        {
            if (isPrime(index)) {
                // print directly
                //printResult(new int[]{index},index);
                primeNumbersUptoN[internalArrayIndex] = index;
                internalArrayIndex++;
            }
        }

        {
            for (int index = 2; index <= 10; index++) {
                int N = index;
                int i = 0, j = 1;
                while (N > 1) {
                    if (N % primeNumbersUptoN[i] == 0) {
                        result[0] += primeNumbersUptoN[i];
                        result[j] = primeNumbersUptoN[i];
                        N = N / primeNumbersUptoN[i];
                        j++;
                        i = 0;
                    } else {
                        i++;
                    }

                }
                printResult(result,index);
                result = new int[5];
            }
        }



    }

    public static int[] primeNumbersUptoN = new int[4];
    public static int[] result = new int[5];
    public static boolean isPrime(int n) {

        for (int index = 2; index < n; index++) {
            if (n % index == 0)
                return false;
        }
        return true;
    }

    public static void printResult(int[] result, int index){
        System.out.print("The sum of all primes for "+ index+ ": "+result[0] + "  (");
        for (int i = 1; i < result.length; i++) {
            
            if(result[i]!=0)
            {
                if(i > 1)
                    System.out.print(" + ");
                System.out.print(result[i]);
            }
                
            
        }
        System.out.print(")");
        System.out.println();
    }

}
