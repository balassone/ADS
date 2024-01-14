/*

Homer Simpson, a very smart guy, likes eating Krusty-burgers. It takes Homer m minutes to eat a Krusty-burger. However, there’s a new type of burger in Apu’s Kwik-e-Mart. Homer likes those too. It takes him n minutes to eat one of these burgers. Given t minutes, you have to find out the maximum number of burgers Homer can eat without wasting any time. If he must waste time, he can have beer.
Input
Input consists of several test cases. Each test case consists of three integers m, n, t (0 < m, n, t < 10000). Input is terminated by EOF.
Output
For each test case, print in a single line the maximum number of burgers
Homer can eat without having beer. If homer must have beer, then also
print the time he gets for drinking, separated by a single space. It is preferable that Homer drinks as little beer as possible.
Sample Input
3 5 54
3 5 55
Sample Output
18
17

*/

// dynamic programming
#include <stdio.h>
#include <stdlib.h>

int main(){
    int m, n, t;
    while(scanf("%d %d %d", &m, &n, &t) != EOF){
        int i, j;
        int *dp = (int *)malloc(sizeof(int) * (t + 1));
        for(i = 0; i <= t; i++){
            dp[i] = 0;
        }
        for(i = m; i <= t; i++){
            if(dp[i - m] + 1 > dp[i]){
                dp[i] = dp[i - m] + 1;
            }
        }
        for(i = n; i <= t; i++){
            if(dp[i - n] + 1 > dp[i]){
                dp[i] = dp[i - n] + 1;
            }
        }
        if(dp[t] == 0){
            for(i = t - 1; i >= 0; i--){
                if(dp[i] != 0){
                    printf("%d %d\n", dp[i], t - i);
                    break;
                }
            }
        }
        else{
            printf("%d\n", dp[t]);
        }
        free(dp);
    }
    return 0;
}