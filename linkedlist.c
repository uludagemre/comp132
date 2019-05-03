#include <stdio.h>
#include <stdlib.h>
#define SENTINEL -1

struct node {
    int data;
    struct node * next;
};

typedef struct node Node; // Node is a synonym for "struct node"
                           // for more readable code

// insert node after current
void insert_after(Node *current, Node *node) {
    node->next = current->next;
    current->next = node;
}

// assumes the list contains at least one element (that is head is not NULL)
void insert_last_version1(Node *head, Node *node) {
     Node *current = head;
     // NOTE: we know that head is not null, while loop will iterate at least ones
     //       we will write a more general method where head->next is NULL (empty list) later
     while (current->next != NULL) 
          current = current->next; // traverse the list until ptr->next is null

     // now we know that ptr shows the last node in the list, append node after ptr
     current->next = node;
     node->next = NULL;
}

// can insert into empty list
// if the list is empty, then head is NULL
// in that case, we need to change the value of head, (so we pass the address of head)

void insert_last_version2(Node **headPtr, Node *node) { // NOTE  

     // special case: empty list
     if (*headPtr == NULL) { //head is NULL
         *headPtr = node;
         node->next = NULL;
     }
     else {
         // the list is not empty, call insert_last_version1
         insert_last_version1(*headPtr, node);
     } 
}




int search(Node *head, int data) {
// To be filled in class
    Node *current = head;

    while(current != NULL) {
        if (current->data == data) return 1;
        current = current->next;
    }
    
    return 0;



}






// removes  the first node which has data = d
// returns the address of the deleted node, or null if not found
Node *remove_node(Node **headPtr, int d) {
// To be filled in class
 
    Node *current = *headPtr;
    Node *prev = NULL;

    while(current != NULL ) {
        if (current->data == d) {

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

// inserts data into the list in sorted order
void insert_sorted(Node **headPtr, int data) {
// To be filled in class
     printf("exersize - complete insert_sorted");
}

void print_list(Node * head) {
    Node * current = head;
    printf("List [");
    while (current != NULL) {
        printf("%3d", current->data);
        current = current->next;
    }
    printf("  ]\n");
}


Node *create_node(int data) {
    Node *node;
    node = (Node *) malloc(sizeof(Node));
    node->data = data;
    node->next = NULL;
    return node;
}



int main() {
    printf("\nLinked List Manual Construction\n\n");
    // Manual creation of a list with two elements
    Node *node1, *node2;

    node1 = (Node *) malloc(sizeof(Node));
    node1->data = 1;

    node2 = (Node *) malloc(sizeof(Node));
    node2->data = 2;

    node1->next = node2;
    node2->next = NULL; // important - marks the end of list

    print_list(node1);

    // check search
    printf("Search test %d \n", search(node1, 5));


    printf("\ntry insert_last_version1\n\n");
    // experimenting with insert_last_version1


    Node *head, *tmpNode;       

    head = node1;

    tmpNode = (Node *) malloc(sizeof(Node)); 
    tmpNode->data = 3;

    insert_last_version1(head,tmpNode);  // we can call version1, the lsit is not empty;
    print_list(head);


    printf("\ntry insert_last_version2\n\n");
    // We start  with an empty list;
    Node *myList1;  // this points to the first node of list1

    printf("myList1 is initially %p\n",myList1);

    tmpNode = create_node(10);
    insert_last_version2(&myList1,tmpNode);
    printf("myList1 after insert %p\n",myList1);
    print_list(myList1);


    tmpNode = create_node(5);
    insert_last_version2(&myList1,tmpNode);
    printf("myList1 after insert %p\n",myList1);
    print_list(myList1);
   

    tmpNode = create_node(20);
    insert_last_version2(&myList1,tmpNode);
    printf("myList1 after insert %p\n",myList1);
    print_list(myList1);

    printf("Test remove_node \n");

    printf("remove 2 from myList1\n");
    Node *deleted = remove_node(&myList1,2);
    print_list(myList1);

    printf("remove 5 from myList1\n");
    deleted = remove_node(&myList1,5);
    print_list(myList1);

    printf("remove 10 from myList1\n");
    deleted = remove_node(&myList1,10);
    print_list(myList1);

    printf("Test insert_sorted\n");
    printf("insert_sorted  30 into myList1\n");
    insert_sorted(&myList1,30);
    print_list(myList1);
    printf("insert_sorted  2 into myList1\n");
    insert_sorted(&myList1,2);
    print_list(myList1);


    // Creation of a list using insert methods
    printf("\nLinked List -  grow the list with user data until SENTINEL value entered\n");

    printf("Exercise - complete the code");
     //int number;
     //printf("Enter data:");
     //scanf("%d",&number);
     //while (number != SENTINEL) {
         // create a node to be inserted in to the list
     //}
    

    printf("\n");

}