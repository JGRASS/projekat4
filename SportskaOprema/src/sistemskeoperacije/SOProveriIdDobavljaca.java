package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SOProveriIdDobavljaca {
	/**
	 * Metoda proverava da li je identifikacioni broj dobavljaca vec zauzet.
	 * @param id identifikacioni broj za koji vrsimo proveru.
	 * @param dobavljaci lista dobavljaca
	 * @return <ul>
	 * <li>false, ukoliko je ID zauzet.</li>
	 * <li>true, ukoliko je ID slobodan.</li>
	 * </ul>
	 */
	public static boolean proveriIdDobavljaca(String id, LinkedList<Dobavljac> dobavljaci){
		for (int i = 0; i < dobavljaci.size(); i++) {
			if(dobavljaci.get(i).getDobavljacId().equals(id))
				return false;
		}
		return true;
		
	}
}
