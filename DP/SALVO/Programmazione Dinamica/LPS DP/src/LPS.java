public class LPS {

    private int[][] dp;

    public void printLPS(String s){
        
        dp=new int[s.length()][s.length()];

        buildDp(s.length(), s);

        printMatrix(dp);
        System.out.println(dp[0][s.length()-1]);

    }

    public void buildDp(int n, String s){

        //caso base 
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        
        for(int len=2;len<=n;len++){
        
            for(int i=0;i<=n-len;i++){
            
                int j=i+len-1;

                if(s.charAt(i)==s.charAt(j) && len==2){
                
                    dp[i][j]=2;

                }else if(s.charAt(i)==s.charAt(j)){
                
                    dp[i][j]=dp[i+1][j-1]+2;

                }else{
                    
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);

                }

            }

        }

    }

    public void printMatrix(int[][] m){
        System.out.println("--------------------------------------------");
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.printf("%3d",m[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }


    public static void main(String[] args) throws Exception {
        LPS lps=new LPS();
        String s="BBABCBCAB";
        lps.printLPS(s);
    }
}
