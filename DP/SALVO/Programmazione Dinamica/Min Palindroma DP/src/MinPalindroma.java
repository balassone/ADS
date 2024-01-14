import java.util.HashMap;

public class MinPalindroma {

    private HashMap<String,Integer> memo=new HashMap<String, Integer>();

    public void printMinPalindroma(String s){
        
        //pulisco memo
        memo.clear();

        char[] string=new char[s.length()];
        for(int i=0;i<string.length;i++){
            string[i]=s.charAt(i);
        }

        int res=minPalindroma(string);

        System.out.println("Il numero di lettere minimo da aggiungere a "+s+" è: "+res);

    }

    public char[] convertToCharArray(String s){
        char[] string=new char[s.length()];
        for(int i=0;i<string.length;i++){
            string[i]=s.charAt(i);
        }

        return string;
    }

    public String convertToString(char[] s){
        String string="";
        for(int i=0;i<s.length;i++){
            string+=s[i];
        }

        return string;
    }

    public boolean isPalindroma(char[] s){

        for(int i=0;i<s.length;i++){

            //se incontra un carattere non uguale al suo duale, torna false
            if(s[i]!=s[s.length-1-i]){
                return false;
            }

            //per non fare tutto il ciclo
            if(i==(s.length/2)+1){
                return true;
            }

        }

        return true;
    }

    public int minPalindroma (char[] s){

        String key=s.toString();
    
        //caso base,la stringa costruita è palindroma
        if(isPalindroma(s)){
            return 0;
        }else if(memo.containsKey(key)){
            return memo.get(key);
        }else{
        
            //Ho tre casi possibili, se il primo carattere è uguale all'ultimo
            if(s[0]==s[s.length-1]){

                //taglio primo e ultimo, facendo delle conversioni
                String stringa=convertToString(s);
                String nuovaStringa=stringa.substring(1, s.length-1);
                char[] newS=convertToCharArray(nuovaStringa);
                
                //richiamo la funzione su stessa stringa, aumento passo, e non aggiungo caratteri
                int res=minPalindroma(newS);
                return res;

            //Altri due casi, ovvero aggiungo in testa o in coda, tra i due scelgo quella con il risultato migliore
            }else{

                //costruisco appositamente 
                String testa=convertToString(s);
                testa=testa.charAt(testa.length()-1)+testa;
                String coda=convertToString(s);
                coda=coda+coda.charAt(0);

                char[] t=convertToCharArray(testa);
                char[] c=convertToCharArray(coda);

                //Attenzione a passare due stringhe modificate nel modo giusto
                //poichè se modifichi sulla stessa stringa potresti riportarla dopo, sbagliando
                int aggiungoInTesta=1+minPalindroma(t);
                int aggiungoInCoda=1+minPalindroma(c);

                int res=Math.min(aggiungoInTesta, aggiungoInCoda);

                return res;
            
            }

        }

    }

    public static void main(String[] args) throws Exception {
        MinPalindroma min=new MinPalindroma();
        String s="cast";
        
        min.printMinPalindroma(s);

    }
}
