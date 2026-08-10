#include <stdio.h>
#include <stdlib.h>
#define zv printf("\n")     //makro

//Typ listelement
struct le {
    int value;
    struct le *next;
};
typedef struct le listelement;

//Typ list
typedef listelement *list;

//Funktion zum einfügen von Elementen am Anfang
void insert(int v, list *l){
    listelement *new;                   //erstellt ein neues Listenelement
    new = malloc(sizeof(listelement));  //reserviert Speicher in der Grösse vom Typ listelement
    new->value = v;                     //übergibt den Wert für new
    new->next = *l;                     //Pointer von new zeigt auf head der Liste/
    *l = new;                           //new ist neuer head der Liste/Listenelement wird am Anfang der Liste eingefügt
                                        //und ist neues erstes Listenelement
}

//Funktion zur Ausgabe der Liste
void print_list(list l){
    if (l == NULL){                     //wenn das Listenelement NULL ist bzw. eine leere Liste ist 
        printf("leer");                 //gib "leer" aus
    } else{
        while(l != NULL){               //solange das Listenelement nicht NULL ist/geht durch ganze Liste
            printf("%d ", l->value);    //gib den Wert vom Listenelement aus
            l = l->next;                //gehe zum nächsten Listenelement
        }
    }
}

//Funktion zum löschen der gesamten Liste
void delete_all(list *l){
    list next;
    while (*l != NULL){     //solange der head nicht leer ist/die Liste nicht leer ist
        next = (*l)->next;  //next ist das Listenelement worauf der alte head zeigt
        free(*l);           //gib den Speicher frei bzw. löscht den aktuellen Listenelement/alten head
        *l = next;          //neuer head ist jetzt next
    }
}

//Funktion, die den Index von v ausgibt
int position_of(int v, list l){
    int index = 0;              //Laufvariable zum zählen der Position
    while (l != NULL){          //solange das Listen nicht NULL ist
        if (l->value == v){     //überprüfe ob der Wert des Listenelements mit v übereinstimmt
            return index;       //wenn ja, gib den Index des Listenelements zurück
        }
        index++;                //erhöhe den index
        l = l-> next;           //geh zum nächsten Listenelement
    }
    return -1;                  //gib -1 zurück bzw. v ist nicht in der Liste enthalten
}

//Funktion zum löschen des Listenelements an der Position pos
int delete_pos(list *l, int pos){
    if (pos < 0){           //überprüfe ob pos negativ ist
        return -1;
    }
    listelement *tmp = *l;  //kopiere den head auf tmp
    if (pos == 0){          //wenn das erste Listenelement gelöscht werden soll
        *l = tmp->next;     //ist der neue head das Listenelement worauf head zeigt
        free(tmp);          //gibt den Speicher frei bzw. löscht das Listenelement
        return 0;       
    }
    for (int i = 0; tmp != NULL && i < pos-1; i++){     //geht zum Listenelement das auf pos zeigt also pos-1
        tmp = tmp->next;
    }
    if(tmp == NULL || tmp->next == NULL){               //überprüft ob pos eine Position in der Liste ist
        return -1;
    }
    listelement *next = tmp->next->next;    //erstellt next mit den Werten vom Listenelement mit Index pos+1
    free(tmp->next);                        //löscht das Listenelement mit Index pos
    tmp->next = next;                       //Listenelement mit Index pos-1 zeigt auf Listenelement mit Index pos+1
    return 0;
}

//Funktion die alle gerade Zahlen filtert
list filter_even(list l){
    list secondlist = NULL;                         //erstellt eine zweite leere Liste
    listelement *new;                               //erstellt ein neues Listenelement
    while (l != NULL){                              //solange das Listenelement nicht NULL ist
        if (l->value%2 == 0){                       //überprüfe ob der Wert gerade ist
            new = malloc(sizeof(listelement));      //wenn ja, füge den Wert in die neue Liste ein
            new->value = l->value;                  //ähnlich wie bei insert()
            new->next = secondlist;
            secondlist = new;
        }
        l = l->next;                                //geh zum nächsten Listenelement
    }
    return secondlist;
}

int main(){
    
    listelement *new = NULL;    //leere Liste new
    
    //Werte werden in new eingefügt
    /*
    insert(45, &new);
    insert(15, &new);
    insert(5, &new);
    insert(-84, &new);
    insert(22, &new);
    insert(50, &new);
    insert(7, &new);
    insert(-17, &new);
    insert(0, &new);
    insert(5, &new);
    insert(69, &new);
    insert(1202, &new);
    */
    
    printf("Liste am Angang:\t"), print_list(new), zv;
    printf("Zahl hat den Index:\t%d",position_of(7, new)), zv;
    delete_pos(&new, 4);
    //delete_all(&new);
    printf("Neue gefilterte Liste:\t"), print_list(filter_even(new)), zv;
    printf("Liste am Ende:\t\t"), print_list(new), zv;

    return 0;
}