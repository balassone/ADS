// Implementa un Inorder Tree Walk
#include <stdlib.h>
//#include <null.h>
typedef struct{
    int key;
    node *left;
    node *right;
    node *p;
} node;

void inorder_tree_walk(node *x){
    if(x != NULL){
        inorder_tree_walk(x->left);
        printf("%d\n", x->key);
        inorder_tree_walk(x->right);
    }
}

//Ricerca
node* tree_search(node *x, int k){
    if(x == NULL || k == x->key)
        return x;
    if(k < x->key)
        return tree_search(x->left, k);
    else
        return tree_search(x->right, k);
}

//ricerca iterativa

node* iterative_tree_search(node *x, int k){
    while(x != NULL && k != x->key){
        if(k < x->key)
            x = x->left;
        else
            x = x->right;
    }
    return x;
}

//Minimo e massimo
node* tree_minimum(node *x){
    while(x->left != NULL)
        x = x->left;
    return x;
}

node* tree_maximum(node *x){
    while(x->right != NULL)
        x = x->right;
    return x;
}

// successore
node* tree_successor(node *x){
    if(x->right != NULL)
        return tree_minimum(x->right);
    node *y = x->p;
    while(y != NULL && x == y->right){
        x = y;
        y = y->p;
    }
    return y;
}

//inserimento
void tree_insert(node *T, node *z){
    node *y = NULL;
    node *x = T;
    while(x != NULL){
        y = x;
        if(z->key < x->key)
            x = x->left;
        else
            x = x->right;
    }
    z->p = y;
    if(y == NULL)
        T = z;
    else if(z->key < y->key)
        y->left = z;
    else
        y->right = z;
}

// Eliminazione di un elemento

node* treeDelete(node* T, node* z){
    node* y = z;
    node* x = NULL;
    if(z->left==NULL || z->right==NULL){
        y = z;
    }else{
        y = tree_successor(z);
    }
    if(y->left != NULL){
        x = y->left;
    }else{
        x = y->right;
    }
    if(x != NULL){
        x->p = y->p;
    }
    if(y->p == NULL){
        T = x;
    }else if(y == y->p->left){
        y->p->left = x;
    }else{
        y->p->right = x;
    }
    if(y != z){
        z->key = y->key;
    }
    return y;
}
