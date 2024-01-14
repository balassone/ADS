package Fibonacci;

import java.util.ArrayList;
import java.util.HashMap;

public class fib {


    public static HashMap<Integer, Integer> fibonacci = new HashMap<>(); //per soluzioe top Down


    //soluzione naive

    public static int naiveFib(int n){
        //soluzione di complessità esponenziale, facilmente calcolabile con T(n-1) + T(n-1) + theta(1) >= 2^n/2

        if(n<=2){ //i primi due passi
            return 1;
        } else { //sennò, ricorro
            return naiveFib(n-1) + naiveFib(n-2);
        }

    }


    //soluzione bottom up 

    public static int bottomUpFib(int n){ //divenbta lineare!

        ArrayList<Integer> fib = new ArrayList<>(); //Memoization!

        for(int i=0; i<n; i++){
            if(i<2){ //minore di 2 
                fib.add(i, 1);
            } else { //negli altri casi, accedo ai valorio precedenti già calcolòati
                fib.add(i, fib.get(i-1)+fib.get(i-2));
            }

        }

        return fib.get(n-1); //ritorno l'elemento desiderato
    }


    //soluzione top down 

    public static int topDownFib(int n){

        if(fibonacci.containsKey(n)){ //se contiene la chiave K allora prendo la n
            return fibonacci.get(n); //ritorno l'elemento alla relativo a n
        } else {

            int f;
            if(n<=2){
                f=1; //se n<=2 allora metto f =1
            } else {
                f = topDownFib(n-1)+topDownFib(n-2); //sennò ricorro
            }

            fibonacci.put(n, f); //salvo in n e torno f
            return f;
        }


        
    }



    public static void main(String[] args) {
        
        System.out.println(topDownFib(7));

        System.out.println(fibonacci.toString());

    }
    
}
