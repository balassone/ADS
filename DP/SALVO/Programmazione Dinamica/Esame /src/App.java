public class App {
    
    private int[][] dp;
    ArrayList<Integer[]> classi;

    public void printMax(ArrayList<Integer[]> list, int b){
    
        this.classi=list;

        dp=new int[classi.size()+1][b+1];

        buildDp(classi.size(),b);

        System.out.println(dp[classi.size()][b]);

    }

    public void buildDp(int nClassi, int budget){

        for(int i=0;i<=nClassi;i++){
            for(int j=0;j<=budget;j++){

                int max=Integer.MIN_VALUE;

                for(int k=0;k<classi.get(i).length;k++){
            
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }else if(classi.get(i)[k]<=j){
                    
                        max=Math.max(max,dp[i-1][j-classi.get(i)[k]]+classi.get(i)[k]);

                    }else{
                    
                        //in teoria se non posso inserire non faccio nulla e metto il precedente
                        dp[i][j]=dp[i-1][j];

                    }

                }

            }
        }

    }

    public static void main(String[] args) throws Exception {
        App app=new App();
        
    }
}
