package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Proizvod;

public class SOProveriIdProizvoda {
	/**
	 * Metoda proverava da li je identifikacioni broj proizvoda vec zauzet.
	 * @param id identifikacioni broj za koji vrsimo proveru.
	 * @param proizvodi lista proizvoda.
	 * @return <ul>
	 * <li>false, ukoliko je ID zauzet.</li>
	 * <li>true, ukoliko je ID slobodan.</li>
	 * </ul>
	 */
	public static boolean proveriIdProizvoda(String id, LinkedList<Proizvod> proizvodi){
		for (int i = 0; i < proizvodi.size(); i++) {
			if(proizvodi.get(i).getId().equals(id))
				return false;
		}
		return true;
	}
}
