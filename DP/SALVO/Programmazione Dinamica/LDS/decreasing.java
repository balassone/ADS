package LDS;

import java.util.Arrays;

public class decreasing {


    public static int [][] dp;


    public static int LDS(int [] vet, int k, int last){ //uguale a LIS solo con minore

        if(k==vet.length){
            return 0;
        }

        if(dp[k][last+1]!=-1){
            
            return dp[k][last+1];
        }
        

        int max = 0;
        if(last ==-1 || vet[k]<vet[last]){
            max= 1+LDS(vet, k+1, k);
        }

        int max2 = LDS(vet, k+1, last);


        return dp[k][last+1]=Math.max(max, max2);

    };

    


    public static void main(String[] args) {
        

        int [] vet = {10, 20, 3, 20, 1};

        dp = new int[vet.length][vet.length];

        for (int [] i : dp) {
            Arrays.fill(i, -1);
        }


        System.out.println(LDS(vet, 0, -1));
    }
}
