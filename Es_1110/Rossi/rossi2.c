#include <stdio.h>
#include <stdlib.h>
// Supremo
void InsertionSort(int* arr, int dim){
    for(int j=1; j<dim; j++){
        int key = arr[j];
        int i=j-1;
        while(i>=0 && arr[i]>key){
            arr[i+1]=arr[i];
            i--;
        }
        arr[i+1]=key;
    }
}

int main() {
    int num_cases;
    FILE* file = fopen("values.txt","r");
    fscanf(file, "%d", &num_cases);
    
    while (num_cases--) {
        int r;
        fscanf(file,"%d", &r);
        int relatives[r];
        
        for (int i = 0; i < r; i++) {
            fscanf(file,"%d", &relatives[i]);
        }
        
        InsertionSort(relatives, r);
        
        int median = relatives[r / 2];
        int total_distance = 0;
        
        for (int i = 0; i < r; i++) {
            total_distance += abs(relatives[i] - median);
        }
        
        printf("%d\n", total_distance);
    }

    fclose(file);
    
    return 0;
}
