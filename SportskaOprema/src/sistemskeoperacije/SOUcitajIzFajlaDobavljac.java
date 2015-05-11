package sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import nabavka.Dobavljac;



public class SOUcitajIzFajlaDobavljac {
	
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
