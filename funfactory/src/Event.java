import java.io.*;
import java.util.Scanner;

/* Die Klasse implementiert alle Inhalte, sich auf Events beziehen. Dazu gehören das erstellen von Events, das speichern in einer Text-Datei,
        das überarbeiten und Löschen von bestehenden Events. Die Textdatei "Veranstaltungen" fungiert dabei als Datenbank, damit auch nach Beendigung
        des Programms die Daten gespeichert bleiben. Als Primary Key, über den nahezu alle Methoden funktionieren und Events eindeutig
        identifzierbar sind, wird die EventID genutzt.
        */

public class Event {
    String name; //Name der Veranstaltung
    int day,month,year ; // Tag, Monat, Jahr, wann das Event stattfindet
    String eventText; //Eventbeschreibung
    String location; // Lage der Veranstaltung
    String venueName; //Name des Veranstaltungsortes
    int numberOfTickets; //Anzahl der Tickets
    static int eventID;
    String genre;
    String artist;
    static int numberOfCategories; //Anzahl der Kategorien
    String categorieManagement; //String mit allen Kategorien

    static File eventFile = new File("Server/Veranstaltungen/Veranstaltungs.txt");

    // Konstruktor, der das erstellen eines Events ermöglicht. Manche Daten eines Events werden durch den Aufruf weiterer Methoden
    // generiert, weshalb nicht alle relevanten Informationen an den Konstruktor übergeben werden.

    /**
     *
     * @param name
     * @param day
     * @param month
     * @param year
     * @param eventText
     * @param location
     * @param venueName
     * @param genre
     * @param artist
     * @param numberOfCategories
     * @param categorieview
     */

    public Event(String name, int day, int month, int year, String eventText, String location, String venueName, String genre, String artist, int numberOfCategories,String categorieview){
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.eventText = eventText;
        this.location = location;
        this.venueName = venueName;
        this.eventID = Integer.parseInt(generateEventID());
        this.genre = genre;
        this.artist = artist;
        this.numberOfCategories = numberOfCategories;
        this.categorieManagement = categorieview;
        this.numberOfTickets = generateNumberOfTickets(categorieManagement);
    }

    // Die Methode speichert das Event in der Textdatei, wodurch das Event später bearbeitbar, löschbar und für Tickets aufrufbar, auch nach Programmbeendigung, ist.
    // Dafür bekommt es als Parameter ein Event übergeben. Die einzelnen Elemente werden durch ein Semikolon getrennt, damit mittels der .split(";") Methode der String
    // später eingelesen und aufgetrennt werden kann.

    /**
     *
     * @param event
     */

    public static void insertEventIntoList(Event event){
        try {
            FileWriter writer = new FileWriter(eventFile, true);
            writer.write(event.name + ";" + event.day + ";" + event.month+ ";" + event.year + ";" + event.eventText+ ";"  +event.location+ ";"  +event.venueName + ";" + event.numberOfTickets
                    + ";" + event.eventID + ";" + event.genre + ";" + event.artist + ";" + event.numberOfCategories + ";"+ event.categorieManagement +";"+ "\n");
            writer.flush();
            writer.close(); 
        } catch (IOException e) {
            System.out.println("Datei existiert nicht");
        }
    }

    // Die Methode wird aufgerufen, um ein Event zu erstellen. Dafür wird zuerst der Konstruktor aufgerufen, weshalb die Methode die gleichen Parameter wie ein Event braucht, und ruft
    // dann die Methode auf, durch welche das Event in die Textdatei eingefügt wird.

    /**
     *
     * @param name
     * @param day
     * @param month
     * @param year
     * @param eventText
     * @param location
     * @param venueName
     * @param genre
     * @param artist
     * @param numberOfCategories
     * @param categorieView
     */
    public static void createEvent(String name, int day, int month, int year, String eventText, String location, String venueName, String genre, String artist, int numberOfCategories,String categorieView){
        Event event = new Event(name, day, month, year, eventText, location, venueName, genre, artist,numberOfCategories,categorieView);
        insertEventIntoList(event);
    }

    // Die Methode erhält als Eingabe eine eventID, durchsucht die Textdatei bis das Event mit der entsprechenden eventID gefunden wurde
    // und gibt diese dann aus.

