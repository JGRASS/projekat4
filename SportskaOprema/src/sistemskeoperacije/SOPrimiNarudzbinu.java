package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;
import prodavnica.Proizvod;

public class SOPrimiNarudzbinu {
	
	public static double primiNarudzbinu(Kupac kupac, Proizvod p, LinkedList<Kupac> kupci, LinkedList<Proizvod> proizvodi, double racun) {
		int j=0;
		for (int i = 0; i < kupci.size(); i++) {
			if(kupci.get(i).getId().equals(kupac.getId())){
				j=i;
			}
		}
		for (int i = 0; i < proizvodi.size(); i++) {
			if(proizvodi.get(i).getId().equals(p.getId()) && p.getKolicina() <= proizvodi.get(i).getKolicina()) {
				proizvodi.get(i).setKolicina(proizvodi.get(i).getKolicina() - p.getKolicina());
				racun += p.getCena() * p.getKolicina();
				kupci.get(j).setKolicina(kupci.get(j).getkolicinaNovca()+(p.getCena() * p.getKolicina()));
				return racun;
			}
		}
		return racun;
		
		

	}
}
