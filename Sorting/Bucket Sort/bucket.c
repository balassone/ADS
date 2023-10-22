#include <stdio.h>
#include <stdlib.h>

// Structure for a single linked list node
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Function to perform Insertion Sort within a bucket
void insertionSort(Node* bucket) {
    if (bucket == NULL || bucket->next == NULL) {
        return;
    }

    Node* sorted = bucket->next;
    bucket->next = NULL;

    while (sorted != NULL) {
        Node* current = sorted;
        sorted = sorted->next;

        Node* previous = bucket;
        Node* currentPtr = bucket->next;
        while (currentPtr != NULL && currentPtr->data < current->data) {
            previous = currentPtr;
            currentPtr = currentPtr->next;
        }

        previous->next = current;
        current->next = currentPtr;
    }
}

// Function to perform Bucket Sort
void bucketSort(int arr[], int n) {
    if (n <= 0) {
        return;
    }

    // Find the maximum value in the array
    int max = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    // Create an array of linked lists (buckets)
    int numBuckets = max + 1;
    Node* buckets[numBuckets];

    for (int i = 0; i < numBuckets; i++) {
        buckets[i] = (Node*)malloc(sizeof(Node));
        buckets[i]->next = NULL;
    }

    // Insert elements into buckets
    for (int i = 0; i < n; i++) {
        int index = arr[i];
        insert(buckets[index], arr[i]);
    }

    // Sort each bucket using Insertion Sort
    for (int i = 0; i < numBuckets; i++) {
        insertionSort(buckets[i]);
    }

    // Concatenate the sorted buckets in order
    int index = 0;
    for (int i = 0; i < numBuckets; i++) {
        Node* current = buckets[i]->next;
        while (current != NULL) {
            arr[index] = current->data;
            index++;
            current = current->next;
        }
    }

    // Free memory used by buckets
    for (int i = 0; i < numBuckets; i++) {
        Node* current = buckets[i];
        while (current != NULL) {
            Node* temp = current;
            current = current->next;
            free(temp);
        }
    }
}

int main() {
    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    bucketSort(arr, n);

    printf("\nSorted array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
