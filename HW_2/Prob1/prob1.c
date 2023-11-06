#include <stdio.h>

int main(){
    FILE* file = fopen("input.txt","r");
    int array[4];
    while(fscanf(file,"%d %d %d %d",&array[0],&array[1],&array[2],&array[3])>0){
        int placeholder_count=array[0];
        int basic_count=0;
        for(int i=0; i<4; i++){ // Complessità O(n)
            if(basic_count+array[i]>basic_count){
                basic_count+=array[i];
                if(basic_count>placeholder_count) placeholder_count=basic_count;
            } else basic_count=0;
        }
        
        printf("%d\n",placeholder_count);
    }
    return 0;
}