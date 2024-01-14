public class StringhePrimitive {

    private String[] dictionary;
    private boolean[] dp;

    public void printIfIsPossible(String s, String[] d){
        
        dp=new boolean[s.length()+1];

        this.dictionary=d;
        
        buildDp(s.length(), s);

        if(dp[s.length()]){
            System.out.println("E' possibile costruire la stringa");
        }else{
            System.out.println("NON è possibile costruire la stringa");
        }

    }

    public boolean contains(String s){

        for(int i=0;i<dictionary.length;i++){
            if(dictionary[i].compareTo(s)==0){
                return true;
            }
        }

        return false;
    }

    public void buildDp(int n, String s){
    
        //Interpretiamo dp[i] come la possibilità di poter costruire la sottostringa da 0 a i
        //caso base, dp[0] è sempre true, stringa nulla si può costruire con il nulla, qualunque dizionario
        dp[0]=true;

        for(int i=1;i<=n;i++){
            
            dp[i]=false;

            for(int j=0;j<i;j++){
            
                boolean result=dp[j] && contains(s.substring(j, i-1));

                if(result){
                    dp[i]=true;
                }

            }

        }

    }

    public static void main(String[] args) throws Exception {
        String[] d={"01","011","10","101"};
        String s="11110101";
        StringhePrimitive str=new StringhePrimitive();
        str.printIfIsPossible(s, d);
    }
}
