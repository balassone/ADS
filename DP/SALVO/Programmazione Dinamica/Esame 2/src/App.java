public class App {
    
    private int[][] dp;
    ArrayList<Integer[]> classi;

    public void printMax(ArrayList<Integer[]> list, int b){
    
        this.classi=list;

        dp=new int[classi.size()+1][b+1];


        buildDp(classi.size(),b);

        int minSpesa=0;
        for(int i=0;i<classi.size();i++){
        
            int minElement=Integer.MAX_VALUE;
            for(int j=0j<classi.get(i).length;j++){

                minElement=Math.min(minElement,classi.get(i)[j]);
            
            }

            minSpesa+=minElement;

        }

        if(dp[classi.size()][b]>=minSpesa){
            System.out.println(dp[classi.size()][b]);
        }else{
            System.out.println("denaro insufficiente");
        }

    }

    public void buildDp(int nClassi, int budget){

        for(int i=0;i<=nClassi;i++){
            for(int j=0;j<=budget;j++){

                int max=Integer.MIN_VALUE;

                for(int k=0;k<classi.get(i).length;k++){
            
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }else if(classi.get(i)[k]<=j){
                    
                        max=Math.max(max,dp[i-1][j-classi.get(i)[k]]+classi.get(i)[k]);

                    }else{
                    
                        //in teoria se non posso inserire non faccio nulla e metto il precedente
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j]);

                    }

                }

            }
        }

    }

    public static void main(String[] args) throws Exception {
        App app=new App();
        ArrayList<Integer[]> list=new ArrayList<Integer[]>();

        Scanner scan=new Scanner(System.in);

        while(scan.hasnext()){
        
            int ntest=scan.nextInt();

            for(int t=0;t<ntest;t++){
            
                int b=scan.nexInt();
                int nClassi=scan.nextInt();

                for(int i=0;i<nClassi;i++){
                
                    int sizeArr=scan.nextInt();
                    int[] arr=new int[sizeArr];
                    for(int j=0;j<sizeArr;j++){
                        arr[j]=scan.nextInt();
                    }

                    list.add(arr);

                }

                app.printMax(list,b);

            }

        }

        scan.close();

    }
}

//Stiamo usando una struttura knapSack con però una modifica, ricordarsi che la somma può essere pseudopolinomiale
//la modifica è provare ad aggiungere il massimo elemento di ogni lista
//quindi complessità O(nclassi*Sum*MaxSizeArrayClasse)
//Ho avuto problemi nel debugging poichè l'estensione ha smesso di funzionare
//sono ricorso ad un compilatore online
//errore da gestire non corrispondenza dell'indice della classi i-esima con la riga della matrice dp
//non sono riuscito a gestirlo per mancanza di tempo