package PreAppello2022;

import java.util.ArrayList;
import java.util.Scanner;

public class militari {



    public static int foundBases(pos [][] matrix, ArrayList<Integer> x, ArrayList<Integer> y){

        int count=0;
        boolean ok = false;
        for(int i=0; i<x.size(); i++){

            int j = 0;
            ok = false;
            
            while (j<x.size()){

                for(int l=0; l<x.size(); l++){
                    if(x.get(i)==matrix[l][l].getX() && y.get(j)==matrix[l][l].getY()){
                    
                        System.out.println(i + "e " + j);
                        if(matrix[i][j]==null){
                            pos position = new pos(i, j);
                            matrix[i][j]= position;
                            
                            if(j<i){
                                count++;
                            }

                        } 

                     ok =true;
                     break;
                     
                    }


                }
                    
                if(ok){
                    break;
                }

                j++;
                
            }
        }

        return count;

    }

   
    





    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int testCases = scan.nextInt();

        for (int i = 0; i < testCases; i++) {
            int N = scan.nextInt();

            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();

            for(int j=0; j<N; j++){
                x.add(scan.nextInt());
            }

            for(int k=0; k<N; k++){
                y.add(scan.nextInt());
            }


            //genero matrice di supporto
            pos [][] matrix = new pos[N][N];

            for(int l=0; l<N; l++){
                pos posizione = new pos(x.get(l), y.get(l));
                matrix[l][l]=posizione;
            }

            x.sort(null);
            


            //chiama funzione
            System.out.println(foundBases(matrix, x, y));

        }

        
    }
}
