import java.util.HashMap;

public class KnapPack {

    private int size;
    private HashMap<String,Integer> memo=new HashMap<String,Integer>();

    public void printMaxValueKnapPack(int[] items, int size){

        //pulisco la memo
        memo.clear();

        //setto la size
        setSize(size);

        System.out.println("Riempiendo al meglio lo zaino riusciamo a trasportare "+maximizeValue(items.length, 0, items));
        
    }

    public void setSize(int s){
        this.size=s;
    }

    public int maximizeValue(int n, int tempFill, int[] items){
        
        String key=n+","+tempFill;

        if(memo.containsKey(key)){
            return memo.get(key);
        }else if(n==0){
        
            //ritorno il guadagno finale, cioè cosa è entrato nello zaino
            return tempFill;

        }else{
        
            int includendo=0;
            if(tempFill+items[n-1]<=size){ //fare il controllo se si eccede la gradezza dello zaino
                includendo=maximizeValue(n-1, tempFill+items[n-1],items);
            }
            int escludendo=maximizeValue(n-1, tempFill, items);

            int res=Math.max(includendo,escludendo);

            //salvo
            memo.put(key, res);

            return res;

        }

    }

    public static void main(String[] args) throws Exception {
        KnapPack pack=new KnapPack();
        int[] a={8,17,3,48,21};
        pack.printMaxValueKnapPack(a, 50);
    }
}
