#include <stdio.h>
#include <stdlib.h>

struct Node {
    double data;
    struct Node* next;
};

void insertionSort(struct Node* head) {
    if (head == NULL) return;
    struct Node* sorted = NULL;
    struct Node* current = head;

    while (current != NULL) {
        struct Node* next = current->next;
        if (sorted == NULL || sorted->data >= current->data) {
            current->next = sorted;
            sorted = current;
        } else {
            struct Node* search = sorted;
            while (search->next != NULL && search->next->data < current->data) {
                search = search->next;
            }
            current->next = search->next;
            search->next = current;
        }
        current = next;
    }

    while (sorted != NULL) {
        printf("%.2lf ", sorted->data);
        sorted = sorted->next;
    }
}

void bucketSort(double arr[], int n) {
    const int numBuckets = 10;
    struct Node* buckets[numBuckets];

    for (int i = 0; i < numBuckets; i++) {
        buckets[i] = NULL;
    }

    for (int i = 0; i < n; i++) {
        int index = (int)(arr[i] * numBuckets);
        struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
        newNode->data = arr[i];
        newNode->next = buckets[index];
        buckets[index] = newNode;
    }

    for (int i = 0; i < numBuckets; i++) {
        insertionSort(buckets[i]);
    }
}

int main() {
    double arr[] = {0.45, 0.12, 0.36, 0.87, 0.55, 0.72, 0.33, 0.50};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Array non ordinato: ");
    for (int i = 0; i < n; i++) {
        printf("%.2lf ", arr[i]);
    }
    printf("\n");

    bucketSort(arr, n);

    return 0;
}
