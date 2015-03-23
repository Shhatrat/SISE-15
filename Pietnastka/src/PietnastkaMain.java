import java.util.HashMap;
import java.util.Queue;



public class PietnastkaMain {
		
	public static void main(String[] args) 
	{
		Plansza pl = new Plansza();
//		System.out.print("SS");
		pl.wypelnijPoKolei();
//		pl.wypisz();
		BFS oo = new BFS(pl);
		oo.przeszukaj();
		
		


	}

}
