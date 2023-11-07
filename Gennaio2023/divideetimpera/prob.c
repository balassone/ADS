#include <stdio.h>

int calculateSum(int A[], int p, int r){
    if(r-p==1){
        return A[p]+A[r];
    } else if(r==p){
        return A[p];
    } else{
        if(p<r){
            int q = (p+r)/2;
            int sum = calculateSum(A,p,q);
            sum+= calculateSum(A,q+1,r);
            return sum;
        }
    }
}

int main(){
    FILE* file = fopen("input.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        int dim;
        fscanf(file,"%d",&dim);
        int A[dim];
        for(int i=0; i<dim; i++){
            fscanf(file,"%d",&A[i]);
        }
        int successione = ((A[0]+A[dim-1])*(dim+1))/2;
        int somma = calculateSum(A,0,dim-1);
        printf("%d\n",successione-somma);
    }
    fclose(file);
    return 0;
}