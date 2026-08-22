package listen;

public class Song implements Comparable<Song> {
	
	//Struktur und Eigenschaften eines Songs 
	String kuenstler;
	String titel;
	int jahr;
		
	// Initialisierungskonstruktor
	Song(String kuenstler, String titel, int jahr){
			this.kuenstler = kuenstler;
			this.titel =titel;
			this.jahr=jahr;
		}
	
	// Methode zur Rueckgabe des Titels
	public String getTitel(){
		return titel;
	}

	// Methode zur Rueckgabe des Kuenstler
	public String getKuenstler(){
		return kuenstler;
	}
		
	// Methode zur Rueckgabe des Erscheinungsjahres 
	public int getJahr(){
		return jahr;
	}
		
	// Methode zur gut lesbaren Stringdarstellung der Attribute eines Songs
	public String toString(){
		return getKuenstler()+": "+ getTitel()+" ("+ getJahr()+")"; 
	}
	
	public int compareTo(Song cmp) {
		int result = this.getKuenstler().compareTo(cmp.getKuenstler());
		if (result == 0) {
			if (this.getJahr() > cmp.getJahr())
				return 1;
			if (this.getJahr() < cmp.getJahr())
				return -1;
			return 0;
		}
		else return result;
	}
}
