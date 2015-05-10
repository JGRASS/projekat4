package sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import nabavka.Dobavljac;



public class SOSacuvajUFajlDobavljac {
	
	public static void sacuvajUFajl(String putanja, LinkedList<Dobavljac> dobavljaci) {
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(putanja)));
			
			out.writeObject(dobavljaci);
			
			out.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
