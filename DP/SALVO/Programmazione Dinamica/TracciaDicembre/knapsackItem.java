import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class knapsackItem {


    //complesità: considerabile pseudo-polinomiale per quanto riguarda la teoria studiata, ma essendoci un ulteriore ciclo può essere vista come theta(n*budget*N)= theta(n^2*budget)
    public static int includo =Integer.MAX_VALUE;
    public static int escludo= Integer.MAX_VALUE;

    public static HashMap<String, Integer> memo = new HashMap<>();
   

    public static int knapsack(int budget, int[][] items, int row, int col, int N){ //in ingresso richiedo 
        //il budget totale, la matrice di items, row e col e il numero di classi (o numero di righe)


        String key = String.valueOf(budget); //genero la key col budget

        if(row == N){ //se ho oltre passato l'ultima riga sono arrivato a spendere tutto 
            return budget;
        }


        if(memo.containsKey(key)){ //memoization
            return memo.get(key); //ritorno il budget avuto 
        }

        
        for (int i =col; i<items[row].length; i++) { //per tutti gli elementi delle colonne (della riga selezionata)

            if(row>=0 && row<N && col<=0 && col<N){ //controllo che row e col siano all'interno della matrice 
                includo = knapsack(budget-items[row][i], items, row+1, col, N); //faccio che prendo e aggiorno il budget, togliendo il valore dell'oggetto, avanzando con la riga (di classe)
                escludo = knapsack(budget, items, row, col+1, N); //sennò vado avanti con la colonna senza aggiornare il budget
                
            }

        }
        
        int value = Math.min(includo, escludo)>=0 ? Math.min(includo, escludo) : Math.max(includo, escludo); //se il min è maggiore di 0, allora salvo quello, 
        //sennò salvo il massimo dei due (potrebbe essere 1, invece
        // denaro insufficiente lo è quando ho solo elementi negativi) 

        memo.put(key, value); //salvo il value con la chiave relativa

        return value;
    }



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int testCases = scan.nextInt();

        for (int i = 0; i < testCases; i++) {

            int budget = scan.nextInt();
            int N = scan.nextInt();


            int [][] items = new int[N][];

            

            for(int j=0; j<N; j++){
                int elems = scan.nextInt();

                items[j]=new int[elems];

                for(int k=0; k<elems; k++){

                    items[j][k]=scan.nextInt();
                }
            }


            //gestione dell'input 

            includo= Integer.MAX_VALUE; //li re-inizializzo ad ogni caso
            escludo=Integer.MAX_VALUE;

            memo.clear(); //anche la memoria
            
            int value = knapsack(budget, items, 0, 0, N); //funzione knapsack


            if(value<0 || value==Integer.MAX_VALUE){
            System.out.println("denaro insufficiente"); 
            } else {
            System.out.println(budget-value); //output
            }

            
            
            
        }


        
    }
    
}
