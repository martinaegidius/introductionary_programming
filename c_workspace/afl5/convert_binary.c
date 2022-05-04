#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int getBinary(int a,int bin,int c){
    char str[13];
    int sentinel = snprintf(str,13,"%d%d%d%d",a,bin,c,0); //more robust than sprintf()
    if(sentinel<0){
        printf("Buffer overflow.");
    }
    printf("%s\n",str);
    int binary = atoi(str); //cast to int

    //convert to binary 
    char * bits = (char *) malloc(14*sizeof(char));
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
    int year = 2012;
    int spring = 1;
    int gpa = 255;
    
    int out = getBinary(year,spring,gpa);
    printf("\n%d",out);
    

    return 0;
}