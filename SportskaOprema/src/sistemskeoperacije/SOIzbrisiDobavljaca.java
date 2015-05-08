package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SOIzbrisiDobavljaca {

	public static void izbrisiDobavljaca(Dobavljac p, LinkedList<Dobavljac> dobavljaci){
		if(dobavljaci.contains(p))dobavljaci.remove(p);
	}
}
