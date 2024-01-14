package Parentesizzazione;

import java.util.ArrayList;
import java.util.Arrays;

public class parent {

    //complessità: un for da i a j, con due chiamatre ricorsive theta(n^2)*theta(n) = theta(n^3)


    //nel problema di parentesizzazione la chiave sta nel cercare di suddividere il problema in sotto-problemi ipotizzando di volta un nuovo posto dove immettere il prodotto

    public static int [][] dp; //struttura di memoization
    public static int last=Integer.MIN_VALUE; //last
    public static int min = Integer.MAX_VALUE; //min per aggiornamento di last

    public static int foundParent(int [][] dp, int i, int j, ArrayList<matrix> matrixes){

        if(dp[i][j]!=Integer.MIN_VALUE){ //se la posizione è già stata esplorata, allora ritorno il valore
            return dp[i][j];
        }

        if(i==j){ 
            return dp[i][j]; //se sono sulla diag principale, torno 0
        }

        int val = Integer.MAX_VALUE; //valore da controllare per il minimo
        
        for(int k=i; k<j; k++){ //da i a j-1, richiamo da i a k e k+1, j poi sommo il costo del prodotto attuale
            val =  Math.min(val, foundParent(dp, i, k, matrixes) + foundParent(dp, k+1, j, matrixes) + (matrixes.get(i).getRows()*matrixes.get(k).getCols()*matrixes.get(j).getCols()));
            if(min>val){ //minimo per salvare correttamente il last
                last=k;
                min=val;
            }
        }

        dp[i][j]=val; //salvo sempre val, che sarà il minimo per quella parentesizzazione 
        
        return val; //ritorno val
    }


    public static void main(String[] args) {
        
        ArrayList<matrix> matrixes = new ArrayList<>();

        matrix m1 = new matrix(50, 10); //creo le strutture matrici
        matrix m2 = new matrix(10, 40);
        matrix m3 = new matrix(40, 30);
        matrix m4 = new matrix(30, 5);

        matrixes.add(m1);
        matrixes.add(m2);
        matrixes.add(m3); //aggiungo al vettore interessato 
        matrixes.add(m4);



        dp = new int[matrixes.size()][matrixes.size()]; //struttura di memoization

        int i=0;
        for (int[] rows : dp) {
            Arrays.fill(rows, Integer.MIN_VALUE); //la inizializzo tutta a -inf, i valori della diagonale principale a 0
            rows[i]=0;
            i++;
        }

        System.out.println(foundParent(dp, 0, matrixes.size()-1, matrixes)); //funzione di programmazione dinamica

        System.out.println(last); //posizione che permette di di avere il minor effort
    }
    
}
