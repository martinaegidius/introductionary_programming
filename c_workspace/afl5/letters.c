#include <stdio.h>
#include <string.h>

int main(int argc, char * argv[]){
    if(argc<2){
        printf("Error: Must start program with a string input! \n");
        return 1;
    }
    int count = 0;
    for(int i=1;i<argc;i++){
        count+=strlen(argv[i]);
    }
    printf("%d\n",count);
    return 0;
}
