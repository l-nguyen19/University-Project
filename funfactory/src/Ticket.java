import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

// Die Klasse implementiert das erstellen sowie Löschen von Tickets. Dafür wird auf die Events zugegeriffen und sowohl die
// eventID als auch die ticketID als PrimaryKey verwendet. Als Datenbank für die Tickets wird Ticket.txt verwendet.

public class Ticket {
    private String ticketID;
    private String eventID;
    private String seatNum;     // entsprichte dem Sitzplatz der dazugehörigen Kategorie
    private String year;
    private String month;
    private String day;
    private Date date;
    private String categorie;
    private String categorieNum;
    private String counter;





    static File ticketFile = new File("Server/Ticketlist/Ticket.txt");
    static File eventFile = new File("Server/Veranstaltungen/Veranstaltungs.txt");

    /**
     *
     * @param ticketID
     * @param eventID
     * @param seatNum
     * @param year
     * @param month
     * @param day
     * @param categorie
     * @param counter
     */
    // Kosntruktor der das Ticket-Objekt erstellt. Wird nicht direkt aufgerufen, sondern nur über buyTicket()
    public Ticket(String ticketID, String eventID, String seatNum, String year, String month, String day, String categorie, String counter){
        this.ticketID = String.valueOf(ticketID);
        this.eventID = String.valueOf(eventID);
        this.seatNum = String.valueOf(seatNum);
        this.year = year;
        this.month = month;
        this.day = day;
        this.categorie = categorie;
        this.counter = counter;
    }

    /**
     *
     * @return
     */
    // Getter der die TicketID zurückgibt, aber nur funktioniert, wenn das Ticket zur selben Laufzeit erstellt wurde
    public String getTicketID() {
        return ticketID;
    }

    /**
     *
     * @param ticketID
     */
    // Setter der die TicketID einfügt, aber nur funktioniert, wenn das Ticket zur selben Laufzeit erstellt wurde. Sollte nicht benutzt werden
    // da diese automatisch generiert wurde.
    public void setTicketID(int ticketID) {
        this.ticketID = String.valueOf(ticketID);
    }

    /**
     *
     * @return
     */
    // Getter der die EventID zurückgibt, aber nur funktioniert, wenn das Ticket zur selben Laufzeit erstellt wurde
    public String getEventID() {
        return eventID;
    }

    /**
     *
     * @param eventID
     */
    // Setter der die eventID einfügt, aber nur funktioniert, wenn das Ticket zur selben Laufzeit erstellt wurde. Sollte
    // nicht benutzt werden, da diese automatisch eingefügt wird.
    public void setEventID(int eventID) {
        this.eventID = String.valueOf(eventID);
    }

    /**
     *
     * @return
     */
    // Getter der die Sitznummer zurückgibt, aber nur funktioniert, wenn das Ticket zur selben Laufzeit erstellt wurde
    public String getSeatNum() {
        return seatNum;
    }

    /**
     *
     * @param seatNum
     */
    // Setter der die Sitznummer einfügt, aber nur funktioniert, wenn das Ticket zur selben Laufzeit erstellt wurde
    public void setSeatNum(int seatNum) {
        this.seatNum = String.valueOf(seatNum);
    }

    /**
     *
     * @return
     */
    // Getter der das Datum zurückgibt, aber nur funktioniert, wenn das Ticket zur selben Laufzeit erstellt wurde
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    // Setter der das Datum einfügt, aber nur funktioniert, wenn das Ticket zur selben Laufzeit erstellt wurde
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @param eventID
     * @param seatNum
     * @param categorie
     * @return
     */
    // Wenn ein Ticket gekauft wird, erstellt diese Methode es und sorgt für das Einfügen des Tickets in die Datenbank.
    // Bekommt als Parameter alle Informationen, die durch die Ticketauswahl generiert werden und generiert die restlichen selber
    // durch den Aufruf der Methoden ticketCounter und createTicketID.
    public static Ticket buyTicket(int eventID, String seatNum, String categorie){
        String localCounter = ticketCounter(eventID, seatNum, categorie);
        String localID = createTicketID(eventID, seatNum, categorie, localCounter);
        //payTicket(eventID, categorie);

        Ticket ticket = new Ticket(localID, String.valueOf(eventID), seatNum, String.valueOf(Event.getYear(eventID)),
                String.valueOf(Event.getMonth(eventID)), String.valueOf(Event.getDay(eventID)),categorie, localCounter);
        insertTicketIntoList(ticket);
        //sendTicket(ticket);
        
        return ticket;
    }

