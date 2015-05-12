package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;

public class SOProveriIdKupca {
	/**
	 * Metoda proverava da li je identifikacioni broj kupca vec zauzet.
	 * @param id identifikacioni broj za koji vrsimo proveru.
	 * @param kupci lista kupaca
	 * @return <ul>
	 * <li>false, ukoliko je ID zauzet.</li>
	 * <li>true, ukoliko je ID slobodan.</li>
	 * </ul>
	 */
	public static boolean proveriIdKupca(String id,LinkedList<Kupac>kupci){
		for (int i = 0; i < kupci.size(); i++) {
			if(kupci.get(i).getId().equals(id))
				return false;
			
		}
		return true;
	}
}
