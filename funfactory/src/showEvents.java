import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


//Klasse showEvents: Notwendig für die Darstellung, das Suchen und Sortieren von Events
public class showEvents {

	//Aufnahme des Pfades mit der Textdatei Veranstaltungen.txt, in dem die Veranstaltungen gespeichert werden
    static File eventFile = new File("Server/Veranstaltungen/Veranstaltungs.txt");

    //Methode zum Testen der getEventID und Eingabe über den Scanner (wird für zukünftige Veränderungen und Testzwecke verwendet und bleibt deswegen im Code)
    public static void selectEvent(){
    	
    	//Scanner liest Namen des Events über das Terminal ein und gibt die EventID über das Terminal zurücK
        Scanner scanner = new Scanner(System.in);
        String eventSelected = scanner.nextLine();
        System.out.println(Event.getEventID(eventSelected));
    }

    /**
     *
     * @param events
     * @return
     */
    //Methode zur Darstellung der Events in einem String-Array. Übergabe der ArrayList events mit allen verfügbaren Events.
    public static ArrayList<String> VisualizeEvents(ArrayList<String> events){
    	
    	//Initialisierung des String Arrays visEvents
    	ArrayList<String> visEvents = new ArrayList<String>();
    	
    	//Iterieren der Liste events und Name, Künstler und Lokation in einen String zusammenfassen und visEvents hinzufügen
        for (int i = 0; i<events.size(); i++){
            visEvents.add(Event.getName(Integer.parseInt(events.get(i))) + " von " +Event.getArtist(Integer.parseInt(events.get(i)))
                    + " in " + Event.getLocation(Integer.parseInt(events.get(i))));
        }
        
        //Rückgabe der String ArrayList visEvents
		return visEvents;
    }

