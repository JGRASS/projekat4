package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Proizvod;

public class SOIzbrisiProizvod {
public static void izbrisiProizvod(Proizvod p,LinkedList<Proizvod> proizvodi){
	if(proizvodi.contains(p))proizvodi.remove(p);
}
}
