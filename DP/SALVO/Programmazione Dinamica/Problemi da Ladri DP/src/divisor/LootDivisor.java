package divisor;
import java.util.HashMap;

public class LootDivisor {

    //Ho implementato versione forza bruta (un po' migliorata ma comunque inefficiente)
    //e anche versione bottom up più efficiente
    
    private HashMap<String,Integer> memo=new HashMap<String,Integer>();
    private int[] loot;

    //la matrice per approccio bottom up va interpretata nel seguente modo:
    //la riga i, indica che posso prendere o tutte o alcune delle prime i monete del vettore loot
    //la colonna j indica la somma j, ovvero una somma parziale che deve essere raggiunta o almeno non ecceduta
    //quindi il valore dp[i][j] è la massima somma che si può ottenere con le prime i monete e non eccedendo la somma j
    private int[][] dp;
    

    public void printTopDownMinDiff(int[] loot){

        //pulisco l'hashmap e copio bottino
        memo.clear();
        this.loot=loot;

        //calcolo il bottino
        int bottino=0;
        for(int i=0;i<this.loot.length;i++){
            bottino+=this.loot[i];
        }

        int res=topDownMinimizeDiff(this.loot.length, 0, bottino);

        System.out.println(res);

    }

    public int topDownMinimizeDiff(int n, int sacco1, int sacco2){
    
        String key=n+","+sacco1;

        if(memo.containsKey(key)){

            //uso memoization
            return memo.get(key);
        
        }else if(n==0){
            
            //caso base, ho due configurazioni di sacchi da confrontare
            return Math.abs(sacco1-sacco2);

        }else{
        
            //richiamo la funzione ricorsiva aggiungendo o non aggiungendo la moneta i-esima
            int includendo=topDownMinimizeDiff(n-1, sacco1+loot[n-1], sacco2-loot[n-1]);
            int escludendo=topDownMinimizeDiff(n-1, sacco1, sacco2);

            int res=Math.min(includendo, escludendo);

            //memorizzo il risultato di questa configurazione
            memo.put(key,res);

            return res;

        }
        
    }

    public void printBottomUpMinimizeDiff(int[] loot){
        
        this.loot=loot;

        //calcolo il bottino
        int bottino=0;
        for(int i=0;i<this.loot.length;i++){
            bottino+=this.loot[i];
        }

        //alloco matrice
        dp=new int[loot.length+1][(bottino/2)+1];

        findBottomUpMinimizeDiff(loot.length, bottino);

        //stampo matrice dp
        //printMatrix(dp);

        System.out.println(bottino-2*(dp[loot.length][bottino/2]));

    }

    public void findBottomUpMinimizeDiff(int n, int Sum){
        
        int m=Sum/2; //bottino totale idealmente diviso a metà
                     //n invece è la lunghezza del vettore loot, quindi quante monete ho

        for(int i=0;i<=n;i++){
            
            for(int j=0;j<=m;j++){
            
                //caso base, con 0 monete posso sicuramente non superare somma j, ma arrivo a guadagno nullo
                //e nessuna moneta da sola riesce a non superare somma 0
                if(i==0 || j==0){

                    dp[i][j]=0;

                //se la singola moneta che sto analizzando riesce a non superare somma j, 
                //provo a vedere se conviene aggiungerla o meno
                }else if(loot[i-1]<=j){

                    //la formula riportata nella scelta del massimo mi dice se aggiungere la moneta migliora la situazione precedente
                    //difatti tiene conta anche che l'aggiungere l'i-esima moneta non sfori la somma j
                    dp[i][j]=Math.max(dp[i-1][j]/*situazione precedente */,loot[i-1] + dp[i-1][j-loot[i-1]]/*situazione se aggiungessi la moneta*/);
                
                }else{
                    
                    //se la singola moneta già supera il valore j, allora prendo situazione precedente direttamente
                    dp[i][j]=dp[i-1][j];

                }

            }

        }

    }

    //funzione di utilità per stampare eventualmente dp, usata per debug
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
        LootDivisor divisor=new LootDivisor();
        int[] a={5,4,9,1};

        divisor.printTopDownMinDiff(a);
        divisor.printBottomUpMinimizeDiff(a);

    }
}
