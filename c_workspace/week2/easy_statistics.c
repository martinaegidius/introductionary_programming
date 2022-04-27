
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void analyzeCount(int * arr,int n,double avg){
    int countHi = 0;
    int countLo = 0;
    for(int i=0;i<n;i++){
        if(arr[i]<avg){
            countLo++;
        }
        else if(arr[i]>avg){
            countHi++;
        }       
    }
    printf("\nAbove average count: %d",countHi);
    printf("\nBelow average count: %d",countLo);
}


double getAvg(int * arr,int n){
    double seqsum = 0.0;
    for(int i=0;i<n;i++){
        seqsum += arr[i];
    }
    printf("Average value: %f",seqsum/n);
    return seqsum/n;
}


int main(){
    printf("How many ints?");
    int n;
    scanf("%d",&n);
    int * arr = malloc(n*sizeof(int));
    printf("please enter your number-string, %d vals: ",n);
    fflush(stdout);
    for(int i = 0;i<n;i++){
        scanf("%1d",&arr[i]);
    }
    printf("\nyou entered: ");
    for (int i=0;i<n;i++){
        printf("%d",arr[i]);
    }
    printf("\n");

    double avg = getAvg(arr,n);
    analyzeCount(arr,n,avg);
    return 0;

}