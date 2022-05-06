#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int convertYear(int a){
    a = a-2009;
    int seqsum = 0;
    int i = 4;
    int bin = 0;
    while(a){
        bin = a % 2;
        a = a/2;
        seqsum += bin*pow(2,i);
        printf("%d",bin);
        i--;
    }
    printf("\nyear seqsum becomes %d",seqsum);
    return seqsum;
}

int convertSemester(int a){
    int seqsum = 0;
    seqsum += a*pow(2,5);
    printf("\nsemester seqsum becomes %d\n",seqsum);
    return seqsum;
}

int convertGrade(int a){
    int seqsum = 0;
    int i = 14;
    int bin = 0;
    while(a){
        bin = a % 2;
        a = a/2;
        seqsum += bin*pow(2,i);
        printf("%d",bin);
        i--;
    }
    printf("\nGrade seqsum becomes %d\n",seqsum);
    return seqsum;
    
}

int main(){
    int year = 2035;
    int season = 0;
    int out1 = convertYear(year);
    int out2 = convertSemester(season);
    int gpa = 240;
    int out3 = convertGrade(gpa);

    int databaseVal = out1+out2+out3;
    printf("\nend database val: %d",databaseVal);
    return 0;
}