#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX 100
// Complessità O(n): scorro tutto l'array

int main(){
    
    FILE* file = fopen("input.txt","r");

    char line[256];

    while(fgets(line,sizeof(line),file)){

        if(strcmp("END",line)==0) break;

        char* token = strtok(line, " ");
        int len = 0;

        int array[MAX];

        while(token != NULL){
            array[len++]=atoi(token);
            token = strtok(NULL," ");
        }

        int somma_tot=array[0]; // Segnaposto per il massimo sottoarray, lo inizializzo al primo elemento

        int somma_par=0; // Somma parziale, parte da zero e successivamente sarà pari o ad una somma o all'i-esimo elemento

        for(int i=0; i<len; i++){

            if(somma_par+array[i]>=array[i]){

                somma_par+=array[i]; // Se la somma è comunque un numero più grande dell'elemento corrente la continuo a considerare: io voglio il massimo.

            
            } else {

                somma_par=array[i];
            }
            // Se l'elemento corrente è maggiore della nuova somma parziale, allora la "resetto" con l'elemento corrente (e non a 0 altrimenti lo "dimentico").

            // Es. -8 +3: sicuramente -5 è meno promettente di +3, quindi inizio a contare da 3
            
            if(somma_par>somma_tot) somma_tot=somma_par; // Se la somma parziale è più grande della totale (inizialmente maggiore del primo elemento) allora la sostituisco
        }
        
        printf("%d\n",somma_tot);
    }
    
    fclose(file);
    return 0;
}