/*
 * Sia data una sequenza di stringhe, w1....wn. Concatenare una stringa wi con wi+1 ha un costo di: (w1.leng+wi+1.leng)^2
 * Scrivere un algoritmo che minimizzi il costo per ottenere la stringa concatenata w1...wn
 */

public class StringConcatenator {

    private int[][] costMat;
    private String[] stringSeq;

    public void printMinCostForSequence(String[] seq){
        
        //allochiamo la matrice
        costMat=new int[seq.length][seq.length];
        stringSeq=seq;

        //riempio la costMat
        buildMinCostMatrix();

        //me la stampo
        printMatrix(costMat);

        //riporto elemento con i minimo e j massimo per risultato finale
        System.out.println("Il costo minimo per la sequenza inserita è: "+costMat[0][seq.length-1]);


    }

    //Approccio bottom up, mi calcolo prima il costo ottimo per sequenza di due stringhe poi per tre ecc
    private void buildMinCostMatrix(){
    
        //Caso base, se la sequenza wi...wj ha i=j, sto analizzando la singola stringa
        //quindi non devo concatenare niente, costo nullo
        for(int i=0;i<stringSeq.length;i++){
            costMat[i][i]=stringSeq[i].length();
        }

        //Come per il calcolo dei prodotti tra matrici, primo for per lunghezze di 2 ecc
        for(int l=1;l<stringSeq.length;l++){
        
            //ricordarsi i<n-l poichè per non sforare in out of bound all'ultimo
            for(int i=0;i<stringSeq.length-l;i++){
            
                int j=i+l;
                costMat[i][j]=Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                    
                    int q=(int) Math.pow((costMat[i][k]+costMat[k+1][j]), 2);

                    if(q<costMat[i][j]){
                        costMat[i][j]=q;
                    }

                }

            }
        
        } 

    }

    public void printMatrix(int[][] m){
        System.out.println("--------------------------------------------");
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.printf("%10d",m[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        String[] seq={"mela","uva","banana","ciliegia","pera"};
        StringConcatenator concatenator=new StringConcatenator();
        concatenator.printMinCostForSequence(seq);
    }
}
