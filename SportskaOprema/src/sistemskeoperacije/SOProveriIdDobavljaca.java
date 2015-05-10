package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SOProveriIdDobavljaca {

	public static boolean proveriIdDobavljaca(String id, LinkedList<Dobavljac>dobavljaci){
		for (int i = 0; i < dobavljaci.size(); i++) {
			if(dobavljaci.get(i).getDobavljacId().equals(id))return false;
		}
		return true;
		
	}
}
