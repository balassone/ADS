package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import divisor.LootDivisor;

public class TestCase {

    public void test(File file) throws FileNotFoundException{
        
        LootDivisor divisor=new LootDivisor();
        Scanner scan=new Scanner(file);
        int ntest=0;

        while(scan.hasNextLine()){
            
            ntest=scan.nextInt();
            int length=0;

            for(int i=0;i<ntest;i++){
                
                length=scan.nextInt();
                int[] array=new int[length];

                for(int j=0;j<length;j++){
                    array[j]=scan.nextInt();
                }

                divisor.printBottomUpMinimizeDiff(array);

            }

        }

        scan.close();

    }

    public static void main(String[] args) throws FileNotFoundException{
        File file=new File("C:\\Users\\salva\\OneDrive\\Desktop\\Università\\Algoritmi e strutture dati\\Esercizi ADS\\Programmazione Dinamica\\Problemi da Ladri DP\\src\\test\\testFile.txt");
        TestCase t=new TestCase();
        t.test(file);
    }
}
