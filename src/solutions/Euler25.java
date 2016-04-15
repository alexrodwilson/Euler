/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

import java.math.BigInteger;

/**
 *
 * @author Alex
 */
public class Euler25 {
    
    private static int nOfDigits(BigInteger number){
        return String.valueOf(number).length();
    }
    
    private static long fibIter(int digitsToContain){
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int count = 2;
        do{
            BigInteger temp = b;
            b = a.add(b);
            a = temp;
            count++;
        }while(nOfDigits(b) < digitsToContain);
        return count;
    }
    public static void main(String[] args) {
        //System.out.println(nOfDigits(100));
        System.out.println(fibIter(1000));
    }
}
