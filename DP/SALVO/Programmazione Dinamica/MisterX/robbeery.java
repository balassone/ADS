package MisterX;

public class robbeery {




    public static int findMax(int [] vet, int i, int j){


        int value = 0;
        int value2 = 0;
        while (i<=vet.length-2 && j<vet.length){ //scorro da 0 a 1, con uno che arriva a prima dell'ultimo e uno che arriva all'ultimo, controllo poi il massimo
            value+=vet[i];
            value2+=vet[j];

            i=i+2;
            j=j+2;
        }
        
        
        return Math.max(value, value2);

    }    


    public static void main(String[] args) {
        
        int [] vet = {1, 3, 2, 1};


        System.out.println(findMax(vet, 0, 1));


    }
}
