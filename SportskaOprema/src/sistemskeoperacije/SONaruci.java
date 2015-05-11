package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;
import prodavnica.Proizvod;

public class SONaruci {
	
	public static void naruci(Dobavljac d, Proizvod p, LinkedList<Proizvod> proizvodi, double tekRacun, LinkedList<Dobavljac> dobavljaci)  {
		if (d == null || p == null) {
			throw new RuntimeException("Greska.");
		}
		
		if(!dobavljaci.contains(d))
			dobavljaci.add(d);
		if(!proizvodi.contains(p)) {
			proizvodi.add(p);
			tekRacun -= p.getCena()*p.getKolicina();
			return;
		}
		
		for (int i = 0; i < d.getProizvodi().size(); i++) {
			if (d.getProizvodi().get(i).equals(p) && p.getKolicina() <= d.getProizvodi().get(i).getKolicina()) {
				for (int j = 0; j < proizvodi.size(); j++) {
					if(proizvodi.get(j).equals(p)) {
						proizvodi.get(j).setKolicina(proizvodi.get(j).getKolicina() + p.getKolicina());
						tekRacun -= p.getCena()*p.getKolicina();
						return;
					}
				}
			}
		}
	}

}
