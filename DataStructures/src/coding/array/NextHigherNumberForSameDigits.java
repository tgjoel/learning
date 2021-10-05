package coding.array;

/*
Given a number n, find the smallest number that has same set of digits as n and is greater than n.
If n is the greatest possible number with its set of digits, then print “not possible”.
Input:  n = "218765"
Output: "251678"

Input:  n = "1234"
Output: "1243"

Input: n = "4321"
Output: "Not Possible"
https://www.youtube.com/watch?v=fOeD3CW2c7c
 */
public class NextHigherNumberForSameDigits {

    public static void main(String[] args) {

        int n = 218765;

        //checking for the element which is greater than the current from the right
        int prevRem = Integer.MIN_VALUE;
        int currRem = Integer.MIN_VALUE;
        int[] count = new int[10]; // this is to store the number of times each digit is repeated.
        while (n > 0) {
            currRem = n % 10;
            n = n / 10;
            count[currRem]++;
            //comparing each of the digits to get if one is greater than the other or not. once we get it we need to replace
            // this with a number immediate greater than the number
            if (prevRem > currRem) {
                //now we need to find the number which is immediate larger than the current number.
                int i = currRem + 1;  // using the count array and getting the number
                for (; i < 10; i++) {
                    if(count[i] > 0) {
                        break;
                    }
                }
                n = n * 10 + i; // adding the number we got to the actual number.
                count[i]--; // reducing the count as we used the number
                //now we need to populate the rest of the numbers in ascending sorted order. can be attained by using the count array
                for (int j = 0; j < 10; j++) {
                    for (int k = count[j]; k > 0; k--) {
                        n = n * 10 + j;
                    }
                }
                //print the n as we have found the number
                System.out.println(n);
                break;
            }
            prevRem = currRem;
        }
        // if the loop continues till n == 0 then the numbers are in decending order and then its not possible
        if (n == 0) System.out.println("Not possible");
    }
}
