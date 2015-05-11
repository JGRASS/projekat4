package sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import prodavnica.Kupac;



public class SOUcitajIzFajlaKupac {
	
	public static void ucitajIzFajla(String putanja, LinkedList<Kupac> kupci) {
		try{
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(putanja)));
			
			LinkedList<Kupac>kupci2 = (LinkedList<Kupac>)(in.readObject());
			kupci.clear();
			kupci.addAll(kupci2);
			in.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
