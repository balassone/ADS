import java.util.Scanner;

public class MinCostPath {

    private int[][] board;
    private int[][] costMatrix;

    public void printValueMinPath(int[][] board){
    
        this.board=board;

        int n=board.length;
        int m=board[0].length;

        //alloco matrice di costi
        this.costMatrix=new int[n][m];

        minPath(n, m);

        //printMatrix(board);
        //printMatrix(costMatrix);

        System.out.println(costMatrix[n-1][m-1]);

    }

    public void minPath(int n, int m){

        //inizializzo i casi base
        costMatrix[0][0]=board[0][0]; // costo di partenza casella iniziale
        costMatrix[1][0]=board[1][0]+costMatrix[0][0]; //la prima mossa verticale, non si può raggiungere in altro modo
        costMatrix[0][1]=board[0][1]+costMatrix[0][0]; //la prima mossa orizzontale, non si può raggiungere in altro modo
    
        for(int i=0;i<n;i++){
        
            for(int j=0;j<m;j++){
            
                //devo gestire le mosse possibili, evitare out of bound
                //li gestisco in questo modo: le mosse impossibili le setto con una spesa di infinito
                int diag=10000000, oriz=10000000, vertic=10000000;

                //le mosse di passo base devo saltarle
                if((i==0 && j==0) || (i==0 && j==1) || (i==1 && j==0)){
                    continue;
                }

                //se la mossa è possibile gli associo il valore effettivo
                if(i-1>=0 && j-1>=0){
                    diag=costMatrix[i-1][j-1];
                }

                if(i-1>=0){
                    vertic=costMatrix[i-1][j];
                }

                if(j-1>=0){
                    oriz=costMatrix[i][j-1];
                }

                //scelgo il minimo tra le mosse possibili
                int tempMin=Math.min(oriz+board[i][j],vertic+board[i][j]);
                costMatrix[i][j]=Math.min(tempMin,diag+board[i][j]);

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
        MinCostPath path=new MinCostPath();

        Scanner scan=new Scanner(System.in);

        int righe=scan.nextInt();
        int colonne=scan.nextInt();
        int[][] board=new int[righe][colonne];

        for(int i=0;i<righe;i++){
            for(int j=0;j<colonne;j++){
                board[i][j]=scan.nextInt();
            }
        }

        path.printValueMinPath(board);

        scan.close();

    }
}
