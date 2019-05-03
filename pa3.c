#include <stdio.h>
#include<stdlib.h> 
#include <stdbool.h>

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
typedef struct student Student;
typedef Student *StudentPtr;


//Prototypes
void addStudentSorted(Student** headPtr, int id, char name[], char surname[]);
Student* removeStudent(Student** headPtr, int id);
void addGrade(Student* head, int id, char exam[], int takenPoint);
void printCourseReportForAllStudents(Student* head);
double calculateClassAvarageForOneExam (Student* head, char examName[]);
bool isStudentInList(Student * head, int id);
void calculateLetterGradesOfAllStudents (Student * head);

//Helper functions
Student* findStudentById(Student* head, int id);
bool isListEmpty(Student **headPtr);

int main(void){
    struct Student* head = (struct Student*)malloc(sizeof(struct Student));
    struct Student* tail = (struct Student*)malloc(sizeof(struct Student));
    head ->next=tail;
    tail ->next=NULL;
    
    



    // initialize empty linkedlist
    
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


void addStudentSorted(Student** headPtr, int id, char name[], char surname[]){

}
Student *remove_node(Student **headPtr, int id) {
// To be filled in class
    Student *current = *headPtr;
    Student *prev = NULL;
    while(current != NULL ) {
        if (current -> id == id) {
            if (prev == NULL) { // special case, delete first node
                *headPtr = current->next;
                return *headPtr; 
            }
            prev->next = current->next;
            return current;
        }
        prev = current;
        current = current->next;
    }
    return NULL; // not found
}

bool isListEmpty(Student **headPtr){
     if (*headPtr == NULL) return true;
     else false;
}
// Student *create_student(int data) {
//     Student *St;
//     node = (Node *) malloc(sizeof(Node));
//     node->data = data;
//     node->next = NULL;
//     return node;
// }
