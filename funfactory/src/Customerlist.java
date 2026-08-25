import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * Arraylist mit Obejekten vom Typ Customer
 *
 */
// Customerlist ist eine Liste die alle registrierten Kunden und ihre gespeicherten Daten enthaelt
public class Customerlist extends ArrayList<Customer>{
	/**
	 * 
	 * @param string Pfad von Kunden.txt
	 */
	// Konstruktor
	public Customerlist(String string) {
		this.readFromFile(string);
	}

	// Konstruktor
	public Customerlist() {
	}
	
	// Methode liest die Textdatei aus und erzeugt aus den Informationen einer Zeile ein Objekt der Klasse Customer und fuegt
	// diese in eine Liste hinzu
	/**
	 * 
	 * @param str ist der Pfad der Datei Kunden.txt
	 * @exception NumberFormatException
	 * @exception FileNotFoundException
	 */
	void readFromFile(String str) {
		try {
			Scanner scan = new Scanner(new File(str));
			while(scan.hasNext()) {
				String zeile = scan.nextLine();
				String[] eintrag = zeile.split("/");
				try {
					String[] payment = eintrag[6].replace("[", "").replace("]", "").replace(" ", "").split(",");
					Customer cust = new Customer(eintrag[0],
							eintrag[1],
							eintrag[2],
							eintrag[3],
							eintrag[4],
							Boolean.parseBoolean(eintrag[5]),
							payment);
					this.add(cust);
				} catch(NumberFormatException e) {
					System.err.println("missing integer");
					//e.printStackTrace();
				}
			}
			scan.close();
		} catch(FileNotFoundException e) {
			System.err.println("file not found");
			//e.printStackTrace();
		}
	}	

