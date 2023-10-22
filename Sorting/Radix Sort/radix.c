#include <stdio.h>

// Funzione Counting Sort per una specifica posizione del cifre (exp)
void countingSort(int arr[], int n, int exp) {
    int output[n];
    int count[10] = {0};

    for (int i = 0; i < n; i++) {
        count[(arr[i] / exp) % 10]++;
    }

    for (int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }

    for (int i = 0; i < n; i++) {
        arr[i] = output[i];
    }
}

// Funzione Radix Sort
void radixSort(int arr[], int n, int numDigits) {
    int exp = 1;

    for (int i = 1; i <= numDigits; i++) {
        countingSort(arr, n, exp);
        exp *= 10;
    }
}

int main() {
    int arr[] = {170, 450, 753, 901, 802, 245, 265, 996};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Array originale: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    radixSort(arr, n, 3); // Supponendo che tutti gli elementi abbiano 3 cifre

    printf("\nArray ordinato: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
