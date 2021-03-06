#include <stdlib.h>
#include <stdio.h>
#include "stack.h"
/*
Tilføj funktionerne newStack, pop, push, top og empty.

*/

stack_t * newStack(){
    stack_t * a = (stack_t *) malloc(1*sizeof(stack_t)); //memory allocate array of length = 1 int
    a->capacity = 1;
    a->array = (int *)malloc(1*sizeof(int)); 
    a->size = 0;
    return a;
}

int pop(stack_t * a){
    if(!a){
        return -1;
    }
    if(!(empty(a))){
        int out = a->array[a->size];
        a->array[a->size] = 0;
        a->size -= 1;
        return out;
    }
    else{
        return -1;
    }
    
}

void push(stack_t * a, int val){
    if(a!=NULL && a->size<a->capacity){//case: reallocate not necessary
        a->array[a->size+1] = val;
        a->size += 1;
        return;
    }
    else if(a==NULL){return;}
    a = (stack_t *) realloc(a,2*(a->capacity)); //reallocate with double capacity
    a->capacity *= 2; 
    if(a==NULL){ //if realloc fails
        printf("Error increasing memorysize of stack.");
        return;
    }
    a->array[a->size+1] = val;
    a->size += 1;
    return;  
}

int top(stack_t * a){
    if(a!=NULL &&!(empty(a))){
        return a->array[a->size];
    }
    else{
        return -1; //sentinel return value 
    }
}

int empty(stack_t * a){
    if(a!=NULL && a->size==0){ //if exists and empty
        return 1;
    }
    else if(a!=NULL){ //else false
        return 0;
    }
    return -1; //sentinel number for error
}

void printStackStatus(stack_t * myStack){
    printf("size: %d, capacity: %d, 0th item: %d\n",myStack->size,myStack->capacity,myStack->array[1]);
}

void printStack(stack_t * a){
    printf("Current stack status:\n");
    if(!(empty(a))){
        for(int i=a->size;i>0;i--){
            printf("%3d: %8d\n",a->size-i+1,a->array[i]);
        }
    }
    else{
        printf("Stack is empty.\n");
    }
}

int main() {
    return 0;
}

