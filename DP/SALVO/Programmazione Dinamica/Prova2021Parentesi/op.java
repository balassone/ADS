package Prova2021Parentesi;

import java.util.Arrays;
import java.util.Scanner;

public class op {

    //per avere il massimo faccio prima tutte le somme, poi prodotti
    //per il minimo prima prodotti poi somme

    public static int min=Integer.MAX_VALUE;
    public static int max=Integer.MIN_VALUE;


    public static int finMaxMin(char [] exp, int i, int j, int [][] dp){


        if(dp[i][j]!=0){
            return dp[i][j];
        }

        if(i==j){
            return dp[i][j];
        }

        
        int valuep =1;
        int values=0;

        for(int k=i; k<j; k++){

            if(exp[k]=='*' || exp[k]=='+'){

                if(exp[k]=='*'){
                    if(valuep==1){
                        valuep = Integer.valueOf(String.valueOf(exp[k-1])) * Integer.valueOf(String.valueOf(exp[k+1]));
                
                    } else {
                        valuep*= Integer.valueOf(String.valueOf(exp[k+1]));
                    }

                    
                } else if(exp[k]=='+') {
                    if(valuep==1){
                        values=exp[k];
                    } else {
                        values=exp[k]+valuep;
                    }

                }
                

            }

            System.out.println(valuep);
        }


        dp[i][j]=values;

        return values;


    }

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);


        String expression = scan.nextLine();

        char [] values = expression.toCharArray();

        System.out.println(Arrays.toString(values));
        int [][] dp = new int[values.length][values.length];

        finMaxMin(values, 0, values.length-1, dp);

        System.out.println(max +" "+ min);

        
    }
    
}
