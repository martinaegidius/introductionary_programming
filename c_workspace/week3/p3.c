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
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main() {
char * s = calloc(1, sizeof (char));
int i, j;
for (i = 1; i <= 3; i++) {
for (j = 1; j <= i; j++) {
s = realloc(s, (strlen(s)+2) * sizeof (char));
int t;
for (t = strlen(s); t >= 0; t--) {
s[t+1] = s[t];
}
s[0] = j+'0';
}
}
printf("%s\n", s);
return 0;
}