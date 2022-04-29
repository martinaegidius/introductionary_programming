#include <stdio.h>

int g(int x){
    return x + 3;
}

int f(int x){
    return g(x+1)*g(x+1);
}

int main(){
    printf("%d",f(1));
    return 0;
}