// cudb.c

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define NAME_SIZE 5
#define DEBUG 0

typedef struct {
  char name[NAME_SIZE];
  int data;
} student_t;

typedef struct {
    student_t * array;
    int size;
} db_t;

db_t * initDB(){
    student_t (*entries) = (student_t *) malloc(10000*sizeof(student_t));
    db_t * db = (db_t *) malloc(1*sizeof(db_t));
    db->array = entries;
    db->size = 0;
    return db;
}


int convertToBinary(int year, int season, int integer){
    //convert year to binary sum 
    int seqsum = 0;
    year -= 2009;
    seqsum += year;

    //convert spring/fall to binary
    seqsum += season*pow(2,5);

    //convert gpa to binary sum 
    long int binary = 0;
    int i = 6;
    while (integer != 0)
    {
        binary = (integer % 2);  // 1 or 0
        seqsum += binary*pow(2,i);
        integer /= 2;
        i++;
    }
    if(DEBUG){
        printf("Seqsum is %d\n",seqsum);
    }
    return seqsum;

}


int decryptSum(int dbsum, int * year, int * spring, int * gpa){
    int year_c = 2009;
    int season = 0;
    int gpa_c = 0;
    
    for(int i = 0;i<=4;i++){
        year_c += dbsum & (1<<i);
    }
    *year = year_c;
    
    season = (dbsum & (1<<5))>>5;
    *spring = season;
    
    for(int i=6;i<=14;i++){
        gpa_c += ((dbsum & (1<<i))>>6);
    }

    *gpa = gpa_c;
    return 0;
}

void addNewStudent(db_t * db){
    printf("Enter name (4 characters only):\n");
    scanf("%s",db->array[db->size].name);
    printf("\nEnter start year (2009-2040):\n");
    int year;
    int spring;
    int gpa;
    scanf("%d",&year);
    printf("\nEnter spring or fall: \n");
    scanf("%d",&spring);
    printf("\nEnter GPA: \n");
    scanf("%d",&gpa);
    int binaryData = convertToBinary(year,spring,gpa);
    db->array[db->size].data = binaryData;
    db->size++;
}

int printStudent(db_t * db,int idx){
    if(DEBUG){
        printf("\nName is: %s",db->array[idx].name);
    }
    char buf[10];
    char sbuf[12];
    int year = 0;
    int spring = 0;
    int gpa = 0;
    int status = decryptSum(db->array[idx].data,&year,&spring,&gpa);   
    
    if(idx<10){
        snprintf(sbuf,12,"s0000%d",idx);
        printf("\n%s",sbuf);
    }
    else if(idx>=10 && idx<100){
        snprintf(sbuf,12,"s000%d",idx);
        printf("\n%s",sbuf);
    }
    else if(idx>=100 && idx<1000){
        snprintf(sbuf,12,"s00%d",idx);
        printf("\n%s",sbuf);
    }
    else if(idx>=1000 && idx<10000){
        snprintf(sbuf,12,"s0%d",idx);
        printf("\n%s",sbuf);
    }
    else{
        snprintf(sbuf,12,"s%d",idx);
        printf("\n%s",sbuf);
    }
    printf("%*c",5,' ');
    printf("%s",db->array[idx].name);
    printf("%*c",5,' ');
    printf("%d",year);
    printf("%*c",5,' ');
    if(spring==0){
        printf("Spring");
    }
    else{
        printf("Autumn");
    }
    printf("%*c",5,' ');
    printf("%d",gpa);
    return gpa;
}

void listAllStudents(db_t * db){
    int gpa = 0;
    if(db->size==0){
        printf("No students in database.");
        return;
    
    }
    else{
        for(int i=0;i<db->size;i++){
            gpa += printStudent(db,i);
        }
    }
    printf("\n\nAverage GPA of all students: %f",gpa/(double)db->size);
}

int main() {
  int action;
  action = -1;
  db_t * db = initDB();
  puts("Welcome to CUDB - The C University Data Base");
  while(action!=0){
      printf("\n0: Halt\n1: List all students\n2: Add a new student\n");
      scanf("%d",&action);
      if(action==2){
          addNewStudent(db); 
      }
      else if(action==1){
          listAllStudents(db);
      }

      else if(action==0){
          printf("\nBye");
      }
      else{
          printf("Only integers allowed. Sadly you broke the database, dont tell your boss! Try again with only integer actions next time :-)");
          return 1;
      }
      
    }
      
  return 0;
  }

