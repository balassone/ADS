#include<stdio.h>
#include<vector>
#include<math.h>
using std::vector;

bool checkJolly(int* A, int dim){
    bool ciao = true;
    for(int i=0; i<dim; i++){
        if(A[i]==0){
            ciao=false;
            break;
        }
    }
    return ciao;
}

int solve(int* nums, int jolly[], int dim, int max){
    int result;

    for(int i=0; i<dim-1; i++){
        result = abs(nums[i]-nums[i+1]);
        
        if(result==0 || result>max){
            return 0;
        } else {
            jolly[result-1]=result;
        }
    }
    return 1;
}

int main(){
    FILE* file = fopen("input.txt","r");
    int dim;
    while(fscanf(file,"%d",&dim)>0){
        int nums[dim];
        for(int i=0; i<dim; i++){
            fscanf(file,"%d",&nums[i]);
        }

        int max = dim-1;
        int count[max];
        for(int i=0; i<max; i++){
            count[i]=0;
        }

        int res = solve(nums,count,dim,max);
        if(res>0 && checkJolly(count,max)){
            printf("Jolly\n");
        } else printf("Not jolly\n");

    }
    fclose(file);
}