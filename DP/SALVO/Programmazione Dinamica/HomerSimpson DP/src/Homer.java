
public class Homer {

    private Box[][] dp;
    private int krusty;
    private int apu;
    private int timeLimit;

    public void printMaxBurgers(int m, int n, int t){
    
        //alloco dp
        dp=new Box[t+1][t+1];

        for(int i=0;i<t+1;i++){
        
            for(int j=0;j<t+1;j++){
                dp[i][j]=new Box(0,0);
            }

        }

        this.krusty=m;
        this.apu=n;
        this.timeLimit=t;

        eatBurgers(timeLimit);

        printMatrix(dp);

    }

    public void eatBurgers(int n){
        
        for(int i=0;i<=n;i++){
            dp[i][0]=new Box(0,0);
            dp[0][i]=new Box(0,0);
        }

        int bigger=Math.max(krusty, apu);
        int smaller=Math.min(krusty,apu);

        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=n;j++){

                Box box1=new Box(dp[i-1][j-bigger].getTimeFilled(),dp[i-1][j-bigger].getnBurgers());
                Box box2=new Box(dp[i-1][j-smaller].getTimeFilled(),dp[i-1][j-smaller].getnBurgers());
                Box box3=new Box(dp[i-1][j].getTimeFilled(),dp[i-1][j].getnBurgers());
            
                if(i==1){
                
                    //caso base, massimizzo per il primo panino
                    if(bigger<=j){
                        dp[i][j].setTimeFilled(bigger);
                        dp[i][j].setnBurgers(1);
                    }else if(smaller<=j){
                        dp[i][j].setTimeFilled(smaller);
                        dp[i][j].setnBurgers(1);
                    }else{
                        dp[i][j].setTimeFilled(0);
                        dp[i][j].setnBurgers(0);
                    }

                }else if(bigger<=j){
                
                    if(box1.getTimeFilled()>box2.getTimeFilled() && box1.getTimeFilled()>box3.getTimeFilled()){
                        dp[i][j]=box1;
                    }else if(box2.getTimeFilled()>box1.getTimeFilled() && box2.getTimeFilled()>box3.getTimeFilled()){

                    }else if(box3.getTimeFilled()>box1.getTimeFilled() && box3.getTimeFilled()>box2.getTimeFilled()){
                        
                    }

                    //int alternative=Math.max(dp[i-1][j].getnBurgers(),dp[i-1][j-bigger].getnBurgers()+1);
                    //dp[i][j].setnBurgers(Math.max(alternative, dp[i-1][j-smaller].getnBurgers()+1));

                }else if(smaller<=j){
                    
                    dp[i][j].setnBurgers(Math.max(dp[i-1][j].getnBurgers(), dp[i-1][j-smaller].getnBurgers()+1));

                }else{
                    dp[i][j]=dp[i-1][j];
                }

                /* 
                if(dp[i][j]==timeLimit){
                    return i;
                }else if(dp[i][j]>timeLimit){
                
                }
                */

            }

        }

    }

    public void printMatrix(Box[][] m){
        System.out.println("--------------------------------------------");
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.printf("%3d",m[i][j].getnBurgers());
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        Homer homer=new Homer();

        int m=3,n=5,t=55;

        homer.printMaxBurgers(m, n, t);

    }
}
