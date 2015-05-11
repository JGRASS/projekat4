package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SOPretraziDobavljace {

	public static Dobavljac pretraziDobavljace(String id,LinkedList<Dobavljac> dobavljaci){
		for (int i = 0; i < dobavljaci.size(); i++) {
			if(dobavljaci.get(i).getDobavljacId().equals(id)){
				return dobavljaci.get(i);
			}
		}
		return null;
	}
}
