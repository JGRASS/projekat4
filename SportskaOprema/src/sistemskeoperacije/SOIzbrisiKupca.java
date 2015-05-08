package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;

public class SOIzbrisiKupca {

	public static void izbrisiKupca(Kupac p, LinkedList<Kupac> kupci){
		if(kupci.contains(p))kupci.remove(p);
	}
}