	/**
	 * 
	 * @param email E-Mail die vom Benutzer beim anmelden eingegeben wird
	 * @param pw Passwort die vom Benutzer beim anmelden eingegeben wird
	 * @return true, falls Daten in der Textdatei uebereinstimmen, sonst false, falls Daten nicht in Textdatei uebereinstimmen
	 * @exception NullPointerException
	 */
	// Methode ueberprueft, ob die eingegebenen Daten, E-Mail und Passwort, mit einem Objekt der Klasse Customer uebereinstrimmt 
	public boolean checklogin(String email, String pw) {
		try {
			// nutzt stream aus um Customers zu filtern, die mit der E-Mail und dem Passwort nicht uebereinstimmen
			Customer result = this.stream()
					.filter(Customer -> Customer.getEmail().equals(email))
					.filter(Customer -> Customer.getPassword().equals(pw))
					.findFirst()
					.orElse(null);
			// true, falls E-Mail und/oder Passwort mit keinem Customer uebereinstimmt
			// false, sonst
			if(result == null) {
				return false;
			} else {
				return true;
			}
		} catch(NullPointerException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param email E-Mail die vom Benutzer eingegeben wird
	 * @return true, falls E-Mail noch nicht in Kunden.txt existiert, sonst false, falls E-Mail schon in Kunden.txt verwendet wird
	 * @exception NullPointerException gh
	 */
	// Methode ueberprueft, ob ein Customer schon die eingebenen E-Mail besitzt
	public boolean checkemail(String email) {
		try {
			// nutzt stream aus um Customers zu filtern, die mit der E-Mail nicht uebereinstimmen
			Customer result = this.stream()
					.filter(Customer -> Customer.getEmail().equals(email))
					.findFirst()
					.orElse(null);
			// true, falls E-Mail zu keinem Customer gehoert
			// false, sonst
			if(result == null) {
				return true;
			} else {
				return false;
			}
		} catch(NullPointerException e1) {
			e1.printStackTrace();
			return true;
		}
	}
	
	/**
	 * 
	 * @param email E-Mail die vom Benutzer eingegeben wird
	 * @param pw Passwort die vom Benutzer eingegeben wird
	 * @return boolean Attribut verified
	 * @exception NullPointerException
	 */
	//Methode ueberprueft ob ein Customer verifiziert ist
	public boolean checkverified(String email, String pw) {
		try {
			// nutzt stream aus um Customers zu filtern, die mit der E-Mail und dem Passwort nicht uebereinstimmen
			Customer result = this.stream()
					.filter(Customer -> Customer.getEmail().equals(email))
					.filter(Customer -> Customer.getPassword().equals(pw))
					.findFirst()
					.orElse(null);
			// true, falls verifizert
			// false, sonst
			return result.getVerified();
		} catch(NullPointerException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	/**
	 * 
	 * @param email	E-Mail die vom Benutzer eingegeben wird
	 * @param pw Passwort die vom Benutzer eingeben wird
	 * @param vcode Verifizierungscode die vom Benutzer eingegeben wird
	 * @return true, falls Konto mit dem Verifierzierungscode uebereinstimmt, sonst false, falls Konto nicht mit dem Verifizierungscode uebereinstimmt
	 * @excpetion IOException
	 * @exception NullPointerException
	 */
	// Methode prueft ob E-Mail und Passwort mit dem zugewiesenen Verifizierungscode uebereinstimmt
	public boolean checkvcode(String email, String pw, String vcode) {
		try {
			// nutzt stream aus um Customers zu filtern, die mit der E-Mail, dem Passwort und dem Verifizierungscode nicht uebereinstimmen
			Customer result = this.stream()
					.filter(Customer -> Customer.getEmail().equals(email))
					.filter(Customer -> Customer.getPassword().equals(pw))
					.filter(Customer -> Customer.getVercode().equals(vcode))
					.findFirst()
					.orElse(null);
			// false, wenn E-Mail, Passwort und Verifizierungscode mit keinem Customer uebereinstimmt
			if(result == null) {
				return false;
			} else {
				//true, falls E-Mail, Passwort und Verifizierungscode mit einem Customer uebereinstimmt...
				try {
					// und aendere hierfuer in der Textdatei beim Customer die Verifizierung von false auf true
					FileWriter fw = new FileWriter("Server/Kunden/Kunden.txt");
					// merkt sich die Anzahl der der Customer in der Liste, um die richtige Anzahl von newlines(\n) zu schreiben
					int newline = this.size();
					int currentline = 1;
					// gehe durch die Liste durch...
					for(Customer cust:this) {
						// und falls die E-Mail uebereinstimmt setze die Verifizierung auf true und schreibe dann in die Textdatei...
						if(cust.getEmail().equals(email)) {
							cust.setVerified(true);
							fw.write(cust.custToString());
							if(currentline < newline) {
								fw.write("\n");
								currentline++;
							}
						// sonst schreibe ohne was zuaendern in die TExtdatei
						} else {
							fw.write(cust.custToString());
							if(currentline < newline) {
								fw.write("\n");
								currentline++;
							}
						}
					}
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		} catch(NullPointerException e1) {
			e1.printStackTrace();
			return false;
		}
	}	
	/**
	 * printet im Terminal die LIste 
	 */
	// Methode printet die Liste in der Konsole aus
	public void printCustlist() {
		System.out.println("---------------------------------------------");
		for(Customer cust:this) {
			System.out.println(cust.custToString());
		}
		System.out.println("---------------------------------------------");
	}
	/**
	 * 
	 * @param email E-MAil die vom Benutzer eingegeben wird
	 * @exception IOException
	 */
	// Methode loescht in der Textdatei einen Customer
	public void deleteacc(String email){
		try {
			FileWriter fw = new FileWriter("Server/Kunden/Kunden.txt");
			// merkt sich die Anzahl der der Customer in der Liste, um die richtige Anzahl von newlines(\n) zu schreiben
			int newline = this.size() - 1;
			int currentline = 1;
			// gehe durch die Liste durch...
			for(Customer cust:this) {
				// und falls die E-Mail mit dem Customer uebereinstimmt, ueberspringe ihn
				if(cust.getEmail().equals(email)) {
					continue;
				// sonst schreibe den Customer in die Textdatei
				} else {
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param email E-Mail die vom Benutzer eingegeben wird
	 * @return E-Mail, sonst null, falls E-Mail nicht in Kunden.txt ist
	 */
	// Methode gibt die E-Mail zurueck, falls sie in der Liste vorhanden ist
	public String getCustEmail(String email) {
		// nutzt stream um Customer zu filtern, die nicht mit der E-Mail uebereinstimmen
		Customer result = this.stream()
				.filter(Customer -> Customer.getEmail().equals(email))
				.findFirst()
				.orElse(null);
		return result.getEmail();
	}
	
	/**
	 * 
	 * @param oldemail alte E-Mail vom Kunden
	 * @param newemail neue E-Mail vom Kunden
	 * @exception IOException
	 */
	// Methode setzt die E-Mail in der Textdatei neu
	public void setCustEmail(String oldemail, String newemail) {
		try {
			FileWriter fw = new FileWriter("Server/Kunden/Kunden.txt");
			// merkt sich die Anzahl der der Customer in der Liste, um die richtige Anzahl von newlines(\n) zu schreiben
			int newline = this.size();
			int currentline = 1;
			// gehe durch die Liste durch...
			for(Customer cust:this) {
				// und falls die E-Mail des Customers mit der alten E-Mail uebereinstimmt, setze die E-Mail auf die neue E-Mail und schreibe dann
				// den Customer in die Textdatei
				if(cust.getEmail().equals(oldemail)) {
					cust.setEmail(newemail);
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				// sonst schreibe sofort in die Textdatei
				} else {
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				}
			}
			fw.close();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}	
	
	/**
	 * 
	 * @param email E-Mail die vom Benutzer eingegebene wird
	 * @return Passwort in String von der E-Mail
	 */
	// Methode gibt das Passwort zurueck, die mit der eingegebenen E-Mail uebereinstimmmt
	public String getCustPassword(String email) {
		// nutzt stream um die Customers zu filtern die nicht mit der E-Mail uebereinstimmen 
		Customer result = this.stream()
				.filter(Customer -> Customer.getEmail().equals(email))
				.findFirst()
				.orElse(null);
		// gibt Passwort als String zurueck
		return String.valueOf(result.getPassword());
	}

	/**
	 * 
	 * @param email E-Mail die vom Benutzer eingegeben wird
	 * @param newpw neues Passwort vom Benutzer
	 * @exception IOException
	 */
	// Methode setzt das Passwort in der Textdatei neu
	public void setCustPassword(String email,char[] newpw) {
		try {
			FileWriter fw = new FileWriter("Server/Kunden/Kunden.txt");
			String pw = String.valueOf(newpw);
			// merkt sich die Anzahl der der Customer in der Liste, um die richtige Anzahl von newlines(\n) zu schreiben
			int newline = this.size();
			int currentline = 1;
			// gehe durch die Liste...
			for(Customer cust:this) {
				// und falls die E-Mail des Customers mit der E-Mail uebereinstimmt, setze das alte Passwort auf das neue Passwort und schreibe dann
				// den Customer in die Textdatei
				if(cust.getEmail().equals(email)) {
					cust.setPassword(pw);
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				// sonst schreibe den Customer sofort in die Textdatei
				} else {
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				}
			}
			fw.close();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param email E-Mail vom Benutzer
	 * @return Name vom Benutzer
	 */
	// Methode gibt den Namen zurueck, die mit der eingegebenen E-Mail uebereinstimmmt
	public String getCustName(String email) {
		// nutzt stream um die Customers zu filtern die nicht mit der E-Mail uebereinstimmen
		Customer result = this.stream()
				.filter(Customer -> Customer.getEmail().equals(email))
				.findFirst()
				.orElse(null);
		return result.getName();
	}
	
	/**
	 * 
	 * @param email E-Mail vom Benutzer
	 * @param newname neuer Name vom Benutzer
	 * @exception IOException
	 */
	// Methode setzt den Namen in der Textdatei neu
	public void setCustName(String email, String newname) {
		try {
			FileWriter fw = new FileWriter("Server/Kunden/Kunden.txt");
			// merkt sich die Anzahl der der Customer in der Liste, um die richtige Anzahl von newlines(\n) zu schreiben
			int newline = this.size();
			int currentline = 1;
			// gehe durch die LIste...
			for(Customer cust:this) {
				// und falls die E-Mail des Customers mit der E-Mail uebereinstimmt, setze den Namen auf den neue Namen und schreibe dann
				// den Customer in die Textdatei
				if(cust.getEmail().equals(email)) {
					cust.setName(newname);
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				// sonst schreibe den Customer sofort in die Textdatei
				} else {
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				}
			}
			fw.close();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param email E-Mail vom Benutzer
	 * @return Adresse vom Benutzer
	 */
	// Methode gibt die Adresse zurueck, die mit der eingegebenen E-Mail uebereinstimmmt
	public String getCustAddress(String email) {
		// nutzt stream um die Customers zu filtern die nicht mit der E-Mail uebereinstimmen
		Customer result = this.stream()
				.filter(Customer -> Customer.getEmail().equals(email))
				.findFirst()
				.orElse(null);
		return result.getAddress();
	}
	
	/**
	 * 
	 * @param email E-Mail vom Benutzer
	 * @param newaddress neue Adresse die vom Benutzer gespeichert haben will
	 * @exception IOException
	 */
	// Methode setzt die Adresse in der Textdatei neu
	public void setCustAddress(String email, String newaddress) {
		try {
			FileWriter fw = new FileWriter("Server/Kunden/Kunden.txt");
			// merkt sich die Anzahl der der Customer in der Liste, um die richtige Anzahl von newlines(\n) zu schreiben
			int newline = this.size();
			int currentline = 1;
			// gehe durch die LIste...
			for(Customer cust:this) {
				// und falls die E-Mail des Customers mit der E-Mail uebereinstimmt, setze die Adresse auf die neue Adresse und schreibe dann
				// den Customer in die Textdatei
				if(cust.getEmail().equals(email)) {
					cust.setAddress(newaddress);
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				// sonst schreibe den Customer sofort in die Textdatei
				} else {
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				}
			}
			fw.close();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param email E-Mail vom Konto das geloescht werden soll
	 * @exception IOException
	 */
	//Methode setzt fuer ein Customer das Passwort neu
	public void resetPassword(String email) {
		try {
			FileWriter fw1 = new FileWriter("Server/Kunden/Kunden.txt");
			FileWriter fw2 = new FileWriter("E-Mail/PasswortVergessen/" + email + ".txt");
			// merkt sich die Anzahl der der Customer in der Liste, um die richtige Anzahl von newlines(\n) zu schreiben
			int newline = this.size();
			int currentline = 1;
			// gehe durch die Liste...
			for(Customer cust:this) {
				// falls die E-Mail mit einem Customer uebereinstimmt...
				if(cust.getEmail().equals(email)) {
					// generiere eine zufaellige 6-stellige Zahl und setze sie als neues Passwort
					// schreibe den Customer anschließend in die Textdatei
					// und erzeuge eine Textdatei mit der E-Mail als Namen der Datei und schreibe darin die generierte Zahl(neues Passwort)
					Random newpw = new Random();
					int num = newpw.nextInt(999999);
					String strnewpw = String.format("%06d", num);	
					cust.setPassword(strnewpw);
					fw1.write(cust.custToString());
					fw2.write("Ihr neues Passwort ist: " + strnewpw + "\nSie koennen anschließend ihr Passwort im Kundenkonto neu setzten.");
					if(currentline < newline) {
						fw1.write("\n");
						currentline++;
					} 
				// sonst schreibe sofort den Customer in die Textdatei
				} else {
						fw1.write(cust.custToString());
						if(currentline < newline) {
							fw1.write("\n");
							currentline++;
						}
				}
			}
			fw1.close();
			fw2.close();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param email E-Mail die fuer die Registrierung genutzt wird
	 * @param name Name der fuer die Registrierung genutzt wird
	 * @param password Passwort das fuer die Registrierung genutzt wird
	 * @param address Adresse die fuer die Registrierung genutzt wird
	 * @exception IOException
	 */
	// Methode erzeugt einen neuen Customer und schreibt ihn in die Textdatei
	public void registration(String email, String name, char[] password, String address) {
		try {
			// erzeuge ein neues Objekt der Klasse Customer mit den eingegebenen Daten
			Customer newCus = new Customer(email, String.valueOf(password), name, address);
			// erzeuge eine Textdatei mit der E-Mail als Namen der Datei
			FileWriter fw1 = new FileWriter("E-Mail/Registrierung/" + email +".txt");
			// erzeuge eine 6-stellige Zahl und setze diese Zahl fuer den neu erzeugten Customer als Verifizierungscode und schreibe diese in 
			// die neuerzeugte Textdatei
			Random rnd = new Random();
			int num = rnd.nextInt(999999);
			String stringNum = String.format("%06d", num);				
			fw1.write("Verifizierungscode: " + stringNum);				
			newCus.setVercode(stringNum);	
			fw1.close();
			// schreibe den neuen Customer in die Textdatei Kunden.txt(Datenbank)
			FileWriter fw2 = new FileWriter("Server/Kunden/Kunden.txt", true);
			fw2.write("\n" + newCus.custToString());
			fw2.close();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @param email E-Mail vom Benutzer
	 * @return die vom Benutzer gespeicherten Zahlungsarten
	 */
	// Methode gibt die Liste der gespeicherten Zahlungsarten zurueck, die mit der eingegebenen E-Mail uebereinstimmmt
	public String[] getCustPayment(String email) {
		// nutzt stream um die Customers zu filtern die nicht mit der E-Mail uebereinstimmen
		Customer result = this.stream()
				.filter(Customer -> Customer.getEmail().equals(email))
				.findFirst()
				.orElse(null);
		return result.getPayment();
	}
	
	/**
	 * 
	 * @param email E-Mail vom Benutzer
	 * @param bd1 Zahlungdaten die gespeichert werden sollen fuer die erste Zahlungsart 
	 * @param bd2 Zahlungdaten die gespeichert werden sollen fuer die zweite Zahlungsart 
	 * @param bd3 Zahlungdaten die gespeichert werden sollen fuer die dritte Zahlungsart 
	 * @exception IOException
	 */
	// Methode setzt die Zahlungsarten in der Textdatei neu
	public void setCustPayment(String email, String bd1, String bd2, String bd3) {
		try {
			FileWriter fw = new FileWriter("Server/Kunden/Kunden.txt");
			// merkt sich die Anzahl der der Customer in der Liste, um die richtige Anzahl von newlines(\n) zu schreiben
			int newline = this.size();
			int currentline = 1;
			// gehe durch die LIste...
			for(Customer cust:this) {
				// und falls die E-Mail des Customers mit der E-Mail uebereinstimmt, setze die Zahlungsarten auf die neuen Zahlungsarten und 
				// schreibe dann den Customer in die Textdatei
				if(cust.getEmail().equals(email)) {
					String[] newpayment = new String[] {bd1, bd2, bd3};
					cust.setPayment(newpayment);
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				// sonst schreibe den Customer sofort in die Textdatei
				} else {
					fw.write(cust.custToString());
					if(currentline < newline) {
						fw.write("\n");
						currentline++;
					}
				}
			}
			fw.close();
		} catch(IOException e1) {
			e1.printStackTrace();
		}		
	}
	

}
