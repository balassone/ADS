import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Alg {
    
    private int[] pivots;
    private int[][] dp;

    public void printOpt(int[] p, int end){
       
        this.pivots=p;

        //alloco dp
        dp=new int[end+1][end+1];

        for(int i=0;i<=end;i++){
            Arrays.fill(dp[i],-1);
        }

        int res=optimizeDividiEtImpera(0, end);

        //printMatrix(dp);

        System.out.println(res);
       
    }

    public int optimizeDividiEtImpera(int start, int end){

        ArrayList<Integer> pivotAvaible=new ArrayList<Integer>();

        for(int i=0;i<pivots.length;i++){
            if(pivots[i]>start && pivots[i]<end){
                pivotAvaible.add(pivots[i]);
            }
        }

        if(pivotAvaible.size()==0){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }

        int minCost=(end-start)+optimizeDividiEtImpera(start, pivotAvaible.get(0))+optimizeDividiEtImpera(pivotAvaible.get(0), end);

        for(int i=1;i<pivotAvaible.size();i++){
            minCost=Math.min(minCost,
            (end-start)+optimizeDividiEtImpera(start, pivotAvaible.get(i))+optimizeDividiEtImpera(pivotAvaible.get(i), end));
        }

        dp[start][end]=minCost;
        return dp[start][end];

    }

    public void printMatrix(int[][] m){
        System.out.println("--------------------------------------------");
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.printf("%5d",m[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        Alg alg=new Alg();
        Scanner scan=new Scanner(System.in);

        while(scan.hasNext()){

            int end=scan.nextInt();

            if(end==0){
                break;
            }

            int len=scan.nextInt();
            int[] p=new int[len];
            for(int i=0;i<len;i++){
                p[i]=scan.nextInt();
            }

            alg.printOpt(p, end);

        }

        scan.close();

        /* 
        int[] p={25,50,75};
        int[] p1={4,5,7,8};
        int[] p2={2,20,25};
        alg.printOpt(p, 100);
        alg.printOpt(p1, 10);
        alg.printOpt(p2, 30);*/
    }
}

/* 
30
3
2 20 25
10
4
4 5 7 8
100
3
25 50 75
0
*/
