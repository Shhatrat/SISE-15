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
		HashSet<Plansza> hs = new HashSet<>();
		pl.wylosujDoZrobienia(10);
		
		pl.wypisz();
		
				System.out.print("O");
		//pl.wypelnijPoKolei();
		BFS oo = new BFS(pl);
		oo.przeszukaj();
//*/	hs.add(oo);	
		
	//	System.out.println(oo.toString());
	//	System.out.println(oo.clone().toString());
		
//		System.out.print(hs.toString());
	}

}
