
#Complessità O(2^(k-1) -1 )
# dove k è il numero di primi compresi tra P e S
# senza contare la funzione che genera i primi e senza conta il driver code


import math

set = []
prime = []

# funzione per controllare che un numero x sia primo
def isPrime(x):
    sqroot = int(math.sqrt(x))

    if (x == 1):
        return False
    else:
        for i in range(2, sqroot + 1):
            if (x % i == 0):
                return False
    return True


def display():
    global set, prime
    length = len(set)
    for i in range(0, length):
        print(set[i], end=" ")
    print()


#funzione che genera la soluzione
def primeSum(total, N, S, index):
    global set, prime

    # Controllo che ho trovato una somma S di N elementi
    if (total == S and len(set) == N):
        display()
        return

    # Controllo se ho superato S e ho raggiunto N elementi
    if (total > S or index == len(prime)):
        return

    # Aggiungo un primo alla soluzione
    set.append(prime[index])
    #Vado avanti nella ricerca
    primeSum(total + prime[index], N, S, index + 1)

    # Backtracking
    set.pop()
    #Vado avanti senza contare l'elemento appena escluso
    primeSum(total, N, S, index + 1)


#funzione per generare tutti i primi minori di S e maggiori di P e poi trova la soluzione
def Prime_Gen(N, S, P):
    global set, prime

    set = []
    prime = []
    for i in range(P + 1, S + 1):
        if (isPrime(i)):
            prime.append(i)

    if (len(prime) < N):
        return
    primeSum(0, N, S, 0)


if __name__ == '__main__':
    # casi di test
    n_test = int(input('casi test: '))

    arr_test = []
    for i in range(n_test):
        S = int(input('Somma: '))
        N = int(input('N: '))
        P = int(input('primo: '))

        arr_test.append([N, S, P])

    i = 1
    for elem in arr_test:
        print('CASO DI TEST', i)
        Prime_Gen(elem[0], elem[1], elem[2])
        i += 1
        set.clear()
        prime.clear()
