void InsertionSort(int* arr, int dim){
    for(int j=1; j<dim; j++){
        int key = arr[j];
        int i=j-1;
        while(i>=0 && arr[i]>key){
            arr[i+1]=arr[i];
            i--;
        }
        arr[i+1]=key;
    }
}