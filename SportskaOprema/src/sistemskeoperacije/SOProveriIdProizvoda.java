package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Proizvod;

public class SOProveriIdProizvoda {

	public static boolean proveriIdProizvoda(String id, LinkedList<Proizvod> proizvodi){
		for (int i = 0; i < proizvodi.size(); i++) {
			if(proizvodi.get(i).getId().equals(id))return false;
		}
		return true;
	}
}
