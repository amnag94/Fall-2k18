public class Sticks
{
    public static int knownSticks [] = { 1, 5, 8, 12, 12, 35, 35, 35, 61 };
    public static int[] unknowStickLengths = { 1, 6, 9, 24, 110, 111, 115, 62, 24, 202, 203, 204, 205 };
    public static int stickCombo(int knownSticks[], int sum, int usedArray[])
    {
        int leftSum = sum, result = 2;
        int n = knownSticks.length;
        for(int i = n-1; i >= 0; i--)
        {

            if(sum > knownSticks[i] && usedArray[i]!=1)
            {
                leftSum = sum - knownSticks[i];
                usedArray[i] = 1;
                result = stickCombo(knownSticks,leftSum,usedArray);
                if(result==0)
                    break;
                if (result == -1)
                {
                    usedArray[i]= 0;
                    continue;
                }

            }
            else if(sum == knownSticks[i]  && usedArray[i]!=1)
            {
                usedArray[i]=1;
                int temp = 0;
                //3 inch:        yes; used sickLengths = 3 inch
                for(int j=0; j < usedArray.length;j++){
                    if(usedArray[j]==1)
                    {
                        temp+= knownSticks[j];
                    }
                }
                System.out.print(temp + " inch:\t yes; used sickLengths = " );
                int temp1 = -1;
                for(int j=0; j < usedArray.length;j++){
                    temp1++;
                    if(usedArray[j]==1)
                    {
                        if(temp1 > 0)
                            System.out.print(", ");
                        System.out.print(knownSticks[j]);

                    }
                }
                System.out.print(" inch");
                System.out.println();
                return 0;
            }
            if(leftSum != 0 && i ==0){
                return -1;
            }
        }
        return result;
    }


    public static void main(String [] args){

        for(int i : unknowStickLengths){
            if(stickCombo(knownSticks,i,new int [knownSticks.length]) == -1)
            {
                System.out.println(i+ " inch:\t No;");
            }
        }
    }
}