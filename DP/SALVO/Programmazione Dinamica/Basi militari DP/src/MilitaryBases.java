import java.util.concurrent.TimeUnit;

public class MilitaryBases {

    private int[] xBases;
    private int[] yBases;

    public void printMaxBondWithLIS(int[] x, int[] y){
    
        //per risolvere il problema con lis devo prima ordinare il vettore delle x
    
        xBases=new int[x.length];
        for(int i=0;i<x.length;i++){
            xBases[i]=x[i];
        }
    
        this.yBases=y;
 
        int[] sortedX=x;
        int[] adjustedY=new int[y.length];

        InsertionSort ins=new InsertionSort(sortedX);
        sortedX=ins.returnSorted(x);

        for(int i=0;i<yBases.length;i++){
            
            for(int j=0;j<sortedX.length;j++){

                int a=sortedX[j];
                int b=xBases[i];
            
                if(a==b){
                    adjustedY[j]=yBases[i];
                }

            }

        }

        for(int i=0;i<sortedX.length;i++){
            System.out.print(sortedX[i]+" ");
        }

        System.out.println();

        for(int j=0;j<adjustedY.length;j++){
            System.out.print(adjustedY[j]+" ");
        }

        System.out.println();

        this.maxBondWithLIS(adjustedY);

    }
 
    public void maxBondWithLIS(int[] s){
    
        //con il vettore di coordinate y ordinate secondo le coordinate x crescenti
        //posso risolvere il problema come se fosse una Longest increasing subsequence
        LIS lis=new LIS();

        lis.printLIS(s);

    }

    public void printMaxBondAmongBases(int[] x, int[] y)throws InterruptedException{
        
        //controllo che abbiano la stessa lunghezza
        if(x.length!=y.length || y.length>50 || x.length>50){
            System.out.println("Errore nei vettori delle basi, riprovare");
            return;
        }

        //setto tutto
        this.xBases=new int[x.length];
        this.yBases=new int[y.length];
        this.xBases=x;
        this.yBases=y;
        boolean[] basetemp=new boolean[50];
        for(int  i=0;i<50;i++){
            basetemp[i]=false;
        }

        int res=maxBondAmongBases(0, basetemp);

        System.out.println("Il numero massimo di basi che possono collegarsi senza interferire è: "+res);

        TimeUnit.SECONDS.sleep(5);

        for(int i=0;i<3;i++){
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("Ok, è inutile che le spieghi la cosa, tanto non le interessa SOTTONE");

    }

    public int maxBondAmongBases(int n, boolean[] basetemp){
     
        if(n==xBases.length){
            return 0;
        }else{
            
            //scorro i vettori delle basi, tramite indice n
            //creo vettori da passare con inclusione e senza inclusione
            boolean[] arrayIncludo=basetemp;
            boolean[] arrayEscludo=basetemp;

            //aggiungo all'includo, solo se posso cioè non ho incroci tra basi
            int includo=-1;

            boolean canInclude=isSafe(n,basetemp);

            if(canInclude){
                arrayIncludo[n]=true;
                includo= 1 + maxBondAmongBases(n+1, arrayIncludo);
            }
            arrayEscludo[n]=false;
            int escludo=maxBondAmongBases(n+1, arrayEscludo);

            int res=Math.max(includo, escludo);

            return res;

        }
        
    }

    public boolean isSafe(int n, boolean[] basetemp){
    
        for(int i=0;i<basetemp.length;i++){
            if(basetemp[i]){
            
                if( (xBases[i]<=xBases[n] && yBases[i]>=yBases[n]) || (xBases[i])>=xBases[n] && yBases[i]<=yBases[n] ){
                    return false;
                }

            }
        }

        return true;

    }

    public static void main(String[] args) throws Exception {
        //int[] x={8,5,3,2};
        //int[] y={3,4,7,6};
        int[] x1={2,5,3,9,12,4};
        int[] y1={1,7,2,4,3,10};

        MilitaryBases bases=new MilitaryBases();
        bases.printMaxBondWithLIS(x1, y1);

    }
}
