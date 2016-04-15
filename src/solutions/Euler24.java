/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Alex
 */
public class Euler24 {

//    private class Suffix{
//        int start;
//        int end;
//        
//        private Suffix(int start, int end){
//            this.start = start;
//            this.end = end;
//        }
//    }
    private static Optional<Integer> getLargestIndexGreaterThanLeftNeighbour(int[] array) {

        for (int i = array.length - 1; i >= 1; i--) {

            if (array[i] > array[i - 1]) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    private static Optional<Integer> getPivot(int i, int[] array) {
        for (int j = array.length - 1; j >= i; j--) {
            if (array[j] > array[i - 1]) {
                return Optional.of(j);
            }
        }
        return Optional.empty();
    }

    private static int[] swap(int a, int b, int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        newArray[a] = array[b];
        newArray[b] = array[a];
        return newArray;
    }

    private static int[] reverseFrom(int i, int[] array) {
        int[] newArray = new int[array.length];
        int lastIndex = array.length - 1;
        for (int k = 0; k < i; k++) {
            newArray[k] = array[k];
        }
        int h = 0;
        for (int j = i; j < array.length; j++) {

            newArray[j] = array[lastIndex - h];
            h++;
        }
        return newArray;
    }

    private static int[] nextPermutation(int[] array) {
        Optional<Integer> i = getLargestIndexGreaterThanLeftNeighbour(array);

        Optional<Integer> j = getPivot(
                i.orElseThrow(() -> new IllegalArgumentException()), array);
        array = swap(j.orElseThrow(() -> new IllegalArgumentException()), i.get() - 1, array);
        return reverseFrom(i.get(), array);
    }

    private static int[] nthPermutation(int n, int[] array) {
        for (int i = 1; i < n; i++) {
            array = nextPermutation(array);
        }
        return array;
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int[] b = {2, 3, 1};
        //System.out.println(getLargestIndexGreaterThanLeftNeighbour(b));
        //print(nextPermutation(b));
        print(nthPermutation(1000000, a));
        //print(swap(0, 3, a));
        //print(a);
//        int [] aReversed = reverseFrom(1, a);
//        for(int i = 0; i < aReversed.length; i++){
//            System.out.println(aReversed[i]);
//        }
//   

    }

}
