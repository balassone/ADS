package Prova2021Parentesi;
import java.util.Scanner;
                                                                                                                                                                                                                                         
public class op2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                                                                                                                                                                                                                                         
        while (true) {                                                                                                                                                                                                                   
            String expression = scanner.nextLine();                                                                                                                                                                                      
            if (expression.equals("0")) {                                                                                                                                                                                                
                break;                                                                                                                                                                                                                   
            }                                                                                                                                                                                                                            
                                                                                                                                                                                                                                         
            int[] result = calculateMinMax(expression);                                                                                                                                                                                  
            System.out.println(result[0] + " " + result[1]);                                                                                                                                                                             
        }                                                                                                                                                                                                                                
                                                                                                                                                                                                                                         
        scanner.close();                                                                                                                                                                                                                 
    }
                                                                                                                                                                                                                                         
    private static int[] calculateMinMax(String expression) {
        int n = expression.length();                                                                                                                                                                                                     
        int[] numbers = new int[(n + 1) / 2];
        char[] operators = new char[n / 2];
                                                                                                                                                                                                                                         
        int numIndex = 0;
        int opIndex = 0;
                                                                                                                                                                                                                                         
        for (int i = 0; i < n; i++) {                                                                                                                                                                                                    
            if (i % 2 == 0) {
                numbers[numIndex++] = Character.getNumericValue(expression.charAt(i));
            } else {
                operators[opIndex++] = expression.charAt(i);                                                                                                                                                                             
            }
        }                                                                                                                                                                                                                                
                                                                                                                                                                                                                                         
        int[][] maxValues = new int[numbers.length][numbers.length];
        int[][] minValues = new int[numbers.length][numbers.length];
                                                                                                                                                                                                                                         
        for (int i = 0; i < numbers.length; i++) {
            maxValues[i][i] = numbers[i];
            minValues[i][i] = numbers[i];
        }
                                                                                                                                                                                                                                         
        for (int len = 2; len <= numbers.length; len++) {
            for (int i = 0; i <= numbers.length - len; i++) {
                int j = i + len - 1;
                maxValues[i][j] = Integer.MIN_VALUE;
                minValues[i][j] = Integer.MAX_VALUE;
                                                                                                                                                                                                                                         
                for (int k = i; k < j; k++) {                                                                                                                                                                                            
                    int resultMax = evaluate(maxValues[i][k], maxValues[k + 1][j], operators[k]);                                                                                                                                        
                    int resultMin = evaluate(minValues[i][k], minValues[k + 1][j], operators[k]);                                                                                                                                        
                                                                                                                                                                                                                                         
                    maxValues[i][j] = Math.max(maxValues[i][j], resultMax);                                                                                                                                                              
                    minValues[i][j] = Math.min(minValues[i][j], resultMin);
                }
            }
        }
                                                                                                                                                                                                                                         
        int[] result = {maxValues[0][numbers.length - 1], minValues[0][numbers.length - 1]};
        return result;                                                                                                                                                                                                                   
    }                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                         
    private static int evaluate(int operand1, int operand2, char operator) {                                                                                                                                                             
        switch (operator) {                                                                                                                                                                                                              
            case '+':                                                                                                                                                                                                                    
                return operand1 + operand2;
            case '*':
                return operand1 * operand2;
            default:                                                                                                                                                                                                                     
                throw new IllegalArgumentException("Invalid operator: " + operator);                                                                                                                                                     
        }                                                                                                                                                                                                                                
    }
}         