/*
 *  Siete i sistemisti di un data center in grado di “macinare” diversi terabyte di dati al giorno. In un periodo di
 n giorni, vi viene comunicato in anticipo la quantit` a xi di dati da gestire nel giorno i. I dati non macinati nel
 giorno i non possono essere gestiti il giorno successivo.
 Purtroppo, la scelta del sistema operativo non `e stata fra le pi`u felici. Infatti le performance del sistema
 peggiorano di giorno in giorno (forse per memory leaks?), fino a quando non decidete di fare reboot. Dopo j
 giorni dall’ultimo reboot, la quantit` a massima di terabyte “macinabili” ` e pari a sj, con s1 > s2 > >sn.
 Peggio ancora, per fare reboot ci vuole un giorno intero e durante quel giorno non ` e possibile gestire alcun
 dato.
 Dato un vettore x[1 n] che misura la quantit`a di dati in input e un vettore s[1 n] che misura le
 performance di sistema dall’ultimo reboot, scrivere un programma che calcola il numero massimo di
 terabyte che possono essere processati dal sistema, e valutarne la sua complessit` a.
 Esempio:

 i 1 2 3 4
------------------
 x 10 1 7 7
------------------
 s 8 4 2 1

La soluzione ottimale consiste nel fare un singolo reboot nel giorno 2. Si processano quindi 8TB nel giorno
 1, 7TB nel giorno 3, 4TB nel giorno 4 per un totale di 19TB.
 * 
 */

public class DataCenter {

    private int[] dayGoals;
    private int[] system;
    private int[][] dp;

    public void findMaxTerabyte(int[] x, int[] s, int n){
    
        //alloco matrice
        dp=new int[n+1][n+1];

        this.dayGoals=x;
        this.system=s;

        maxTerabyte(n);

        System.out.println(dp[1][1]);

    }

    public void maxTerabyte(int n){

        for(int i=0;i<=n;i++){
            dp[i][0]=0;
            dp[0][i]=0;
        }
    
        for(int j=1;j<=n;j++){
            dp[n][j]=Math.min(dayGoals[n],system[j]);
        }

        for(int i=n-1;i>=1;i--){
        
            for(int j=1;j<=i;j++){
                
                dp[i][j]=Math.max(dp[i+1][1],Math.min(dayGoals[i],system[j])+dp[i+1][j+1]);

            }

        }
        
    }

    public static void main(String[] args) throws Exception {
        int[] x={0,10,1,7,7};
        int[] s={0,8,4,2,1};

        DataCenter center=new DataCenter();

        center.findMaxTerabyte(x, s, x.length-1);

    }
}
