// cudb.c

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NAME_SIZE 5

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


int BecomeBinary(int year, int spring, int gpa){
    year -= 2009;
    printf("Binary data becomes\nYear: %d\nSeason: %d\nGPA: %d",year,(spring<<5),(gpa<<6));
    return year + (spring<<5) + (gpa<<6); //kan forstås som zero-padding
}

int BinaryToData(int bin, int * year, int * spring, int * gpa){
    int start_year_c = 2009;
    int gpa_c = 0;
    int spring_c = 0;
    for(int i=0;i<=4;i++){
        start_year_c += bin & (1<<i); 
    } 

    spring_c = (bin & (1<<5))>>5;

    for(int i=6;i<=13;i++){
        gpa_c += ((bin & (1<<i))>>6);
    }

    *year = start_year_c;
    *spring = spring_c;
    *gpa = gpa_c;
    
    return 0;
}


void addNewStudent(db_t * db){
    //db->array[db->size].name = 'john';
    //int * arr;
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
    int binaryData = BecomeBinary(year,spring,gpa);
    db->array[db->size].data = binaryData;

    //scanf("%d",&db->array[db->size].data);
    db->size++;
}

void printStudent(db_t * db,int idx){
    printf("\nName is: %s",db->array[idx].name);

    int year = 0;
    int spring = 0;
    int gpa = 0;
    int status = BinaryToData(db->array[idx].data,&year,&spring,&gpa);
    printf("\nBinary data is %d",db->array[idx].data);
    printf("\nYear is: %d",year);
    printf("\nSemester is: %d",spring);
    printf("\nGPA is %d",gpa);
}

void listAllStudents(db_t * db){
    if(db->size==0){
        printf("No students in database.");
    }
    else{
        for(int i=0;i<db->size;i++){
        printStudent(db,i);
        }
    }
}

int main() {
  int action;
  action = -1;
  db_t * db = initDB();
  puts("Welcome to CUDB - The C University Data Base");

  //fflush();
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
      
  }
  return 0;

/*

Tilf�j funktioner og anden kode efter behov.
Strukturen student_t m� dog ikke �ndres.

*/

  return 0;
}
