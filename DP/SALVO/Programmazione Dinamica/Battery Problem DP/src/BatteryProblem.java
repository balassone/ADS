/*
 * Siete a bordo di un’auto elettrica su un’autostrada. Entrate in autostrada al km 0 con la batteria carica e
 dovete uscire al km L.
 Prima che la vostra batteria si esaurisca (dopo r km), dovete fermarvi in un’area di servizio e sostituirla con
 una batteria di ricambio.
 Sia D[1 n]unvettore di interi, dove D[i] `e la distanza dell’area di servizio i-isima dall’inizio dell’auto
strada.
 Scrivete un algoritmo che prenda in input D, n, L e r e restituisca il numero minimo di fermate necessarie
 per completare il viaggio. Discutere correttezza e complessit` a.
 Nota: Negli esercizi aggiuntivi del Capitolo 13 relativi alla programmazione dinamica si trova una
 formulazione diversa di questo problema.
 * 
 */

import javax.management.RuntimeErrorException;

public class BatteryProblem {

    private int L; //destination
    private int batteryAutonomy; //in km
    private int[] stations; //location in km delle stazioni di rifornimento

    public void printMinStopToL(int[] s, int r, int l){
        
        //setto i valori
        L=l;
        stations=s;
        batteryAutonomy=r;

        int res=minStopToL(0,0);

        System.out.println("Il numero minimo di fermate per arrivare a "+L+" km è: "+res);

    }

    public int minStopToL(int kmPercorsi, int n){
    
        if(kmPercorsi+batteryAutonomy>=L){
            return 0;
        }else{
            
            int max=Integer.MIN_VALUE;
            int nextPosition=0;

            //scorro il vettore delle station a partire dalla posizione attuale
            //Questa è la scelta greedy, cioè la stazione più lontana a cui posso arrivare
            for(int i=n;i<stations.length;i++){
                if(stations[i]>max && stations[i]<=kmPercorsi+batteryAutonomy){
                    max=stations[i];
                    nextPosition=i;
                }
            }

            //se mai anche la più vicina stazione è più lontana della mia autonomia, ritorno che il viaggio non è riuscito
            if(max==Integer.MIN_VALUE){
                Error e=new Error("Ops, viaggio interrotto per stazione troppo lontana dopo "+kmPercorsi+" km");
                throw new RuntimeErrorException(e);
            }

            //trovata la prossima stazione cui sostare, chiamo la procedura ricorsivamente
            int q=1+minStopToL(max, nextPosition);

            return q;

        }
    
    }

    public static void main(String[] args) throws Exception {
        int[] s={10,15,17,22,28,30,39,41};
        BatteryProblem b=new BatteryProblem();
        b.printMinStopToL(s, 12, 50);
    }
}
