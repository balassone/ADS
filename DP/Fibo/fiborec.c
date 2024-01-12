#include <stdio.h>

int Fibonacci(int n, int* A){
    if(n<=1) return 1;
    if(A[n]!=0) return A[n];
    else {
        A[n] = Fibonacci(n-1,A)+Fibonacci(n-2,A);
        return A[n];
    }
}

int main(){
    int A[100] = {0};
    A[0]=A[1]=1;
    int a=0;
    scanf("%d",&a);
    printf("%d\n",Fibonacci(a,A));
    return 0;
}