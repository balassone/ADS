import java.util.Arrays;
import java.util.Scanner;

public class MinMaxResult {

    private int[] numbers;
    private char[] operations;
    private int[][] maxMatrix;
    private int[][] minMatrix;

    public void printMinMaxResult(String string){
    
        this.numbers=new int[(string.length()+1)/2];
        this.operations=new char[(string.length()-1)/2];

        //alloco le matrici
        this.maxMatrix=new int[numbers.length][numbers.length];
        this.minMatrix=new int[numbers.length][numbers.length];

        int k=0,q=0;
        for(int i=0;i<string.length();i++){
            
            String num="";
            char op;

            while(string.charAt(i)!='+' && string.charAt(i)!='*'){
                num += string.charAt(i);
            }

            op=string.charAt(i);
            numbers[k]=Integer.parseInt(num);
            operations[q]=op;

            k++;
            q++;

        }

        //costruisco le due matrici
        minMaxResult();

        //le stampo
        printMatrix(maxMatrix);
        printMatrix(minMatrix);

    }

    public void minMaxResult(){

        //inizializzo le matrici con i valori sulla diagonale, cioè i casi base
        for(int i=0;i<maxMatrix.length;i++){
            maxMatrix[i][i]=numbers[i];
            minMatrix[i][i]=numbers[i];
        }
        
        for(int l=1;l<numbers.length;l++){
        
            for(int i=0;i<numbers.length-l;i++){
            
                int j=i+l;
                maxMatrix[i][j]=Integer.MIN_VALUE;
                minMatrix[i][j]=Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                
                    int min=0;
                    int max=0;
                    if(findOperation(k)=="sum"){
                        
                        min=minMatrix[i][k]+minMatrix[k+1][j];
                        max=maxMatrix[i][k]+maxMatrix[k+1][j];

                    }else if(findOperation(k)=="product"){
                    
                        min=minMatrix[i][k]*minMatrix[k+1][j];
                        max=maxMatrix[i][k]*maxMatrix[k+1][j];

                    }

                    if(min<minMatrix[i][j]){
                        minMatrix[i][j]=min;
                    }

                    if(max>maxMatrix[i][j]){
                        maxMatrix[i][j]=max;
                    }

                }

            }

        }

    }

    public String findOperation(int k){
        
        if(operations[k]=='+'){
            return "sum";
        }else if(operations[k]=='*'){
            return "product";
        }

        return "";

    }

    public void printMatrix(int[][] m){
        System.out.println("--------------------------------------------");
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.printf("%7d",m[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        MinMaxResult minmax=new MinMaxResult();
        Scanner scan=new Scanner(System.in);

        while(scan.hasNextLine()){

            String[] tokens=scan.nextLine().split("\\s");
            System.out.println(Arrays.toString(tokens));

            for (String string : tokens) {

                if(string=="0"){
                    scan.close();
                    return;
                }

                minmax.printMinMaxResult(string);
            }

        }

    }
}
