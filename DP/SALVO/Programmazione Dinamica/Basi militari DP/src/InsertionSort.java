public class InsertionSort {

    private int[] array;

    public InsertionSort(int[] a){
        this.array=a;
    }

    public void sort(){
        
        //variabile key
        int key=0;

        //parti direttamente dal secondo elemento
        for(int i=1;i<this.array.length;i++){
        
            key=array[i];

            //indice dinamico per il confronto all'indietro
            int j=i-1;

            while(j>=0 && key<array[j]){
            
                //sto facendo lo swap traslando, il valore di key è salvato prima
                array[j+1]=array[j];
                j=j-1;

            }

            //ripristino il valore di key
            array[j+1]=key;
        
        }

    }

    public int[] returnSorted(int[] s){
        //variabile key
        int key=0;

        //parti direttamente dal secondo elemento
        for(int i=1;i<s.length;i++){
        
            key=s[i];

            //indice dinamico per il confronto all'indietro
            int j=i-1;

            while(j>=0 && key<s[j]){
            
                //sto facendo lo swap traslando, il valore di key è salvato prima
                s[j+1]=s[j];
                j=j-1;

            }

            //ripristino il valore di key
            s[j+1]=key;
        
        }

        return s;
    }

    public void arrayToString(){
    
        for(int i : array){
        
            System.out.print(i+" ");

        }

    }

    public static void main(String[] args){
    
        int[] ex={3,2,5,1,8,6};
        InsertionSort in=new InsertionSort(ex);

        System.out.println("Array iniziale: ");
        in.arrayToString();

        System.out.println("\nSorting dell'array....");
        
        in.sort();
        System.out.println("Array sorted: ");
        in.arrayToString();

    }

}