package listen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.*;
import java.util.*;


public class SongList extends ArrayList<Song>{

	public SongList(String string) {
		//einlesen der datei mit fillFromFile
		this.readFromFile(string);
	}
	public SongList() {
	}
	
	

	void readFromFile(String str) {
		try {
			Scanner scan = new Scanner(new File(str));
			while(scan.hasNext()) {
				String zeile = scan.nextLine();
				String[] eintrag = zeile.split("/");
				try {
					Song so = new Song(eintrag[0],eintrag[1],
							Integer.parseInt(eintrag[2]));
					this.add(so);
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

	public void printSongs() {
		//durch die Liste iterieren und Songs der Playlist ausgeben
		System.out.println("In der Playlist befinden sich folgende " + this.size() + " Songs:");
		System.out.println("---------------------------------------------");
		for(Song song:this) {
			System.out.println(song.toString());
		}
		System.out.println("---------------------------------------------");
	}
	
	public void deleteSongs() {
		// jedes 3. Element wird entfernt
		for(int i = 2; i < this.size(); i += 2) {
			this.remove(i);
		}
	}
	
	public void printSongsIter() {
		// durch die Liste iterieren und Songs der Playlist ausgeben
		System.out.println("In der Playlist befinden sich folgende " + this.size() + " Songs:");
		System.out.println("---------------------------------------------");
		Iterator<Song> iter = this.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
		System.out.println("---------------------------------------------");
	}
	
	public List<String> mapToKuenstler(){
		List<String> result = this.stream()
				// Abbildung nach Name
				.map(song -> song.getKuenstler())
				// Filter nach distinkten Elementen(Object.equals(o))
				.distinct()
				// erstellen einer neuen Liste aus den Streamelementen
				.collect(Collectors.toList());
				return result;
	}
	
	public Song findsong(String string) {
		Song result = this.stream()
				// FIltern nach [Kue] Songs
				.filter(song -> song.getKuenstler().equals(string))
				// Stream, der die gefundenen Songs beinhaltet
				// Rueckgabe ist vom Typ Optional<Song>
				.findFirst()
				// erstes Element des Streams
				.orElse(null);
				// Optional ist leer
		return result;
	}
	
	public List<Song> findsongs(String string){
		List<Song> result = this.stream()
				// Filtern nach Songs des gesuchten Kuenstlers
				.filter(song -> song.getKuenstler().equals(string))
				// erstellen einer neuen Liste aus den Streamelementen
				.collect(Collectors.toList());
		return result;	
	}
	
	public static void main(String[] args) {
		SongList mySongs = new SongList("SongListPlus.txt");
		
		// Alle Songs von "Max herre"
		//System.out.println("Songs von Max Herre: " + mySongs.findsongs("Max Herre") + "\n" );
		
		// Alle Songs ausgeben und Anzahl ausgeben
		//mySongs.printSongs();
		//System.out.println("Länge der Liste: " + mySongs.size()+"\n");
		
		// Jeden dritten Eintrag löschen
		/*
		mySongs.deleteSongs();
		System.out.println("Nach dem Löschen jedes dritten Eintrags: ");
		System.out.println("Länge der Liste: " + mySongs.size());
		mySongs.printSongs();
		*/
		
		// Songs sortiert nach Name, anschließend Jahr
		Collections.sort(mySongs);
	    mySongs.printSongs();

	    
	    System.out.println(mySongs.mapToKuenstler());
	    
	
	}
}
