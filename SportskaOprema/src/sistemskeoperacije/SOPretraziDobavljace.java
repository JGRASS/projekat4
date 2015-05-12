package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SOPretraziDobavljace {
	/**
	 * Metoda kojom se vrsi pretraga liste dobavljaca na osnovu identifikatora dobavljaca.
	 * @param id identifikator dobavljaca
	 * @param dobavljaci lista dobavljaca
	 * @return 
	 *<ul>
	 * <li> objekat klase Dobavljac ukoliko je on pronadjen.</li>
	 * <li> vraca null ukoliko objekat nije pronadjen u listi.</li>
	 *</ul>
	 */
	public static Dobavljac pretraziDobavljace(String id,LinkedList<Dobavljac> dobavljaci){
		for (int i = 0; i < dobavljaci.size(); i++) {
			if(dobavljaci.get(i).getDobavljacId().equals(id)){
				return dobavljaci.get(i);
			}
		}
		return null;
	}
}
