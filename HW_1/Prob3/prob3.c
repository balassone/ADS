#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct {
    int key, priority;
    node *left, *right;
} node;

node* newNode(int key) {
    node* temp = (node*)malloc(sizeof(node));
    temp->key = key;
    temp->priority = rand()%100;
    temp->left = temp->right = NULL;
    return temp;
}

node* rightRotate(node* y) {
    node* x = y->left,  *T2 = x->right;
    x->right = y;
    y->left = T2;
    return x;
}

node* leftRotate(node* x) {
    node* y = x->right, *T2 = y->left;
    y->left = x;
    x->right = T2;
    return y;
}

node* insert(node* root, int key) {
    if (root == NULL)
        return newNode(key);

    if (key <= root->key) {
        root->left = insert(root->left, key); //inserimento BST e ritorno il puntatore

        if (root->left->priority < root->priority)
            root = rightRotate(root);
    } else {

        root->right = insert(root->right, key); //inserimento BST e ritorno il puntatore

        if (root->right->priority < root->priority)
            root = leftRotate(root);
    }
    return root;
}

void inorder(node* root) {
    if (root) {
        inorder(root->left);
        printf("key: %d | priority: %d \n", root->key, root->priority);
        inorder(root->right);
    }
}

int main() {
    node* root = NULL;
    srand(time(NULL));

    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);

    inorder(root);

    return 0;
}
