package prodavnica;

import java.util.LinkedList;

public class Prodavnica {
	
	private double tekuciRacun;
	private LinkedList<Kupac> kupci;
	private LinkedList<Proizvod> proizvodi;
	
	
	private boolean daLiImaPopust(Kupac kupac){
	for (int i = 0; i < kupci.size(); i++) {
		if(kupac.getId()==kupci.get(i).getId()){
			if(kupac.getkolicinaNovca()>=10000) return true;
		}
	}	
		return false;
	}
    
}
