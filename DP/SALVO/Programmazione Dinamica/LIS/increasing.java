package LIS;

import java.util.Arrays;

public class increasing {


    //complessita': O(n^2), al massimo scorro due volte lo stesso vettore

    public static int [][] dp;

    public static int LIS(int [] vet, int k,  int last){


        if(k==vet.length){ //se ho raggiunto il massimo trono 0
            return 0;
        }

        if(dp[k][last+1]!=-1){ //se invece, la posizione dell'indice che sto scorrendo e l'ultimo salvato e' gia' occupata, torno quel valore
            
            return dp[k][last+1]; //ritorno
        }

        int max = Integer.MIN_VALUE;
        if(last == -1 || vet[k]>vet[last]){ //se last e' -1, o se quelolo che scorro e' l'ultimo del last 
            max = 1+LIS(vet, k+1, k); //1+chiamta con k+1 e k come last 
        } 
        
        int max2 = LIS(vet, k+1, last);  //chiamo senza anche senza prendere!
       

        
        return dp[k][last+1] = Math.max(max, max2);// salvo il massimo dei due! 

    }


    public static void main(String[] args) {
        

        int [] vet= {0, 123, 2, 19, 20}; //sequenza

        dp=new int[vet.length][vet.length]; //creo la matrice 


        for (int [] r : dp) {
            Arrays.fill(r, -1); //la fillo di -1
        }


        System.out.println(LIS(vet, 0, -1)); //soluzione

        for (int [] r : dp) {
            System.out.println(Arrays.toString(r));
        }

    }
    
}
