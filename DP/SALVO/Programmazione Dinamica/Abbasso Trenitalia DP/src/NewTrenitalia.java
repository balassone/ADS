/*
 *  Siamo nel 2050. Le ferrovie tedesche-austriache (DB,OBB), dopo aver conquistato la tratta del Brennero,
 hanno fatto fallire Trenitalia e dominano il mercato italiano. La loro politica dei prezzi `e la seguente: `e
 possibile acquistare un abbonamento per X euro con validit`a un mese a partire dal giorno di emissione,
 valido su tutte le tratte. Oppure pagare un biglietto a tariffa intera per un particolare viaggio. Siete un
 rappresentantante di commercio e avete programmato una serie di viaggi per il prossimo anno, nei giorni
 d1.....dn. La tariffa intera per ognuno di questi viaggi ` e f1......fn. Scrivete un algoritmo che minimizzi
 il costo totale, stampando i giorni in cui comprare gli abbonamenti.
 Valutare la complessit` a e discutere la correttezza del vostro algoritmo
 * 
 */

import java.util.Scanner;

public class NewTrenitalia {

    private int abbonamento;
    private int[] giorni;
    private int[] tariffe;
    private int[] dp;

    public void pritnMinExpense(int[] g, int[] t, int X){
    
        //alloco dp
        dp=new int[g.length];

        this.giorni=g;
        this.tariffe=t;
        this.abbonamento=X;

        minExpense(giorni.length-1);

        System.out.println(dp[0]);

    }

    public void minExpense(int n){

        dp[n]=Math.min(abbonamento, tariffe[n]);
    
        for(int i=n-1;i>=0;i--){
        
            //ogni volta devo trovarmi il primo giorno che scadrebbe l'abbonamento, se lo pagassi il giorno i
            int j=i;
            while(j<=n && giorni[j]<=giorni[i]+30){
                j++;
            }

            if(j!=n+1){
                dp[i]=Math.min(tariffe[i]+dp[i+1],abbonamento+dp[j]);
            }else{
                dp[i]=Math.min(tariffe[i]+dp[i+1],abbonamento);
            }

        }

    }

    public static void main(String[] args) throws Exception {
        /* 
        int[] g={3,17,22,45,54};
        int[] t={6,10,7,8,4};
        int X=20;
        */

        Scanner scan=new Scanner(System.in);
        NewTrenitalia treni=new NewTrenitalia();

        while(true){
            String line=scan.nextLine();
            if(line=="END"){
                scan.close();
                break;
            }else{

                String[] lineSplitted=line.split(" ");

                int n=Integer.parseInt(lineSplitted[0]);
                int X=Integer.parseInt(lineSplitted[1]);

                int[] g=new int[n];
                int[] t=new int[n];

                for(int i=0;i<n;i++){
                    g[i]=scan.nextInt();
                }

                for(int i=0;i<n;i++){
                    t[i]=scan.nextInt();
                }

                treni.pritnMinExpense(g, t, X);
                scan.nextLine();
                
            }
        }

    }
}

//Comandi da provare al terminale
/* 
5 20
3 17 22 45 54
6 10 7 8 4
3 20
3 17 22
6 10 7
END
*/

