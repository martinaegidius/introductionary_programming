//in java it will write out 2+4-13/2 = small negative number:

//public class P1 {
//    public static void main(String[] args) {
//    System.out.println(2 + 2 * 2 - 13 / 2);
//    }
//}
//c implementation:

#include <stdio.h>

int main(){
    double val = 2+2*2-13/(float)2;
    printf("%f",val);
    return 0;
}