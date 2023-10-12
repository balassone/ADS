#include <stdio.h>

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

int* solve(int tc, int* sol){
    FILE* file = fopen("values.txt","r");
    for(int k=0; k<tc; k++){
        int position=-1;
        int dim;
        fscanf(file,"%d",&dim);
        int houses[dim];
        
        
        for(int j=0; j<dim; j++){
            fscanf(file,"%d",&houses[j]);
        }

        int somma;
        int minimo;
        InsertionSort(houses,dim);
        for(int i=houses[0]; i<houses[dim-1]; i++){
            somma=0;
            for(int j=0;j<dim;j++){
                somma+= (i-houses[j]<0 ? houses[j]-i : i-houses[j]);
            }
            if(i==houses[0]){
                minimo=somma;
                position=i;
            } else {
                if(somma<minimo){
                    minimo=somma;
                    position=i;
                }
            }

        }
        sol[k]=minimo;
    }
    return sol;
        
    // ordino vettore, scelgo ogni punto dell'array, calcolo le distanze e trovo il min tra queste distanze

}

int main(){
    int tc;
    scanf("%d",&tc);
    int sol[tc];
    solve(tc,sol);
    for(int i=0; i<tc; i++){
        printf("%d\n",sol[i]);
    }
    return 0;
}