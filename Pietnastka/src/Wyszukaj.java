import java.util.*;

//import Plansza.Strony;

public class Wyszukaj {
	
	public Plansza pl;
	public List<Plansza> lista;
	public HashSet<Plansza> hash;
	public int licznik;

	public Wyszukaj(Plansza pl) {
		this.pl = pl;
		this.lista = new ArrayList<Plansza>();
		this.hash = new HashSet<>();
		licznik = 0;
	}

	public boolean sprawdzIdodajDoListy(int indeksRodzica)
			throws CloneNotSupportedException {
		if(wykonaj(indeksRodzica, Plansza.Strony.DOL,
				Plansza.Strony.GORA)){return true;};
		if(wykonaj(indeksRodzica, Plansza.Strony.GORA,
				Plansza.Strony.DOL)){return true;};
		if(wykonaj(indeksRodzica, Plansza.Strony.PRAWO,
				Plansza.Strony.LEWO)){return true;};
		if(wykonaj(indeksRodzica, Plansza.Strony.LEWO,
				Plansza.Strony.PRAWO)){return true;};
				return false;
	}

	public boolean wykonaj(int indeksRodzica, Plansza.Strony strona,
			Plansza.Strony strona2) throws CloneNotSupportedException {
		Plansza pl = lista.get(indeksRodzica);
		if (pl.zmienBezWspolrzednych(strona) == 1) {
			
			
			if (pl.sprawdz() == 1) 
			{

//				lista.add((Plansza) pl.clone());
				Plansza cloned = (Plansza) pl.clone();
				cloned.rodzic = indeksRodzica;
				lista.add(cloned);
				pl.wypisz(); System.out.println("\n\n\n ZNALAZLEM");
				pl.zmienBezWspolrzednych(strona2);

				return true;
			}

						
			Plansza cloned = (Plansza) pl.clone();
			cloned.rodzic = indeksRodzica;
			if (hash.add(cloned)) {
				lista.add(cloned);
				System.out.println();
				
				pl.wypisz();
				System.out.println(lista.size());
			}

			pl.zmienBezWspolrzednych(strona2);
		}
		return false;

	}
	
	public void wyszukajZwartoscia() throws CloneNotSupportedException
	{
		int licznik = 0;
		boolean koniec = false;
		while(!koniec && licznik <1000)
		{
			int wynik= 101010;
			Plansza nowa =null;
			Plansza nowaok = null;
			
			
			for(Plansza.Strony oo : Plansza.Strony.values())
			{
				nowa = pl.zwrocPlanszePoPrzesunieciu(oo);
				if(nowa!=null)
				{
					if(hash.add(nowa))
					{
						int w = nowa.wyliczKoszt();
						if(w<wynik)
						{
							wynik = w;
							nowaok = nowa;
						}
					}
					nowa=null;
				}
			}
			
			nowaok.wypisz();
			pl= nowaok;
			hash.add((Plansza) nowaok.clone());
			licznik ++;
			System.out.println("-----------" + licznik);
			System.out.println("_________" + hash.size() + "________" + nowaok.hashCode()); 
			if(pl.sprawdz()==1)
			{
				System.out.print(licznik+"KONIEC");
				koniec =  true;}
			
		}
	}

	public int przeszukaj() throws CloneNotSupportedException {
		Plansza poczatkowa = (Plansza) pl.clone();
		if (pl.sprawdz() == 1) {

			System.out.println("OK");
			pl.wypisz();
			return 0;
		} else {
			pl.rodzic = 0;
		}
		Plansza tmp = (Plansza) pl.clone();
		tmp.rodzic = pl.rodzic;
		lista.add(tmp);
		hash.add(tmp);
		licznik = 0;

		boolean koniec = false;
		while (!koniec) {
			koniec = sprawdzIdodajDoListy(licznik);
			licznik++;
			if(licznik > 1221010){koniec= true;}
			
		}	

		int i = lista.size()-1;
		System.out.println("LICZBA ELEMENTOW = " + lista.size());
		while(i!=0)
		{
			System.out.println("\n\nINDEKS = " + i);
			lista.get(i).wypisz();
			i = lista.get(i).rodzic;
		}

		System.out.println("\n\nsprawdzenie poczatkowej");
		poczatkowa.wypisz();
		return 0;
	}
	
}