package CutRod;

import java.util.Hashtable;

public class rod {

    //complessità: essendo che le chiamate costano 1, lo faccio al massimo n volte contemplano un for, O(n^2)


    //HashTable che permette di tener conto dei costi
    public static Hashtable<Integer, Integer> prices = new Hashtable<Integer, Integer>(); //tabella dei prezzi, lego dimensione e

    public static Hashtable<Integer, Integer> saves = new Hashtable<>(); //memoization, salvo rispetto alla dim il valore maggiore 


    public static int cutRod(int dim){  //gli passo la dimensione 

        if(saves.contains(dim)){ //se la struttura di memo contiene la dim, allora ritorno quello salvato 
            return saves.get(dim);
        } 

        if(dim==0){ //se 0, allora torno 0
            return 0;
        }

        int value = Integer.MIN_VALUE; //valore 

        for(int i=1; i<=dim; i++){ //da 1 a dim, taglio in maniera incrementale
            value = Math.max(value, prices.get(i)+cutRod(dim-i)); //prezzo di i, più la miglior soluzione su dim-i
        }

        saves.put(dim, value); //salvo

        return value; //ritorno
    }


    public static void main(String[] args) {
        
        prices.put(1, 1);
        prices.put(2, 2);
        prices.put(3, 5);
        prices.put(4, 6);
        prices.put(5, 6);
        prices.put(6, 13);
        prices.put(7, 13);
        prices.put(8, 15);
        prices.put(9, 15);
        prices.put(10, 30); //inserimento dei valori 

        
        System.out.println(cutRod(9));
        
        
    }
    
}
