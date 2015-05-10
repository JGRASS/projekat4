package sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import prodavnica.Zaposleni;



public class SOUcitajIzFajlaZaposleni {
	
	public static void ucitajIzFajla(String putanja, LinkedList<Zaposleni> dobavljaci) {
		try{
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(putanja)));
			
			dobavljaci = (LinkedList<Zaposleni>)(in.readObject());
			
			in.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
