
#Complessità O(NlogN)
# al netto del driver code

def count(arr, l, r, k):

    #controllo se sono arrivato a dividere fino a un solo elemento
    if ((l > r) or (l == r and arr[l] != k)):
        return 0

    #se sono a un solo elemento ed è k allora ritorno 1
    if (l == r and arr[l] == k):
        return 1

    #divido in due parti
    return count(arr, l, (l + r) // 2, k) + count(arr, 1 + (l + r) // 2, r, k)


# Driver code
if __name__ == '__main__':

    #casi di test
    n_test = int(input('casi test: '))

    arr_test = []
    for i in range(n_test):

        k = int(input('k: '))
        dim_arr = int(input('dim_arr: '))
        input_arr = input('')
        arr = []
        for elem in input_arr.split(' '):
            arr.append(int(elem))

        arr_test.append(count(arr, 0, dim_arr - 1, k))

    for elem in arr_test:
        print(elem)
