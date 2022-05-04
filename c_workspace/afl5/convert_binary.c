#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int getBinary(int a,int n){
    char str[n];
    int sentinel = snprintf(str,n,"%d",a); //more robust than sprintf()
    if(sentinel<0){
        printf("Buffer overflow.");
    }
    printf("%s\n",str);
    int binary = atoi(str); //cast to int

    //convert to binary 
    char * bits = (char *) malloc(n*sizeof(char));
    int b;
    int k= 0;
    while(binary){
        b = binary % 2;
        binary = binary/2;
        bits[k] = k;
        k++;

        printf("%d",b);
    }

    return binary;
}

int main(){
    int binarynum = 1111011111111;
    int year = 2012;
    int spring = 1;
    int gpa = 255;
    int out1 = getBinary(86);
    printf("\n%d",out1);
    int out = getBinary(year);
    printf("\n%d",out);
    printf("%d",binarynum);
    

    return 0;
}