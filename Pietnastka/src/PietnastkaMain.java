import java.math.BigInteger;
import java.util.Dictionary;
import java.util.Map;


public class PietnastkaMain {

	public static void main(String[] args) 
	{
		Plansza pl = new Plansza();
		System.out.print("SS");
		pl.wypelnijPoKolei();
	//	pl.wypisz();
//		System.out.print(pl.zwrocUstawienie());
	//	BFS oo = new BFS(pl);
		//oo.przeszukaj();
		pl.wypisz();
		BFS oo = new BFS(pl);
		oo.przeszukaj();
	//	Dictionary<String, int> oo = new  
	}

}
