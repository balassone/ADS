package FrogJump;

import java.util.HashMap;

public class frog {
    

    //complessità lineare!

    public static HashMap<Integer, Integer> save = new HashMap<>();

    public static int findMin(int [] vet, int i){

        //problema del frog jump, voglio saltare fino all'ultimo spendendo il minimo possibile, differenza assoluta tra quello di adesso e il next, posso saltare
        // a i+1 o i+2



        if(save.containsKey(i)){ //memoization
            return save.get(i);
        }


        if(i==vet.length-1){ //se arrivo alla fine, torno 0
            return 0;
        }

        int value1=Integer.MAX_VALUE;
        int value2= Integer.MAX_VALUE; //due valori di appoggio

        if(i<vet.length-1){
            value1=Math.abs(vet[i]-vet[i+1])+findMin(vet, i+1); //controllo se prendo questa diff e salto di 1
        } 

        if(i<vet.length-2){
            value2=Math.abs(vet[i]-vet[i+2])+findMin(vet, i+2); //controllo se prendo questa diff e salto di 2
        }


        save.put(i, Math.min(value1, value2)); //salvo il minimo dei due
        return Math.min(value1, value2); //torno il minimo dei due

    }


    public static void main(String[] args) {

        int [] arr = {4, 6, 2, 8, 1, 5};


        System.out.println(findMin(arr, 0));
        
    }
}