    /**
     *
     * @param eventID
     * @param categorie
     * @param antwort
     * @return
     */
    // Die Methode erhält die eventID, des Events für die das Ticket bezahlt wird, die Kategorie, um den Preis zu bestimmen
    // sowie die Information, ob ein Discout stattfinden soll. Ist das der Fall wird noch ausgelesen, ob es einen absoluten oder
    // relativen Discount gibt.
    public static double payTicket(int eventID, String categorie, String antwort) {
        Scanner scanner = new Scanner(System.in);
        int price = Integer.parseInt(Event.getCategorieManagement(eventID, categorie, "Price"));
        int absoluteDiscout = Integer.parseInt(Event.getCategorieManagement(eventID, categorie, "absoluteDiscount"));
        int procentualDiscount = Integer.parseInt(Event.getCategorieManagement(eventID, categorie, "procentualDiscount"));
        double finalPrice;
        // es wird überprüft welcher Discount zählt und entsprechend der Preis angepasst
        if (antwort.equals("Ja")){
            if(Event.getCategorieManagement(eventID, categorie, "procentualDiscount")!=(String.valueOf(0))){
               // System.out.println("Der prozentuale Discount beträgt: " + Event.getCategorieManagement(eventID, categorie, "procentualDiscount"));
                finalPrice = price - (price*procentualDiscount*0.01);
            }else if(Event.getCategorieManagement(eventID, categorie, "absoluteDiscount")!=(String.valueOf(0))){
                //System.out.println("Der absolute Discount beträgt: " + Event.getCategorieManagement(eventID, categorie, "absoluteDiscount"));
                finalPrice = price-absoluteDiscout;
            } else{
               // System.out.println("Es gibt leider keinen Discount.");
                finalPrice = price;
            }
        }else{
            finalPrice = price*1;
        }
        return finalPrice;
    }

