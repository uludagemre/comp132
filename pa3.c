#include <stdio.h>
#include<stdlib.h> 
#include <stdbool.h>
#include <string.h>

struct Grade{
    char examName[20];
    int points;
};
struct Student{
    int id;
    char name[20];
    char surname[20];
    char letterGrade;
    struct Grade grades[5];
    int numberOfExamsGraded;
    struct Student *next;
};


//Prototypes
// void addStudentSorted(Student** headPtr, int id, char name[], char surname[]);
// Student* removeStudent(Student** headPtr, int id);
// void addGrade(Student* head, int id, char exam[], int takenPoint);
// void printCourseReportForAllStudents(Student* head);
// double calculateClassAvarageForOneExam (Student* head, char examName[]);
// bool isStudentInList(Student * head, int id);
// void calculateLetterGradesOfAllStudents (Student * head);

//Helper functions
// Student* findStudentById(Student* head, int id);
// bool isListEmpty(struct Student **headPtr);



bool isListEmpty(struct Student **headPtr){
    struct Student *current = *headPtr;
    if(current ->next -> id == 0) return true;
    else return false;
}
void addStudentSorted(struct Student **headPtr, int id, char name[], char surname[]){
    struct Student *currentIter = *headPtr;
    if(currentIter ->next ->id == 0){ //if the list is empty condition!
        struct Student *tail = currentIter -> next ;
        struct Student *nodeToPut = (struct Student*)malloc(sizeof(struct Student));
        currentIter -> next = nodeToPut;
        nodeToPut -> next = tail;
        nodeToPut ->id=id;
        strcpy(nodeToPut->name,name);
        strcpy(nodeToPut->surname,surname); 
    }
     else{ //if the list is not empty!
        struct Student *nodeToPut = (struct Student*)malloc(sizeof(struct Student));   
        while(id> currentIter->next->id && currentIter->next->next != NULL){ //in the first place currentIter was header student node
            currentIter = currentIter ->next;  //according to my code's logic currentIter never becomes tail node!
        }
        nodeToPut->id = id;
        strcpy(nodeToPut->name,name);
        strcpy(nodeToPut->surname,surname);
        nodeToPut->next=currentIter->next;
        currentIter->next =nodeToPut;
    }    
    
}
struct Student* removeStudent(struct Student **headPtr, int id){
    struct Student *currentIter = *headPtr;
    if(currentIter ->next ->id == 0){ //if the list is empty condition!
        return NULL;
    }
     else{ //if the list is not empty!
        while(id > currentIter->next->id && currentIter->next->next != NULL){ //in the first place currentIter was header student node
            currentIter = currentIter ->next;//according to my code's logic currentIter never becomes tail node!
            if(id == currentIter->next->id) {
                struct Student *previousNode = currentIter;
                struct Student *nodeToBeDeleted = currentIter->next;
                struct Student *nextNode = nodeToBeDeleted->next;
                previousNode->next=nextNode;
                return nodeToBeDeleted;
            }
        }
        return NULL;
    }    
    
}

struct Student* findStudentById(struct Student* head, int id){
    struct Student* currentIter = head;
    if(isListEmpty(&head)){ //if the list is empty condition!
        return NULL;
    }else{
        while(id > currentIter->next->id && currentIter->next->next != NULL){ //in the first place currentIter was header student node
            currentIter = currentIter ->next;//according to my code's logic currentIter never becomes tail node!
            if(id == currentIter->next->id) {
                return currentIter->next;
            }
        }
        return NULL;   
    }
 }


bool isStudentInList(struct Student * head, int id){
    struct Student* tempStudent = findStudentById(head,id);
    if (tempStudent == NULL) return false;
    else return true;
}

void printStudent(struct Student* student) {

       printf("%s %s\t id:%d\t", student->name, student->surname, student->id);
       printf("Graded exams: ");
       for (int i = 0; i <5; i++) {
            printf("%s :%d\t", student->grades[i].examName, student->grades[i].points);
        }
       printf("\nLetter : %c\n", student->letterGrade); }



int main(void){
    // initialize empty linkedlist
    struct Student* head = (struct Student*)malloc(sizeof(struct Student));
    struct Student* tail = (struct Student*)malloc(sizeof(struct Student));
    head->next=tail;
    // initialize empty linkedlist

    addStudentSorted(&head,50209,"emre","uludağ");     
    addStudentSorted(&head,53781,"aylin","akseki");
    addStudentSorted(&head,60350,"haşmettin","kıllibacak");     

    // removeStudent(&head,60350);
    struct Student* myStudent= findStudentById(head,60350);
    printStudent(myStudent);
    // if(myStudent ==NULL){
    //     printf("Cannot find the student with given id!\n");
    // }else{
    //     printf("This is student name: %s\n",myStudent->name);
    // }
    
    if(isListEmpty(&head)){
    printf("The list is empty\n");
    }else{
    printf("The list is not empty\n");
    }
   
    
    // int option;
    // printf("Option 1 – Enter 1 in order to add a new student then press Enter\n");
    // printf("Option 2 – Enter 2 in order to check if a student is in the course list\n"); struct LinkedList *next; struct LinkedList *next;
    // printf("Option 3 – Enter 3 in order to delete a student in the course then press Enter\n");
    // printf("Option 4 – Enter 4 in order to add or change the grade of the student then press Enter\n");
    // printf("Option 5 – Enter 5 in order to calculate the class average point then press Enter\n");
    // printf("Option 6 – Enter 6 in order to print the course report for one student then press Enter\n");
    // printf("Option 7 – Enter 7 in order to print the course report for all students then press Enter\n");
    // printf("Option 8 – Enter 8 in order to exit then press Enter\n");
    // printf("Choose one option: \n");
    // scanf("%d",&option);

return 0;
}




