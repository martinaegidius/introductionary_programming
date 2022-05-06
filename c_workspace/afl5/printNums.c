#include <stdio.h>

int main(){
    
    char buf[10];
    for(int i=0;i<=10000;i++){
        if(i<10){
            snprintf(buf,12,"s0000%d",i);
            printf("%s\n",buf);
        }
        else if(i>=10 && i<100){
            snprintf(buf,12,"s000%d",i);
            printf("%s\n",buf);
        }
        else if(i>=100 && i<1000){
            snprintf(buf,12,"s00%d",i);
            printf("%s\n",buf);
        }
        else if(i>=1000 && i<10000){
            snprintf(buf,12,"s0%d",i);
            printf("%s\n",buf);
        }
        else{
            snprintf(buf,12,"s%d",i);
            printf("%s\n",buf);
        }
        

    }

    return 0;

}