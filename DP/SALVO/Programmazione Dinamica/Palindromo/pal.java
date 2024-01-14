package Palindromo;

import java.util.Arrays;
import java.util.HashMap;

public class pal {

    //complessità theta(n^2) (chiamata (n+n)) 


    public static HashMap<Integer, Integer> memo = new HashMap<>();


    public static int findMaxPal(char[] word, int dim){

        if(memo.containsKey(dim)){
            return memo.get(dim);
        }

        if(dim==0){
            return 0;
        }

        int value = Integer.MIN_VALUE;
        
        for(int i=0; i<dim; i++){    
            value = Math.max(value, 1+findMaxPal(word, dim-1));            
        }

        if(isSafe(word, dim)){
            memo.put(dim, value);
        }

        
        return value;
    }
    


    private static boolean isSafe(char[] word, int dim) {
        for(int i=0; i<dim; i++){
            
            if(word[i]!=word[dim-i]){
                return false;
            }
        }


        return true;
    }


    public static void main(String[] args) {
        String ok = "annad";

        char[] word = new char[ok.length()];
        ok.getChars(0, ok.length(), word, 0);

        
        
        findMaxPal(word, word.length-1);
        System.out.println(memo.toString());
        Object [] values = memo.values().toArray();
        System.out.println(((int)(values[values.length-1]))+1);
        System.out.println(memo.toString());
        
       
    }


}
