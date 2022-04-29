/*  the following program in java will print j+jj+jjj = jjjjjj
public class P2 {
    public static void main(String[] args) {
        String s = "";
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= i; j++) {
                s = j + s;
            }
        }
    System.out.println(s);
    }
}

c-implementation: */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(){
    char * s = calloc(1,sizeof (char));
    for(int i=1;i<=3;i++){
        for(int k=1;k<=i;k++){
            s = realloc(s, (strlen(s)+2) * sizeof (char)); //+2 for adding terminator and new letter
            for (int t=strlen(s); t>=0; t--){
                s[t+1] = s[t]; //push existing j's one idx downstream
            }
            s[0] = k+'0'; //fill in new j
        }
    }

    printf("\n%s",s);
    return 0;
}