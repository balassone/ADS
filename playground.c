void CountingSort(int A[], int B[], int dim, int exp){
    int C[10] = {0};
    for(int i=0; i<dim; i++){
        C[(A[i]/exp)%10]++;
    }
    for(int i=1; i<10; i++){
        C[i]+=C[i-1];
    }
    for(int i=0; i<dim; i++){
        B[C[(A[i]/exp%10)]-1]=A[i];
        C[(A[i]/exp%10)]--;
    }
}

void RadixSort(int A[], int B[], int dim, int nDigits){
    int exp=1;
    for(int i=0; i<nDigits; i++){
        CountingSort(A,B,dim,exp);
        exp*=10;
    }
}