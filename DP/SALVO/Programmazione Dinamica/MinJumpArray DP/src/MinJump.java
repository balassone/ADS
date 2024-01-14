public class MinJump {

    public void printMinJump(int[] a){
    
        int res=minJump(0, a);

        System.out.println("Il numero minimo di salti è: "+res);

    }

    public int minJump(int I,int[] a){
    
        if(I==a.length-1){
            return 0;
        }else{
            
            int max=I+1;

            int limit=Math.min(a[I],a.length-1-I);

            //trovo la posizione del nuovo massimo
            for(int i=0;i<limit;i++){
                if(a[I+1+i]>a[max]){
                    max=I+1+i;
                }
            }

            //scelta greedy
            int res=1+minJump(max, a);

            return res;

        }

    }

    public static void main(String[] args) throws Exception {
        MinJump min=new MinJump();
        int[] a={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        min.printMinJump(a);
    }
}
