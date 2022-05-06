#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

int convertToInt(char a[4]){
    int i = 0;
    int num = 0;
    while (a[i] != 0)
    {
        num =  (a[i] - '0')  + (num * 10);
        i++;
    }
    return num;;
}


char * BeBinary(int a,int b,int c){
    int n = 14;
    a = a-2009;
    //convert to binary with remainder division
    char * final = (char *) malloc(14*sizeof(char));
    int bin;
    int k = 0;
    int seqsum = 0;
    printf("a is: ");
    while(a){
        bin = a % 2;
        a = a/2;
        seqsum += (int)pow(2,k);
        k++;
        final[k] = bin;
        printf("%d",bin);
    }
    printf("\nb is: ");
    bin = 0;
    while(b){
        bin = b % 2;
        b = b/2;
        seqsum += (int)pow(2,k);
        k++;
        final[k] = bin;
        printf("%d",bin);
    }
    bin = 0;
    printf("\nc is: ");
    while(c){
        bin = c % 2;
        c = c/2;
        seqsum += (int)pow(2,k);
        k++;
        final[k] = bin;
        printf("%d",bin);
    }

    long long int i;
    printf("\nfinal is: ");
    for(int i = 0;i<14;i++){
        printf("%d",final[i]);
    }
    sscanf(&final[1], "%lld", &i);
    printf("\n integer becomes: %lld",i);
    printf("seqsum becomes %d",seqsum);
    
    return final;
}



char * BeNoNBinary(char * num){
    int a;
    char * holder = (char *) malloc(4*sizeof(char));
    for(int i=0;i<5;i++){
        holder[i] = num[i+1];
        printf("in loop %d",holder[i]);
    }
    printf("\nholder is:");
    for(int i = 0;i<5;i++){
        printf("%d",holder[i]);
    }

    //a = sscanf(holder[1],"%d",a);
    printf("\na has become: %d",a);
    return NULL;
}



int main(){
    int year = 2011;
    int spring = 1;
    int gpa = 255;
    char * out = BeBinary(year,spring,gpa);
    printf("\nreceived value: \n");
    for(int i =0;i<14;i++){
        printf("%d",out[i]);
    }

    char * lol = BeNoNBinary(out);
    
    

    return 0;
}