#include <stdio.h>
#include <stdlib.h>
void half(int xn[], int yn[],int n);

int main() {
    int x[] = { 1, 2, 3, 4, 5 };
    int n = sizeof x / sizeof x[0];
    printf("n=%d\n", n);
    int y[n];
    half(x,y,n);
    int i;
    for (i = 0; i < n; i++) {
        printf("%d %d\n", x[i], y[i]);
    }
    return 0;
}

void half(int xn[], int yn[], int n) {
    for(int i=0;i<n;i++){
        yn[i] = xn[i]/2;
    }
}
