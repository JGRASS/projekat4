package sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import nabavka.Dobavljac;



public class SOUcitajIzFajlaDobavljac {
	/**
	 * Metoda koja vrsi deserijalizaciju fajla u kome se nalazi lista dobavljaca.
	 * @param putanja lokacija fajla iz kog se vrsi ucitavanje.
	 * @param dobavljaci lista dobavljaca
	 */
	public static void ucitajIzFajla(String putanja, LinkedList<Dobavljac> dobavljaci) {
		try{
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(putanja)));
			
			LinkedList<Dobavljac> dobavljaci2 = (LinkedList<Dobavljac>)(in.readObject());
			dobavljaci.clear();
			dobavljaci.addAll(dobavljaci2);
			in.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
