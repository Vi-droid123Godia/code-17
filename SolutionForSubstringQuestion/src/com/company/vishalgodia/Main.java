package com.company.vishalgodia;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }


    public static String getSmallestAndLargest(String s, int k) {
        String currentString = s.substring(0, k);
        String smallest = currentString;
        String largest = currentString;

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for (int i = k; i < s.length(); i++) {
            currentString = currentString.substring(1, k) + s.charAt(i);
            int[] array1Current;
            int[] array2Smallest;
            int[] array3Largest;
            array1Current = findAsciiCode(currentString);
            array2Smallest = findAsciiCode(smallest);
            array3Largest = findAsciiCode(largest);
            for (int j = 0; j < k; j++) {
                if (array1Current[j] == array2Smallest[j]) {
                    continue;
                } else if (array1Current[j] < array2Smallest[j]) {
                    smallest = currentString;
                }else{
                    break;
                }
            }
            for (int j = 0; j < k; j++) {
                if (array1Current[j] == array3Largest[j]) {
                    continue;
                } else if (array1Current[j] > array3Largest[j]) {
                    largest = currentString;
                }else{
                    break;
                }
            }

        }        return smallest + "\n" + largest;
    }
     public static int[] findAsciiCode(String toCheck){
         int[] myIntegerArray = new int[toCheck.length()];
         for(int i = 0; i < toCheck.length(); i++){
             myIntegerArray[i] =  toCheck.charAt(i);
         }
         return myIntegerArray;
     }
}


