package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;
import prodavnica.Proizvod;

public class SONaruci {
	
	public static double naruci(Dobavljac d, Proizvod p, LinkedList<Proizvod> proizvodi, double tekRacun, LinkedList<Dobavljac> dobavljaci) {
		boolean b=false;
		int e=0;
		
		for (int i = 0; i <proizvodi.size(); i++) {
		if(proizvodi.get(i).getNaziv().equals(p.getNaziv())||proizvodi.get(i).getId().equals(p.getId())){ b=true; e=i;}
		}
		
		if(b==true){
		for (int i = 0; i < d.getProizvodi().size(); i++) {
			if (d.getProizvodi().get(i).getNaziv().equals(p.getNaziv())&&p.getKolicina() <= d.getProizvodi().get(i).getKolicina()) {
						proizvodi.get(e).setKolicina(proizvodi.get(e).getKolicina() + p.getKolicina());
						return tekRacun -= p.getCena()*p.getKolicina();
					
			}
		}
		}
		else{
			proizvodi.add(p);
			return tekRacun -= p.getCena()*p.getKolicina();
			
		}
		return tekRacun;
	}

}
