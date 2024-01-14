/*
 * Given a fence with n posts and k colors, 
 * find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. 
 * Examples:

    Input : n = 2 k = 4
    Output : 16
    Explanation: We have 4 colors and 2 posts.
    Ways when both posts have same color : 4 
    Ways when both posts have diff color :4(choices for 1st post) * 3(choices for 2nd post) = 12
 */

public class PaintingFences {

    //Il passo "i" determina la lunghezza del sottoproblema, prima risolviamo per fence lunga uno (i=0), poi ricorsivamente per fence lunghe 2 ecc

    private int[] same; //al passo i numero di combinazioni con le ultime due caselle uguali
    private int[] diff; //al passo i numero di combinazioni con le ultime due caselle diverse
    private int[] total; //numero di combinazioni totali al passo i

    public void printNumWaysOfPainting(int n, int k){
        
        //alloco array
        this.same=new int[n];
        this.diff=new int[n];
        this.total=new int[n];

        //chiamo per buidare i vettori
        numWaysOfPainting(k, n);

        //stampo risultato
        System.out.println("Per dipingere una staccionata con "+k+" colori e senza più di due colori adiacenti ci sono "+total[n-1]+" modi");

    }

    private void numWaysOfPainting(int k, int n){
        
        //setto le prime posizioni dei vettori di appoggio
        //in pratica mi costruisco i casi base

        same[0]=0; //una sola casella non ha combinazioni in cui le ultime due hanno stesso colore
        diff[0]=k; //con una casella ho k (il numero dei colori) combinazioni possibili
        total[0]=diff[0]+same[0]; //tutte le combinazioni sono la somma delle due ad ogni passo i

        for(int i=1;i<n;i++){
            same[i]=diff[i-1]; //poichè sono vincolato a scegliere sempre il colore dell'ultima casella, prendo solo diff perchè altrimenti violerei regola adiacenti
            diff[i]=total[i-1]*(k-1); //per ogni soluzione precedente, per non avere le ultime due caselle uguali scelgo i restanti colori, cioè k-1
            total[i]=diff[i]+same[i]; //sempre solita regola
        }

    }

    public static void main(String[] args) throws Exception {
        PaintingFences p=new PaintingFences();
        p.printNumWaysOfPainting(4, 3);
    }
}
