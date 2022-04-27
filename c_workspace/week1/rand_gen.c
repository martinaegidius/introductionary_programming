#include <stdlib.h>
#include <stdio.h>
#include <time.h>

int main(){
    srand((unsigned int)time((time_t *)NULL));
    printf("How many random numbers [0,%d]?\n",RAND_MAX);
    fflush(stdout);
    int inputInt;
    scanf("%d",&inputInt);
    int vals[inputInt],i;
    for(i=0;i<inputInt;i++){
        vals[i] = rand();
        printf("%d %d\n",i,vals[i]);
    }
    return 0;
}