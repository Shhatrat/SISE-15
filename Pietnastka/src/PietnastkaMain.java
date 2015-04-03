import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;



public class PietnastkaMain {
		
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		Plansza pl = new Plansza();
		pl.wypelnijPoKolei();
		pl.wylosujDoZrobienia(20);
		Wyszukaj oo = new Wyszukaj(pl);
		oo.przeszukaj();
//		oo.wyszukajZwartoscia();

		/*
		HashSet<Plansza> oo = new HashSet<>();
		System.out.print(oo.add((Plansza) pl.clone()));
		System.out.print(oo.add((Plansza) pl.clone()));
		pl.zmienBezWspolrzednych(Plansza.Strony.DOL);
		//pl2 = (Plansza) pl.clone();
		//oo.add(pl2);
		System.out.print(oo.size());
		*/
	}

}
