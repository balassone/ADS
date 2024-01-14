import java.util.HashMap;

public class SottoSequenza {

    private int[] array;
    private HashMap<Integer,Integer> memo;

    public SottoSequenza(){
        this.memo=new HashMap<Integer, Integer>();
    }

    public void printMaxSubSequence(int[] a){
        
        //pulisco hasmap
        memo.clear();
        
        //copio il vettore
        array=a;

        int max=-1;

        //chiamo per tutte le posizioni del vettore sottosequenza
        for(int i=0;i<a.length;i++){
            
            int res=sottoSequenza(a.length, i);

            //qua scelgo il massimo
            if(res>max){
                max=res;
            }

        }

        System.out.println(memo.toString());
        System.out.println("La sottosequenza maggiore è lunga "+max);

    }

    public int sottoSequenza(int n, int index){
        int q=1;

        if(index==n){
            //non faccio niente come al solito
        }else if(memo!=null && memo.containsKey(index)){
            //sfrutto memoization
            q=memo.get(index);
        }else{

            int max=1;
        
            //queste sono tutte le combinazioni a partire da index
            //quindi tutte le sequenze che iniziano con A[index]
            for(int i=index;i<n;i++){

                //posso richiamare la ricorrenza solo se il numero A[i] è più grande 
                if(array[index]<array[i]){
                    q=1+sottoSequenza(n, i);
                }

                //localemente ogni sequenza di A[index] avrà una lunghezza
                //bisogna scegliere la più grande
                if(max<q){
                    max=q;
                }

            }

            //memorizzo in memo, il massimo valore
            //inoltre riporto max se è la prima volta che eseguo per questo A[index]
            memo.put(index, max);
            q=max;
        
        }

        return q;
    }

    public static void main(String[] args) throws Exception {
        SottoSequenza sotto=new SottoSequenza();
        int[] a={9,15,3,6,4,2,5,10,3};

        sotto.printMaxSubSequence(a);

    }
}
