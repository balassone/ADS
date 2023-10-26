#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct node {
    int key, priority;
    struct node* left;
    struct node* right;
    struct node* parent;
};

struct node* newnode(int key) { // O(1)
    struct node* temp = (struct node*)malloc(sizeof(struct node));
    temp->key = key;
    temp->priority = rand()%100;
    temp->left = temp->right = temp->parent =NULL;
    return temp;
}

void left_rotate(struct node **T, struct node *x) { //O(1), non itero
    struct node *y = x->right;
		// operazione 1
    x->right = y->left;
    if (y->left != NULL) {
        y->left->parent = x;
    }
		// operazione 2
    y->parent = x->parent;
    if (x->parent == NULL) {
        *T = y;
    } else if (x == x->parent->left) {
        x->parent->left = y;
    } else {
        x->parent->right = y;
    }
		// operazione 3
    y->left = x;
    x->parent = y;
}

void right_rotate(struct node **T, struct node *y) { //O(1), non itero
    struct node *x = y->left;
	// operazione 1
    y->left = x->right;
    if (x->right != NULL) {
        x->right->parent = y;
    }
	// operazione 2
    x->parent = y->parent;
    if (y->parent == NULL) {
        *T = x;
    } else if (y == y->parent->left) {
        y->parent->left = x;
    } else {
        y->parent->right = x;
    }
	// operazione 3
    x->right = y;
    y->parent = x;
}

void BSTinsert(struct node **T, struct node *z){ // Caso peggiore inserire alla fine, O(h)
    struct node *y = NULL;
    struct node *x = *T;
    while(x != NULL){
        y = x;
        if(z->key < x->key)
            x = x->left;
        else
            x = x->right;
    }
    z->parent = y;
    if(y == NULL)
        *T = z;
    else if(z->key < y->key)
        y->left = z;
    else
        y->right = z;
}

void treap_insert(struct node **T, int key) { //O(h)
    struct node *z = newnode(key);

    BSTinsert(T, z);

    while (z != *T && z->priority < z->parent->priority) { // fintantoché la priorità di z è minore di quella di suo padre, voglio ripristinare il min heap per le priorità
        // supponiamo z sia una foglia, il while si ferma quando z==*T, quindi per risalirlo dovrei fare h volte una rotazione O(1), quindi costa O(h)
        if (z == z->parent->left) {
            right_rotate(T, z->parent); // se z è un figlio sinistro
        } else {
            left_rotate(T, z->parent);
        }
    }

    if (z->parent == NULL) {
        *T = z;
    }
    // In generale O(h) dell'inserimento + O(h) del caso peggiore della proprietà di Treap, costa O(h)
}


void inorderTraversal(struct node* root) {
    if (root != NULL) {
        inorderTraversal(root->left);
        printf("%d(%d) ", root->key, root->priority);
        inorderTraversal(root->right);
    }
}

int main() {
    FILE* file = fopen("input.txt","r");
    int cases;
    fscanf(file,"%d",&cases);
    while(cases>0){
        struct node* root = NULL;
        srand(time(NULL));
        int dim;
        fscanf(file,"%d",&dim);
        int keys[dim];
        for(int i=0; i<dim; i++){
            fscanf(file,"%d",&keys[i]);
        }

        for (int i = 0; i < dim; i++) {
            treap_insert(&root, keys[i]);
        }

        printf("Albero Treap dopo l'inserimento: ");
        inorderTraversal(root);
        printf("\nDove la radice e':\n");
        printf("%d(%d) ", root->key, root->priority);
        printf("\n");
        if(root->left!=NULL){
            printf("\nFiglio sx:\n");
            printf("%d(%d) ", root->left->key, root->left->priority);
            printf("\n");
        }
        if(root->right!=NULL){
            printf("\nFiglio dx:\n");
            printf("%d(%d) ", root->right->key, root->right->priority);
            printf("\n");
        }
        printf("\n");
        cases--;
    }
    return 0;
}
