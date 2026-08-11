import java.util.*;
public class Ring<T>{
    
    //Datenelemente
    le<T> end;              //Element am "Ende" des Rings, dass auf dem aktuellen Element immer zeigt
    le<T> aktuell;          //aktuelles Element
    int cap;                //Kapazitaet des Rings
    private int size;       //akutelle Anzahl der Elemente des Rings
    
    
    //Konstruktor
    public Ring(int cap){
        if(cap <= 0){           //faengt Fehler ab
        throw new IllegalArgumentException("Kapazitaet des Rings muss groesser als 0 sein.");
        }
        this.cap = cap;         //setzt Kapazitaet des Rings
        this.size = 0;          //setzt Anzahl der Elemente 0
        }
        
        
    //Methode: gibt akutelle Anzahl der Elemente aus
    public int size(){
        return size;    //gibt aktuelle Anzahl der Elemente aus
    }
        
    //Methode: gibt Kapazitaet des Rings aus
    public int capacity(){
        return cap;     //gibt Kapaziaet des Rings aus
    }
                
                
    //Methode: fuegt neues Element in den Ring
    public void add(T t){
        if(size == cap){ //Wenn der Ring voll ist, gib Fehler aus
            throw new IllegalArgumentException("Kapazitaet des Rings ist voll.");
        }
        le<T> newE = new le<T>(t);                  //erzeugt neues Element "newE"
        if(size == 0){                              //wenn der Ring leer ist...
            end = aktuell = newE;                   //setze end und aktuell gleich newE
            end.next = end.prev = aktuell;          //next(Links) und prev(Rechts) Zeiger von end zeigen auf aktuell
            aktuell.next = aktuell.prev = end;      //next und prev Zeiger von aktuell zeigen auf end => Ring
        } else{
            newE.next = aktuell.next;               //next Zeiger von newE zeigt auf next Zeiger von aktuell
            newE.prev = aktuell;                    //prev Zeiger von newE zeigt auf aktuell
            aktuell.next.prev = newE;               //der prev Zeiger vom linken Element von aktuell zeigt auf newE
            aktuell.next = newE;                    //next Zeiger von aktuell zeigt auf newE
        }
        this.size += 1;                             //Anzahl der aktuellen Elemente wird um 1 erhoeht
    }
            
    //Methode: ueberprueft ob der Ring leer ist
    public boolean isEmpty(){
        return (size == 0);             //ueberprueft ob der Ring leer ist
    }
    
    //Methode: gibt aktuelles Wert zurueck
    public T getAktuell(){
            return aktuell.getValue();
            }
            
            
    //Methode: verschiebt das aktuelle Element einmal nach links
    public void back(){
        if(isEmpty()){          //wenn der Ring leer ist, gib Fehler aus
            throw new NoSuchElementException("Liste ist Leer. Aktuelles Element kann nicht verschoben werden.");
        }
        aktuell = aktuell.next; //verschiebt aktuell
        end = end.next;         //und end einmal nach links
    }
    
    //Methode: zum loeschen und neu setzen des aktuell
    public T remove(){
        T r = aktuell.getValue();       //merken des Werts des alten aktuell
        if(isEmpty()){                  //wenn der Ring leer ist, Fehler ausgeben
            throw new NoSuchElementException("Ring ist leer. Keine Element zum loeschen vorhanden");
        }
        int i = 1;
        while(i < size){                //durchlaeuft den Ring bis aktuell an Position von end ist
            aktuell = aktuell.next;
            i++;
        }
        aktuell.next = aktuell.next.next;       //loescht das alte aktuell
        this.size -= 1;                 //verringert size um 1
        return r;               //gibt den alten Wert von aktuell aus
    }
        
    //Methode: ersetzt den Wert von aktuell und setzt Position von aktuell neu
    public void set(T t){
        if(isEmpty()){  //wenn der Ring leer ist, gib Fehler aus
            throw new NoSuchElementException("Ring ist leer. Kein Element vorhanden zum ersetzen.");
        }
        le<T> newE = new le<T>(t);          //erzeugt neues Element
        aktuell = aktuell.prev;             //setzt aktuell gleich auf das rechte Element, also end
        end = end.prev;                     //und end auch auf das rechte Element 
        newE.next = aktuell.next.next;      //newR zeigt auf den alten aktuell.next
        aktuell.next.next.prev = newE;      //und das rechte Element vom alten aktuell.next ist das neue Element
        aktuell.next = newE;                //linkes Element vom aktuelles Element ist das neue Element 
        newE.prev = aktuell;                //rechtes Element von newE ist das aktuelle Element
    }
         
