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
			
			LinkedList<Zaposleni> dobavljaci2 = (LinkedList<Zaposleni>)(in.readObject());
			dobavljaci.clear();
			dobavljaci.addAll(dobavljaci2);
			in.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
