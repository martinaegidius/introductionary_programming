#include <stdio.h>

int main(){
    int n = 6;
    int a[] = {1,2,3,-1,5,6};
    int i = 0;
    
    while(i<n && a[i]>0){
        a[i]*=2;
        i++;
    }
    for(int j=n-1;j>=0;j--){
        printf("%d\n",a[j]);
    }
    return 0;
}