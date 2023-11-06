#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

int solve(bool* tree, int nodes, int leaves, int throws, int node){
    if(node>=(nodes-leaves)){
        if(throws==1) return node;
        else{
            throws--;
            tree[node]=!tree[node];
            return solve(tree,nodes,leaves,throws,1);
        }
    } else{
        if (!tree[node]){
            tree[node]=!tree[node];
            return solve(tree,nodes,leaves,throws,2*node);
        } else {
            tree[node]=!tree[node];
            return solve(tree,nodes,leaves,throws,(2*node)+1);
        }
    }
}

int main(){
    FILE* file = fopen("problem.txt","r");
    int tc;
    fscanf(file,"%d",&tc);
    while(tc--){
        int depth, throws;
        fscanf(file, "%d %d",&depth, &throws);
        int nodes = pow(2,depth);
        int leaves = nodes/2;
        bool myTree[nodes];
        for(int i=0; i<nodes; i++) myTree[i]=false;
        int val = solve(myTree,nodes,leaves,throws,1);
        printf("%d\n",val);
    }
    fclose(file);
    return 0;
}