    /**
     *
     * @return
     */
    //Methode, die Veranstaltungen.txt ausliest und in die EventsIDs in die ArrayList<String> events einfügt
    public static ArrayList<String> GetAllEvents(){
        try {
        	String[] split;
        	
        	//Erstellung eines BufferedReader, damit Textdatei eingelesen werden kann
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            
            //Zeile in einen neuen String einlesen
            String event = reader.readLine();
            
            //splitten des Strings mit ";" (als Trennungszeichen definiert), falls nicht leer
            //Anlegen des neuen Arrays und hinzufügen des 8. Splits (EventID)
            if(event != null){
            split = event.split(";");
            }
            ArrayList<String> events = new ArrayList<String>();
            while(event!=null){
                split = event.split(";");
                events.add(split[8]);
                event = reader.readLine();
            }
            
            //Schließen des readers
            reader.close();
            return events;
            
            //Fehlerbehandlung, falls in try durch das Auslesen der Textdatei ein Fehler entsteht
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param aspect
     * @param search
     * @return
     */
    //Methode, die eine geordnete ArrayList zurück gibt, welche nach aspect und search bestimmte Eigenschaften vorweist und für die Veranstaltungssuche bei Kunden verwendet wird
    public static ArrayList<String> searchEvents(String aspect, String search){
        try {
        	
        	//Erstellen eines BufferedReaders, der Veranstaltungen.txt einliest. String wird erneut mit ";" gesplittet
        	//Definition einer neuen ArrayList<String>, welche die gesuchten Events aufnimmt
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            String[] split = event.split(";");
            ArrayList<String> events = new ArrayList<String>();
            
            //aspect beschreibt im der Kundenview die ComboBox, mit der ausgesucht werden kann, nach welchem Aspekt das gesucht werden soll (in Kombination mit der Eingabe aus dem Textfeld)
            //Fallunterscheidung der 4 Möglichkeiten in der Combobox(Name, Kuenstler, Genre, Location
            //der jeweilige split wird nach dem Stichtwort search untersucht und bei einer Übereinstimmung wird die EventID in die ArrayList event übergeben
            
            if (aspect.equals("Name")){
                while(event!=null){
                    split = event.split(";");
                    if (split[0].contains(search)){
                        events.add(split[8]);
                    }
                    event = reader.readLine();
                }
            }
            else if (aspect.equals("Kuenstler")){
                while(event!=null){
                    split = event.split(";");
                    if (split[10].contains(search)){
                        events.add(split[8]);
                    }
                    event = reader.readLine();
                }
            }
            else if (aspect.equals("Genre")){
                while(event!=null){
                    split = event.split(";");
                    if (split[9].contains(search)){
                        events.add(split[8]);
                    }
                    event = reader.readLine();
                }
            }
            else if (aspect.equals("Location")){
                while(event!=null){
                    split = event.split(";");
                    if (split[6].equals(search)){
                        events.add(split[8]);
                    }
                    event = reader.readLine();
                }
            } else{
                while(event!=null){
                    events.add(split[8]);
                    event = reader.readLine();
                }
            }
            reader.close();
            return events;
            
          //Fehlerbehandlung, falls in try durch das Auslesen der Textdatei ein Fehler entsteht
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     *
     * @param sortBy
     * @param wayToSort
     * @param events
     * @return
     */
    //Methode, mit der Events nach sortBy und wayToSort aktualisiert in einer ArrayList ausgegeben werden
    public static ArrayList<String> sortEvents(String sortBy, String wayToSort, ArrayList<String> events){
    	
    	//sortBy ist bei der Kundensicht in Veranstaltungen eine Combobox und enthält die Möglichkeiten Alphabet oder Datum
    	//wayToSort wird ebenfalls bei den Veranstaltungen durch eine ComboBox mit den Werten aufsteigend und absteigend definiert und in die Methode weitergegeben
    	
    	//Sortierung der ArrayList events auf Basis der angegebenen sortBy und wayToSort mit Collections.sort. Danach Aktualisierung der events
        if (sortBy.equals("Alphabet")){
            ArrayList<String> eventNames = new ArrayList<String>();
            for (int i = 0; i<events.size(); i++){
            	//Hinzufügen der Event Namen in eine neue ArrayList eventNames
                eventNames.add(Event.getName(Integer.parseInt(events.get(i))) + ";"+ events.get(i));
            }
            if (wayToSort.equals("aufsteigend")){
            	
            	//Sortierung der Event Namen
                Collections.sort(eventNames);
                String line;
                for (int i = 0; i<eventNames.size(); i++){
                    line = eventNames.get(i);
                    String[] split = line.split(";");
                    
                    //Setzen der jeweiligen ersten Splits(events.get(i)) in Events auf die neuen Indices
                    events.set(i,split[1]);
                }
                //return der ArrayList events
                return events;
            }
            
            //Parallel zu aufsteigend mit Collections.reverseOrder() (damit absteigend)
            if (wayToSort.equals("absteigend")){
                Collections.sort(eventNames, Collections.reverseOrder());
                String line;
                for (int i = 0; i<eventNames.size(); i++){
                    line = eventNames.get(i);
                    String[] split = line.split(";");
                    events.set(i,split[1]);
                }
                return events;
            }else{
                return events;
            }
        }
        
        //Parallel zu Name
        if (sortBy.equals("Datum")){
            if (wayToSort.equals("aufsteigend")){
                ArrayList<Integer> eventDates = new ArrayList<Integer>();
                ArrayList<String> eventDatesID = new ArrayList<String>();
                String date;
                for (int i = 0; i<events.size(); i++){
                    date = Event.getYear(Integer.parseInt(events.get(i))) + ""+ Event.getMonth(Integer.parseInt(events.get(i)))+""+Event.getDay(Integer.parseInt(events.get(i)));
                    eventDates.add(Integer.valueOf(date));
                    eventDatesID.add(Integer.valueOf(date)+";"+events.get(i));
                }
                Collections.sort(eventDates);
                String line;
                for (int i = 0; i<eventDatesID.size(); i++){
                    line = eventDatesID.get(i);
                    String[] split = line.split(";");
                    for (int x = 0; x<eventDates.size(); x++){
                        if (split[0].equals(eventDates.get(x).toString())){
                            events.set(x, split[1]);
                        }
                    }
                }
                return events;
            }
            else{ //entspricht den Werten sortBy="Datum" und wayToSort="absteigend"
                ArrayList<Integer> eventDates = new ArrayList<Integer>();
                ArrayList<String> eventDatesID = new ArrayList<String>();
                String date;
                for (int i = 0; i<events.size(); i++){
                    date = Event.getYear(Integer.parseInt(events.get(i))) + ""+ Event.getMonth(Integer.parseInt(events.get(i)))+""+Event.getDay(Integer.parseInt(events.get(i)));
                    eventDates.add(Integer.valueOf(date));
                    eventDatesID.add(Integer.valueOf(date)+";"+events.get(i));
                }
                Collections.sort(eventDates, Collections.reverseOrder());
                String line;
                for (int i = 0; i<eventDatesID.size(); i++){
                    line = eventDatesID.get(i);
                    String[] split = line.split(";");
                    for (int x = 0; x<eventDates.size(); x++){
                        if (split[0].equals(eventDates.get(x).toString())){
                            events.set(x, split[1]);
                        }
                    }
                }
                return events;
            }

        }
        return events;
    }
}
