package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;
import prodavnica.Proizvod;

public class SOPrimiNarudzbinu {
	
	public static void primiNarudzbinu(Kupac kupac, Proizvod p, LinkedList<Kupac> kupci, LinkedList<Proizvod> proizvodi, double racun) {
		
		for (int i = 0; i < proizvodi.size(); i++) {
			if(proizvodi.get(i).equals(p) && p.getKolicina() <= proizvodi.get(i).getKolicina()) {
				proizvodi.get(i).setKolicina(proizvodi.get(i).getKolicina() - p.getKolicina());
				racun += p.getCena() * p.getKolicina();
			}
		}
		
		if (!kupci.contains(kupac)) {
			kupci.add(kupac);
		} else {
			for (int i = 0; i < kupci.size(); i++) {
				if(kupci.get(i).equals(kupac))
					kupci.get(i).setKolicina(kupci.get(i).getkolicinaNovca() + kupac.getkolicinaNovca());
			}
		}
		
	}

}
