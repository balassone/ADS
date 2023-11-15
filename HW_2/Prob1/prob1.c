#include <stdio.h>

// Complessità O(n): scorro tutto l'array

int main(){
    FILE* file = fopen("input.txt","r");

    int array[4]; // Dimensione fixata pari a 4 per i test case.

    while(fscanf(file,"%d %d %d %d",&array[0],&array[1],&array[2],&array[3])>0){

        int placeholder_count=array[0]; // Segnaposto per il massimo sottoarray

        int basic_count=0; // Somma parziale

        for(int i=0; i<4; i++){ // Complessità O(n)
            if(basic_count+array[i]>basic_count){ // Se il prossimo elemento aumenta la somma parziale
                basic_count+=array[i];
                if(basic_count>placeholder_count) placeholder_count=basic_count; // Se la nuova somma è maggiore
                // del segnaposto
            } else basic_count=0; // Azzero la somma parziale alla ricerca di una somma migliore
        }
        
        printf("%d\n",placeholder_count);
    }
    return 0;
}