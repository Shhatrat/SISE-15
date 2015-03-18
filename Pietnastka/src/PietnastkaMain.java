
public class PietnastkaMain {

	public static void main(String[] args) 
	{
		Plansza pl = new Plansza();
		
		pl.wypelnijPoKolei();

		
		System.out.println();
		System.out.println();
		
		
		System.out.println(pl.pozycjaZeroX);
		System.out.println(pl.pozycjaZeroY);

		
		
		
		pl.wypisz();
		System.out.println();
		System.out.println();
		
		pl.wylosujDoZrobienia(3000);
		
		pl.wypisz();
		
		System.out.println();
		System.out.println();
		
		System.out.println(pl.pozycjaZeroX);
		System.out.println(pl.pozycjaZeroY);
		
		
	}

}
