#include <stdio.h>

void(test(int dummy));

int main(){
    test(2);
    return 0;

}

void test(int dummy){
    if(dummy == 1){
        printf("One %d\n",dummy);
    }
    else{
        printf("Two %d\n",dummy);
    }

}