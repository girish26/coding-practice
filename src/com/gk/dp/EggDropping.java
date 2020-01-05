package com.gk.dp;

import java.util.Arrays;

public class EggDropping {

    int solveEggDropping(int floors, int eggs){
        final int results[][] = new int[floors+1][eggs+1];
        for(int i=0;i < floors+1; i++)
                results[i][1] = i;

        for(int i=0;i <eggs+1; i++)
            results[1][i] = 1;

        for(int i=2; i<floors+1; i++){
            for(int j=2; j<eggs +1; j++){
                results[i][j] = Integer.MAX_VALUE;
                for(int k=1; k<i; k++){
                    int brokenEggResult = results[k-1][j-1] ;
                    int survivedEggResult = results[i-k][j];
                    int temp = Math.max(brokenEggResult, survivedEggResult) +1;
                    if(temp < results[i][j])
                        results[i][j] = temp;
                }
            }
        }
        for (final int[] a : results) {
            System.out.println(Arrays.toString(a));
        }
        return results[floors][eggs];
    }
    public static void main(String[] args) {
        System.out.println(new EggDropping().solveEggDropping(100, 2));
    }
}
