/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.IntStream;

/**
 *
 * @author Alex
 */
public class Euler26 {
    
    private static boolean stringEquals(String a, String b){
       // int shortestStringLength = Math.min(a.length(), b.length());
//        for (int i = 0; i < shortestStringLength; i++){
//            if(a.charAt(i) != b.charAt(i)){
//                return false;
//            }
//        }
//        return true;
       return a.equals(b);
    }
    
    private static boolean isSingleNumberRepeated(String sequence){
        return sequence.chars()
                .allMatch(ch -> ch == sequence.charAt(0));
    }
    private static int longestRecurringCycle(String expansion){
        int longestCycleLength = 0;
        int lastIndex = expansion.length() - 1;
        for(int i = 0; i < lastIndex; i++){
            for(int j = i + 2; j < expansion.length(); j++){
                String possCycle = expansion.substring(i, j);
                String rest = 
                        expansion.substring(j, Math.min(j + possCycle.length(), expansion.length()));
                if(stringEquals(possCycle, rest)){
                    if (isSingleNumberRepeated(possCycle)){
                        possCycle = "1";
                    }
                    longestCycleLength = Math.max(longestCycleLength, possCycle.length());
                }
            }
        }
        return longestCycleLength;
    }
    
    
    private static String getExpansionAsString(BigDecimal bd){
        return bd.toPlainString().split("\\.")[1];
    }
    
    private static int getMaxCycleLength(int n){
        BigDecimal answer = BigDecimal.ONE.divide(
                BigDecimal.valueOf(n), 1000, RoundingMode.HALF_UP);
        return longestRecurringCycle(getExpansionAsString(answer));
    }
    
    private static int unitFractionLongestCycle(int limit){
        int maxCycleLengthSoFar = 0;
        int leader = 0;
        for(int i = 2; i <= limit; i++){
            int iCycleLength = getMaxCycleLength(i);
            if (iCycleLength > maxCycleLengthSoFar){
                maxCycleLengthSoFar = iCycleLength;
                leader = i;
            }
        }
        return leader;
    }

    public static void main(String[] args) {
//    {   BigDecimal ONE = BigDecimal.ONE;
//        BigDecimal answer = ONE.divide(BigDecimal.valueOf(3), 1000, RoundingMode.HALF_UP);
//        System.out.println(answer.toPlainString().split("\\.")[1]);
        System.out.println(longestRecurringCycle("2121212121212"));
        //System.out.println(isSingleNumberRepeated("33333333"));
        //System.out.println(isSingleNumberRepeated("33333433"));
    }

}