    //Methode: Ausgabe des Rings
    public String toString(){
        String S = "{ ";                        //erstelle Stringe S
        le<T> tmp = aktuell;                    //Laufelement ist aktuell
        if(size == 0){                          //wenn leere Ring...
            return "Liste ist leer.";
        }
        int i = 1;
        while(i < size){                                        //geht durch den Ring
            S += String.valueOf(tmp.getValue()) + " => ";   //wandert generischen Typ in String um und fuegt ihn zu S hinzu
            tmp = tmp.prev;                                 //gehe nach rechts
            i++;    
        }            
        S += String.valueOf(tmp.getValue());                    //fuegt das letzte Element hinzu damit nicht am Ende " => " ist    
        return S + " }";                                        //gib S zurueck 
    }            
        
    public static void main(String[] args){ 
        
    //erster Teilring:                
        //Ring<String> R1 = new Ring(-5);   
        Ring<String> R1 = new Ring(5);                                                
        R1.add("eins");                                                               
        R1.add("zwei");                                                               
        R1.add("drei");                                                               
        R1.add("vier");                                                               
        //R1.add("fuenf");                                                            
        //R1.add("zu viel");
        
    //zweiter Teilring:                                                           
        Ring<String> R2 = new Ring(5);                                                
        R2.add("sechs");                                                              
        R2.add("sieben");                                                             
        R2.add("acht");                                                               
        R2.add("neun");                                                               
        R2.add("zehn");
        
    //dritter Teilring:                                                           
        Ring<String> R3 = new Ring(5);                                                
        R3.add("aa");                                                                 
        R3.add("bb");                                                                 
        R3.add("cc");                                                                 
        R3.add("dd");                                                                 
        R3.add("ee");                                                                 
        
    //vierter Teilring: 
        Ring<String> R4 = new Ring(5);        
        R4.add("1");                          
        R4.add("2");                          
        R4.add("3");                          
        R4.add("4");                          
        R4.add("5");   
        
    //fuenfter Teilring:                  
        Ring<String> R5 = new Ring(5);        
        R5.add("a");                          
        R5.add("b");                          
        R5.add("c");                          
        R5.add("d");                          
        R5.add("e");   
        
    //Aeusserer Ring:                     
        Ring<Ring> outR = new Ring(5);        
        outR.add(R1);                         
        outR.add(R2);                         
        outR.add(R3);                            
        outR.add(R4);                          
        outR.add(R5);                          
    
    //Ausgaben:
        System.out.println("\n");
        System.out.println("erster innere Ring am Anfang:");
        System.out.printf("Aktuelle Anzahl der Elemnete von R1: ");
        System.out.print(R1.size() + "\n");
        System.out.print(R1.toString() + "\n");
        System.out.print("Kapazitaet von R1: " + R1.capacity() + "\n");
        System.out.print("R1 nach dem verschieben: ");
        R1.back();
        System.out.print(R1.toString() + "\n");
        System.out.print("Entferntes Element: " + R1.remove() + "\n");
        System.out.print("R1 nach dem Loeschen: ");
        System.out.print(R1.toString() + "\n");
        R1.set("ERSETZT");
        System.out.print("R1 nach set:");
        System.out.print(R1.toString() + "\n");
        System.out.println("\n");
    
    
        System.out.println("zweite innere Ring am Anfang:");
        System.out.print(R2.toString() + "\n\n");
    
        System.out.println("dritte innere Ring am Anfang:");
        System.out.print(R3.toString() + "\n\n");
    
        System.out.println("vierte innere Ring am Anfang:");
        System.out.print(R4.toString() + "\n\n");
    
        System.out.println("fuenfte innere Ring am Anfang:");
        System.out.print(R5.toString() + "\n\n");
    
        System.out.println("aeussere Ring am Anfang:");
        System.out.print(outR.toString() + "\n\n");
    
    //Integer Ring
        Ring<Integer> num = new Ring(3);
        num.add(65);
        num.add(-5);
        num.add(0);
        System.out.println("Integer Ring am Anfang:");
        System.out.print(num.toString() + "\n\n");
    
    //Boolean Ring
        Ring<Boolean> bool = new Ring(3);
        bool.add(true);
        bool.add(true);
        bool.add(false);
        System.out.println("Boolean Ring am Anfang:");
        System.out.print(bool.toString() + "\n\n");
    
    }
}
    
                
