/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Alex
 */
public class Euler23 {
    
    private static <T, U> List<U> getCombinations(List<T> xs, BiFunction<T,T,U> combiner){
        List<U> results = new ArrayList<>();
        for(int i = 0; i < xs.size(); i++){
            for(int j = i; j < xs.size(); j++){
                results.add(combiner.apply(xs.get(i), xs.get(j)));
            }
        }
        return results;
    }
//    private static <T> List<T> comb(T a, T b){
//        return Arrays.asList(a, b);
//    }
    
    private static List<Integer> getProperDivisors(int n){
        List<Integer> properDivisors = new LinkedList<>();
        for (int i = 1; i <= n / 2; i++){
            if(n % i == 0){
                properDivisors.add(i);
            }
        }
        return properDivisors;
    }
    
    private static IntStream getProperDivisorsStream(int n){
        int half = Math.round((float)n / 2);
        return IntStream.rangeClosed(1, half)
                .filter(i-> n % i == 0);
                
    }
    
    private static boolean isAbundant(int n){
        int sumOfDivisors = 
                getProperDivisorsStream(n)
                .sum();
        return sumOfDivisors > n;           
    }
    
    private static Integer add(Integer a, Integer b){
        return a + b;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Integer> abundants = IntStream
                .range(1, 20162)
                .filter(Euler23::isAbundant)
                .boxed()
                .collect(Collectors.toList());
        
        List<Integer>abundantSums = getCombinations(abundants, Euler23::add);
        System.out.println(IntStream.rangeClosed(1, 20162)
                .filter(n->! abundantSums.contains(n))
                .sum());
        
    }
    
}
