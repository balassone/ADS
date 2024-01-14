public class FibonacciDP {

    private double[] memo;

    public void fibTop(int n){

        if(n<=0){
            System.out.println("Input inserito non valido, serve un numero positivo");
            return ;
        } 

        //inizializzo memo
        memo=new double[n];

        for(int i=0;i<n;i++){
            memo[i]=0;
        }

        /* 
        for(int i=0;i<n;i++){
            System.out.println(this.fibNaive(i));
        }
        */

        System.out.println("Numero sequenza di fibonacci di "+n+" è : "+this.fibTopDown(n-1));

    }

    private double fibTopDown(int n){    
        if(memo[n]!=0){

            //Memoization dei numeri salvati in precedenza
            return memo[n];
        
        }else{
            
            //Algoritmo di fibonacci ricorsivo standard
            if(n<2){
                return 1;
            }else{
                double f=fibTopDown(n-1)+fibTopDown(n-2);
                memo[n]=f; //salvo il risultato per riutilizzo
                return memo[n];
            }

        }
    }

    /* 
    public double fibNaive(int n){
        if(n<2){
                return 1;
            }else{
                double f=fibNaive(n-1)+fibNaive(n-2);
                return f;
            }
    }
    */

    public static void main(String[] args) throws Exception {
        FibonacciDP fib=new FibonacciDP();
        int n=100;
        fib.fibTop(n);
    }
}
