import java.util.*;

public class BFS {
	public Plansza pl;
	public List<Plansza> lista;
	public HashSet<int[][]> hash;
//	public HashSet<Plansza> hash;
	public int licznik;

	public BFS(Plansza pl) {
		this.pl = pl;
		this.lista = new ArrayList<Plansza>();
		this.hash = new HashSet<>();
		licznik = 0;
	}

	public boolean sprawdzIdodajDoListy(int indeksRodzica)
			throws CloneNotSupportedException {
		if(wykonaj(lista.get(indeksRodzica), Plansza.Strony.DOL,
				Plansza.Strony.GORA)){System.out.print("jest");return true;};
		if(wykonaj(lista.get(indeksRodzica), Plansza.Strony.GORA,
				Plansza.Strony.DOL)){System.out.print("jest");return true;};
		if(wykonaj(lista.get(indeksRodzica), Plansza.Strony.PRAWO,
				Plansza.Strony.LEWO)){System.out.print("jest");return true;};
		if(wykonaj(lista.get(indeksRodzica), Plansza.Strony.LEWO,
				Plansza.Strony.PRAWO)){System.out.print("jest");return true;};
				return false;
	}

	public boolean wykonaj(Plansza pl, Plansza.Strony strona,
			Plansza.Strony strona2) throws CloneNotSupportedException {
		if (pl.zmienBezWspolrzednych(strona) == 1) {
			if (pl.sprawdz() == 1) {

				lista.add((Plansza) pl.clone());
				pl.wypisz(); System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
				return true;
				
			}

			Plansza cloned = (Plansza) pl.clone();
			if (hash.add(cloned.tab)) {
				lista.add(cloned);
				System.out.println(); pl.wypisz();
			}

			pl.zmienBezWspolrzednych(strona2);
		}
		return false;

	}

	public int przeszukaj() throws CloneNotSupportedException {
		if (pl.sprawdz() == 1) {

			System.out.println("OK");
			pl.wypisz();
			return 0;
		} else {
			pl.rodzic = 0;
		}
		lista.add((Plansza) pl.clone());
		hash.add(pl.tab);
		licznik = 0;

		boolean koniec = false;
		while (!koniec) {
			koniec = sprawdzIdodajDoListy(licznik);
//			pl.wypisz();
			licznik++;
			//System.out.println(); pl.wypisz();

			if(licznik > 122110){koniec= true;}
			
		}

		return 0;
	}

}
