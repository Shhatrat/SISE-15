import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;



public class PietnastkaMain {
		
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		List<Plansza> oo = new ArrayList<>();
		Plansza pl = new Plansza();
		Plansza bb;

		pl.wypelnijPoKolei();
		bb = (Plansza) pl.clone();
		

		bb.zmienBezWspolrzednych(Plansza.Strony.DOL);		
		//oo.add(pl);
		//oo.add(bb);
		
		System.out.println(pl.pozycjaZeroX);
		System.out.println(pl.pozycjaZeroY);
		pl.wypisz();
		
		//bb.wypisz();		
		
		System.out.println();
		
		System.out.println(oo.toString());
		
		


	}

}
