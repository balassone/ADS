#include <stdio.h>
#include <stdlib.h>

long fibonacci(long n, long* memory){
    if(n==0) return 0;
    if (n==1) return 1;
    if(memory[n]!=0){
        return memory[n];
    }
    memory[n]=fibonacci(n-1,memory)+fibonacci(n-2,memory);
    return memory[n];
}

int main(int argc, char** argv){

    if(argc!=2){
        perror("Inserire parametro!");
        return -1;
    }

    long memory[65535] = {0};
    long num = atol(argv[1]);;
    
    if(num<65535){
        long result = fibonacci(num,memory);
        printf("Fibonacci: %ld\n",result);
    } else {
        perror("Numero troppo grande!");
    }

    
    return 0;
}