    /**
     *
     * @param eventID
     */
    public static void showEvent(int eventID){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            String[] split = event.split(";");
            while(reader.readLine()!=null){
                if (split[8].equals(Integer.toString(eventID))){
                    System.out.println(event);
                    reader.close();
                } else {
                    System.out.println("Dieses Event existiert nicht.");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Die Methode erhält als Eingabe eine eventID, durchsucht die Textdatei bis das Event mit der entsprechenden eventID gefunden wurde
    // und gibt diese als Array zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.

    /**
     *
     * @param eventID
     * @return
     */
    public static String[] getEvent(int eventID){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return split;
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *
     * @return
     */
    // Getter, der den Namen des Events zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public String getName() {
        return name;
    }

    // Getter, der den Namen des Events zurückgibt. erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt den
    // Namen als String zurück.

    /**
     *
     * @param eventID
     * @return
     */
    public static String getName(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine(); // ließt die Zeile ein, speichert sie in einem String
            while (event != null){
                String[] split = event.split(";"); // teilt den String mittels der Semikolons in einen Array auf
                if (split[8].equals(Integer.toString(eventID))){ // split[8] entspricht der Stelle, wo die eventID gespeichert wurde, sollte diese mit
                	reader.close();                              // dem Parameter übereinstimmen, wird der Name zurückgegeben
                    return split[0];
                }
                event = reader.readLine(); // sollte das Ende der Textdatei ereicht sein, ist event = null, wodurch die Schleife stoppt
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Setter, der den Namen des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param eventID
     * @param name
     */
    // Methode, die den Namen eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie der neue Name notwendig.
    public static void changeName(int eventID, String name) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine(); // Zeile wird eingelesen
            while (line != null)
            {
                // die eingelesene Zeile wird in die Einzelteile zerlegt und in einem Array gespeichert
                String[] split = line.split(";");
                // es wird die Zeile mit dem richtigen Event auf Basis der EventID gesucht
                if (split[8].equals(Integer.toString(eventID))){
                    split[0] = name; // die gewünschte Änderung wird am Array durchgeführt
                }
                // der Array wird wieder in einen String gewandelt, sollte es nicht das gesuchte Event gewesen sein
                // wird dieses unverändert wieder eingefügt
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                // die überarbeitete Zeile wird in die Textdatei eingefügt
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            // die Änderung wird endgültig vollendet
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                //Resources werden geschlossen
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    // Getter, der den Tag des Events zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.

    /**
     *
     * @return
     */
    public int getDay() {
        return day;
    }

    // Getter, der den Tag des Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt den
    // Tag als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.

    /**
     *
     * @param eventID
     * @return
     */
    public static int getDay(int eventID){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return Integer.parseInt(split[1]);
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    // Setter, der den Tag des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.

    /**
     *
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    // Methode, die den Tag eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie der neue Tag notwendig.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.

    /**
     *
     * @param eventID
     * @param day
     */
    public static void changeDay(int eventID, int day){
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[1] = String.valueOf(day);
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                //Resources werden geschlossen
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    // Getter, der den Monat des Events zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.

    /**
     *
     * @return
     */
    public int getMonth() {
        return month;
    }

    // Getter, der den Monat des Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt den
    // Monat als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.

    /**
     *
     * @param eventID
     * @return
     */
    public static int getMonth(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return Integer.parseInt(split[2]);
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    /**
     *
     * @param month
     */
    // Setter, der den Monat des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     *
     * @param eventID
     * @param month
     */
    // Methode, die den Monat eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie der neue Monat notwendig.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.
    public static void changeMonth(int eventID, int month) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[2] = String.valueOf(month);
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param year
     * @return
     */
    // Getter, der das Jahr des Events zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public String getYear(String year) {
        return year;
    }

    // Getter, der den Jahr das Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt das
    // Jahr als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.
    public static int getYear(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return Integer.parseInt(split[3]);
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    /**
     *
     * @param year
     */
    // Setter, der das Jahr des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *
     * @param eventID
     * @param year
     */
    // Methode, die das Jahr eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie das neue Jahr notwendig.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.
    public static void changeYear(int eventID, int year) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[3] = String.valueOf(year);
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @return
     */
    // Getter, der die Lage des Events zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param eventID
     * @return
     */
    // Getter, der den Veranstaltungsort des Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt den
    // Veranstaltungsort als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.
    public static String getLocation(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return split[5];
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *
     * @param location
     */
    // Setter, der die Lage des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @param eventID
     * @param location
     */
    // Methode, die die Lage eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie die neue Lage notwendig.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.
    public static void changeLocation(int eventID, String location) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[5] = location;
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @return
     */
    // Getter, der den Beschreibungstext des Events zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public String getEventText() {
        return eventText;
    }

    /**
     *
     * @param eventID
     * @return
     */
    // Getter, der den Beschreibungstext des Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt den
    // Beschreibungstext als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.
    public static String getEventText(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return split[4];
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *
     * @param eventText
     */
    // Setter, der den Beschreibungstext des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    /**
     *
     * @param eventID
     * @param eventText
     */
    // Methode, die den Beschreibungstext eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie der neue Beschreibungstext notwendig.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.
    public static void changeEventText(int eventID, String eventText) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[4] = eventText;
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @return
     */
    // Getter, der den Namen des Veranstaltungsortes zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public String getVenueName() {
        return venueName;
    }

    /**
     *
     * @param eventID
     * @return
     */
    // Getter, der den Veranstaltungsort des Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt den
    // Veranstaltungsort als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.
    public static String getVenueName(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return split[6];
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *
     * @param venueName
     */
    // Setter, der den Namen des Veranstaltungsortes des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    /**
     *
     * @param eventID
     * @param venueName
     */
    // Methode, die den Veranstaltunsgort eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie der neue Veranstaltungsort notwendig.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.
    public static void changeVenueName(int eventID, String venueName) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[6] = venueName;
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    /**
     *
     * @param categorieManagement
     * @return
     */
    // Die Methode erhält als Parameter einen String mit den Kategorien, wird vom Konstruktor aufgerufen und gibt die
    // Anzahl an Tickets der Kategorien zurück.
    public int generateNumberOfTickets(String categorieManagement) {
        int seatCounter = 0;        // der Counter der die Anzahl der Tickets zählt
        String[] split = categorieManagement.split(";"); // der String wird in einen Array aufgeteilt, um leichter auf die Teile zuzugreifen
        for (int i = 1; i< split.length; i+=5){
            seatCounter += Integer.parseInt(split[i]); // der Counter wird um die jewilige Anzahl an Tickets der Kategorie erhöht
        }
        return seatCounter;
    }

    /**
     *
     * @param eventID
     */
    // Sollte eine Änderung an der Anzahl an Sitzen vorgenommen worden sein, wird diese Methode aufgerufen, damit auch die summierte
    // Zahl der Wahrheit entspricht. Dafür benötigt sie die eventID und funktioniert wie generateNumerofTickets(String categorieManagement)
    // Am Ende wird die Change Methode aufgerufen, damit die neue Anzahl an Tickets auch gespeichert wird.
    public static void updateNumberOfTickets(int eventID) {
        int seatCounter = 0;
        String[] event = getEvent(eventID);
        for (int i = 13; i< event.length; i+=5){
            seatCounter += Integer.parseInt(event[i]);
        }
        changeNumberOfTickets(eventID, seatCounter);
    }


    /**
     *
     * @param eventID
     * @param numberOfTickets
     */
    // Methode, die die Anzahl an Tickets eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie die neue Anzahl an Tickets notwendig. Sollte nur über updateNumberofTickets(int eventID) aufgerufen werden.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.
    public static void changeNumberOfTickets(int eventID, int numberOfTickets) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[7] = String.valueOf(numberOfTickets);
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param eventID
     * @return
     */
    // Getter, der die Anzahl an Tickets des Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt die
    // Anzahl an Tickets als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.
    public static int getNumberOfTickets(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return Integer.parseInt(split[7]);
                }
                event = reader.readLine();
                
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        return 0;
    }


    /**
     *
     * @param numberOfTickets
     */
    // Setter, der die Anzahl der Tickets des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    /**
     *
     * @return
     */
    // Methode wird über den Konstruktor aufgerufen und generiert automatisch die eventID des Events
    public String generateEventID() {
        try {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(eventFile));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            // sollte es sich um das erste Event handeln, hat das Event die geringste eventID
            if (eventFile.length() == 0) {
            	reader.close();
                return "100000";
            } else {
                int eventCounter = 0;  // zählt die Anzahl an Events
                String line = reader.readLine();
                //überprüft wie viele Events bereitsexistieren
                while (line != null) {
                    eventCounter+=1;
                    line = reader.readLine();
                }
                // Im Folgenden wird dann die eventID mit Hilfe des Counters zusammengesetzt. Dafür wird überprüft
                // wie viele Stellen die Zahl hat, damit die eventID immer sechsstellig ist.
                if (eventCounter<10){
                	reader.close();
                    return "10000"+eventCounter;
                } else if (eventCounter<100) {
                	reader.close();
                    return "1000"+eventCounter;
                }else if (eventCounter<1000) {
                	reader.close();
                    return "100"+eventCounter;
                }
                else if (eventCounter<10000) {
                	reader.close();
                    return "10"+eventCounter;
                }
                else if (eventCounter<100000) {
                	reader.close();
                    return "1"+eventCounter;
                } else if (eventCounter>100000 && eventCounter<1000000) {
                	reader.close();
                    return String.valueOf(eventCounter);
                }else{
                	reader.close();
                    return null;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return
     */
    // Getter, der die EventID des Events zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public int getEventID() {
        return eventID;
    }

    /**
     *
     * @param name
     * @return
     */
    // Getter, der die eventID des Events zurückgibt, erhält als Parameter den Namen, mit welcher das Event in der Textdatei gefunden wird. Gibt die
    // eventID als String zurück. Methode nur mit Vorsicht zu benutzen, da Name nicht eindeutig ist!
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird und dass es hier auf Basis des Namens funktioniert.
    public static int getEventID(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[0].equals((name))){
                	reader.close();
                    return Integer.parseInt(split[8]);
                }
                
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }


    /**
     *
     * @param eventID
     */
    // Setter, der die EventID des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     *
     * @param eventID
     * @param newEventID
     */
    // Methode, die die EventID eines gespeicherten Events verändert. Als Parameter sind dafür die alte eventID, um das entsprechende Event
    // zu finden, sowie die neue eventID notwendig. Methode nur mit Vorischt zu benutzen, eventID werden automatisch generiert.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.
    public static void changeEventID(int eventID, int newEventID) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[8] = String.valueOf(newEventID); // die gewünschte Änderung wird am Array durchgeführt
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @return
     */
    // Getter, der das Genre des Events zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @param eventID
     * @return
     */
    // Getter, der das Genre des Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt das
    // Genre als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.
    public static String getGenre(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return split[9];
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *
     * @param genre
     */
    // Setter, der das Genre des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     *
     * @param eventID
     * @param genre
     */
    // Methode, die das Genre eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie das neue Genre notwendig.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.
    public static void changeGenre(int eventID, String genre) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[9] = genre;
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @return
     */
    // Getter, der den Künstler des Events zurückgibt, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public String getArtist() {
        return artist;
    }

    /**
     *
     * @param eventID
     * @return
     */
    // Getter, der den Künstler des Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt den
    // Künstler als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.
    public static String getArtist(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return split[10];
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *
     * @param artist
     */
    // Setter, der den Künstler des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     *
     * @param eventID
     * @param artist
     */
    // Methode, die den Künstler eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, sowie der neue Künstler notwendig.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), einziger Unterschied ist was geändert wird.
    public void changeArtist(int eventID, String artist) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            StringBuilder line = new StringBuilder(reader.readLine());
            while (line != null)
            {
                String[] split = line.toString().split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    split[10] = artist;
                }
                line = new StringBuilder(split[0]);
                for (int y=1;y<split.length; y++){
                    line.append(";").append(split[y]);
                }
                content.append(line).append(System.lineSeparator());
                line = new StringBuilder(reader.readLine());
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param eventID
     * @return
     */
    // Getter, der die Anzahl an Kategorie des Events zurückgibt, erhält als Parameter die eventID, mit welcher das Event in der Textdatei gefunden wird. Gibt die
    // Anzahl an Kategorien als String zurück.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird.
    public static String getNumberOfCategories(int eventID) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                	reader.close();
                    return split[11];
                }
                event = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *
     * @param eventID
     * @return
     */
    // Die Methode erhält als Parameter die eventID, identifziert mit dieser das Event in der Textdatei und gibt alle dazugehörigen Kategorien als
    // String zurück.
    public static String showCategories(int eventID){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine(); // liest Zeile ein
            String categories = "";
            while (event != null){
                String[] split = event.split(";"); // Zeile wird mit Hilfe der Semikolons aufgeteilt
                if (split[8].equals(Integer.toString(eventID))){
                    for (int i =0; i< Integer.parseInt(getNumberOfCategories(eventID)); i++){
                        // String wird zusammengesetzt
                        categories =categories + "Name: "+ split[12+(i*5)] + "  Kapazitaeten: " + split[13+(i*5)] + "  Preis: " + split[14+(i*5)]
                                +"  relativer Rabatt: " + split[15+(i*5)] +"%  absoluter Rabatt: "+ split[16+(i*5)] + "\n";
                    }
                }
                event = reader.readLine();
            }
            reader.close();
            return categories;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param eventID
     * @param categorieName
     * @param thingToGet
     * @return
     */
    // Getter, der Teile des Kategorien des Events zurückgibt, erhält als Parameter die eventID, den relevanten Kategorie-Namen und welchen Part der Kategorie man erhalten möchte.
    // Durch die eventID wird das Event in der Textdatei gefunden. Durch den Namen der Kategorie wird sichergestellt, dass der richtige Part zurückgegeben wird.
    // Für genaue Funktionsweise siehe bitte getName(int eventID), der einzige Unterschied ist, was zurückgegeben wird und dass hier noch Unterschieden wird, was genau
    // zurückgegeben wird.
    public static String getCategorieManagement(int eventID, String categorieName, String thingToGet) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String event = reader.readLine();
            while (event != null){
                String[] split = event.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    for (int i =0; i< split.length; i++){
                        if(split[(12 + i)].equals(categorieName)){
                            if(thingToGet.equals("Name")){
                            	reader.close();
                                return split[(12+i)];
                            } else if (thingToGet.equals("Seats")) {
                            	reader.close();
                                return split[(12+i+1)];
                            } else if (thingToGet.equals("Price")) {
                            	reader.close();
                                return split[(12+i+2)];
                            }else if (thingToGet.equals("procentualDiscount")) {
                            	reader.close();
                                return split[(12+i+3)];
                            }else if (thingToGet.equals("absoluteDiscount")) {
                            	reader.close();
                                return split[(12+i+4)];
                            }
                        }
                    }
                }
                event = reader.readLine();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *
     * @param categorieManagement
     */
    // Setter, der die Kategorien des Events bearbeitet, funktioniert nur wenn das Objekt im selben Programmlauf erstellt wird.
    public void setCategorieManagement(String categorieManagement) {
        this.categorieManagement = categorieManagement;
    }

    /**
     *
     * @param eventID
     * @param categorieName
     * @param thingToChange
     * @param howToChange
     */
    // Methode, die die Kategorie eines gespeicherten Events verändert. Als Parameter sind dafür die eventID, um das entsprechende Event
    // zu finden, der CategorieName, dessen Aspekte verändert werden sollen, der Aspekt der verändert werden soll und wie der Aspekt verändert werden soll
    // notwendig.
    // Für genaue Funktionsweise der Methode siehe bitte changeName(int eventID, String name), der Unterschied ist nicht groß.
    public static void changeCategorieManagement(int eventID, String categorieName, String thingToChange, String howToChange) {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            while (line != null)
            {
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    for (int i =12; i< split.length; i++){
                        // Unterschied zu den anderen Change Methoden, es wird noch agefragt, was geändert werden soll,
                        // um die richtige Stelle zu finden
                        if(split[(i)].equals(categorieName)){
                            if(thingToChange == "Name"){
                                split[(i)] = howToChange;
                                break;
                            } else if (thingToChange == "Seats") {
                                split[(i+1)]=howToChange;
                                break;
                            } else if (thingToChange == "Price") {
                                split[(i+2)] = howToChange;
                                break;
                            }else if (thingToChange == "procentualDiscount") {
                                split[(i+3)]=howToChange;
                                break;
                            }else if (thingToChange == "absoluteDiscount") {
                                split[(i+4)]=howToChange;
                                break;
                            }
                        }
                    }
                }
                line = split[0];
                for (int y=1;y<split.length; y++){
                    line = line +";"+ split[y];
                }
                content.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                //Resources werden geschlossen
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if (thingToChange.equals("Seats")){
            updateNumberOfTickets(eventID);
        }
    }

    /**
     *
     * @param eventID
     */
    // Wenn ein Event abgebrochen wird oder bereits stattfand, kann dieses Event gelöscht werden. Dafür wird als Parameter die eventID übergeben, um das
    // Event zu identifzieren. Nach Löschung des Events werden automatisch alle dem Event zugehörigen Tickets gelöscht.
    public static void DeleteEvent(int eventID){
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine(); // liest die Zeile ein
            while (line != null)
            {
                // die eingelesene Zeile wird in die Einzelteile zerlegt und in einem Array gespeichert
                String[] split = line.toString().split(";");
                // es wird die Zeile mit dem richtigen Event auf Basis der EventID gesucht
                if (split[8].equals(Integer.toString(eventID))){
                    // die Zeile wird übersprungen
                } else{
                    content.append(line).append(System.lineSeparator());// der Text wird wieder zusammengesetzt
                }
                line = reader.readLine();
            }
            // die Änderung wird endgültig vollendet
            writer = new FileWriter(eventFile);
            writer.write(content.toString());
            Ticket.deleteTickets(eventID); // die dazugehörigen Tickets werden gelöscht
            assert reader != null;
            reader.close();
            assert writer != null;
            writer.close();
        }
        catch (IOException e)
        {
        }
    }

}
