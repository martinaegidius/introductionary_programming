/*  same program as earlier, but now simply adds 
public class P3 {
    public static void main(String[] args) {
        String s = "";
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= i; j++) {
                s += j;
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
            s[strlen(s)+1] = '\0';
            s[strlen(s)] = k+'0';
        }
    }
    printf("\n%s",s);
    return 0;
}