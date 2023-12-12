def findMinDiff(monete, n, somma, somma_totale):

    #inizializzazione della matrice dp
    dp = [[0 for _ in range(somma+1)] for _ in range(n+1)]

    for i in range(n + 1): #è possibile ottenere una somma pari 0 utilizzando 0 o più monete
        dp[i][0] = True

    for i in range(1, somma + 1): #non è possibile ottenere una somma diversa da zero
        dp[0][i] = False          #senza utilizzare alcuna moneta

    for i in range(1, n + 1):  #per ogni moneta
        for j in range(1, somma + 1):  #e per ogni possibile somma
						#se il valore della moneta corrente
            if monete[i - 1] <= j:  #è minore o uguale alla somma corrente
								#vediamo se è possibile ottenere la somma corrente j con le prime i monete
								#due opzioni: includiamo la moneta corrente nel totale
								#             o escludiamo la moneta corrente nel totale
                dp[i][j] = dp[i - 1][j - monete[i - 1]] or dp[i - 1][j]
            else:
								#se il valore della moneta corrente è maggiore della somma corrente
								#vediamo se è possibile ottenere la somma corrente j escludendo la moneta
                dp[i][j] = dp[i - 1][j]

    j = somma
		#Troviamo la massima somma che può essere ottenuta utilizzando tutte le n monete
    while dp[n][j] != True:
        j -= 1

    ans = j
    return somma_totale - (2*ans) #calcolo e restituisco la differenza minima
	
if __name__ == "__main__":
    
    with open("./input.txt") as file:

        num_test = int(file.readline().strip())

        while num_test > 0:

            n = int(file.readline().strip())

            data = file.readline().strip().split()
            monete = [int(x) for x in data]

            somma_totale = sum(monete) #Calcolo del valore totale delle monete
            somma = somma_totale // 2 # Calcolo della metà del valore totale,
            #che rappresenta il massimo guadagno possibile per il ladro con il bottino minore

            print(findMinDiff(monete, n, somma, somma_totale))

            num_test -= 1