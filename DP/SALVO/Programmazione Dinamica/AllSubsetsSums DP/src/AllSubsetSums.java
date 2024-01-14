public class AllSubsetSums {

    private boolean[][] dp;
    private int[] array;

    public void printAllSubsetSums(int[] a){

        this.array=a;

        //calcolo la sum
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum += array[i];
        }

        //alloco dp
        dp=new boolean[array.length+1][sum+1];

        //riempio dp
        findAllSubsetSums(array.length, sum);

        //stampo l'ultima riga di dp
        for(int j=0;j<=sum;j++){
            if(dp[array.length][j]){
                System.out.print(j+" ");
            }
        }
    
    }

    public void findAllSubsetSums(int n, int sum){

        //Inizializzo la matrice dp a tutti false
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=false;
            }
        }
    
        //con array[0..i] c'è sempre subset che da somma zero, ovvero quello nullo
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }

        //dp[i][j]=true se e solo se nei primi array[0...i] elementi c'è un subset che raggiunge la somma j
        for(int i=1;i<=n;i++){
            
            //in ogni caso devo mettere true per la casella di quell'elemento dell'array
            dp[i][array[i-1]]=true;

            for(int j=1;j<=sum;j++){
                //se ho raggiunto in precedenza la somma attuale j, allora la stessa casella con riga i+1 è ancora true
                //in più posso aggiungere il valore attuale dell'elemento array[i-1]
                if(dp[i-1][j]==true){
                    dp[i][j]=true;
                    dp[i][j+array[i-1]]=true;
                }
            }

        }

    }

    public static void main(String[] args) throws Exception {
        AllSubsetSums ss=new AllSubsetSums();
        int[] a={1,2,4};
        ss.printAllSubsetSums(a);
    }
}
