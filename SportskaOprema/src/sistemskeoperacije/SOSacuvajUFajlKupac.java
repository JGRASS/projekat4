package sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import prodavnica.Kupac;


public class SOSacuvajUFajlKupac {
	
	public static void sacuvajUFajl(String putanja, LinkedList<Kupac> kupci) {
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(putanja)));
			
			out.writeObject(kupci);
			
			out.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
