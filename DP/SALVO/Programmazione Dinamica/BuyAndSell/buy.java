package BuyAndSell;

import java.util.Arrays;

public class buy {


    //complessità O(n)

    public static int [][] dp;



    public static int findMaxDif(int [] vet, int i, int j){

        //problema del buy and sell, devo massimizzare il guadagno, quando vendo e quando faccio sell?


        if(i==0 || j==-1){ //partendo dalla fine, controllo se i o j sforano i limiti
            
            return 0;
        }


        if(dp[i][j]!=-1){ //memoization
            return dp[i][j];
        }

    
        int maxvalue=-1;
        if(j>=0 && vet[i]-vet[j]>0){//se j>=0 e la differenza mi porta guadagno
             maxvalue=Math.max(vet[i]-vet[j], findMaxDif(vet, i, j-1));//prendo il massimo tra questo guadagno o andando indietro di 1 con j
        }

        return dp[i][j]= Math.max(maxvalue, findMaxDif(vet, i-1, i-2)); //alla fine, salvo e ritorno il massimo con quello calcolato prima e quello che calcolo ora andando indietro

    }





    public static void main(String[] args) {

        int [] vet = {0, 1, 5, 3, 6, 4};

        dp = new int[vet.length][vet.length];

        for (int [] i : dp) {
            Arrays.fill(i, -1);
        }

        System.out.println(findMaxDif(vet, vet.length-1, vet.length-2));
        
    }
    
}
