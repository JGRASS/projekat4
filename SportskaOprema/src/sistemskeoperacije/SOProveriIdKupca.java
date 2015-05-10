package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;

public class SOProveriIdKupca {

	public static boolean proveriIdKupca(String id,LinkedList<Kupac>kupci){
		for (int i = 0; i < kupci.size(); i++) {
			if(kupci.get(i).getId().equals(id))return false;
			
		}
		return true;
	}
}
