import java.util.HashMap;

public class SufficienzaDP {

    private Task[] tasks;
    HashMap<String,Integer> memo=new HashMap<String,Integer>();

    public void printSeqMinEffort(Task[] t, int suff){
        
        //pulisco memo
        memo.clear();

        this.tasks=t;

        int res=minEffort(t.length, 0, 0, suff);

        System.out.println("Il valore di tempo minimo è: "+res);

    }

    public int minEffort(int n, int tempoTrascorso, int valoreTot, int suff){

        String key=n+","+valoreTot+","+tempoTrascorso;
        
        if(valoreTot>=suff){
            return tempoTrascorso;
        }else if(memo.containsKey(key)){
            return memo.get(key);
        }else if(n==0 && valoreTot < suff){
            return Integer.MAX_VALUE;
        }else{

            int svolgendo=minEffort(n-1, tempoTrascorso+tasks[n-1].getTime(), valoreTot+tasks[n-1].getValue(), suff);
            int nonSvolgendo=minEffort(n-1, tempoTrascorso, valoreTot, suff);

            int res=Math.min(svolgendo,nonSvolgendo);

            memo.put(key, res);

            return res;
        
        }
    
    }

    public static void main(String[] args) throws Exception {
        Task t1=new Task(14, 7);
        Task t2=new Task(24, 15);
        Task t3=new Task(8, 10);
        Task t4=new Task(35, 22);
        Task t5=new Task(25, 17);

        Task[] tasks={t1,t2,t3,t4,t5};

        SufficienzaDP sufficienza=new SufficienzaDP();
        sufficienza.printSeqMinEffort(tasks, 18);

    }
}
