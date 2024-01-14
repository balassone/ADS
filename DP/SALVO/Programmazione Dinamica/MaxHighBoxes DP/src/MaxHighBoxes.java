/*
 * Date delle scatole con i seguenti parametri (Lunghezza,larghezza,altezza)
 * determinare la massima altezza raggiungibile impilando le varie scatole
 * Per impilare una scatola su un'altra: lung1 < lung2 && larg1 < larg2
 * Così posso impilare la scatola 1 su 2
 */

public class MaxHighBoxes {

    private Box[] boxes;
    private int[] dp;

    public void printMaxHighBoxes(Box[] b){
    
        dp=new int[b.length];

        Box[] boxesSorted=sortBoxes(b);
        this.boxes=boxesSorted;

        buildDp(boxes.length);

        System.out.println(dp[boxes.length-1]);

    }

    public Box[] sortBoxes(Box[] b){
    
        //variabile key
        Box key;

        //parti direttamente dal secondo elemento
        for(int i=1;i<b.length;i++){
        
            key=b[i];

            //indice dinamico per il confronto all'indietro
            int j=i-1;

            while(j>=0 && key.isSmaller(b[j])){
            
                //sto facendo lo swap traslando, il valore di key è salvato prima
                b[j+1]=b[j];
                j=j-1;

            }

            //ripristino il valore di key
            b[j+1]=key;
        
        }

        return b;

    }

    public void buildDp(int n){
    
        //caso base, con solo la più piccola scatola, il massimo che posso fare è impilarla da sola
        dp[0]=boxes[0].getAltezza();

        //per i casi successivi, possiamo ricondurre il problema ad una forma alternativa di LIS
        for(int i=1;i<n;i++){

            int max=0;

            for(int j=0;j<i;j++){
                
                if(boxes[i].getLunghezza() > boxes[j].getLunghezza() && boxes[i].getLarghezza() > boxes[j].getLarghezza() && max<dp[j]){
                    max=dp[j];
                }

            }

            dp[i]=max+boxes[i].getAltezza();

        }

    }
    
    public static void main(String[] args) throws Exception {

        Box b1=new Box(4, 5, 3);
        Box b2=new Box(2, 3, 2);
        Box b3=new Box(3, 6, 2);
        Box b4=new Box(1, 5, 4);
        Box b5=new Box(2, 4, 1);
        Box b6=new Box(1, 2, 2);

        Box[] boxes=new Box[6];

        boxes[0]=b1;
        boxes[1]=b2;
        boxes[2]=b3;
        boxes[3]=b4;
        boxes[4]=b5;
        boxes[5]=b6;

        MaxHighBoxes m=new MaxHighBoxes();
        m.printMaxHighBoxes(boxes);

    }
}
