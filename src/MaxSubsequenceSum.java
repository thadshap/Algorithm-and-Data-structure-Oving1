import java.util.ArrayList;

public class MaxSubsequenceSum {

    public static void main (String[]args){
        // Exercise 1-1
        /**int[]priceChangeArray = {-1, 3, -9, 2, 2, -1, 2, -1, -5};
        Result result = maxSubSum(priceChangeArray);
        System.out.println("Max subsequence sum: " + result.maxSum +"\n Start date: " +result.startDate+ "\n End date: " + result.endDate);
        */
        // Exercise 1-2
        /**
         * O(n^2)
         *
         */

        // Exercise 1-3
        ArrayList<Integer> list = new ArrayList<Integer>();

        int n=0;
        while (n<1000){
            list.add(getRandomDoubleBetweenRange(-5,5));
            n++;
        }
        //System.out.println(list.size()+"\n"+ list.toString() +"\n"+ maxSubSumArray(list));
        double startTime = System.nanoTime();
        maxSubSumArray(list);
        double endTime = System.nanoTime();
        System.out.println("Kjøretid med 1000 elementer (millisekunder): " + (endTime-startTime)/1000000);

        list.clear();

        int m=0;
        while (m<10000){
            list.add(getRandomDoubleBetweenRange(-5,5));
            m++;
        }
        double startTime1 = System.nanoTime();
        maxSubSumArray(list);
        double endTime1 = System.nanoTime();
        System.out.println("Kjøretid med 10000 elementer millisekunder): " + (endTime1-startTime1)/1000000);

        int l=0;
        while (l<100000){
            list.add(getRandomDoubleBetweenRange(-5,5));
            l++;
        }
        double startTime2 = System.nanoTime();
        maxSubSumArray(list);
        double endTime2 = System.nanoTime();
        System.out.println("Kjøretid med 100000 elementer millisekunder): " + (endTime2-startTime2)/1000000);
    }

    public static Result maxSubSum(int []a){
        int maxSum = 0;
        int thisSum;
        int startDate = 0;
        int endDate = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum = a[i];
            int tempDate = i+1;
            for (int j = i+1; j < a.length; j++) {
                thisSum += a[j];

                if (thisSum >= maxSum) {
                    maxSum = thisSum;
                    startDate = tempDate;
                    endDate = j+1;
                }
            }
        }
        return new Result(startDate,endDate,maxSum);
    }

    public static int getRandomDoubleBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public static Result maxSubSumArray(ArrayList<Integer> a) {
        int maxSum = 0;
        int thisSum;
        int startDate = 0;
        int endDate = 0;
        for (int i = 0; i < a.size(); i++) {
            thisSum = a.get(i);
            int tempDate = i + 1;
            for (int j = i + 1; j < a.size(); j++) {
                thisSum += a.get(j);

                if (thisSum >= maxSum) {
                    maxSum = thisSum;
                    startDate = tempDate;
                    endDate = j + 1;
                }
            }
        }
        return new Result(startDate, endDate, maxSum);
    }
}



