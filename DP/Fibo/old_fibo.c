#include <stdio.h>
#include <stdlib.h>

long fibonacci(long n){
    if(n==0) return 0;
    if (n==1) return 1;
    return fibonacci(n-1)+fibonacci(n-2);
}

int main(int argc, char** argv){

    if(argc!=2){
        perror("Inserire parametro!");
        return -1;
    }
    long num = atol(argv[1]);
    
    if(num<65535){
        long result = fibonacci(num);
        printf("Fibonacci: %ld\n",result);
    } else {
        perror("Numero troppo grande!");
    }
    

    
    return 0;
}