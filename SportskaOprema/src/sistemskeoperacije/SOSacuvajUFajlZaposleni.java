package sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import prodavnica.Zaposleni;



public class SOSacuvajUFajlZaposleni {
	/**
	 * Metoda koja vrsi serijalizaciju liste zaposlenih
	 * @param putanja mesto gde ce se sacuvati fajl.
	 * @param zaposleni lista zaposlenih.
	 */
	public static void sacuvajUFajl(String putanja, LinkedList<Zaposleni> zaposleni) {
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(putanja)));
			
			out.writeObject(zaposleni);
			
			out.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
