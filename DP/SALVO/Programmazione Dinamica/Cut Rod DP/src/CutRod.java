/*
 * PROBLEMA: Ricavare il guadagno massimo tagliando una stanga di ferro e rivendendola ad i prezzi segnati in prices
 * ex: una stanga lunga uno costa 1, lunga 2 costa 5, lunga 3 costa 8 ecc
 * Se avessimo una stanga lunga 4, potremmo al posto di venderla per intera tagliarla a meta e ricavarci 10
 * Altri tagli per la stanga lunga 4 non sono convenienti, provare per credere
 * Trovare data la lunghezza n il ricavo massimo che si può ottenere
 * 
 *    9
 *   ----
 * 
 *  5    5    =   10
 * --   --
 * 
 */

public class CutRod {

    private int[] prices={1,5,8,9,10,17,17,20,24,30};
    private int[] besties;

    public void findMaxGain(int n){
        
        //inizializzo il vettore di besties
        besties=new int[n];
        for(int i=0;i<n;i++){
            besties[i]=-1;
        }

        System.out.println("Il ricavo massimo per una stanga lunga "+n+" è : "+cutRodTopDown(n));

    }

    public int cutRodTopDown(int n){
        int gain=0;

        if(n==0){
            //non faccio nulla, passo base
        }else if(besties[n-1]>=0){
            //memoization
            gain=besties[n-1];
        }else{
            
            //in questo caso devo attuare la ricorsione
            for(int i=0;i<n;i++){
                //effettuo la scelta del massimo
                if(gain<(prices[i]+cutRodTopDown(n-i-1))){
                    gain=prices[i]+cutRodTopDown(n-i-1);
                }
            }

            //dopo aver trovato il massimo per questa n la salvo
            besties[n-1]=gain;

        }

        return gain;
    }  

    public static void main(String[] args) throws Exception {
        CutRod cut=new CutRod();
        cut.findMaxGain(7);
    }
}
