import java.util.Arrays;
/**
 * 
 * Klasse fuer registrierte Kunden
 *
 */
// Klasse Customer und ihre Attribute: email, password, name, address, verified(ob dieser Kunde verifiziert ist), vercode(Verifizierungscode),
// payment(Zahlungsarten die vom Kunde gespeichert wurden)
public class Customer{
	private String email;
	private String password;
	private String name;
	private String address;
	private boolean verified;
	private String vercode;
	private String[] payment;

	/**
	 * 
	 * @param email E-Mail die vom Benutzer eingegeben wird
	 * @param password Passwort das vom Benutzer eingegeben wird
	 * @param name Name der vom Benutzer eingegeben wird
	 * @param address Adresse die vom Benutzer eingegeben wird
	 */
	// Konstruktor 1: bei der Registrierung
	public Customer(String email, String password, String name, String address) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.verified = false;
		this.vercode = null;
		this.payment = new String[]{null, null, null};
	}
	
	/**
	 * 
	 * @param email E-Mail die aus Kunden.txt gelesen wird
	 * @param password Passwort das aus Kunden.txt gelesen wird
	 * @param name Name der aus Kunden.txt gelesen wird
	 * @param address Adresse die aus Kunden.txt gelesen wird
	 * @param vercode Verifizierungscode der aus Kunden.txt gelesen wird
	 * @param verified Verifizierung die aus Kunden.txt gelesen wird
	 * @param payment Zahlungsarten die aus Kunden.txt gelesen wird
	 */
	// Konstruktor 2: beim auslesen aus der Textdatei
	public Customer(String email, String password, String name, String address, String vercode, boolean verified, String[] payment) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.verified = verified;
		this.vercode = vercode;
		this.payment = payment;
	}
	
	/**
	 * 
	 * @return E-Mail
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @return Passwort
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return Adresse
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @return Verifizierung
	 */
	public boolean getVerified() {
		return verified;
	}
	
	/**
	 * 
	 * @param verified neue Verifiezierung
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	/**
	 * 
	 * @return Verifizierungscode
	 */
	public String getVercode() {
		return vercode;
	}
	
	/**
	 * 
	 * @return Zahlungsarten
	 */
	public String[] getPayment() {
		return payment;
	}
	
	/**
	 * 
	 * @param payment neu gespeicherte Zahlungsarten
	 */
	public void setPayment(String[] payment) {
		this.payment = payment;
	}

	/**
	 * 
	 * @param vercode Verifizierungscode
	 */
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	
	/**
	 * 
	 * @param password neues Passwort
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @param name neuer Name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param address neue Adresse
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 
	 * @param email neue E-Mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return String mit der Attributen eines Kunden in der Form "E-Mail/Passwort/Name/Adresse/Verifizierungscode/Verifizierung/Zahlungsarten"
	 */
	// fuegt alle Attribute eines Customers zu einem String zusammen
	public String custToString() {
		return this.getEmail()
				+ "/" + this.getPassword() 
				+ "/" + this.getName() 
				+ "/" + this.getAddress() 
				+ "/" + this.getVercode() 
				+ "/" + this.getVerified()
				+ "/" + Arrays.toString(this.getPayment());
	}
	

	

	
}