    /**
     *
     * @param eventID
     * @param seatNum
     * @param categorie
     * @return
     */
    // Die Methode prüft, ob das selbe Ticket bereits einmal verkauft wurde. Wenn das der Fall ist, geht der Counter hoch. Dabei wird auf die Ticketlist zugegriffen
    private static String ticketCounter(int eventID, String seatNum, String categorie) {

        try {
            int counter = 1;
            String rueckgabeCounter;
            String toBeIgnored;
            String potentialEventID;
            String potentialSeatNum;
            String potentialCategorie;
            String potentialYear;
            BufferedReader reader = new BufferedReader(new FileReader(ticketFile));
            // Wenn noch kein Ticket verkauft wurde, ist der Counter 01
            if(ticketFile.length() == 0) {
                rueckgabeCounter = "01";
                return rueckgabeCounter;
            }else {
                // ansonsten wird gezählt, ob dieses Ticket bereits einmal verkauft wurde, indem die eventID, Sitzplatz, Kategorie und Jahr abgefragt werden
                String line = reader.readLine();
                String[] split = line.split(";");
                while (line!=null) {
                    split = line.split(";");
                    if (String.valueOf(eventID).equals(split[1]) && seatNum.equals(split[2]) && categorie.equals(split[3]) && String.valueOf(Event.getYear(eventID)).equals(split[4])){
                        counter += 1;
                    }
                    line = reader.readLine();
                // der Counter wird an die Länge der Tickets, die für diesen Platz bereits verkauft wurden angepasst
                }
                if(counter < 10) {
                    rueckgabeCounter = "0" + String.valueOf(counter);
                } else{
                    rueckgabeCounter = String.valueOf(counter);
                }
                return rueckgabeCounter;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param ticket
     */
    // Hier wird ein Ticket in die "Datenbank" (also die Textdatei) eingefügt und somit gespeichert. Dafür wird ein Semikolon genutzt
    // um ein späteres auslesen über .split() zu ermöglichen
    public static void insertTicketIntoList(Ticket ticket){
        try {
            FileWriter writer = new FileWriter(ticketFile, true);
            writer.write(ticket.ticketID +";"+ ticket.eventID +";"+ ticket.seatNum +";"+ ticket.categorie +";"+
                    ticket.year +";"+ ticket.month +";"+ ticket.day + ";" +ticket.counter + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Datei existiert nicht");
        }
    }

    /**
     *
     * @param eventID
     * @param categorieName
     * @return
     */
    // Die Methode erhält als Parameter die eventID und der relevante Kategoriname und gibt die Nummer der Kategorie zurück.
    public static String getCategorieNumeration(int eventID, String categorieName){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(eventFile));
            String line = reader.readLine();
            int numberCategories = Integer.parseInt(Event.getNumberOfCategories(eventID));
            int[] prices = new int[numberCategories];
            int counter = 0;
            int samePriceCounter = 0;
            int categoriePrice = Integer.parseInt(Event.getCategorieManagement(eventID, categorieName, "Price"));
            String[] eventArray = new String[0];
            //Dafür werden zuerst in einem Array alle Preise der Kategorien eiens Events gespeichert.
            while (line != null){
                String[] split = line.split(";");
                if (split[8].equals(Integer.toString(eventID))){
                    for (int i =0; i<numberCategories; i++){
                        prices[i] = Integer.parseInt(split[(14+(i*5))]);
                    }
                    eventArray = split;
                    break;
                }
                line = reader.readLine();
            }
            reader.close();
            // Dieser Array wird dann sortiert
            Arrays.sort(prices);
            // Daraufhin wird überprüft ob anderen Kategorie den selben Preis haben, wie die Kategorie aus dem Parameter
            for (int i= 0; i<prices.length; i++){
                if (prices[i] == categoriePrice){
                    samePriceCounter +=1;
                }
            }
            // Sollte das nicht der Fall sein wird ermittelt an welche Stelle die übergebene Kategorie steht
            if (samePriceCounter==0){
                for (int y= 0; y<prices.length; y++){
                    if(prices[y]==categoriePrice){
                        if(y<10){
                            return ("0"+y);
                        }else{
                            return String.valueOf(y);
                        }
                    }
                }
            }else{
                // sollte es noch andere Kategorie mit dem selben Preis geben, wir diese PFad eingeschlagen
                String [] nameArray = new String[samePriceCounter];
                int nameArrayCounter = 0;
                // hier werden die Namen der Kategorie mit den selben Preis gespeichert
                for (int i =0; i< numberCategories; i++){
                    if(Integer.parseInt(eventArray[(14+(i*5))]) == categoriePrice){
                        nameArray[nameArrayCounter] = eventArray[12+(i*5)];
                        nameArrayCounter +=1;
                    }
                }
                // dieser Array wird schließlich sortiert
                Arrays.sort(nameArray);
                int numberPosition = 0;
                int namePosititon = 0;
                // Nun wird ermittelt auf welchen Platz die Kategorien mit dem selben Preis stehen
                for (int t=0; t<prices.length; t++){
                    if(prices[t]==categoriePrice){
                        numberPosition = t+1;
                    }
                }
                // Und innerhalb der Kategorien mit dem selben Preis schließlich die Postition der übergebenen Kategorie bestimmt
                for (int h =0; h<nameArray.length; h++){
                    if(nameArray[h] == categorieName){
                        namePosititon= h;
                    }
                }
                // Dadurch kann dann final die Position der übergeben Kategorie bestimmt werden
                if((numberPosition+namePosititon)<10){
                    return ("0"+(numberPosition+namePosititon));
                }else{
                    return String.valueOf(numberPosition+namePosititon);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Fehler";
    }

    /**
     *
     * @param eventID
     * @param seatNum
     * @param categorie
     * @param counter
     * @return
     */
    // hier wird die TicketID zusammengefügt
    public static String createTicketID(int eventID, String seatNum, String categorie, String counter){
        String categorieNum= getCategorieNumeration(eventID, categorie);
        String localTicketID = String.valueOf(Event.getYear(eventID)) +String.valueOf(eventID) + categorieNum + seatNum + counter;
        return localTicketID;
    }


    /**
     *
     * @param ticket
     * @param email
     * @param name
     * @param adress
     * @param payment
     */
    // die Methode versendet das Ticket per Post, dafuer wird zuerst die Datei mit der TicketID als Namen erstellt und dann ein kurzer Text, sowie
    // das Ticket in die Datei eingefuegt.
    public static void sendPost(Ticket ticket, String email, String name, String adress, String payment) {
    


        File postFile = new File(ticket.ticketID+".txt");
        try {
            postFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter writer = new FileWriter(postFile);
            writer.write( name+ "\n" + adress + "\n" + "\n" + "\n" + "\n" +
                    "Sehr geehrte/r Herr/Frau " + name + "," + "\n" + "vielen dank, dass sie sich fuer die Funfactory entschieden haben. Hier ist ihr Ticket: "+ "\n"+
                    "TicketID: " + ticket.ticketID + "\n" +
                    "Sitplatz: " + ticket.seatNum + "\n" +
                    "Categorie: " + ticket.categorie + "\n" +
                    "Datum: " + ticket.day + "."+ ticket.month + "."+ ticket.year + "\n"
                    + "Art der Bezahlung: " + payment);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param ticket
     * @param email
     * @param name
     * @param adress
     * @param payment
     */
    // die Methode versendet das Ticket per Mail dafuer wird zuerst die Datei mit der TicketID als Namen erstellt und dann ein kurzer Text, sowie
    // das Ticket in die Datei eingefuegt.
    public static void sendMail(Ticket ticket, String email, String name, String adress, String payment) {
        File mailFile = new File(ticket.ticketID +".txt");
        try {
            mailFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter writer = new FileWriter(mailFile);
            writer.write("Guten Tag, "+ name + "\n" + "vielen dank, dass sie sich fuer die Funfactory entschieden haben. Hier ist ihr Ticket: "+ "\n"+
                    "TicketID: " + ticket.ticketID + "\n" +
                    "Sitplatz: " + ticket.seatNum + "\n" +
                    "Categorie: " + ticket.categorie + "\n" +
                    "Datum: " + ticket.day + "."+ ticket.month + "."+ ticket.year +"\n"
                    		+ "Zahlungsinformationen:" + email +" "+ name + " " + adress + " " + payment);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     *
     * @param ticketID
     */
    // Hierüber kann das Ticket online zurückgegeben werden. Es erhält die ticketID, sucht das entsprechende Ticket und
    // ergänzt die TicketID um "invalid, wodurch es ungültig wird

    public static void returnTicketOnline(String ticketID){
        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(ticketFile));
            // Zeile wird eingelesen
            String line = reader.readLine();
            //speichert den gesamten Text in OldContent
            while (line != null)
            {

                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

           // Ersetzt die alte TicketID aus oldContent durch TicketID mit der Ergänzung "invalid"

            String newContent = oldContent.replaceAll(ticketID, (ticketID + "invalid"));

            // die alte TicketID wird endgültig durch die neue und ungültige TicketID überschrieben

            writer = new FileWriter(ticketFile);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Resources werden geschlossen

                reader.close();

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
     * @param ticketID
     */
    // Hierüber kann das Ticket in Person zurückgegeben werden. Der Mitarbeiter muss dafür die ticketID eingeben. Funktioniert identisch wie
    // returnTicketOnline(String ticketID).
    public static void returnTicketPost(String ticketID){
        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(ticketFile));

            // Liest alle Zeilen der Ticketlist und speichert es in oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            // Ersetzt die alte TicketID aus oldContent durch TicketID mit der Ergänzung "invalid"

            String newContent = oldContent.replaceAll(ticketID, (ticketID + "invalid"));

            // die alte TicketID wird endgültig durch die neue und ungültige TicketID überschrieben

            writer = new FileWriter(ticketFile);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Resources werden geschlossen

                reader.close();

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
    // Die Methode zeigt alle verfügbaren Tickets eines Events an. Es erhält dafür als Paramete die eventID und gibt eine ArrayList mit den Tickets zurück
    public static ArrayList<String> showAvailableTickets(int eventID){
 
        //String localEventID = String.valueOf(eventID);
        String[] eventArray = Event.getEvent(eventID);
        int anzahlCategories = (eventArray.length-12)/5;
        ArrayList<String> ticketsList = new ArrayList<String>();

        for (int i = 0; i < anzahlCategories; i++){

            int anzahlSitze = Integer.parseInt(eventArray[(11 + (i*5) + 2 )]);
            for (int x =1; x<=anzahlSitze;x++){
                // über die Methode checkAvailabitlity wird überprüft, ob das Ticket noch verfügbar ist, wenn ja, dann wird es
                // der ArrayList hinzugefügt
                if (checkAvailability(eventID, x, eventArray[(11 + (i*5) + 1)])){
                    ticketsList.add("Kategorie: " + eventArray[(11 + (i*5) + 1 )]+ "\t" + "Sitzplatz: " + x );
                    
                }
            }
        }
		return ticketsList;
    }

    /**
     *
     * @param eventID
     * @param chosenIndex
     * @return
     */
    // Die Methode gibt die vom Kunden ausgewählte Kategorie zurück, indem eine ArraylList mit allen verfügabren Kategorien erstellt wird
    // und der Index der ausgeuchten Kategorie übergeben wird, anhand dessen die Kartegorie zurückgegeben werden kann.
    public static String getChosenCategorie (int eventID, int chosenIndex){
    	 String[] eventArray = Event.getEvent(eventID);
    	 ArrayList<String> availableCategories = new ArrayList<String>();
    	 String chosenCategorie;
    	 int anzahlCategories = (eventArray.length-12)/5;

         for (int i = 0; i < anzahlCategories; i++){

             int anzahlSitze = Integer.parseInt(eventArray[(11 + (i*5) + 2 )]);
             for (int x =1; x<=anzahlSitze;x++){
                 if (checkAvailability(eventID, x, eventArray[(11 + (i*5) + 1)])){
                     availableCategories.add(eventArray[(11 + (i*5) + 1 )]);

                 }
             }
         }
        chosenCategorie = availableCategories.get(chosenIndex);
 		return chosenCategorie;
    }

    /**
     *
     * @param eventID
     * @param chosenIndex
     * @return
     */
    // Die Methode gibt die vom Kunden ausgewählte Kategorie zurück, indem eine ArraylList mit allen verfügabren Sitzplätzen erstellt wird
    // und der Index des ausgeuchten Sitzplatzes übergeben wird, anhand dessen der ausgewählte Sitzplatz zurückgegeben werden kann.
    public static int getChosenSeat (int eventID, int chosenIndex){
   	    String[] eventArray = Event.getEvent(eventID);
        int anzahlCategories = (eventArray.length-12)/5;
        ArrayList<Integer> seatsList = new ArrayList<Integer>();
        int chosenSeat;

        for (int i = 0; i < anzahlCategories; i++){

            int anzahlSitze = Integer.parseInt(eventArray[(11 + (i*5) + 2 )]);
            for (int x =1; x<=anzahlSitze;x++){
                if (checkAvailability(eventID, x, eventArray[(11 + (i*5) + 1)])){
                    seatsList.add(x);
                }
            }
        }
        chosenSeat = seatsList.get(chosenIndex);
		return chosenSeat;
   }

    /**
     *
     * @param eventID
     * @param seatNum
     * @param categorie
     * @return
     */
   // die Methode überprüft, ob ein Sitzplatz verfügbar ist und erhält dafür die eventID, den Sitzplatz und die Kategorie
    public static boolean checkAvailability(int eventID, int seatNum, String categorie){
        boolean availablity = true;
        try {
            Scanner scanner;
            String toBeIgnored;
            String potentialTicketID;
            String potentialEventID;
            String potentialSeatNum;
            String potentialCategorie;
            BufferedReader reader = new BufferedReader(new FileReader(ticketFile));
            // Wenn es noch keine Tickets gibt, ist der Sitzplatz auf jeden Fall verfügbar
            if(ticketFile.length() == 0) {
            	reader.close();
                return true;
            }
            String line = reader.readLine(); // Zeile wird eingelesen
            String[] split = line.toString().split(";"); // Zeile wird in einen Array zerlegt, um besser auf die einzelnen Elemente zuzugreifen
            // Ansonsten werden alle Tickets durchgegangen und überprüft, ob es bereits ein Ticket mit der eventId, dem Sitzplatz und der Kategorie gibt
            // sowie, ob das Ticket invalid ist (also zurückgegeben)
            while (line!=null) {
                split = line.toString().split(";");
                if(split[1].equals(String.valueOf(eventID)) && split[2].equals(String.valueOf(seatNum)) && split[3].equals(categorie) && !split[0].contains("invalid")){
                    availablity = false;
                    break;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return availablity;
    }

    /**
     *
     * @param eventID
     */
    // Die Methode wird automatisch aufegrufen, wenn ein Event gelöscht wird und sorgt dafür, dass alle Tickets, die zu dem Event
    // gehörten gelöscht werden
    public static void deleteTickets(int eventID){
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(ticketFile));
            // Liest alle Zeilen der Ticketlist und speichert es in oldContent
            String line = reader.readLine();
            while (line != null)
            {
                // die eingelesene Zeile wird in die Einzelteile zerlegt und in einem Array gespeichert
                String[] split = line.split(";");
                // es wird die Zeile mit dem richtigen Event auf Basis der EventID gesucht
                if (split[1].equals(Integer.toString(eventID))){
                    // die Zeile wird übersprungen
                } else{
                    content.append(line).append(System.lineSeparator());
                }
                line = reader.readLine();
            }
            // die Änderung wird endgültig vollendet
            writer = new FileWriter(ticketFile);
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

}
