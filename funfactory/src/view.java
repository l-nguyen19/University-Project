import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class view extends JFrame{
	//paths
	protected final String pathcustomerlist = "Server/Kunden/Kunden.txt";
	
	//Fenster
	private JFrame window;
	//Panels
	private JPanel mainview;
	private JPanel registrationview;
	private JPanel loginview;
	private JPanel custview;
	private JPanel custaccview;
	private JPanel verifyview;
	private JPanel resetpwview;
	
	//Employeeview
	private JPanel employeeloginview;
	private JPanel employeeview;
	private JPanel adminview;
	private JPanel employeeregisterview;
	private JPanel deleteemployeeadminview;
	private JPanel deleteemployeeview;
	private JPanel employeeeditview;
	private JPanel deleteemployeesuccess;
	private JPanel employeeeditnameview;
	private JPanel employeeeditpasswordview;
	private JPanel employeeeditemailview;
	private JPanel employeeeditadminview;
	private JPanel employeeeditnameadminview;
	private JPanel employeeeditpasswordadminview;
	private JPanel employeeeditemailadminview;
	
	//EmployeeEventview
	private JPanel mainviewEvent;
	private JPanel createEventView;
	private JPanel deleteEventView;
	private JPanel showEventView;
	private JPanel changeEventView;
	private JPanel createCategoriesView; 
	
	//CustEvent
	private JPanel mainEventsCustomerView;
	private JPanel searchEventsCustomerView;
	private JPanel showAvailableTicketsCustomerView;
	private JPanel payEventCustomerView;
	private JPanel returnTicketsCustomerView;
	
	//Buttons
	private JButton toregistration;
	private JButton tologin;	
	private JButton registrationback;	
	private JButton loginback;
	private JButton login;	
	private JButton registration;
	private JButton logout;	
	private JButton toCustAcc;
	private JButton custaccviewback;
	private JButton editsave;
	private JButton pwreset;
	private JButton deleteAcc;
	private JButton verifyback;
	private JButton verifyok;
	private JButton sendpwreset;
	private JButton pwresetback;
	private JButton toevents;
	
	//Employeee
	private JButton elogin;
	private JButton employeelogin;
	private JButton adminlogout;
	private JButton eregistration; 
	private JButton switchtoempregister;
	private JButton switchtiempldelet;
	private JButton backadmin;
	private JButton backadmin2;
	private JButton finaldeleteemployee;
	private JButton employeeedit;
	private JButton	employeeevent;
	private JButton employeelogout;
	private JButton employeeeditdelet;
	private JButton employeeeditchangename;
	private JButton employeeeditchangeemail;
	private JButton employeeeditchangepassword;
	private JButton employeeeditchangenameadmin;
	private JButton employeeeditchangeemailadmin;
	private JButton employeeeditchangepasswordadmin;
	private JButton employeeeditbackadmin;
	private JButton employeeeditback;
	private JButton employeeeditback2;
	private JButton finaldeleteemployee2;
	private JButton editback;
	private JButton editback2;
	private JButton editback3;
	private JButton changename;
	private JButton changepassword;
	private JButton changeemail;
	private JButton editbackadmin;
	private JButton editback2admin;
	private JButton editback3admin;
	private JButton changenameadmin;
	private JButton changepasswordadmin;
	private JButton changeemailadmin;
	private JButton switchtoempedit;
	
	//EmployeeEvent
	private JButton backemployee;
	private JButton backtomain1;
	private JButton createEventButton;
	private JButton deleteEventButton;
	private JButton showEventButton;
	private JButton changeEventButton;
	private JButton createButton;
	private JButton deleteButton;
	private JButton showButton;
	private JButton changeButton;
	private JButton createEventBack;
	private JButton deleteEventBack;
	private JButton showEventBack;
	private JButton changeEventBack;
	private JButton toupdatelistEvent;
	private JButton toupdatesetEvent;

	//CustEvent
	private JButton backtomain;
	private JButton toEventtCustomer;
	private JButton mainBuyTicketButton;
	private JButton mainReturnTicketButton;
	private JButton searchEventsBackButton;
	private JButton showTicketsBackButton;
	private JButton payEventsBackButton;
	private JButton returnTicketsBackButton;
	private JButton searchEventsButton;
	private JButton continueEventsButton;
	private JButton buyTicketButton;
	private JButton perPostButton;
	private JButton perMailButton;
	private JButton returnTicketButton;
	private JButton discountYes;
	private JButton discountNo;
	
	//Label
	private JLabel registrationemaill;
	private JLabel registrationnamel;
	private JLabel loginemaill;
	private JLabel registrationpwl;
	private JLabel loginpwl;
	private JLabel registrationaddressl;
	private JLabel registrationoptionall;
	private JLabel editemaill;
	private JLabel editnamel;
	private JLabel editpwl;
	private JLabel editaddressl;
	private JLabel editpayment1l;
	private JLabel editpayment2l;
	private JLabel editpayment3l;
	private JLabel errregistrationl;
	private JLabel errloginl;
	private JLabel verifyl;
	private JLabel pwresetl;
	private JLabel editerrl;
	private JLabel registrationerrl;
	
	//EmployeeEvent
	private JLabel deleteEventLabel;
	private JLabel showEventLabel;
	private JLabel changeEventLabel;
	private JLabel createEventLabelname;
	private JLabel createEventLabelday; 
	private JLabel createEventLabelmonth; 
	private JLabel createEventLabelyear; 
	private JLabel createEventLabeleventText; 
	private JLabel createEventLabellocation; 
	private JLabel createEventLabelvenueName; 
	private JLabel createEventLabelgenre; 
	private JLabel createEventLabelartist;
	private JLabel createEventLabelnumberOfCategories;
	private JLabel createCategoriessuccess1;
	private JLabel showEventLabeldaymonthyear;
	private JLabel showEventLabeleventText;
	private JLabel showEventLabelLocation;
	private JLabel showEventLabelvenuename;
	private JLabel showEventLabelnumberoftickets;
	private JLabel showEventLabelgenre;
	private JLabel showEventLabelartist;
	private JLabel showEventLabeleventID;
	private JLabel showEventLabelnumberofcategories;
	private JLabel showEventLabelcategoriemanagement;
	
	//Employee
	private JLabel eloginenname;
	private JLabel eloginemaill;
	private JLabel eloginpwl;
	private JLabel eerrloginl;
	private JLabel eregistrationemaill;
	private JLabel eregistrationpwl;
	private JLabel eregistrationnamel;
	private JLabel eerrregistrationl;
	private JLabel deleteemail;
	private JLabel deletepw;
	private JLabel deletename;
	private JLabel deleteemail2;
	private JLabel deletepw2;
	private JLabel deletename2;
	private JLabel tochangename;
	private JLabel tochangenameemail;
	private JLabel tochangenamepassword;
	private JLabel tochangenameinto;
	private JLabel tochangeemailpassword ;
	private JLabel tochangeemailinto ;
	private JLabel tochangeemail ;
	private JLabel tochangeemailname;
	private JLabel tochangepasswordemail ;
	private JLabel tochangepasswordname ;
	private JLabel tochangepasswordinto ;
	private JLabel tochangepassword ;
	private JLabel tochangenameadmin;
	private JLabel tochangenameemailadmin;
	private JLabel tochangenamepasswordadmin;
	private JLabel tochangenameintoadmin;
	private JLabel tochangeemailpasswordadmin ;
	private JLabel tochangeemailintoadmin ;
	private JLabel tochangeemailadmin ;
	private JLabel tochangeemailnameadmin;
	private JLabel tochangepasswordemailadmin ;
	private JLabel tochangepasswordnameadmin ;
	private JLabel tochangepasswordintoadmin ;
	private JLabel tochangepasswordadmin ;
	private JLabel editsuccess;
	private JLabel createesuccess;
	private JLabel deleteeesuccess;

	//CustEvent
	private JLabel searchForEventsLabel;
	private JLabel discountEligibleLabel;
	private JLabel howToSearch;
	private JLabel availableTicketsLabel;
	private JLabel returnTicketLabel;
	
	//TextField
	private JTextField registrationemailtf;
	private JTextField registrationnametf;
	private JTextField loginemailtf;
	private JTextField registrationaddresstf;
	private JTextField editemailtf;
	private JTextField editnametf;
	private JTextField editaddresstf;
	private JTextField editpayment1tf;
	private JTextField editpayment2tf;
	private JTextField editpayment3tf;
	private JTextField verifytf;
	private JTextField pwresettf;
	
	//Employee
	private JTextField eloginemailtf;
	private JTextField eloginename;
	private JTextField eregistrationemailtf;
	private JTextField eregistrationnametf;
	private JTextField deleteemailtf;
	private JTextField deletenametf;
	private JTextField deletepwpf;
	private JTextField deleteemailtf2;
	private JTextField deletenametf2;
	private JTextField deletepwpf2;
	private JTextField tochnagename1;
	private JTextField tochangenameemail1;
	private JTextField tochangenameinto1;
	private JTextField tochangeemailname1 ;
	private JTextField tochnageemail1 ;
	private JTextField tochangeemailinto1 ;
	private JTextField tochangepasswordemail1 ;
	private JTextField tochangepasswordname1;
	private JTextField tochnagename1admin;
	private JTextField tochangenameemail1admin;
	private JTextField tochangenameinto1admin;
	private JTextField tochangeemailname1admin ;
	private JTextField tochnageemail1admin ;
	private JTextField tochangeemailinto1admin ;
	private JTextField tochangepasswordemail1admin ;
	private JTextField tochangepasswordname1admin;
	
	//EmployeeEvent
	private JTextField deleteEventTextField;
	private JTextField showEventTextField;
	private JTextField createEventTextFieldname;
	private JTextField createEventTextFieldday;
	private JTextField createEventTextFieldmonth;
	private JTextField createEventTextFieldyear;
	private JTextField createEventTextFieldeventText;
	private JTextField createEventTextFieldlocation;
	private JTextField createEventTextFieldvenueName;
	private JTextField createEventTextFieldgenre;
	private JTextField createEventTextFieldartist;
	private JTextField createEventTextFieldnumberOfCategories;
	private JTextField createCategotieTextFieldname;
	private JTextField createCategotieTextFieldseats;
	private JTextField createCategotieTextFieldprice;
	private JTextField createCategotieTextFieldrelativediscount;
	private JTextField createCategotieTextFieldabsolutelydiscount;
	
	//Custevent
	private JTextField searchForEventsTextField;
	private JTextField returnTicketTextField;
	
	//Custevent
	//Dropdown Menue (ComboBox)
	private JComboBox searchComboBox;
	private JComboBox sortComboBox;
	private JComboBox sortComboBox2;
	//JList
	private JList searchEventsList;
	private JList showAvailableTicketsList;
	private JList returnTicketList;	
	
	//Scroller
	private JScrollPane showAvailableTicketsScroller;
		
	private String aspect = "Name";
	private String sortBy = "Alphabet";
	private String wayToSort = "aufsteigend";
	private static int selectedEventID;
	ArrayList<String> eventIDs = new ArrayList<String>();
	private String[] eventArray;
	
	private int chosenSeatNum;
	private String chosenCategorie;
	private double finalPrice;
		
	//Textarea
	private JTextArea showEventsInTextArea;
	//Dropdown Menue (ComboBox) EmployeeEvent
	private JComboBox changeComboBox;
	private JComboBox showEventComboBox;

	
	//PasswordField
	private JPasswordField registrationpwpf;
	private JPasswordField loginpwpf;
	private JPasswordField editpwpf;
	
	//Employee
	private JPasswordField eloginpwpf;
	private JPasswordField eregistrationpwpf;
	private JPasswordField tochangenamepassword1;
	private JPasswordField tochangepassword1 ;
	private JPasswordField tochangepasswordinto1 ;
	private JPasswordField tochangeemailpassword1;
	private JPasswordField tochangenamepassword1admin;
	private JPasswordField tochangepassword1admin ;
	private JPasswordField tochangepasswordinto1admin ;
	private JPasswordField tochangeemailpassword1admin;
	
	//Dialog
	private JDialog errregistration;
	private JDialog	errlogin;
	
	//Employee
	private JDialog eerrlogin;
	private JDialog eerrregistration;
	private JDialog success;
	private JDialog deletesuccess;
	private JDialog createsuccess;
	
	//Event
	private JDialog createCategoriessuccess;
	
	//Mainview label + text
	private JLabel custdataLabel;
	private JLabel emailLabel;
	private JTextField emailText;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel adressLabel;
	private JTextField adressText;
	private JLabel paymentLabel;
	private JTextField paymentText;
	private JLabel buySuccess;
	
	private static String name, adress, payment,email	= "";
	private static String namereg,adressreg,paymentreg,emailreg = "";

	public view() {
		//Fenster deklarieren und Beschreibung des Fensters
		window = new JFrame("funfactory");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(20, 20);
		window.setSize(1500, 800);
		window.setVisible(true);
		
		mainview = new JPanel();
		registrationview = new JPanel();
		loginview = new JPanel();
		custview= new JPanel();
		custaccview = new JPanel();
		verifyview = new JPanel();
		resetpwview = new JPanel();
		
		//Employee
		employeeloginview = new JPanel();
		employeeview = new JPanel();
		adminview = new JPanel();
		deleteemployeeadminview = new JPanel ();
		employeeregisterview = new JPanel();
		employeeeditview = new JPanel();
		deleteemployeesuccess = new JPanel();
		deleteemployeeview = new JPanel();
		employeeeditpasswordview = new JPanel();
		employeeeditemailview = new JPanel();
		employeeeditnameview = new JPanel ();
		employeeeditpasswordadminview = new JPanel();
		employeeeditemailadminview = new JPanel();
		employeeeditnameadminview = new JPanel ();
		employeeeditadminview = new JPanel ();
		
		//EmployeeEvent
		mainviewEvent = new JPanel();
		createEventView = new JPanel();
		deleteEventView = new JPanel();
		showEventView = new JPanel();
		changeEventView = new JPanel();
		createCategoriesView = new JPanel();
		
		//Custevent
		mainEventsCustomerView = new JPanel();
		searchEventsCustomerView = new JPanel();
		showAvailableTicketsCustomerView = new JPanel();
		payEventCustomerView = new JPanel();
		returnTicketsCustomerView = new JPanel();
		
		mainview.setBackground(Color.white);
		mainview.setLayout(null);
		registrationview.setBackground(Color.gray);
		registrationview.setLayout(null);
		window.add(registrationview);
		loginview.setBackground(Color.gray);
		loginview.setLayout(null);
		custview.setBackground(Color.white);
		custview.setLayout(null);
		custaccview.setBackground(Color.gray);
		custaccview.setLayout(null);
		verifyview.setBackground(Color.gray);
		verifyview.setLayout(null);
		resetpwview.setBackground(Color.gray);
		resetpwview.setLayout(null);
		
		//Employee
		employeeloginview.setBackground(Color.gray);
		employeeloginview.setLayout(null);
		employeeview.setBackground(Color.gray);
		employeeview.setLayout(null);
		adminview.setBackground(Color.gray);
		adminview.setLayout(null);
		deleteemployeeadminview.setBackground(Color.gray);
		deleteemployeeadminview.setLayout(null);
		employeeregisterview.setBackground(Color.gray);
		employeeregisterview.setLayout(null);
		employeeeditview.setBackground(Color.gray);
		employeeeditview.setLayout(null);
		deleteemployeesuccess.setBackground(Color.gray);
		deleteemployeesuccess.setLayout(null);
		deleteemployeeview.setBackground(Color.gray);
		deleteemployeeview.setLayout(null);
		employeeeditpasswordview.setBackground(Color.gray);
		employeeeditpasswordview.setLayout(null);
		employeeeditemailview.setBackground(Color.gray);
		employeeeditemailview.setLayout(null);
		employeeeditnameview.setBackground(Color.gray);
		employeeeditnameview.setLayout(null);
		employeeeditpasswordadminview.setBackground(Color.gray);
		employeeeditpasswordadminview.setLayout(null);
		employeeeditemailadminview.setBackground(Color.gray);
		employeeeditemailadminview.setLayout(null);
		employeeeditnameadminview.setBackground(Color.gray);
		employeeeditnameadminview.setLayout(null);
		employeeeditadminview.setBackground(Color.gray);
		employeeeditadminview.setLayout(null);
		
		//EmployeeEvent
		mainviewEvent.setBackground(Color.white);
		mainviewEvent.setLayout(null);
		createEventView.setBackground(Color.white);
		createEventView.setLayout(null);
		deleteEventView.setBackground(Color.white);
		deleteEventView.setLayout(null);
		showEventView.setBackground(Color.white);
		showEventView.setLayout(null);
		changeEventView.setBackground(Color.white);
		changeEventView.setLayout(null);
		createCategoriesView.setBackground(Color.white);
		createCategoriesView.setLayout(null);
		
		//Custevent
		mainEventsCustomerView.setBackground(Color.white);
		mainEventsCustomerView.setLayout(null);
		searchEventsCustomerView.setBackground(Color.white);
		searchEventsCustomerView.setLayout(null);
		showAvailableTicketsCustomerView.setBackground(Color.white);
		showAvailableTicketsCustomerView.setLayout(null);
		payEventCustomerView.setBackground(Color.white);
		payEventCustomerView.setLayout(null);
		returnTicketsCustomerView.setBackground(Color.white);
		returnTicketsCustomerView.setLayout(null);

		//Einrichtung des Cardlayout, um Panels hinzuzufgen
		JPanel cards = new JPanel(new CardLayout());
		cards.add(mainview, "mainview");
		cards.add(registrationview,"registrationview");
		cards.add(loginview, "loginview");
		cards.add(custview, "custview");
		cards.add(custaccview, "custaccview");
		cards.add(verifyview, "verifyview");
		cards.add(resetpwview, "resetpwview");
		//Employee
		cards.add(employeeloginview,"employeeloginview");
		cards.add(employeeview, "employeeview");					
		cards.add(adminview,"adminview");
		cards.add(deleteemployeeadminview,"deleteemployeeadminview");
		cards.add(employeeregisterview,"employeeregisterview");
		cards.add(employeeeditview,"employeeeditview");
		cards.add(deleteemployeeview,"deleteemployeeview");
		cards.add(deleteemployeesuccess,"deleteemployeesuccess");
		cards.add(employeeeditemailview,"employeeeditemailview");
		cards.add(employeeeditpasswordview,"employeeeditpasswordview");
		cards.add(employeeeditnameview,"employeeeditnameview");
		cards.add(employeeeditemailadminview,"employeeeditemailadminview");
		cards.add(employeeeditpasswordadminview,"employeeeditpasswordadminview");
		cards.add(employeeeditnameadminview,"employeeeditnameadminview");
		cards.add(employeeeditadminview,"employeeeditadminview");
		//EmployeeEvent
		cards.add(mainviewEvent, "mainviewEvent");
		cards.add(createEventView,"createEventView");
		cards.add(deleteEventView, "deleteEventView");
		cards.add(showEventView, "showEventView");
		cards.add(changeEventView, "changeEventView");
		cards.add(createCategoriesView, "createCategoriesView");
		//Custevent
		cards.add(mainEventsCustomerView, "mainEventsCustomerView");
		cards.add(searchEventsCustomerView,"searchEventsCustomerView");
		cards.add(showAvailableTicketsCustomerView, "showAvailableTicketsCustomerView");
		cards.add(payEventCustomerView, "payEventCustomerView");
		cards.add(returnTicketsCustomerView, "returnTicketsCustomerView");
		
		// Card Container zum Frame hinzufgen
		Container pane = window.getContentPane();
		pane.add(cards);

		//mainview
		toregistration = new JButton("Registrierung");
		toregistration.setBounds(400, 300, 190, 25);
		mainview.add(toregistration);
		
		
		toEventtCustomer = new JButton("Veranstaltungen");
		toEventtCustomer.setBounds(600, 300, 190, 25);
		mainview.add(toEventtCustomer);
	
		tologin = new JButton("Anmeldung");
		tologin.setBounds(800, 300, 190, 25);
		mainview.add(tologin);

		toregistration.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent e) {
				// setzt die Registrierungsseite nach vorn
		        CardLayout cl = (CardLayout)(cards.getLayout());
		        cl.show(cards, "registrationview");
		    }       
		});
	
		tologin.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// setzt die Anmeldeanseite nach vorn
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "loginview");
			}       
		});
		
		toEventtCustomer.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "mainEventsCustomerView");
			}       
		});
		
		//Eingabe von Informationen fr den Kauf von Tickets
		custdataLabel = new JLabel("Kundendaten (falls nicht angemeldet):");
		custdataLabel.setBounds(10, 300, 300, 25);
		payEventCustomerView.add(custdataLabel);
				
		emailLabel = new JLabel("E-Mail");
		emailLabel.setBounds(10, 350, 170, 25);
		payEventCustomerView.add(emailLabel);
				
		emailText = new JTextField();
		emailText.setBounds(190, 350, 230, 25);
		payEventCustomerView.add(emailText);
		emailText.setColumns(10);
				
		nameLabel = new JLabel("*Name (Vorname Nachname)");
		nameLabel.setBounds(10, 380, 170, 25);
		payEventCustomerView.add(nameLabel);
				
		nameText = new JTextField();
		nameText.setBounds(190, 380, 230, 25);
		payEventCustomerView.add(nameText);
		nameText.setColumns(10);
				
		adressLabel = new JLabel("*Adresse");
		adressLabel.setBounds(10, 410, 170, 25);
		payEventCustomerView.add(adressLabel);
				
		adressText = new JTextField();
		adressText.setBounds(190, 410, 230, 25);
		payEventCustomerView.add(adressText);
		adressText.setColumns(10);
				
		paymentLabel = new JLabel("*Banknummer:");
		paymentLabel.setBounds(10, 440, 170, 25);
		payEventCustomerView.add(paymentLabel);
				
		paymentText = new JTextField();
		paymentText.setBounds(190, 440, 230, 25);
		payEventCustomerView.add(paymentText);
					
		
		//Kaufbestaeaetigung Gast
		buySuccess = new JLabel("");
		buySuccess.setBounds(260,280,300,25);
		mainview.add(buySuccess);
		
		
		//Registrierungsansicht
		registrationback = new JButton("<-");
		registrationback.setBounds(20, 20, 100, 25);
		registrationview.add(registrationback);
		
		registrationemaill = new JLabel("E-Mail");
		registrationemaill.setBounds(20, 100, 300, 25);
		registrationview.add(registrationemaill);

		registrationpwl = new JLabel("Passwort");
		registrationpwl.setBounds(20, 150, 300, 25);
		registrationview.add(registrationpwl);
		
		registrationnamel = new JLabel("*Name(Vorname Nachname)");
		registrationnamel.setBounds(20, 200, 300, 25);
		registrationview.add(registrationnamel);
		
		registrationaddressl = new JLabel("*Adresse");
		registrationaddressl.setBounds(20, 250, 300, 25);
		registrationview.add(registrationaddressl);
		
		registrationoptionall = new JLabel("*Mit Stern markierte Angaben sind optional.");
		registrationoptionall.setBounds(20, 300, 300, 25);
		registrationview.add(registrationoptionall);

		registrationemailtf = new JTextField();
		registrationemailtf.setBounds(500, 100, 300, 25);
		registrationview.add(registrationemailtf);

		registrationpwpf = new JPasswordField();
		registrationpwpf.setBounds(500, 150, 300, 25);
		registrationview.add(registrationpwpf);
		
		registrationnametf = new JTextField();
		registrationnametf.setBounds(500, 200, 300, 25);
		registrationview.add(registrationnametf);
		
		registrationaddresstf = new JTextField();
		registrationaddresstf.setBounds(500, 250, 300, 25);
		registrationview.add(registrationaddresstf);
		
		registration = new JButton("registrieren");
		registration.setBounds(320, 350, 130, 25);
		registrationview.add(registration);
		
		errregistrationl = new JLabel("   E-Mail existiert bereits!");
		errregistrationl.setBounds(30, 30, 100, 25);
		
		errregistration = new JDialog();
		errregistration.setTitle("Fehler");
		errregistration.setLocation(650, 350);		
		errregistration.setSize(200, 100);
		errregistration.setModal(true);
		errregistration.add(errregistrationl);
		errregistration.setVisible(false);
		
		registrationerrl = new JLabel();
		registrationerrl.setBounds(300, 400, 200, 25);
		registrationview.add(registrationerrl);
		
		registrationback.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				registrationerrl.setText("");
				// setzt die Hauptseite nach vorne
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "mainview");
	    	}       
		});		
		
	
		registration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// speichert den eingebenen String in die Variable name
				String name = registrationnametf.getText();
				// wenn das Textfeld fuer die E-Mail leer ist gib eine Fehlermeldung aus
				if(registrationemailtf.getText().isEmpty()) {
					registrationerrl.setText("Bitte geben Sie Ihre E-Mail ein.");
				} else {
					// wenn das Textfeld fuer das Passwort leer ist gib eine Fehlermeldung aus
					if(String.valueOf(registrationpwpf.getPassword()).isEmpty()) {
						registrationerrl.setText("Bitte geben Sie Ihr Passwort ein.");
					// sonst speicher die eingegebenen Daten auf VAriablen
					} else {
						String email = registrationemailtf.getText();
						char[] password = registrationpwpf.getPassword();
						String address = registrationaddresstf.getText();
						Customerlist clist = new Customerlist(pathcustomerlist);
						// Wenn die E-Mail nicht schon registirert ist,...
						if(clist.checkemail(email)) {
							// ist die Registration erfolgreich und setzt die Textfelder zurueck und geht zur Hauptseite zurueck
							clist.registration(email, name, password, address);
							CardLayout cl = (CardLayout)(cards.getLayout());
							cl.show(cards, "mainview");
							registrationnametf.setText("");
							registrationemailtf.setText("");
							registrationpwpf.setText("");
							registrationaddresstf.setText("");
							registrationerrl.setText("");
						// sonst gib eine Fehlermeldung aus
						} else {
							errregistration.setVisible(true);
						}
					}
				}
			}	
		});
		
		//Anmeldeansicht
		loginback = new JButton("<-");
		loginback.setBounds(20, 20, 100, 25);
		loginview.add(loginback);
		
		elogin = new JButton("Mitarbeiterlogin");
		elogin.setBounds(20, 600, 150, 25);
		loginview.add(elogin);
		
		login = new JButton("anmelden");
		login.setBounds(150, 220, 100, 25);
		loginview.add(login);
		
		pwreset = new JButton("Passwort vergessen");
		pwreset.setBounds(300, 220, 150, 25);
		loginview.add(pwreset);
	
		loginemaill = new JLabel("E-Mail");
		loginemaill.setBounds(20, 100, 200, 25);			
		loginview.add(loginemaill);

		loginpwl = new JLabel("Passwort");
		loginpwl.setBounds(20, 150, 200, 25);		
		loginview.add(loginpwl);
		
		loginemailtf = new JTextField();
		loginemailtf.setBounds(200, 100, 300, 25);		
		loginview.add(loginemailtf);
		
		loginpwpf = new JPasswordField();
		loginpwpf.setBounds(200, 150, 300, 25);	
		loginview.add(loginpwpf);

		errloginl = new JLabel("   Anmeldung fehlgeschlagen!");
		
		errlogin = new JDialog();
		errlogin.setTitle("Fehler");
		errlogin.setLocation(650, 350);		
		errlogin.setSize(200, 100);
		errlogin.setModal(true);
		errlogin.add(errloginl);
		errlogin.setVisible(false);
		
		loginback.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// setzt die Hauptseite nach vorn
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "mainview");
	    	}       
		});	
		
		elogin.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// setzt die Mitarbeiter-Login Sicht nach vorne
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "employeeloginview");
	    	}       
		});
		
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// speichert eingegebenen Werte auf Variablen
				String email = loginemailtf.getText();
				char[] pw = loginpwpf.getPassword();
				Customerlist clist = new Customerlist(pathcustomerlist);
				// Überpruefe, ob E-Mail und Passwort richtig eingeben worden sind und in der Datenbank existiert
				if(clist.checklogin(email, String.valueOf(pw))) {
					// Überpruefe, ob das Konto verifirziert ist
					if(clist.checkverified(email, String.valueOf(pw))) {
						// wenn ja, setze in der Kundenkontoseite alle Daten vom angemeldeten Konto und setze die Kundenansicht nach vorn
						editemailtf.setText(clist.getCustEmail(email));
						editpwpf.setText(clist.getCustPassword(email));
						editaddresstf.setText(clist.getCustAddress(email));
						editnametf.setText(clist.getCustName(email));
						if(clist.getCustPayment(email)[0].equals("null")) {
							editpayment1tf.setText("");
						} else {
							editpayment1tf.setText(clist.getCustPayment(email)[0]);
						}
						if(clist.getCustPayment(email)[1].equals("null")) {
							editpayment2tf.setText("");
						} else {
							editpayment2tf.setText(clist.getCustPayment(email)[1]);
						}
						if(clist.getCustPayment(email)[2].equals("null")) {
							editpayment3tf.setText("");
						} else {
							editpayment3tf.setText(clist.getCustPayment(email)[2]);
						}
						//Customer Daten
	    				emailreg = editemailtf.getText();
	    				namereg = editnametf.getText();
	    				adressreg = editaddresstf.getText();
	    				if(editpayment1tf.getText()!= "") {
	    					paymentreg = editpayment1tf.getText();
	    				}
	    				else if(editpayment2tf.getText()!="") {
	    					paymentreg = editpayment2tf.getText();
	    				}
	    				else {
	    					paymentreg = editpayment3tf.getText();
	    				}
	    				
						CardLayout cl = (CardLayout)(cards.getLayout());
						cl.show(cards, "custview");	
					// sonst gehe zur Verifizierungsasicht					
					} else {
						CardLayout cl = (CardLayout)(cards.getLayout());
						cl.show(cards, "verifyview");	
					}
				// sonst gib eine Fehlermeldung aus
				} else {
					errlogin.setVisible(true);
				}
			}
		});
		
		pwreset.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// setze die Passwortzuruecksetzenseite nach vorn
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "resetpwview");
	    	}       
		});	
		
		//Kundenansicht	
		logout = new JButton("abmelden");
		logout.setBounds(1300, 20, 130, 25);
		custview.add(logout);
	
		toCustAcc = new JButton("Konto");
		toCustAcc.setBounds(1150, 20, 130, 25);
		custview.add(toCustAcc);
		
		toevents = new JButton("Veranstaltungen");
		toevents.setBounds(1000, 20, 130, 25);
		custview.add(toevents);
		
		toevents.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "mainEventsCustomerView");
				loginemailtf.setText("");
				loginpwpf.setText("");
			}
		});
		
		logout.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// setze die Hauptseite nach vorn und setze die Textfelder in der Anmeldeseite und Kundenkontoseite zurueck
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "mainview");
				loginemailtf.setText("");
				loginpwpf.setText("");
				editemailtf.setText("");
				editnametf.setText("");
				editpwpf.setText("");
				editaddresstf.setText("");
				editpayment1tf.setText("");
				editpayment2tf.setText("");
				editpayment3tf.setText("");
			}
		});
		
		toCustAcc.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// setze die Kundenkontoseite nach vorn
				Customerlist clist = new Customerlist(pathcustomerlist);	
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "custaccview");
	    	}       
		});	
		
		//Kundenkontoansicht
		custaccviewback = new JButton("<-");
		custaccviewback.setBounds(20, 20, 100, 25);
		custaccview.add(custaccviewback);
		
		editsave = new JButton("speichern");
		editsave.setBounds(200, 450, 100, 25);
		custaccview.add(editsave);
		
		deleteAcc = new JButton("Konto loeschen");
		deleteAcc.setBounds(400, 450, 200, 25);
		custaccview.add(deleteAcc);
		
		editemaill = new JLabel("E-Mail");
		editemaill.setBounds(20, 100, 300, 25);
		custaccview.add(editemaill);
		
		editnamel = new JLabel("Name(Vorname Nachname)");
		editnamel.setBounds(20, 150, 300, 25);
		custaccview.add(editnamel);
		
		editpwl = new JLabel("Passwort");
		editpwl.setBounds(20, 200, 300, 25);
		custaccview.add(editpwl);
		
		editaddressl = new JLabel("Adresse");
		editaddressl.setBounds(20, 250, 300, 25);
		custaccview.add(editaddressl);
		
		editpayment1l = new JLabel("Zahlungsart 1");
		editpayment1l.setBounds(20, 300, 300, 25);
		custaccview.add(editpayment1l);
		
		editpayment2l = new JLabel("Zahlungsart 2");
		editpayment2l.setBounds(20, 350, 300, 25);
		custaccview.add(editpayment2l);
		
		editpayment3l = new JLabel("Zahlungsart 3");
		editpayment3l.setBounds(20, 400, 300, 25);
		custaccview.add(editpayment3l);
		
		editemailtf = new JTextField();
		editemailtf.setBounds(400, 100, 300, 25);
		custaccview.add(editemailtf);
		
		editnametf = new JTextField();
		editnametf.setBounds(400, 150, 300, 25);
		custaccview.add(editnametf);
		
		editpwpf = new JPasswordField();
		editpwpf.setBounds(400, 200, 300, 25);
		custaccview.add(editpwpf);
		
		editaddresstf = new JTextField();
		editaddresstf.setBounds(400, 250, 300, 25);
		custaccview.add(editaddresstf);
		
		editpayment1tf = new JTextField();
		editpayment1tf.setBounds(400, 300, 300, 25);
		custaccview.add(editpayment1tf);
		
		editpayment2tf = new JTextField();
		editpayment2tf.setBounds(400, 350, 300, 25);
		custaccview.add(editpayment2tf);
		
		editpayment3tf = new JTextField();
		editpayment3tf.setBounds(400, 400, 300, 25);
		custaccview.add(editpayment3tf);
		
		editerrl = new JLabel();
		editerrl.setBounds(300, 500, 200, 25);
		custaccview.add(editerrl);
		
		custaccviewback.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// setze die Kundenansicht nach vorn und setze die Fehlermeldung zurueck
				editerrl.setText("");
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "custview");
			}
		});
		
		editsave.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Customerlist clist = new Customerlist(pathcustomerlist);
				// speichert die alte E-Mail auf eine Variable
				String oldemail = loginemailtf.getText();
				// falls das E-Mail Textfeld leer ist gib eine fehlermeldung aus
				if(editemailtf.getText().isEmpty()) {
					editerrl.setText("Bitte geben Sie Ihre E-Mail ein.");
				} else {
					// falls das Passworttextfeld leer ist gib eine Fehlermeldung aus
					if(String.valueOf(editpwpf.getPassword()).isEmpty()) {
						editerrl.setText("Bitte geben Sie Ihr Passwort ein.");
					} else {
						// speichert eingegebene Werte auf Variablen
						String newemail = editemailtf.getText();
						char[] newpw = editpwpf.getPassword();
						String newname = editnametf.getText();
						String newaddress = editaddresstf.getText();
						String bd1 = editpayment1tf.getText();
						String bd2 = editpayment2tf.getText();
						String bd3 = editpayment3tf.getText();	
						if(bd1.length() == 0) {
							bd1 = null;
						}
						if(bd2.length() == 0) {
							bd2 = null;
						}
						if(bd3.length() == 0) {
							bd3 = null;
						}
						// wenn die E-Mail nicht veraendert wurde
						if(oldemail.equals(newemail)) {
							// aendere die Daten in der Textdatei
							clist.setCustPassword(newemail, newpw);
							clist.setCustName(newemail, newname);
							clist.setCustAddress(newemail, newaddress);
							clist.setCustPayment(newemail, bd1, bd2, bd3);
							loginpwpf.setText(String.valueOf(newpw));
							editerrl.setText("gespeichert");
						// sonst...
						} else {
							// Überpruefe zuerst, ob die neue E-Mail von jemand anderem genutzt wird
							if(clist.checkemail(newemail)) {
								// wenn nein, aendere die Daten in der Textdatei
								clist.setCustEmail(oldemail, newemail);
								clist.setCustPassword(newemail, newpw);
								clist.setCustName(newemail, newname);
								clist.setCustAddress(newemail, newaddress);
								clist.setCustPayment(newemail, bd1, bd2, bd3);
								loginemailtf.setText(newemail);
								loginpwpf.setText(String.valueOf(newpw));
								editerrl.setText("gespeichert");
							// sonst gib eine Fehlermeldung aus
							}else {
								errregistration.setVisible(true);
							}
						}
					}
				}		
			}
		});
		
		deleteAcc.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// speichert eingegebene Werte auf Variablen
				String email = loginemailtf.getText();
				Customerlist clist = new Customerlist(pathcustomerlist);
				loginemailtf.setText("");
				loginpwpf.setText("");
				// loescht den Account(in der Textdatei) und wechselt zu der Anmeldeseite
				clist.deleteacc(email);
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "loginview");
			}
		});
		
		//Verifizierungsansicht
		verifyback = new JButton("<-");
		verifyback.setBounds(20, 20, 100, 25);
		verifyview.add(verifyback);
		
		verifyl = new JLabel("Verifizierungscode eingeben");
		verifyl.setBounds(665, 300, 300, 25);
		verifyview.add(verifyl);
		
		verifytf = new JTextField();
		verifytf.setBounds(695, 325, 100, 25);
		verifyview.add(verifytf);
		
		verifyok = new JButton("OK");
		verifyok.setBounds(695, 375, 100, 25);
		verifyview.add(verifyok);
		
		verifyback.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// setze die Anmeldeseite nach vorn und setzt die Textfelder dort zurueck
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "loginview");
				loginemailtf.setText("");
				loginpwpf.setText("");
			}
		});
		
		verifyok.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// speichert eingegebene Werte auf Variablen
				String email = loginemailtf.getText();
				char[] pw = loginpwpf.getPassword();
				String vcode = verifytf.getText();
				Customerlist clist = new Customerlist(pathcustomerlist);
				// Überprueft ob der eingebenene Verifizierungscode mit dem Konto uebereinstimmt
				if(clist.checkvcode(email, String.valueOf(pw), vcode)) {
					// wenn ja setze die Daten in der Kundenkontoseite auf die passenden Daten und wechsel zu Kundenansicht
					editemailtf.setText(clist.getCustEmail(email));
					editpwpf.setText(clist.getCustPassword(email));
					editaddresstf.setText(clist.getCustAddress(email));
					editnametf.setText(clist.getCustName(email));
					if(clist.getCustPayment(email)[0].equals("null")) {
						editpayment1tf.setText("");
					} else {
						editpayment1tf.setText(clist.getCustPayment(email)[0]);
					}
					if(clist.getCustPayment(email)[1].equals("null")) {
						editpayment2tf.setText("");
					} else {
						editpayment2tf.setText(clist.getCustPayment(email)[1]);
					}
					if(clist.getCustPayment(email)[2].equals("null")) {
						editpayment3tf.setText("");
					} else {
						editpayment3tf.setText(clist.getCustPayment(email)[2]);
					}
					//Customer Daten
    				emailreg = editemailtf.getText();
    				namereg = editnametf.getText();
    				adressreg = editaddresstf.getText();
    				if(editpayment1tf.getText()!= "") {
    					paymentreg = editpayment1tf.getText();
    				}
    				else if(editpayment2tf.getText()!="") {
    					paymentreg = editpayment2tf.getText();
    				}
    				else {
    					paymentreg = editpayment3tf.getText();
    				}
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "custview");	
					verifytf.setText("");
				// sonst gib eine Fehlermeldung aus
				} else {
					errlogin.setVisible(true);
					
				}
			}
		});
	
		
		//Passwortzuruecksetzen Ansicht
		pwresetback = new JButton("<-");
		pwresetback.setBounds(20, 20, 100, 25);
		resetpwview.add(pwresetback);
		
		sendpwreset = new JButton("Passwort zuruecksetzen");
		sendpwreset.setBounds(650, 380, 200, 25);
		resetpwview.add(sendpwreset);
		
		pwresetl = new JLabel("Geben Sie Ihre E-Mail ein");
		pwresetl.setBounds(665, 300, 300, 25);
		resetpwview.add(pwresetl);
		
		pwresettf = new JTextField();
		pwresettf.setBounds(695, 325, 100, 25);
		resetpwview.add(pwresettf);	
		
		pwresetback.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// setze die Anmeldeseite nach vorn und setze das Textfeld zurueck
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "loginview");
				pwresettf.setText("");
			}
		});
		
		sendpwreset.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				// speichert eingebene E-Mail auf Variable
				String email = pwresettf.getText();
				Customerlist clist = new Customerlist(pathcustomerlist);
				// und setzt das Passwort zurueck, wechselt zur Anmeldeseite und setzt Textfelder zurueck
				clist.resetPassword(email);
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "loginview");
				pwresettf.setText("");
			}
		});
		
		
	//Employeeview Start
		
		
	//Employeelogin
		
	backtomain1 = new JButton("<-");
	backtomain1.setBounds(20, 20, 100, 25);
	employeeloginview.add(backtomain1);
	
	employeelogin = new JButton("anmelden");
	employeelogin.setBounds(50, 300, 100, 25);
	employeeloginview.add(employeelogin);		
	
	eloginemaill = new JLabel("E-Mail");
	eloginemaill.setBounds(20, 100, 200, 25);			
	employeeloginview.add(eloginemaill);

	eloginenname = new JLabel("Name");
	eloginenname.setBounds(20, 150, 200, 25);			
	employeeloginview.add(eloginenname);
	
	eloginpwl = new JLabel("Passwort");
	eloginpwl.setBounds(20, 200, 200, 25);		
	employeeloginview.add(eloginpwl);
	
	eloginemailtf = new JTextField();
	eloginemailtf.setBounds(200, 100, 300, 25);		
	employeeloginview.add(eloginemailtf);
	
	eloginename = new JTextField();
	eloginename.setBounds(200, 150, 300, 25);		
	employeeloginview.add(eloginename);
	
	eloginpwpf = new JPasswordField();
	eloginpwpf.setBounds(200, 200, 300, 25);	
	employeeloginview.add(eloginpwpf);

	eerrloginl = new JLabel("   Anmeldung fehlgeschlagen!");
	
	eerrlogin = new JDialog();
	eerrlogin.setTitle("Fehler");
	eerrlogin.setLocation(650, 350);		
	eerrlogin.setSize(200, 100);
	eerrlogin.setModal(true);
	eerrlogin.add(eerrloginl);
	eerrlogin.setVisible(false);
	
	//Zurueck zum Kunden Loginfenster 
	backtomain1.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "loginview");
    	}       
	});
	
	//Überpruefung von eingegeben Daten in den Textfeldern um eingelogged zu werden
	employeelogin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String eemail = eloginemailtf.getText();
			String epw = eloginpwpf.getText();
			String ename = eloginename.getText();
			try {Employee ADMIN = new Employee("ADMIN","funfactory" ,"1111" );									
			if (eemail.equals(ADMIN.email) && epw.equals(ADMIN.password) && ename.equals(ADMIN.name) ) {		
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "adminview");
				}
			else if(ADMIN.allcheck(ename,eemail,epw) ){
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "employeeview");
			}
			else {
				eerrlogin.setVisible(true);
			}
			}
			catch (IOException e2) {				
			}
		}				
			}
	);
	
	//Employee view 
	employeeedit = new JButton("Konto bearbeiten");
	employeeedit.setBounds(20, 150, 300, 25);
	employeeview.add(employeeedit);
	
	employeeevent = new JButton("Veranstaltung erstellen");
	employeeevent.setBounds(20, 200, 300, 25);
	employeeview.add(employeeevent);
			
	employeelogout = new JButton("Abmelden");
	employeelogout.setBounds(20, 20, 100, 25);
	employeeview.add(employeelogout);
	
	//Employee meldet sich ab und setzt dadurch die Logindaten zurueck
	employeelogout.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeloginview");
			eloginemailtf.setText("");
			eloginpwpf.setText("");
			eloginename.setText("");
    	}       
	});	
	
	//Employee moechte seine Daten aendern wechselt die Ansicht
	employeeedit.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeeditview");
    	}       
	});
	
	//Employee moechte eine Veranstaltung bearbeiter/erstellen/loeschen wechselt die Ansicht 
	employeeevent.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "mainviewEvent");
    	}       
	});
	
	
	
	//Employee Edit view
	
	employeeeditdelet = new JButton("Konto loeschen");
	employeeeditdelet.setBounds(20, 150, 300, 25);
	employeeeditview.add(employeeeditdelet);
	
	employeeeditchangename = new JButton("Name aendern");
	employeeeditchangename.setBounds(20, 250, 300, 25);
	employeeeditview.add(employeeeditchangename);
	
	employeeeditchangeemail = new JButton("Email aendern");
	employeeeditchangeemail.setBounds(20, 300, 300, 25);
	employeeeditview.add(employeeeditchangeemail);
	
	employeeeditchangepassword = new JButton("Password aendern");
	employeeeditchangepassword.setBounds(20, 350, 300, 25);
	employeeeditview.add(employeeeditchangepassword);
	
	employeeeditback = new JButton("<-");
	employeeeditback.setBounds(20, 20, 100, 25);
	employeeeditview.add(employeeeditback);
	
	editsuccess = new JLabel("   Bearbeitung Erfolgreich!");
	
	success = new JDialog();
	success.setTitle("Erfolgreich Bearbeitet");
	success.setLocation(650, 350);		
	success.setSize(200, 100);
	success.setModal(true);
	success.add(editsuccess);
	success.setVisible(false);
	
	//Zurueck zur Employee Ansicht 
	employeeeditback.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeview");
			
    	}       
	});	
	
	//Employee moechte sein Account loeschen wechselt Ansicht
	employeeeditdelet.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "deleteemployeeview");
			
    	}       
	});


	//Employee moechte sein Namen aendern wechselt Ansicht
	employeeeditchangename.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeeditnameview");
			
    	}       
	});	
	
	//Employee moechte seine Email aendern wechselt Ansicht
	employeeeditchangeemail.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeeditemailview");
			
    	}       
	});	
	
	//Employee moechte sein Password aendern wechselt Ansicht
	employeeeditchangepassword.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeeditpasswordview");
			
    	}       
	});	
	
	//Employee Name aendern
	
	editback = new JButton("<-");
	editback.setBounds(20, 20, 100, 25);
	employeeeditnameview.add(editback);
	
	tochangenameemail = new JLabel("E-Mail");
	tochangenameemail.setBounds(20, 100, 300, 25);
	employeeeditnameview.add(tochangenameemail);

	tochangenamepassword = new JLabel("Passwort");
	tochangenamepassword.setBounds(20, 150, 300, 25);
	employeeeditnameview.add(tochangenamepassword);
			
	tochangename = new JLabel("Alter Name(Vorname Nachname)");
	tochangename.setBounds(20, 200, 300, 25);
	employeeeditnameview.add(tochangename);
	
	tochangenameinto = new JLabel("Neuer Name(Vorname Nachname)");
	tochangenameinto.setBounds(20, 250, 300, 25);
	employeeeditnameview.add(tochangenameinto);
							
	tochangenameemail1 = new JTextField();
	tochangenameemail1.setBounds(500, 100, 300, 25);
	employeeeditnameview.add(tochangenameemail1);

	tochangenamepassword1 = new JPasswordField();
	tochangenamepassword1.setBounds(500, 150, 300, 25);
	employeeeditnameview.add(tochangenamepassword1);
			
	tochnagename1 = new JTextField();
	tochnagename1.setBounds(500, 200, 300, 25);
	employeeeditnameview.add(tochnagename1);
	
	tochangenameinto1 = new JTextField();
	tochangenameinto1.setBounds(500, 250, 300, 25);
	employeeeditnameview.add(tochangenameinto1);	
			
	changename = new JButton("Name aendern");
	changename.setBounds(200, 350, 130, 25);
	employeeeditnameview.add(changename);
	
	//Zurueck zur Employee Ansicht
	editback.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeview");
			
    	}       
	});	
	
	//Bei benutzen werden die eingegebenen Daten in den Textfeldern ueberprueft und falls diese Daten richtig sind wird der Name geaendert
	changename.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String oldname = tochnagename1.getText();
			String newname = tochangenameinto1.getText();
			String email = tochangenameemail1.getText();
			String password = tochangenamepassword1.getText();
			try {Employee todelete = new Employee(oldname,email ,password );
				if((todelete.allcheck(oldname,email,password))){
					todelete.deleteEmployee(oldname, email, password);
					todelete.EmployeeList(newname, email, password);
					tochnagename1.setText("");
					tochangenameinto1.setText("");
					tochangenameemail1.setText("");
					tochangenamepassword1.setText("");
					success.setVisible(true);
			}
			else{
				eerrregistration.setVisible(true);
			}}
				catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
			
			
    	});	
	
	
	//Employee Email aendern
	
	editback2 = new JButton("<-");
	editback2.setBounds(20, 20, 100, 25);
	employeeeditemailview.add(editback2);
		
	tochangeemailname = new JLabel("Name");
	tochangeemailname.setBounds(20, 100, 300, 25);
	employeeeditemailview.add(tochangeemailname);

	tochangeemailpassword = new JLabel("Passwort");
	tochangeemailpassword.setBounds(20, 150, 300, 25);
	employeeeditemailview.add(tochangeemailpassword);
					
	tochangeemail = new JLabel("Alte Email");
	tochangeemail.setBounds(20, 200, 300, 25);
	employeeeditemailview.add(tochangeemail);
			
	tochangeemailinto = new JLabel("Neue Email");
	tochangeemailinto.setBounds(20, 250, 300, 25);
	employeeeditemailview.add(tochangeemailinto);
									
	tochangeemailname1 = new JTextField();
	tochangeemailname1.setBounds(500, 100, 300, 25);
	employeeeditemailview.add(tochangeemailname1);

	tochangeemailpassword1 = new JPasswordField();
	tochangeemailpassword1.setBounds(500, 150, 300, 25);
	employeeeditemailview.add(tochangeemailpassword1);
					
	tochnageemail1 = new JTextField();
	tochnageemail1.setBounds(500, 200, 300, 25);
	employeeeditemailview.add(tochnageemail1);
			
	tochangeemailinto1 = new JTextField();
	tochangeemailinto1.setBounds(500, 250, 300, 25);
	employeeeditemailview.add(tochangeemailinto1);
							
	changeemail = new JButton("Email aendern");
	changeemail.setBounds(200, 350, 130, 25);
	employeeeditemailview.add(changeemail);
	
	//Zurueck zur Employee Ansicht
	editback2.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeview");
				}});	
	
	//Bei benutzen werden die eingegebenen Daten in den Textfeldern ueberprueft und falls diese Daten richtig sind wird der Email geaendert
	changeemail.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String oldemail = tochnageemail1.getText();
			String newemail = tochangeemailinto1.getText();
			String name = tochangeemailname1.getText();
			String password = tochangeemailpassword1.getText();
			try {Employee todelete = new Employee(name,oldemail ,password );
				if((todelete.allcheck(name,oldemail,password))){
						todelete.deleteEmployee(name, oldemail, password);
						todelete.EmployeeList(name, newemail, password);
						tochnageemail1.setText("");
						tochangeemailinto1.setText("");
						tochangeemailname1.setText("");
						tochangeemailpassword1.setText("");
						success.setVisible(true);
						}
				else{
					eerrregistration.setVisible(true);
				}}
				catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
					}
					
					
		    	});	
			
			
	//Employee Passwort aendern
			
	editback3 = new JButton("<-");
	editback3.setBounds(20, 20, 100, 25);
	employeeeditpasswordview.add(editback3);
			
	tochangepasswordemail = new JLabel("E-Mail");
	tochangepasswordemail.setBounds(20, 100, 300, 25);
	employeeeditpasswordview.add(tochangepasswordemail);

	tochangepasswordname = new JLabel("Name");
	tochangepasswordname.setBounds(20, 150, 300, 25);
	employeeeditpasswordview.add(tochangepasswordname);
					
	tochangepassword = new JLabel("Altes Password");
	tochangepassword.setBounds(20, 200, 300, 25);
	employeeeditpasswordview.add(tochangepassword);
			
	tochangepasswordinto = new JLabel("Neues Password");
	tochangepasswordinto.setBounds(20, 250, 300, 25);
	employeeeditpasswordview.add(tochangepasswordinto);
									
	tochangepasswordemail1 = new JTextField();
	tochangepasswordemail1.setBounds(500, 100, 300, 25);
	employeeeditpasswordview.add(tochangepasswordemail1);

	tochangepasswordname1 = new JTextField();
	tochangepasswordname1.setBounds(500, 150, 300, 25);
	employeeeditpasswordview.add(tochangepasswordname1);
					
	tochangepassword1 = new JPasswordField();
	tochangepassword1.setBounds(500, 200, 300, 25);
	employeeeditpasswordview.add(tochangepassword1);
			
	tochangepasswordinto1 = new JPasswordField();
	tochangepasswordinto1.setBounds(500, 250, 300, 25);
	employeeeditpasswordview.add(tochangepasswordinto1);
								
	changepassword = new JButton("Password aendern");
	changepassword.setBounds(200, 350, 130, 25);
	employeeeditpasswordview.add(changepassword);
	
	//Zurueck zur Employee Ansicht
	editback3.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeview");
					
		    	}});	
	
	//Bei benutzen werden die eingegebenen Daten in den Textfeldern ueberprueft und falls diese Daten richtig sind wird der Passwort geaendert		
	changepassword.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String oldpassword = tochangepassword1.getText();
			String newpassword = tochangepasswordinto1.getText();
			String email = tochangepasswordemail1.getText();
			String name = tochangepasswordname1.getText();
			try {Employee todelete = new Employee(name,email ,oldpassword );
				if((todelete.allcheck(name,email,oldpassword))){
						todelete.deleteEmployee(name, email, oldpassword);
						todelete.EmployeeList(name, email, newpassword);
						tochangepassword1.setText("");
						tochangepasswordinto1.setText("");
						tochangepasswordemail1.setText("");
						tochangepasswordname1.setText("");
						success.setVisible(true);
					}
				else{
						eerrregistration.setVisible(true);
					}
					}
						catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
					}
					
					
		    	});	
	
	

	
	//ADMIN Ansicht
	adminlogout = new JButton("Abmelden");
	adminlogout.setBounds(20, 20, 100, 25);
	adminview.add(adminlogout);	
	
	switchtoempregister = new JButton("Konto erstellen");
	switchtoempregister.setBounds(200, 350, 130, 25);
	adminview.add(switchtoempregister);
	
	switchtoempedit = new JButton("Konto bearbeiten");
	switchtoempedit.setBounds(600, 350, 130, 25);
	adminview.add(switchtoempedit);
	
	switchtiempldelet = new JButton("Konto loeschen");
	switchtiempldelet.setBounds(400, 350, 130, 25);
	adminview.add(switchtiempldelet);
	
	//Zur Employee erstellen Ansicht
	switchtoempregister.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeregisterview");
    	}       
	});	
	
	//Zur Employee bearbeiten Ansicht
	switchtoempedit.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeeditadminview");
    	}       
	});	
	
	//Zur Employee loeschen Ansicht
	switchtiempldelet.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "deleteemployeeadminview");
    	}       
	});	
	
	//Erstellen von Mitarbeiterkonten
	backadmin2 = new JButton("<-");
	backadmin2.setBounds(20, 20, 100, 25);
	employeeregisterview.add(backadmin2);
			
	eregistrationemaill = new JLabel("E-Mail");
	eregistrationemaill.setBounds(20, 100, 300, 25);
	employeeregisterview.add(eregistrationemaill);

	eregistrationpwl = new JLabel("Passwort");
	eregistrationpwl.setBounds(20, 150, 300, 25);
	employeeregisterview.add(eregistrationpwl);
			
	eregistrationnamel = new JLabel("Name(Vorname Nachname)");
	eregistrationnamel.setBounds(20, 200, 300, 25);
	employeeregisterview.add(eregistrationnamel);
							
	eregistrationemailtf = new JTextField();
	eregistrationemailtf.setBounds(500, 100, 300, 25);
	employeeregisterview.add(eregistrationemailtf);

	eregistrationpwpf = new JPasswordField();
	eregistrationpwpf.setBounds(500, 150, 300, 25);
	employeeregisterview.add(eregistrationpwpf);
			
	eregistrationnametf = new JTextField();
	eregistrationnametf.setBounds(500, 200, 300, 25);
	employeeregisterview.add(eregistrationnametf);			
			
	eregistration = new JButton("Konto erstellen");
	eregistration.setBounds(200, 350, 130, 25);
	employeeregisterview.add(eregistration);
			
	eerrregistrationl = new JLabel("   Fehler!");
	eerrregistrationl.setBounds(30, 30, 100, 25);
			
	eerrregistration = new JDialog();
	eerrregistration.setTitle("Fehler");
	eerrregistration.setLocation(650, 350);		
	eerrregistration.setSize(200, 100);
	eerrregistration.setModal(true);
	eerrregistration.add(eerrregistrationl);
	eerrregistration.setVisible(false);
	
	createesuccess = new JLabel("   Bearbeitung Erfolgreich!");
	
	createsuccess = new JDialog();
	createsuccess.setTitle("Konto Erfolgreich erstellt");
	createsuccess.setLocation(650, 350);		
	createsuccess.setSize(200, 100);
	createsuccess.setModal(true);
	createsuccess.add(createesuccess);
	createsuccess.setVisible(false);
	
	//Zurueck zur ADMIN Ansicht
	backadmin2.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "adminview");
    	}       
	});
	
	//ADMIN meldet sich ab Textfelder werden zurueckgesetzt		
	adminlogout.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeloginview");
			eloginemailtf.setText("");
			eloginpwpf.setText("");
			eloginename.setText("");
    	}       
	});	
	
	//Eingegebene Daten werden ueberprueft ob sie schon vorhanden sind und danach wird ein Mitarbeiterkonto erstellt 
	eregistration.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name = eregistrationnametf.getText();
			String email = eregistrationemailtf.getText();
			String password = eregistrationpwpf.getText();
			try {Employee ADMIN = new Employee("ADMIN","funfactory" ,"1111" );
				if(!(ADMIN.allcheck(name,email,password))){
					Employee newEmployee = new Employee(name,email, password );
					newEmployee.EmployeeList(name, email, password);
					eregistrationnametf.setText("");
					eregistrationemailtf.setText("");
					eregistrationpwpf.setText("");
					createsuccess.setVisible(true);
				}
				else{
					eerrregistration.setVisible(true);
				}
				}
				//}
			 catch (IOException e2) {
				e2.printStackTrace();
			}
	}});

	//Mitarbeiter loeschen (Mitarbeiter Ansicht) 
	employeeeditback2 = new JButton("<-");
	employeeeditback2.setBounds(20, 20, 100, 25);
	deleteemployeeview.add(employeeeditback2);
	
	deleteemail2 = new JLabel("E-Mail");
	deleteemail2.setBounds(20, 100, 300, 25);
	deleteemployeeview.add(deleteemail2);
	
	deletepw2 = new JLabel("Passwort");
	deletepw2.setBounds(20, 150, 300, 25);
	deleteemployeeview.add(deletepw2);
			
	deletename2 = new JLabel("Name(Vorname Nachname)");
	deletename2.setBounds(20, 200, 300, 25);
	deleteemployeeview.add(deletename2);
							
	deleteemailtf2 = new JTextField();
	deleteemailtf2.setBounds(500, 100, 300, 25);
	deleteemployeeview.add(deleteemailtf2);

	deletepwpf2 = new JTextField();
	deletepwpf2.setBounds(500, 150, 300, 25);
	deleteemployeeview.add(deletepwpf2);
			
	deletenametf2 = new JTextField();
	deletenametf2.setBounds(500, 200, 300, 25);
	deleteemployeeview.add(deletenametf2);
	
	finaldeleteemployee2 = new JButton("Konto loeschen");
	finaldeleteemployee2.setBounds(400, 350, 130, 25);
	deleteemployeeview.add(finaldeleteemployee2);
	
	deleteeesuccess = new JLabel("Konto Erfolgreich geloescht");
	
	deletesuccess = new JDialog();
	deletesuccess.setTitle("Konto Erfolgreich geloescht");
	deletesuccess.setLocation(650, 350);		
	deletesuccess.setSize(200, 100);
	deletesuccess.setModal(true);
	deletesuccess.add(deleteeesuccess);
	deletesuccess.setVisible(false);
	
	//Zurueck zur Employee Ansicht
	employeeeditback2.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeview");			
    	}       
	});
	
	//Eingegebene Daten werden ueberprueft ob es dieses Konto gibt danach wird das Konto geloescht und Textfelder zurueckgesetzt
	finaldeleteemployee2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name = deletenametf2.getText();
			String email = deleteemailtf2.getText();
			String password = deletepwpf2.getText();
			try{Employee deleteEmployee = new Employee (name, email, password);
				if(!(deleteEmployee.allcheck(name,email,password))){
					deleteEmployee.deleteEmployee(name, email, password);
					deletenametf2.setText("");
					deleteemailtf2.setText("");
					deletepwpf2.setText("");
					deletesuccess.setVisible(true);
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "mainview");
			}
			else{
				deletesuccess.setVisible(true);
			}}
		 catch (IOException e2) {
			e2.printStackTrace();
		}
			
		}});

	//Mitarbeiter loeschen (ADMIN Ansicht)
	
	backadmin = new JButton("<-");
	backadmin.setBounds(20, 20, 100, 25);
	deleteemployeeadminview.add(backadmin);
	
	deleteemail = new JLabel("E-Mail");
	deleteemail.setBounds(20, 100, 300, 25);
	deleteemployeeadminview.add(deleteemail);
	
	deletepw = new JLabel("Passwort");
	deletepw.setBounds(20, 150, 300, 25);
	deleteemployeeadminview.add(deletepw);
			
	deletename = new JLabel("Name(Vorname Nachname)");
	deletename.setBounds(20, 200, 300, 25);
	deleteemployeeadminview.add(deletename);
							
	deleteemailtf = new JTextField();
	deleteemailtf.setBounds(500, 100, 300, 25);
	deleteemployeeadminview.add(deleteemailtf);

	deletepwpf = new JTextField();
	deletepwpf.setBounds(500, 150, 300, 25);
	deleteemployeeadminview.add(deletepwpf);
			
	deletenametf = new JTextField();
	deletenametf.setBounds(500, 200, 300, 25);
	deleteemployeeadminview.add(deletenametf);
	
	finaldeleteemployee = new JButton("Konto loeschen");
	finaldeleteemployee.setBounds(400, 350, 130, 25);
	deleteemployeeadminview.add(finaldeleteemployee);		
	
	//Zurueck zur ADMIN Ansicht
	backadmin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "adminview");			
    	}       
	});
	
	//Eingegebene Daten werden ueberprueft ob es dieses Konto gibt danach wird das Konto geloescht und Textfelder zurueckgesetzt
	finaldeleteemployee.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name = deletenametf.getText();
			String email = deleteemailtf.getText();
			String password = deletepwpf.getText();
			try{Employee deleteEmployee = new Employee (name, email, password);
				if((deleteEmployee.allcheck(name,email,password))){
					deleteEmployee.deleteEmployee(name, email, password);
					deletenametf.setText("");
					deleteemailtf.setText("");
					deletepwpf.setText("");
					deletesuccess.setVisible(true);
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "adminview");
			}
				else{
					eerrregistration.setVisible(true);
				}}
		 catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
			
		}});
	
	//Mitarbeiterkonto bearbeiten(ADMIN Ansicht)
	
	employeeeditchangenameadmin = new JButton("Name aendern");
	employeeeditchangenameadmin.setBounds(20, 250, 300, 25);
	employeeeditadminview.add(employeeeditchangenameadmin);
	
	employeeeditchangeemailadmin = new JButton("Email aendern");
	employeeeditchangeemailadmin.setBounds(20, 300, 300, 25);
	employeeeditadminview.add(employeeeditchangeemailadmin);
	
	employeeeditchangepasswordadmin = new JButton("Password aendern");
	employeeeditchangepasswordadmin.setBounds(20, 350, 300, 25);
	employeeeditadminview.add(employeeeditchangepasswordadmin);
	
	employeeeditbackadmin = new JButton("<-");
	employeeeditbackadmin.setBounds(20, 20, 100, 25);
	employeeeditadminview.add(employeeeditbackadmin);
	
	//Zurueck zur ADMIN Ansicht
	employeeeditbackadmin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "adminview");
		   }});	
	
	//Mitarbeiter Name aendern Ansicht wechseln
	employeeeditchangenameadmin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeeditnameadminview");			
    	}       
	});
	
	//Mitarbeiter Email aendern Ansicht wechseln
	employeeeditchangeemailadmin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeeditemailadminview");
			
    	}       
	});
	
	//Mitarbeiter Passwort aendern Ansicht wechseln
	employeeeditchangepasswordadmin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeeditpasswordadminview");
		}});	

	
	//Employeeedit Name(ADMIN Ansicht)
	
	editbackadmin = new JButton("<-");
	editbackadmin.setBounds(20, 20, 100, 25);
	employeeeditnameadminview.add(editbackadmin);
			
	tochangenameemailadmin = new JLabel("E-Mail");
	tochangenameemailadmin.setBounds(20, 100, 300, 25);
	employeeeditnameadminview.add(tochangenameemailadmin);

	tochangenamepasswordadmin = new JLabel("Passwort");
	tochangenamepasswordadmin.setBounds(20, 150, 300, 25);
	employeeeditnameadminview.add(tochangenamepasswordadmin);
					
	tochangenameadmin = new JLabel("Alter Name(Vorname Nachname)");
	tochangenameadmin.setBounds(20, 200, 300, 25);
	employeeeditnameadminview.add(tochangenameadmin);
			
	tochangenameintoadmin = new JLabel("Neuer Name(Vorname Nachname)");
	tochangenameintoadmin.setBounds(20, 250, 300, 25);
	employeeeditnameadminview.add(tochangenameintoadmin);
									
	tochangenameemail1admin = new JTextField();
	tochangenameemail1admin.setBounds(500, 100, 300, 25);
	employeeeditnameadminview.add(tochangenameemail1admin);

	tochangenamepassword1admin = new JPasswordField();
	tochangenamepassword1admin.setBounds(500, 150, 300, 25);
	employeeeditnameadminview.add(tochangenamepassword1admin);
					
	tochnagename1admin = new JTextField();
	tochnagename1admin.setBounds(500, 200, 300, 25);
	employeeeditnameadminview.add(tochnagename1admin);
			
	tochangenameinto1admin = new JTextField();
	tochangenameinto1admin.setBounds(500, 250, 300, 25);
	employeeeditnameadminview.add(tochangenameinto1admin);			
					
	changenameadmin = new JButton("Name aendern");
	changenameadmin.setBounds(200, 350, 130, 25);
	employeeeditnameadminview.add(changenameadmin);
	
	//Zurueck zu ADMIN Ansicht
	editbackadmin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "adminview");
					
		   }});	
	
	//Eingegebene Daten werden ueberprueft ob es dieses Konto gibt danach wird der Name geaendert und Textfelder zurueckgesetzt
	changenameadmin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String oldname = tochnagename1admin.getText();
			String newname = tochangenameinto1admin.getText();
			String email = tochangenameemail1admin.getText();
			String password = tochangenamepassword1admin.getText();
			try {Employee todelete = new Employee(oldname,email ,password );
				if((todelete.allcheck(oldname,email,password))){
						todelete.deleteEmployee(oldname, email, password);
						todelete.EmployeeList(newname, email, password);
						tochnagename1admin.setText("");
						tochangenameinto1admin.setText("");
						tochangenameemail1admin.setText("");
						tochangenamepassword1admin.setText("");
						success.setVisible(true);
					}
				else{
					eerrregistration.setVisible(true);
					}}
				catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
						
			}});	
			
			
	//Employeeedit email (ADMIN)
			
	editback2admin = new JButton("<-");
	editback2admin.setBounds(20, 20, 100, 25);
	employeeeditemailadminview.add(editback2admin);
					
	tochangeemailnameadmin = new JLabel("Name");
	tochangeemailnameadmin.setBounds(20, 100, 300, 25);
	employeeeditemailadminview.add(tochangeemailnameadmin);

	tochangeemailpasswordadmin = new JLabel("Passwort");
	tochangeemailpasswordadmin.setBounds(20, 150, 300, 25);
	employeeeditemailadminview.add(tochangeemailpasswordadmin);
							
	tochangeemailadmin = new JLabel("Alte Email");
	tochangeemailadmin.setBounds(20, 200, 300, 25);
	employeeeditemailadminview.add(tochangeemailadmin);
					
	tochangeemailintoadmin = new JLabel("Neue Email");
	tochangeemailintoadmin.setBounds(20, 250, 300, 25);
	employeeeditemailadminview.add(tochangeemailintoadmin);
									
	tochangeemailname1admin = new JTextField();
	tochangeemailname1admin.setBounds(500, 100, 300, 25);
	employeeeditemailadminview.add(tochangeemailname1admin);

	tochangeemailpassword1admin = new JPasswordField();
	tochangeemailpassword1admin.setBounds(500, 150, 300, 25);
	employeeeditemailadminview.add(tochangeemailpassword1admin);
							
	tochnageemail1admin = new JTextField();
	tochnageemail1admin.setBounds(500, 200, 300, 25);
	employeeeditemailadminview.add(tochnageemail1admin);
					
	tochangeemailinto1admin = new JTextField();
	tochangeemailinto1admin.setBounds(500, 250, 300, 25);
	employeeeditemailadminview.add(tochangeemailinto1admin);
										
	changeemailadmin = new JButton("Email aendern");
	changeemailadmin.setBounds(200, 350, 130, 25);
	employeeeditemailadminview.add(changeemailadmin);
	
	//Zurueck zur ADMIN Ansicht
	editback2admin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "adminview");
					  }});		
	
	//Eingegebene Daten werden ueberprueft ob es dieses Konto gibt danach wird die Email geaendert und Textfelder zurueckgesetzt
	changeemailadmin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String oldemail = tochnageemail1admin.getText();
			String newemail = tochangeemailinto1admin.getText();
			String name = tochangeemailname1admin.getText();
			String password = tochangeemailpassword1admin.getText();
			try {Employee todelete = new Employee(name,oldemail ,password );
			if((todelete.allcheck(name,oldemail,password))){
					todelete.deleteEmployee(name, oldemail, password);
					todelete.EmployeeList(name, newemail, password);
					tochnageemail1admin.setText("");
					tochangeemailinto1admin.setText("");
					tochangeemailname1admin.setText("");
					tochangeemailpassword1admin.setText("");
					success.setVisible(true);
						}
			else{
					eerrregistration.setVisible(true);
						}}
		catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
								}
								
							}});	
					
					
	//Employeeedit password (ADMIN)
					
	editback3admin = new JButton("<-");
	editback3admin.setBounds(20, 20, 100, 25);
	employeeeditpasswordadminview.add(editback3admin);
					
	tochangepasswordemailadmin = new JLabel("E-Mail");
	tochangepasswordemailadmin.setBounds(20, 100, 300, 25);
	employeeeditpasswordadminview.add(tochangepasswordemailadmin);

	tochangepasswordnameadmin = new JLabel("Name");
	tochangepasswordnameadmin.setBounds(20, 150, 300, 25);
	employeeeditpasswordadminview.add(tochangepasswordnameadmin);
							
	tochangepasswordadmin = new JLabel("Altes Password");
	tochangepasswordadmin.setBounds(20, 200, 300, 25);
	employeeeditpasswordadminview.add(tochangepasswordadmin);
					
	tochangepasswordintoadmin = new JLabel("Neues Password");
	tochangepasswordintoadmin.setBounds(20, 250, 300, 25);
	employeeeditpasswordadminview.add(tochangepasswordintoadmin);
											
	tochangepasswordemail1admin = new JTextField();
	tochangepasswordemail1admin.setBounds(500, 100, 300, 25);
	employeeeditpasswordadminview.add(tochangepasswordemail1admin);

	tochangepasswordname1admin = new JTextField();
	tochangepasswordname1admin.setBounds(500, 150, 300, 25);
	employeeeditpasswordadminview.add(tochangepasswordname1admin);
							
	tochangepassword1admin = new JPasswordField();
	tochangepassword1admin.setBounds(500, 200, 300, 25);
	employeeeditpasswordadminview.add(tochangepassword1admin);
					
	tochangepasswordinto1admin = new JPasswordField();
	tochangepasswordinto1admin.setBounds(500, 250, 300, 25);
	employeeeditpasswordadminview.add(tochangepasswordinto1admin);					
							
	changepasswordadmin = new JButton("Password aendern");
	changepasswordadmin.setBounds(200, 350, 130, 25);
	employeeeditpasswordadminview.add(changepasswordadmin);
	
	//Zurueck zur ADMIN Ansicht
	editback3admin.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "adminview");	
				   	}});	
	
	//Eingegebene Daten werden ueberprueft ob es dieses Konto gibt danach wird das Passwort geaendert und Textfelder zurueckgesetzt
	changepasswordadmin.addActionListener(new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String oldpassword = tochangepassword1admin.getText();
			String newpassword = tochangepasswordinto1admin.getText();
			String email = tochangepasswordemail1admin.getText();
			String name = tochangepasswordname1admin.getText();
			try {Employee todelete = new Employee(name,email ,oldpassword );
				if((todelete.allcheck(name,email,oldpassword))){
						todelete.deleteEmployee(name, email, oldpassword);
						todelete.EmployeeList(name, email, newpassword);
						tochangepassword1admin.setText("");
						tochangepasswordinto1admin.setText("");
						tochangepasswordemail1admin.setText("");
						tochangepasswordname1admin.setText("");
						success.setVisible(true);
						}
				else{
						eerrregistration.setVisible(true);
						}}
				catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
								}
							}});
	
	//EmployeeEvent Ansicht
	
	createEventButton = new JButton("Veranstaltung erstellen");
	createEventButton.setBounds(600,20,300,25);
	mainviewEvent.add(createEventButton);
	
	deleteEventButton = new JButton("Veranstaltung loeschen");
	deleteEventButton.setBounds(600,55,300,25);
	mainviewEvent.add(deleteEventButton);
	
	showEventButton = new JButton("Veranstaltung anzeigen");
	showEventButton.setBounds(600,90,300,25);
	mainviewEvent.add(showEventButton);
	
	changeEventButton = new JButton("Veranstaltung bearbeiten");
	changeEventButton.setBounds(600,125,300,25);
	mainviewEvent.add(changeEventButton);
	
	//Wechselt zu erstellen von Event Ansicht
	createEventButton.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, "createEventView");
	    }       
	});
	
	//Wechselt zu loeschen von Event Ansicht
	deleteEventButton.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, "deleteEventView");
	    }       
	});
	
	//Wechselt zu anzeigen von Event Ansicht
	showEventButton.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, "showEventView");
	    }       
	});
	
	//Wechselt zu aendern von Event Ansicht
	changeEventButton.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, "changeEventView");
	    }       
	});
	
	backemployee = new JButton("<-");
	backemployee.setBounds(20, 20, 100, 25);
	mainviewEvent.add(backemployee);
	
	//Zurueck zur Employee Ansicht
	backemployee.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	    	CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "employeeview");
	    }       
	});
	
	//EmployeeEvent erstellen Ansicht
	createEventTextFieldname = new JTextField();
	createEventTextFieldname.setBounds(600,100,300,25);
	createEventView.add(createEventTextFieldname);
	
	createEventLabelname = new JLabel("Event Name:");
	createEventLabelname.setBounds(350, 100, 400, 25);
	createEventView.add(createEventLabelname);
	
	createEventTextFieldday = new JTextField();
	createEventTextFieldday.setBounds(600,150,300,25);
	createEventView.add(createEventTextFieldday);
	
	createEventLabelday = new JLabel("Event Tag:");
	createEventLabelday.setBounds(350, 150, 200, 25);
	createEventView.add(createEventLabelday);
	
	createEventTextFieldmonth = new JTextField();
	createEventTextFieldmonth.setBounds(600,200,300,25);
	createEventView.add(createEventTextFieldmonth);
	
	createEventLabelmonth = new JLabel("Event Monat:");
	createEventLabelmonth.setBounds(350, 200, 400, 25);
	createEventView.add(createEventLabelmonth);
	
	createEventTextFieldyear = new JTextField();
	createEventTextFieldyear.setBounds(600,250,300,25);
	createEventView.add(createEventTextFieldyear);
	
	createEventLabelyear = new JLabel("Event Jahr");
	createEventLabelyear.setBounds(350, 250, 400, 25);
	createEventView.add(createEventLabelyear);
	
	createEventTextFieldeventText = new JTextField();
	createEventTextFieldeventText.setBounds(600,300,300,25);
	createEventView.add(createEventTextFieldeventText);
	
	createEventLabeleventText = new JLabel("Event Beschreibung:");				
	createEventLabeleventText.setBounds(350, 300, 400, 25);
	createEventView.add(createEventLabeleventText);
	
	createEventTextFieldlocation = new JTextField();
	createEventTextFieldlocation.setBounds(600,350,300,25);
	createEventView.add(createEventTextFieldlocation);
	
	createEventLabellocation = new JLabel("Event Ort:");
	createEventLabellocation.setBounds(350, 350, 400, 25);
	createEventView.add(createEventLabellocation);
	
	createEventTextFieldvenueName = new JTextField();
	createEventTextFieldvenueName.setBounds(600,400,300,25);
	createEventView.add(createEventTextFieldvenueName);
	
	createEventLabelvenueName = new JLabel("Event Venue Name:");			
	createEventLabelvenueName.setBounds(350, 400, 400, 25);
	createEventView.add(createEventLabelvenueName);			
	
	createEventTextFieldgenre = new JTextField();
	createEventTextFieldgenre.setBounds(600,450,300,25);
	createEventView.add(createEventTextFieldgenre);
	
	createEventLabelgenre = new JLabel("Event Genre:");
	createEventLabelgenre.setBounds(350, 450, 400, 25);
	createEventView.add(createEventLabelgenre);
								
	createEventTextFieldartist = new JTextField();
	createEventTextFieldartist.setBounds(600,500,300,25);
	createEventView.add(createEventTextFieldartist);
	
	createEventLabelartist = new JLabel("Event Kuenstler/innen:");
	createEventLabelartist.setBounds(350, 500, 400, 25);
	createEventView.add(createEventLabelartist);	
	
	createEventTextFieldnumberOfCategories = new JTextField();
	createEventTextFieldnumberOfCategories.setBounds(600,550,300,25);
	createEventView.add(createEventTextFieldnumberOfCategories);
	
	createEventLabelnumberOfCategories = new JLabel("Anzahl der Kategorien:");
	createEventLabelnumberOfCategories.setBounds(350, 550, 400, 25);
	createEventView.add(createEventLabelnumberOfCategories);
	
	createButton = new JButton("Veranstaltung erstellen");
	createButton.setBounds(600,600,300,25);
	createEventView.add(createButton);
	
	createCategoriessuccess1 = new JLabel("		Die Veranstaltung wurde Erfolgreich erstellt!");
	
	createCategoriessuccess = new JDialog();
	createCategoriessuccess.setTitle("Erfolgreich Bearbeitet");
	createCategoriessuccess.setLocation(650, 350);		
	createCategoriessuccess.setSize(400, 200);
	createCategoriessuccess.setModal(true);
	createCategoriessuccess.add(createCategoriessuccess1);
	createCategoriessuccess.setVisible(false);									
	
	//Eingegebene Daten werden gespeichert und Abfragen werden gestellt fuer die Kategorien danach werden die Daten genutzt im eine Veranstaltung erstellen danach Textfelder zurueckgesetzt
	createButton.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	    	String name = createEventTextFieldname.getText();
	    	int day = Integer.parseInt(createEventTextFieldday.getText());
	    	int year = Integer.parseInt(createEventTextFieldyear.getText());
	    	int month = Integer.parseInt(createEventTextFieldmonth.getText());
	    	String eventText = createEventTextFieldeventText.getText();
	    	String location = createEventTextFieldlocation.getText();
	    	String venueName = createEventTextFieldvenueName.getText();
	    	String genre = createEventTextFieldgenre.getText();
	    	String artist = createEventTextFieldartist.getText();
	    	int numberOfCategories = Integer.parseInt(createEventTextFieldnumberOfCategories.getText());;
	    	String categorieView = null;	    	
	    	for(int i=0; i< numberOfCategories; i++){
	    		String categoriename = JOptionPane.showInputDialog("Bitte geben Sie den Namen der Kategorie an.");
	    		String categorieseats = JOptionPane.showInputDialog("Wie viele Sitze gibt es in dieser Kategorie?");
	    		String categorieprice = JOptionPane.showInputDialog("Wie viel kostet ein Sitz in dieser Kategorie?");
	    		String categorierelativediscount = JOptionPane.showInputDialog("Sofern vorhanden, geben Sie bitte den prozentualen Discount der Kategorie in Prozent an.");
	    		String categorieabsolutelydiscount = JOptionPane.showInputDialog("Sofern vorhanden, geben Sie bitte den absoluten Discount der Kategorie an.");
	    		
	            if (categorieView == null){
	                categorieView = categoriename + ";"+ categorieseats+ ";" + categorieprice+ ";" + categorierelativediscount + ";" + categorieabsolutelydiscount;
	               
	            } else{
	                categorieView = categorieView + ";" + categoriename + ";"+ categorieseats+ ";" +categorieprice+ ";" + categorierelativediscount + ";" + categorieabsolutelydiscount;
	            }
	    	}
	    	Event newEvent = new Event(name, day, month, year, eventText, location, venueName, genre, artist,numberOfCategories,categorieView);	
	    	Event.insertEventIntoList(newEvent);
	    	createCategoriessuccess.setVisible(true);
	    	createEventTextFieldname.setText("");
	    	createEventTextFieldday.setText("");
	    	createEventTextFieldyear.setText("");
	    	createEventTextFieldmonth.setText("");
	    	createEventTextFieldeventText.setText("");
	    	createEventTextFieldlocation.setText("");
	    	createEventTextFieldvenueName.setText("");
	    	createEventTextFieldgenre.setText("");
	    	createEventTextFieldartist.setText("");
	    	createEventTextFieldnumberOfCategories.setText("");
	           
	}});
	
	
	
	//EmployeeEvent loeschen Ansicht
	
	deleteEventLabel = new JLabel("Event ID der zu loeschenden Veranstaltung:");
	deleteEventLabel.setBounds(350, 350, 400, 25);
	deleteEventView.add(deleteEventLabel);
	
	deleteButton = new JButton("Veranstaltung loeschen");
	deleteButton.setBounds(1000,600,300,25);
	deleteEventView.add(deleteButton);
	
	deleteEventTextField = new JTextField();
	deleteEventTextField.setBounds(600,350,300,25);
	deleteEventView.add(deleteEventTextField);
	
	//Eingegebene EventID wird genutz um Veranstaltung zu loeschen
	deleteButton.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	    	int EventIDtodelete = Integer.parseInt(deleteEventTextField.getText());
	    	Event.DeleteEvent(EventIDtodelete);												
	        deleteEventTextField.setText("");
	    }       
	});
	
	
	//EmployeeEvent anzeigen Ansicht
	//leere Liste fuer Combobox
	String listOfEvents[] = {""}; 
	
	showEventComboBox = new JComboBox(listOfEvents);
	showEventComboBox.setBounds(500, 100, 400, 25);
	showEventView.add(showEventComboBox);
	
	toupdatelistEvent = new JButton("Veranstaltungs Liste aktualisieren");
	toupdatelistEvent.setBounds(1000,700,300,25);
	showEventView.add(toupdatelistEvent);
	
	
	showEventLabeleventID = new JLabel("Event ID:");
	showEventLabeleventID.setBounds(150, 150, 400, 25);
	showEventView.add(showEventLabeleventID);
	
	showEventLabeldaymonthyear = new JLabel("Datum:");
	showEventLabeldaymonthyear.setBounds(150, 200, 400, 25);
	showEventView.add(showEventLabeldaymonthyear);
	
	showEventLabeleventText = new JLabel("Beschreibung:");
	showEventLabeleventText.setBounds(150, 250, 400, 25);
	showEventView.add(showEventLabeleventText);
	
	showEventLabelLocation = new JLabel("Veranstaltungsort:");
	showEventLabelLocation.setBounds(150, 300, 400, 25);
	showEventView.add(showEventLabelLocation);
	
	showEventLabelvenuename = new JLabel("Venue Name:");
	showEventLabelvenuename.setBounds(150, 350, 400, 25);
	showEventView.add(showEventLabelvenuename);
	
	showEventLabelnumberoftickets = new JLabel("Anzahl der Tickets:");
	showEventLabelnumberoftickets.setBounds(150, 400, 400, 25);
	showEventView.add(showEventLabelnumberoftickets);
	
	showEventLabelgenre = new JLabel("Genre:");
	showEventLabelgenre.setBounds(150, 450, 400, 25);
	showEventView.add(showEventLabelgenre);
	
	showEventLabelartist = new JLabel("Kuenstler/innen:");
	showEventLabelartist.setBounds(150, 500, 400, 25);
	showEventView.add(showEventLabelartist);
	
	showEventLabelnumberofcategories = new JLabel("Anzahl der Kategorien:");
	showEventLabelnumberofcategories.setBounds(150, 550, 400, 25);
	showEventView.add(showEventLabelnumberofcategories);
	
	showEventLabelcategoriemanagement = new JLabel("Kategorien:");
	showEventLabelcategoriemanagement.setBounds(550, 100, 1400, 400);
	showEventView.add(showEventLabelcategoriemanagement);
	
	//Wenn in der ComboBox eine Veranstaltung ausgewaehlt wird werden die Labels mit den jeweiligen Daten der Veranstaltung ueberschrieben
	showEventComboBox.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	    	if(e.getSource()== showEventComboBox) {
	    		String i = showEventComboBox.getSelectedItem().toString();
	    		int eventID = Event.getEventID(i);
	    		showEventLabeleventID.setText("Event ID:"+Integer.toString(eventID));
	    		showEventLabeldaymonthyear.setText("Datum:"+Integer.toString(Event.getDay(eventID))+"."+Integer.toString(Event.getMonth(eventID))+"."+Integer.toString(Event.getYear(eventID)));
	    		showEventLabeleventText.setText("Beschreibung:"+Event.getEventText(eventID));
	    		showEventLabelLocation.setText("Veranstaltungsort:"+Event.getLocation(eventID));
	    		showEventLabelvenuename.setText("Venue Name:"+Event.getVenueName(eventID));
	    		showEventLabelnumberoftickets.setText("Anzahl der Tickets:"+Integer.toString(Event.getNumberOfTickets(eventID)));
	    		showEventLabelgenre.setText("Genre:"+Event.getGenre(eventID));
	    		showEventLabelartist.setText("Kuenstler/innen:"+Event.getArtist(eventID));
	    		showEventLabelnumberofcategories.setText("Anzahl der Kategorien:"+Event.getNumberOfCategories(eventID));
	    		showEventLabelcategoriemanagement.setText("<html>" +Event.showCategories(eventID).replaceAll("\n", "<br/>")+ "</html>");		    				
	    	}   	
	    }       
	});

	//Aktualisieren Veranstaltungen in der ComboBox
	toupdatelistEvent.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	    	int counter = 0 ; 
	    	for (int i = 0; i<showEvents.GetAllEvents().size(); i++){
	    		showEventComboBox.addItem(Event.getName(Integer.parseInt(showEvents.GetAllEvents().get(i))));
    }  }       
	});
	
	
	
	
	
	//EmployeeEvent aendern Ansicht
	changeEventLabel = new JLabel("Event ID der Veranstaltung:");
	changeEventLabel.setBounds(350, 200, 400, 25);
	changeEventView.add(changeEventLabel);
	
	//Liste mit Optionen was veraendert werden soll 
	String comboBoxListe[] = {"Namen aendern", "Tag aendern", "Monat aendern", "Jahr aendern", "Lokation aendern", 
			"Veranstaltungsort aendern", "Anzahl der Tickets aendern", "EventID aendern", "Genre aendern", "Kuenstler aendern", "Kategorie aendern"}; 
	
	changeComboBox = new JComboBox(comboBoxListe);
	changeComboBox.setBounds(500, 100, 400, 25);
	changeEventView.add(changeComboBox);
	
	//Wenn eine Option in der Combobox ausgewaehlt wird dann werden Abfragen gestarten um gewuenschte Aenderung an der Veranstaltung vorzunehmen
	changeComboBox.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	    	if(e.getSource()== changeComboBox ) {
	    		String todo = changeComboBox.getSelectedItem().toString();
	    		if( todo.equals("Namen aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			String newname = JOptionPane.showInputDialog("Bitte geben Sie den neuen Namen ein.");
	    			Event.changeName(EventID, newname);
	    		}
	    		if( todo.equals("Tag aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			int newDay = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie den neuen Tag ein."));
	    			Event.changeDay(EventID, newDay);
	    		}
	    		if( todo.equals("Monat aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			int newMonth = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie den neuen Monat ein."));
	    			Event.changeMonth(EventID, newMonth);
	    		}
	    		if( todo.equals("Jahr aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			int newYear = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie das neue Jahr ein."));
	    			Event.changeYear(EventID, newYear);
	    		}
	    		if( todo.equals("Lokation aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			String newLocation = JOptionPane.showInputDialog("Bitte geben Sie die neue Lokation ein.");
	    			Event.changeLocation(EventID, newLocation);
	    		}
	    		if( todo.equals("Veranstaltungsort aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			String newVenuename = JOptionPane.showInputDialog("Bitte geben Sie den neue Veranstaltungsort ein.");
	    			Event.changeVenueName(EventID, newVenuename);
	    		}
	    		if( todo.equals("Anzahl der Tickets aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			int newVenuename = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die neue Anzahl an Tickets ein."));
	    			Event.changeNumberOfTickets(EventID, newVenuename);
	    		}
	    		if( todo.equals("EventID aendern") ) { 
	    			int oldEventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die alte EventID ein."));
	    			int newEventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die neue EventID ein."));
	    			Event.changeEventID(oldEventID, newEventID);
	    		}
	    		if( todo.equals("Genre aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			String newGenre = JOptionPane.showInputDialog("Bitte geben Sie das neue Genre ein.");
	    			Event.changeGenre(EventID, newGenre);
	    		}
	    		if( todo.equals("Kuenstler aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			String newArtist = JOptionPane.showInputDialog("Bitte geben Sie den/die neue/n Kuenster/innen ein.");
	    			Event.changeGenre(EventID, newArtist);
	    		}
	    		if( todo.equals("Kategorie aendern") ) { 
	    			int EventID = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die EventID ein."));
	    			String categorieName = JOptionPane.showInputDialog("Bitte geben Sie den Namen der Kategorie ein.");
	    			String thingToChange = JOptionPane.showInputDialog("Name,Sitze,Preis,prozentualen Discount,absoluten Discount");
	    			String howToChange = JOptionPane.showInputDialog("Bitte geben Sie die Veraenderung ein.");
	    			Event.changeCategorieManagement(EventID, categorieName,thingToChange,howToChange);
	    		}
	    		
	    	}	
	    }});
	    
	
	
	//Zurueck Buttons fuer jedes Panel in EmployeeEvent Ansicht
	createEventBack = new JButton("Zurueck zum Start");
	createEventBack.setBounds(40,55,200,25);
	showEventBack = new JButton("Zurueck zum Start");
	showEventBack.setBounds(40,55,200,25);
	deleteEventBack = new JButton("Zurueck zum Start");
	deleteEventBack.setBounds(40,55,200,25);
	changeEventBack = new JButton("Zurueck zum Start");
	changeEventBack.setBounds(40,55,200,25);
	
	createEventView.add(createEventBack);
	showEventView.add(showEventBack);
	deleteEventView.add(deleteEventBack);
	changeEventView.add(changeEventBack);
	
	//Zurueck zu Verstaltung Ansicht von erstellen Veranstaltung Ansicht
	createEventBack.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, "mainviewEvent");
	    }       
	});
	
	//Zurueck zu Verstaltung Ansicht von anzeigen Veranstaltung Ansicht
	showEventBack.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, "mainviewEvent");
	    }       
	});
	
	//Zurueck zu Verstaltung Ansicht von loeschen Veranstaltung Ansicht
	deleteEventBack.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, "mainviewEvent");
	    }       
	});
	
	//Zurueck zu Verstaltung Ansicht von aendern Veranstaltung Ansicht
	changeEventBack.addActionListener(new ActionListener() {
	    public void actionPerformed (ActionEvent e) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, "mainviewEvent");
	    }       
	});
	
	
	//viewCustEvent
	
	//mainEventsCustomerView
	
			backtomain = new JButton("<-");
			backtomain.setBounds(20, 20, 100, 25);
			mainEventsCustomerView.add(backtomain);
	
			mainBuyTicketButton = new JButton("Ticket kaufen");
			mainBuyTicketButton.setBounds(600,30,300,25);
			mainEventsCustomerView.add(mainBuyTicketButton);
			
			mainReturnTicketButton = new JButton("Ticket zurueckgeben");
			mainReturnTicketButton.setBounds(600,80,300,25);
			mainEventsCustomerView.add(mainReturnTicketButton);
			
			//Actionlistener auf Button, der von der mainEventsCustomerView zurueck auf die mainview (Hauptseite) wechselt
			backtomain.addActionListener(new ActionListener() {
				public void actionPerformed (ActionEvent e) {
					registrationerrl.setText("");
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "mainview");
		    	}       
			});
			
			//Actionlistener auf Button, der von der mainEventsCustomerView auf die searchEventsCustomerView wechselt
			mainBuyTicketButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			        CardLayout cl = (CardLayout)(cards.getLayout());
			        cl.show(cards, "searchEventsCustomerView");
			    }       
			});
			
			//Actionlistener auf Button, der von der mainEventsCustomerView auf die returnTicketsCustomerView wechselt
			mainReturnTicketButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			        CardLayout cl = (CardLayout)(cards.getLayout());
			        cl.show(cards, "returnTicketsCustomerView");
			    }       
			});
			
			//searchEventsCustomerView
			searchForEventsLabel = new JLabel("Event nach x suchen:");
			searchForEventsLabel.setBounds(100,150,300,25);
			searchEventsCustomerView.add(searchForEventsLabel);
			
			searchForEventsTextField = new JTextField();
			searchForEventsTextField.setBounds(350,100,300,25);
			searchEventsCustomerView.add(searchForEventsTextField);
			
			searchEventsButton = new JButton("Nach Veranstaltungen suchen/sortieren");
			searchEventsButton.setBounds(700,100,350,25);
			searchEventsCustomerView.add(searchEventsButton);
			
					//ComboBoxen zur Sortierung und Suche nach Events
			String comboBoxListe0[] = {"Name", "Kuenstler", "Genre", "Location"};
			searchComboBox = new JComboBox(comboBoxListe0);
			searchComboBox.setBounds(100,200,300,25);
			searchEventsCustomerView.add(searchComboBox);
			
			String comboBoxListe1[] = {"Alphabet", "Datum"};
			sortComboBox = new JComboBox(comboBoxListe1);
			sortComboBox.setBounds(100,350,300,25);
			searchEventsCustomerView.add(sortComboBox);
			
			String comboBoxListe2[] = {"aufsteigend", "absteigend"};
			sortComboBox2 = new JComboBox(comboBoxListe2);
			sortComboBox2.setBounds(100,500,300,25);
			searchEventsCustomerView.add(sortComboBox2);
			
			//Bei Auswahl eines Items in der ComboBox wird sortBy aktualisiert (vorher standardmaeig "Alphabet")
			sortComboBox.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    sortBy = (String) sortComboBox.getSelectedItem();
			    }       
			});
			
			//Bei Auswahl eines Items in der ComboBox2 wird wayToSort aktualisiert (vorher standardmaeig "aufsteigend")
			sortComboBox2.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    wayToSort = (String) sortComboBox2.getSelectedItem();
			    }       
			});
			
			
			//Anlegen einer neuen JList mit aufgerufenen Methoden aus der Klasse showEvents
			searchEventsList = new JList(showEvents.VisualizeEvents(showEvents.sortEvents(sortBy, wayToSort, showEvents.GetAllEvents())).toArray()); 
			eventIDs = showEvents.sortEvents(sortBy, wayToSort, showEvents.GetAllEvents());
			searchEventsList.setBounds(450,220,1200,300);
			searchEventsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			searchEventsList.setLayoutOrientation(JList.VERTICAL_WRAP);
			searchEventsList.setVisibleRowCount(-1);
			JScrollPane searchEventsListScroller = new JScrollPane(searchEventsList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			searchEventsListScroller.setPreferredSize(new Dimension(250,80));
			searchEventsCustomerView.add(searchEventsListScroller);
			searchEventsCustomerView.add(searchEventsList);
			
			continueEventsButton = new JButton("Weiter mit der Bezahlung");
			continueEventsButton.setBounds(900,600,200,25); 
			searchEventsCustomerView.add(continueEventsButton);
			
			//Bei Auswahl eines Items in der searchComboBox wird aspect aktualisiert (vorher standardmaeig "Name")
			searchComboBox.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    aspect = (String) searchComboBox.getSelectedItem();
			    }       
			});
			 
			//ActionListener des searchEventButtons: removen der searchEventsList, anlegen einer neuen Listen mit den Methoden sortEvents und searchEvents und hinzufgen der Liste zu dem Panel
			searchEventsButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    searchEventsList.setVisible(false);
			    searchEventsCustomerView.remove(searchEventsList);
			    searchEventsCustomerView.remove(searchEventsListScroller);
			
			    searchEventsList = new JList(showEvents.VisualizeEvents(showEvents.sortEvents(sortBy, wayToSort, showEvents.searchEvents(aspect, searchForEventsTextField.getText()))).toArray());//TBD: Schnittstelle zu showEvents, Veranstaltungen muessen eingetragen werden
				eventIDs = showEvents.sortEvents(sortBy, wayToSort, showEvents.searchEvents(aspect, searchForEventsTextField.getText()));
				
			    searchEventsList.setBounds(450,220,1200,300);
				searchEventsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				searchEventsList.setLayoutOrientation(JList.VERTICAL_WRAP);
				searchEventsList.setVisibleRowCount(-1);
				JScrollPane searchEventsListScroller = new JScrollPane(searchEventsList);
				searchEventsListScroller.setPreferredSize(new Dimension(250,80));
				searchEventsCustomerView.add(searchEventsListScroller);
				searchEventsCustomerView.add(searchEventsList);
			    //showEvents.VisualizeEvents(showEvents.searchEvents(aspect, searchForEventsTextField.getText()))) //TBD: Schnittstelle zu showEvents, Veranstaltungen muessen eingetragen werden
				
			    }       
			});
			
			
			
			//ActionListener, der checkt ob ein Event aus der JList ausgewaehlt wurde. Falls ausgewhlt, wird die EventID des Events gespeichert und die JList fr die verfgbaren Tickets generiert. Die view wird angepasst
			continueEventsButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    	if(searchEventsList.getSelectedIndex() != -1) {
			    		selectedEventID = Integer.parseInt(eventIDs.get(searchEventsList.getSelectedIndex()));
			    		//System.out.println(selectedEventID);
			    		CardLayout cl = (CardLayout)(cards.getLayout());
				        cl.show(cards, "showAvailableTicketsCustomerView");
				        
				        showAvailableTicketsList = new JList(Ticket.showAvailableTickets(selectedEventID).toArray());
						showAvailableTicketsList.setBounds(50,150,1400,400);
						showAvailableTicketsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
						showAvailableTicketsList.setLayoutOrientation(JList.VERTICAL_WRAP);
						showAvailableTicketsList.setVisibleRowCount(-1);
						showAvailableTicketsScroller = new JScrollPane(showAvailableTicketsList);
						showAvailableTicketsScroller.setPreferredSize(new Dimension(250,80));
						showAvailableTicketsCustomerView.add(showAvailableTicketsScroller);
						showAvailableTicketsCustomerView.add(showAvailableTicketsList);
						
						eventArray = Event.getEvent(selectedEventID);
				        
			    	}
			    }       
			});
			
			howToSearch = new JLabel("Sortieren der Liste nach:");
			howToSearch.setBounds(100,310,300,25);
			searchEventsCustomerView.add(howToSearch);
			
			//showAvailableTicketsCustomerView
			availableTicketsLabel = new JLabel("Folgende Tickets sind fuer diese Veranstaltung noch verfuegbar:");
			availableTicketsLabel.setBounds(300, 100, 500, 25);
			showAvailableTicketsCustomerView.add(availableTicketsLabel);
			
			buyTicketButton = new JButton("Ticket kaufen");
			buyTicketButton.setBounds(900,600,200,25);
			showAvailableTicketsCustomerView.add(buyTicketButton);
			
			//ActionListener, der checkt ob ein Ticket ausgewhlt wurde. Falls ausgewhlt, wird die gewhlte Kategorie und Sitznummer gespeichert. View wird aktualisiert
			buyTicketButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    	if(showAvailableTicketsList.getSelectedIndex() != -1) {
			    		chosenCategorie = Ticket.getChosenCategorie(selectedEventID, showAvailableTicketsList.getSelectedIndex());
			    		chosenSeatNum = Ticket.getChosenSeat(selectedEventID, showAvailableTicketsList.getSelectedIndex());
			    		
			        CardLayout cl = (CardLayout)(cards.getLayout());
			        cl.show(cards, "payEventCustomerView");
			    	}
			    }       
			});
			
			//payEventCustomerView	
			discountEligibleLabel = new JLabel("Sind Sie zu einem Discount befaehigt?:");
			discountEligibleLabel.setBounds(200,120,300,25);
			payEventCustomerView.add(discountEligibleLabel);
			
			
			discountYes = new JButton("Zu Discount befaehigt");
			discountYes.setBounds(250, 200, 300, 25);
			payEventCustomerView.add(discountYes);
			
			//ActionListener fr Button, falls die Person fr einen Discount befhigt ist. Preis wird basierend auf der Discountfhigkeit ausgerechnet und ein Pop-Up Fenster teilt den Preis mit
			discountYes.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    	finalPrice = Ticket.payTicket(selectedEventID, chosenCategorie, "Ja");
			    	
			    	JOptionPane.showMessageDialog(window,
			    		    "Der Preis fuer das Ticket betraegt: " + finalPrice +" Euro",
			    		    "aktueller Ticketpreis",
			    		    JOptionPane.PLAIN_MESSAGE);
					
			    }       
			});
			
			discountNo = new JButton("Nicht zu Discount befaehigt (Standard)");
			discountNo.setBounds(650, 200, 350, 25);
			payEventCustomerView.add(discountNo);
			
			//ActionListener fr Button, falls die Person fr keinen Discount befhigt ist. Preis wird basierend auf der Discountfhigkeit ausgerechnet und ein Pop-Up Fenster teilt den Preis mit
			discountNo.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    	finalPrice = Ticket.payTicket(selectedEventID, chosenCategorie, "No");
					
			    	JOptionPane.showMessageDialog(window,
			    		    "Der Preis fuer das Ticket betraegt: " + finalPrice +" Euro",
			    		    "aktueller Ticketpreis",
			    		    JOptionPane.PLAIN_MESSAGE);
			    }       
			});
			
			perPostButton = new JButton("Ticket per Post");
			perPostButton.setBounds(250, 500, 300, 25);
			payEventCustomerView.add(perPostButton);
			
			//ActionListener fr Button, der das Ticket kauft und per Post sendet. View wird aktualisiert
			//Informationen ber Kufer werden entweder von dem Login bernommen, oder falls in die bereitgestellten Felder geschrieben wurde, der Text aus den Feldern bernommen
			//Falls keine Login Informationen vorhanden sind und nicht in die Felder geschrieben wurde, wird eine Fehlermeldung im Pop Up Format erstellt
			perPostButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    	if(!(emailText.getText().isEmpty())) {
			    		email = emailText.getText();
			    		name = nameText.getText();
			    		adress= adressText.getText();
			    		payment = paymentText.getText();
			    		}
			    		else {
			    				email = emailreg;
			    				name = namereg;
			    				adress= adressreg;
			    				payment = paymentreg;	

			    				}
			    	
			    	if(email.isEmpty()) {
			    		System.out.println(email+namereg+adressreg+paymentreg+emailreg.isEmpty());
			    		eerrregistration.setVisible(true);
			    	}
			    	else {
			    		System.out.println(email);
			    		showAvailableTicketsList.setVisible(false);
				    	showAvailableTicketsCustomerView.remove(showAvailableTicketsList);
				    	showAvailableTicketsCustomerView.remove(searchEventsListScroller);
			    		Ticket ticket = Ticket.buyTicket(selectedEventID, String.valueOf(chosenSeatNum), chosenCategorie);
			    		Ticket.sendPost(ticket,email,name,adress,payment); //Customer Data
			    	
			    		CardLayout cl = (CardLayout)(cards.getLayout());
			    		cl.show(cards, "mainEventsCustomerView");
			    	}
			    }       
			});
			
			perMailButton = new JButton("Ticket per Mail");
			perMailButton.setBounds(650, 500, 300, 25);
			payEventCustomerView.add(perMailButton);
			
			//ActionListener fr Button, der das Ticket kauft und per Mail sendet. View wird aktualisiert
			//Informationen ber Kufer werden entweder von dem Login bernommen, oder falls in die bereitgestellten Felder geschrieben wurde, der Text aus den Feldern bernommen
			//Falls keine Login Informationen vorhanden sind und nicht in die Felder geschrieben wurde, wird eine Fehlermeldung im Pop Up Format erstellt
			perMailButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    	if(emailText.getText()!= "") {
			    		email = emailText.getText();
			    		name = nameText.getText();
			    		adress= adressText.getText();
			    		payment = paymentText.getText();
			    		}
			    		else {
			    				email = emailreg;
		    					name = namereg;
		    					adress= adressreg;
		    					payment = paymentreg;	
			    				}			
			    	if(email.isEmpty()) {   	
			    		eerrregistration.setVisible(true);
			    	}
			    	else {
			    		showAvailableTicketsList.setVisible(false);
				    	showAvailableTicketsCustomerView.remove(showAvailableTicketsList);
				    	showAvailableTicketsCustomerView.remove(searchEventsListScroller);
			    		Ticket ticket = Ticket.buyTicket(selectedEventID, String.valueOf(chosenSeatNum), chosenCategorie);
			    		Ticket.sendMail(ticket,email,name,adress,payment); //add Customer Data
			    	
			    	
			    		CardLayout cl = (CardLayout)(cards.getLayout());
			    		cl.show(cards, "mainEventsCustomerView");
			    	}
			    }       
			});
			
			
			
			//returnTicketsCustomerView
			returnTicketLabel = new JLabel("TicketID eingeben:");
			returnTicketLabel.setBounds(300, 300, 300, 25);
			returnTicketsCustomerView.add(returnTicketLabel);
			
			returnTicketTextField = new JTextField();
			returnTicketTextField.setBounds(600, 300, 300, 25);
			returnTicketsCustomerView.add(returnTicketTextField);
			
			returnTicketButton = new JButton("Zurueckgeben des Tickets");
			returnTicketButton.setBounds(850, 550, 300, 25);
			returnTicketsCustomerView.add(returnTicketButton);
			
			//ActionListener fr Button, der Ticket auf Basis der angegebenen EventID in dem TextField zurckgibt. View wird aktualisiert
			returnTicketButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    	Ticket.returnTicketOnline(returnTicketTextField.getText());	
			    	JOptionPane.showMessageDialog(window,
			    		    "Das Ticket wurde zurueckgegeben.",
			    		    "aktueller Ticketpreis",
			    		    JOptionPane.PLAIN_MESSAGE);
			        CardLayout cl = (CardLayout)(cards.getLayout());
			        cl.show(cards, "mainEventsCustomerView");
			    }       
			});
			
			
			
			//Zurueck Buttons fuer jedes Panel
			searchEventsBackButton = new JButton("Zurueck zum Start");
			searchEventsBackButton.setBounds(40,55,200,25);
			showTicketsBackButton = new JButton("Zurueck zur Veranstaltungsauswahl");
			showTicketsBackButton.setBounds(40,55,200,25);
			payEventsBackButton = new JButton("Zurueck zu verfuegbaren Tickets");
			payEventsBackButton.setBounds(40,55,200,25);
			returnTicketsBackButton = new JButton("Zurueck zum Start");
			returnTicketsBackButton.setBounds(40,55,200,25);
			
			
			searchEventsCustomerView.add(searchEventsBackButton);
			showAvailableTicketsCustomerView.add(showTicketsBackButton);
			payEventCustomerView.add(payEventsBackButton);
			returnTicketsCustomerView.add(returnTicketsBackButton);
			
			
			//ActionListener fr jeden "Zurueck" Button, der die jeweils vorherige View aufruft
			searchEventsBackButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			        CardLayout cl = (CardLayout)(cards.getLayout());
			        cl.show(cards, "mainEventsCustomerView");
			    }       
			});
			
			showTicketsBackButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			    	showAvailableTicketsList.setVisible(false);
			    	showAvailableTicketsCustomerView.remove(showAvailableTicketsList);
			    	showAvailableTicketsCustomerView.remove(showAvailableTicketsScroller);
			    	
			        CardLayout cl = (CardLayout)(cards.getLayout());
			        cl.show(cards, "searchEventsCustomerView");
			    }       
			});
			
			payEventsBackButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			        CardLayout cl = (CardLayout)(cards.getLayout());
			        cl.show(cards, "showAvailableTicketsCustomerView");
			    }       
			});
			
			returnTicketsBackButton.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent e) {
			        CardLayout cl = (CardLayout)(cards.getLayout());
			        cl.show(cards, "mainEventsCustomerView");
			    }       
			});
			
		}
	
	

	public static void main(String[] args) {
		view gui = new view();
			
	}

}

