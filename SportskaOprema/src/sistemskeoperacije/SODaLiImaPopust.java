package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;

public class SODaLiImaPopust {
	
	public static boolean daLiImaPopust(Kupac kupac, LinkedList<Kupac> kupci){
		for (int i = 0; i < kupci.size(); i++) {
			if(kupac.getId()==kupci.get(i).getId()){
				if(kupac.getkolicinaNovca()>=10000) return true;
			}
		}	
			return false;
		}

}
