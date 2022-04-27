#include <stdio.h>
void swap(int * a, int * b, int n) {
    int temp[n];
    int i;
    for (i=0;i<n;i++){
        temp[i] = a[i];
        a[i] = b[i];
        b[i] = temp[i];        
    }
    
}
int main() {
    int x[] = { 1, 2, 3, 4, 5 };
    int y[] = { 6, 7, 8, 9 };
    swap(x, y, 3);
    int i;
    for (i = 0; i < 5; i++) {
        printf("%d", x[i]);
    }
    printf("\n");
    for (i = 0; i < 4; i++) {
        printf("%d", y[i]);
    }
    printf("\n");
    return 0;
}