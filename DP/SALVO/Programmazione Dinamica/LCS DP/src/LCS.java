public class LCS {

    private int[][] dp;

    public void printLCS(String s1, String s2){
    
        dp=new int[s1.length()+1][s2.length()+1];

        findLCS(s1.length(), s2.length(), s1, s2);

        System.out.println(dp[s1.length()][s2.length()]);

    }

    public void findLCS(int n, int m, String s1, String s2){
        
        for(int i=0;i<=n;i++){
        
            for(int j=0;j<=m;j++){
            
                if(i==0 || j==0){
                
                    dp[i][j]=0;

                }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                
                    dp[i][j]=dp[i-1][j-1]+1;

                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }

        }

    }

    public static void main(String[] args) throws Exception {
        String s1="ABCD";
        String s2="ACDF";

        LCS lcs=new LCS();

        lcs.printLCS(s1, s2);

    }
}
