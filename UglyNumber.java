// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : As we need to check the factors of only 2,3 and 5, we can solve the problem using 3 pointers that points each of one factor.
// We create an array and store 1 in 0th index as it is considered to be in result. We maintain n2, n3 and n5 with 2,3 and 5 values.
// We add the minimum of these values to the arr, increment the corresponding pointer and update it's value by multiplying with 2,3 or 5 based
// on which value we inserted into the array. We continue until n and n-1 element in the array gives the result.

class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        //pointers
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        //values
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        for(int i = 1; i<n;i++){
            arr[i] = Math.min(n2, Math.min(n3,n5)); //insert the minimum at index

            if(arr[i] == n2){
                p1++; //move pointer
                n2 = 2*arr[p1]; //update n2
            }

            if(arr[i] == n3){
                p2++; //move pointer
                n3 = 3*arr[p2]; //update n3
            }

            if(arr[i] == n5){
                p3++; //move pointer
                n5 = 5*arr[p3]; //update n5
            }
        }
        return arr[n-1];
    }
}