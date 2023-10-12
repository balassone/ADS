#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
struct node
{
    int parent;
    bool val;
    int value;
    int lchild;
    int rchild;
};


int main(){
    FILE* file = fopen("problem.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        int depth;
        fscanf(file, "%d",&depth);
        int nodes = pow(2,depth);
        struct node tree[nodes];

        for(int i=1; i<nodes+1; i++){
            if(i==1){
                tree[i].parent=-1;
            } else {
                tree[i].parent=i/2;
            }
            tree[i].val=false;
            tree[i].value=i;
            if(i<(depth-(2*(depth-1)))){
                tree[i].lchild=2*i;
                tree[i].rchild=2*i+1;
            } else {
                tree[i].lchild=-1;
                tree[i].rchild=-1;
            }
        }
        int attempts;
        fscanf(file,"%d",&attempts);
        for(int i=0; i<attempts; i++){
            int j=1;
            while(tree[j].rchild!=-1){
                if(tree[j].val==false){
                    tree[j].val=true;
                    j=tree[j].lchild;
                } else {
                    tree[j].val=false;
                    j=tree[j].rchild;
                }
            }
            if(i==attempts-1){
                printf("%d\n",tree[j].value);
            }
        }
    }
    fclose(file);
    return 0;
}