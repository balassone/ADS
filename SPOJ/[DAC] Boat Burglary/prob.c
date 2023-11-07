#include <stdio.h>

/*
sorto array
2 3 5 6 9

*/

int main(){
    FILE* file = fopen("input.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        int N,D;
        fscanf(file,"%d %d",&N,&D);
        int weight[N];
        for(int i=0; i<N; i++){
            fscanf(file,"%d",&weight[i]);
        }
    }
    fclose(file);
    return 0;
}