import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

		int[][] nowa = new int[][] {{1, 5,	2,	3},	
{4,	9,	6,	7},	
{8,	13,	0,	10},	
{12,14,	15,	11}};
		
		pl.tab = nowa;
		pl.pozycjaZeroX=2;
		pl.pozycjaZeroY=2;
//		pl.wypisz();
		
		
		Wyszukaj oo = new Wyszukaj(pl);
		oo.najnowsze();
		
//		oo.przeszukaj();
//		oo.wyszukajZwartoscia();

/*		
		//HashSet<Plansza> oo = new HashSet<>();
		List<Plansza> wo = new ArrayList<>();
		
		wo.add(pl);
		Collections.sort(wo);
		
/*		
		pl.koszt = 1;
		Plansza pl2  = new Plansza();
		pl2.koszt = 2;
		Plansza pl22  = new Plansza();
		pl22.koszt = 22;
		

		oo.add(pl22);
		oo.add(pl);
		oo.add(pl2);
			

		Collections.sort(oo);
		System.out.print(oo.get(2).koszt);
		
	*/	
		//pl2 = (Plansza) pl.clone();
		//oo.add(pl2);
//		System.out.print(oo.size());
		
	}

}
