/**
 * Sticks.java
 * 
 * Version :
 *          1
 * Revisions : 
 *          1
 */


 /**
  * This program finds a subset of sticks which will sum up to a given number
  *
  * @author Ketan Balbhim Kokane
  * @author Ameya Deepak Nagnur
  */

public class Sticks
{
    public static int LengthFound = 0, LengthNotFound = -1;
    public static int knownSticks [] = { 1, 5, 8, 12, 12, 35, 35, 35, 61 };
    public static int[] unknowStickLengths = { 1, 6, 9, 24, 110, 111, 115, 62, 24, 202, 203, 204, 205 };

    public static void main(String [] args){

        for(int i : unknowStickLengths){
            if(findStickLengthFromKnowSticks(knownSticks,i,new int [knownSticks.length]) == LengthNotFound)
            {
                System.out.println(i+ " inch:\t No;");
            }
        }
    }

    public static int findStickLengthFromKnowSticks(int knownSticks[], int stickLengthToMatch, int usedSticks[])
    {
        
        /**
         * result is assigned a random value in the begining, only value of concern for result is 0 and -1 which is assigned when subset is found
         * and not found respectively
         */

        int remainingStickLength = stickLengthToMatch, stickLengthFound = 2;
        /**
         * as the knownSticks array is sorted, it is traversed in reverse order to tackle the bigger numbers first,
         * can be also be changed to random order to provide same time complexity to all the elements of the array
         * 
         * an Array usedSticks is used to keep the track of the sticks that are already being used
         */
        for(int index = knownSticks.length -1; index >= 0; index--)
        {
            /**
             * Check if the stick length to match is more than the current stick length and also the current stick should not be used already
             */
            if(stickLengthToMatch > knownSticks[index] && usedSticks[index]!=1)
            {
                remainingStickLength = stickLengthToMatch - knownSticks[index];
                usedSticks[index] = 1;
                stickLengthFound = findStickLengthFromKnowSticks(knownSticks,remainingStickLength,usedSticks);
                if(stickLengthFound == LengthFound)
                    break;
                if (stickLengthFound == LengthNotFound)
                {
                    usedSticks[index]= 0;
                    continue;
                }

            }
            else if(stickLengthToMatch == knownSticks[index]  && usedSticks[index]!=1)
            {
                usedSticks[index]=1;
                int temp = 0;// TD: rename this variable

                for(int j=0; j < usedSticks.length;j++){
                    if(usedSticks[j]==1)
                    {
                        temp+= knownSticks[j];
                    }
                }
                System.out.print(temp + " inch:\t yes; used sickLengths = " );
                int temp1 = -1;
                for(int j=0; j < usedSticks.length;j++){
                    temp1++;
                    if(usedSticks[j]==1)
                    {
                        if(temp1 > 0)
                            System.out.print(", ");
                        System.out.print(knownSticks[j]);

                    }
                }
                System.out.print(" inch");
                System.out.println();
                return LengthFound;
            }
            /**
             * when the entire array of know stick lengths is been traversed but the remaining stick length is still not zero
             * means you have exhausted all the options and the sub set of sticks for a given number cannot be found
             */
            if(remainingStickLength != 0 && index ==0){
                return LengthNotFound;
            }
        }
        return stickLengthFound;
    }

}