#include <stdio.h>
#include <stdbool.h>

void process_solution(int A[], int dim){
    for(int i=0; i<dim; i++){
        printf("%d\t",A[i]);
    }
    printf("\n");
}

bool isIn(int A[], int dim, int val){
    for(int i=0; i<dim; i++){
        if(A[i]==val) return true;
    }
    return false;
}

void build_candidates(int A[], int step, int perm[], int candidates[], int* nc){
    for(int i=0; i<10; i++){
        if(!isIn(perm,step,i)){
            candidates[*(nc)]=i;
            (*nc)++;
        }
    }
}

int getSum(int A[], int perm[]){
    int sum=0;
    for(int i=0; i<10; i++){
        sum+=A[i]*perm[i];
    }
    return sum;
}

bool backtrack(int A[], int step, int perm[], int target){
    if(step==10){
        if(getSum(A,perm)==target){
            process_solution(perm,step);
            return true;
        }
        return false;
    }
    int candidates[10-step];
    int nc=0;
    build_candidates(A,step,perm,candidates,&nc);
    if(nc!=0){
        for(int i=0; i<nc; i++){
            perm[step]=candidates[i];
            step++;
            if(backtrack(A,step,perm,target)) return true;
            step--;
        }
        return false;
    }
    return false;
}

int main(){
    FILE* file = fopen("input.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        int numbers[10];
        int permutation[10];
        for(int i=0; i<10; i++){
            fscanf(file,"%d",&numbers[i]);
            permutation[i]=0;
        }
        int target;
        fscanf(file,"%d",&target);

        if(!backtrack(numbers,0,permutation,target)){
            printf("-1\n");
        }

    }
    fclose(file);
    return 0;
}