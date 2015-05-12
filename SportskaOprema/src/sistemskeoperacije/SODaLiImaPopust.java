package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;

public class SODaLiImaPopust {
	/**
	 * Metoda provarava da li kupac ostvaruje pravo na popust. 
	 * Pravo na popust se ostvaruje ukoliko je kupac u nasoj prodavnici potrosio vise od 10000 dinara.
	 * @param kupac objekat klase Kupac za koji se vrsi provera da li ima popust.
	 * @param kupci lista kupaca.
	 * @return
	 * <ul>
	 * <li> true, ukoliko kupac ima popust.</li>
	 * <li> false, ukoliko kupac nema pravo na popust.</li>
	 *</ul>
	 */
	public static boolean daLiImaPopust(Kupac kupac, LinkedList<Kupac> kupci){
		if (kupac == null) {
			throw new RuntimeException("Greska.");
		}
		for (int i = 0; i < kupci.size(); i++) {
			if(kupac.getId()==kupci.get(i).getId()){
				if(kupac.getkolicinaNovca()>=10000) return true;
			}
		}	
			return false;
		}

}
