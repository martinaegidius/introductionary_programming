#include <stdio.h>

int main(){
    char v = 'A';
    if(!(1>0)){
        v = 'B';
    }
    else if(1 && 0){
        v = 'C';
    }
    else if(1||0){
        v = 'D';
    }
    else{
        v = 'E';
    }

    printf("%c",v);
    return 0;
}