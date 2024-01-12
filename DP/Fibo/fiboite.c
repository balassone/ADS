#include <stdio.h>

int Fibonacci(int n){
    int A[100]={0};
    A[0]=1;
    A[1]=1;
    if(n>1){
        for(int i=2; i<=n; i++){
            A[i]=A[i-1]+A[i-2];
        }
        return A[n];
    }
    return 1;
}

int main(){
    int a=0;
    scanf("%d",&a);
    printf("%d\n",Fibonacci(a));
    return 0;
}