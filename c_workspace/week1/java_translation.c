#include <stdio.h>

int fun(int n);

int main(){
    int n = 1,i;
    for(i=1;i<=10;i++){
        int res = fun(n);
        printf("%10d %10d\n",n,res);
        n *= 10;
    }
    return 0;
}

int fun(int n){
    int r = 0;
    while (n>0) {
        n/=2;
        r++;
    }
    return r;
}
