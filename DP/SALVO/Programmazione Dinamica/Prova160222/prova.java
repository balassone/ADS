package Prova160222;

import java.util.ArrayList;

/**
 * prova
 */
public class prova {


    public static ArrayList<Integer> counts = new ArrayList<>();
    public static int [][] dp = new int[6][7];


    public static int foundMax(int [][] mat, int i, int j, int n, int count){


        //aggiungere memoization
        if(dp[i][j]!=0){
            return dp[i][j];
        }

        if(i==mat.length && j==mat[0].length){
            return 0;
        }

        if(mat[i][j]==0){

            if(i>=0 && j>=0 && i<mat.length &&j<mat[0].length){
                if(mat[i][j+1]==0){
                dp[i][j]=count++;
                    foundMax(mat, i, j+1, n++, count);
                } else if(mat[i][j+1]==1){
                    foundMax(mat, i+1, j-n, n, count);

                    //controllo 

                }
            }
        }


    }



    public static void main(String[] args) {

        int [][] mat = {
            {0, 1, 1, 0, 1, 1, 0}, 
            {0, 0, 0, 0, 0, 1, 0}, 
            {1, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1, 0, 0}
        };



        
    }

    
}