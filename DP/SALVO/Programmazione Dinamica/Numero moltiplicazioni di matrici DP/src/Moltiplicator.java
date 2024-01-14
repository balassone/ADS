public class Moltiplicator {

    //memoization implicita con l'utilizzo di matrici di appoggio e approccio bottom up
    private int[][] nMultiplications;
    private int[][] kthCut;

    public void buildMinNumberMoltiplication(int[] p){
        //inizializzo le matrici
        nMultiplications=new int[p.length-1][p.length-1];
        kthCut=new int[p.length-1][p.length-1];

        //chiamo funzione
        minNumberMoltiplication(p);

        //stampo risultato
        printMatrix(nMultiplications);
        printMatrix(kthCut);

    }

    //il vettore p passato è il vettore di sequenze di righe colonne, una matrice Ai ha p[i] righe e p[i+1] colonne
    public void minNumberMoltiplication(int[] p){
        
        //numero di matrici, è il numero della squenza di pesi meno uno
        int n=p.length-1;

        for(int i=0;i<n;i++){
            //inanzi tutto poniamo nella matrice di numeri i casi base
            //ovvero m[i,i]=0, cioè quando la sottosequenza di matrici è una singola matrice
            nMultiplications[i][i]=0;
        }

        //primo for per calcolarsi tutti i numeri da sequenze diverse
        //a partire da sequenze di matrici di lunghezza 2, poi 3 ecc
        for(int l=1;l<n;l++){
            
            //secondo for serve per costruirmi dinamicamnete ogni volta gli indici i e j per sequenza di lunghezza 2, poi 3 e cosi via
            for(int i=0;i<n-l;i++){
            
                int j=i+l;
                nMultiplications[i][j]=Integer.MAX_VALUE;

                //terzo for serve data una sequenza Ai....Aj per trovare il CUT migliore
                //per cut intendo parentizzazione con minore numero di moltiplicazioni
                for(int k=i;k<j;k++){
                    int q=nMultiplications[i][k]+nMultiplications[k+1][j]+(p[i]*p[k+1]*p[j+1]);

                    //qua scelgo il minore tra i numeri di moltiplicazioni
                    if(q<nMultiplications[i][j]){
                        nMultiplications[i][j]=q;
                        kthCut[i][j]=k;
                    }
                }
            
            }

        }

    }

    public void printMatrix(int[][] m){
        System.out.println("--------------------------------------------");
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.printf("%7d",m[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        int[] p={30,35,15,5,10,20,25};
        Moltiplicator m=new Moltiplicator();
        m.buildMinNumberMoltiplication(p);
    }
}
