public class Palinsesto {

    private int[] songs;
    private int[][] dp;

    public void printMaxAgreement(int[] s, int[] g, int N){
        
        //non ha senso mettere le canzoni che non hanno gradimento
        //creo un vettore con solo canzoni a gradimento uno
        int canzoniDaEliminare=0;
        for(int i=0;i<g.length;i++){
            if(g[i]==0){
                canzoniDaEliminare++;
            }
        }

        int[] newSongs=new int[s.length-canzoniDaEliminare];

        int j=0;
        for(int i=0;i<g.length;i++){
            if(g[i]==1){
            
                newSongs[j]=s[i];
                j++;
            
            }
        }

        for(int i=0;i<newSongs.length;i++){
            System.out.print(newSongs[i]+" ");
        }

        this.songs=newSongs;
        this.dp=new int[newSongs.length+1][N+1];

        maxAgreement(newSongs.length, N);

        printMatrix(dp);

        System.out.println();
        System.out.println(dp[newSongs.length][N]);

    }

    public void maxAgreement(int n, int N){
        
        //le prima riga e prima colonna tutte nulle
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<=N;i++){
            dp[0][i]=0;
        }

        //il caso base sarebbe la riga i=1, cioè massimizzare usando solo la prima canzone
        for(int j=1;j<=N;j++){
            if(songs[0]<=j){
                dp[1][j]=1;
            }else{
                dp[1][j]=0;
            }
        }

        //poi gestione della matrice dp come il problema dello zaino
        for(int i=2;i<=n;i++){
        
            for(int j=1;j<=N;j++){
                
                if(songs[i-1]<=j){
                    
                    //solita "formula" per attraversare la matrice dello zaino
                    dp[i][j]=Math.max(dp[i-1][j] , dp[i-1][j-songs[i-1]] + 1);

                }else{

                    //caso precedente se sforo direttamente
                    dp[i][j]=dp[i-1][j];
                
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
        Palinsesto pal=new Palinsesto();

        int[] songs={5,3,2,4,7,2,1,5,9,3,4,1};
        int[] agree={0,1,1,0,1,0,0,1,1,0,1,1};

        pal.printMaxAgreement(songs, agree, 30);

    }
}
