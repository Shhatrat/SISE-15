import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Plansza implements Cloneable, Comparator<Plansza>, Comparable<Plansza>
{
	int[][] tab = new int[4][4];
	int pozycjaZeroX;
	int pozycjaZeroY;
	public int rodzic;
	public Integer koszt;

	public enum Strony {
		GORA, LEWO, PRAWO, DOL;

		public static Strony getRandom() {
			return values()[(int) (Math.random() * values().length)];
		}
	}
	
	
	public int wyliczKoszt()
	{
		ArrayList<DoListy> lista = new ArrayList<>();
		//int l=0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
			{
				lista.add(new DoListy(i, j));
			}

		int wartosc=0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
			{
				wartosc+=Math.abs((lista.get(tab[i][j]).x - i));
				wartosc+=Math.abs((lista.get(tab[i][j]).y - j));
			}
		return wartosc;
	}
	
	
	public void dodajKoszt()
	{
		koszt = wyliczKoszt();
	}
	
	
	public Plansza zwrocPlanszePoPrzesunieciu(Plansza.Strony strona) throws CloneNotSupportedException
	{
		Plansza nowa  = (Plansza) this.clone();
		if(nowa.zmienBezWspolrzednych(strona)==0){return null;}else
		return nowa;
	}
	
	public void wylosujPoczatkowe() {

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				tab[i][j] = 99;

		Random rand = new Random();
		int[] doWypelnienia = new int[16];
		for (int i = 0; i < 16; i++) {
			doWypelnienia[i] = i;
		}

		boolean dalej = true;

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {

				while (dalej) {
					int random = rand.nextInt(16);
					if (doWypelnienia[random] == random) {
						tab[i][j] = random;
						doWypelnienia[random] = 99;
						dalej = false;
					}
				}
				dalej = true;
			}
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				if (tab[i][j] == 0) {
					pozycjaZeroX = i;
					pozycjaZeroY = j;
				}
			}

	}

	public String zwrocUstawienie() {
		String tmp = "";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				tmp = tmp + String.format("%02d", tab[i][j]);
		}
		return tmp;
	}

	public void wypelnijPoKolei() {
		int licz = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				tab[i][j] = licz;
				licz++;
			}
		pozycjaZeroX = 0;
		pozycjaZeroY = 0;
	}

	public void wylosujDoZrobienia(int iloscKrokow) {
		for (int i = 0; i < iloscKrokow; i++) {
			while (zmienBezWspolrzednych(Strony.getRandom()) == 0)
				;
		}

	}

	public void wypisz() {
		for (int i = 0; i < 4; i++) {
			System.out.println();
			for (int j = 0; j < 4; j++)
				System.out.print(tab[i][j] + "\t");
		}
		System.out.print(koszt +" \n");
	}

	// 0 - nie;
	// 1 - ok;
	public int sprawdz() {
		int[][] tab2 = new int[4][4];
		int licz = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				tab2[i][j] = licz;
				licz++;
			}
		if (Arrays.deepEquals(tab, tab2)) {
			return 1;
		} else {
			return 0;
		}
	}

	// 0 - nie da sie;
	// 1 - ok;
	// sprawdza czy jest 0 i czy czy pola sa obok siebie
	public int zmien(int ax, int ay, int bx, int by) {
		if (ax >= 0 && ay >= 0 && bx >= 0 && by >= 0 && ax < 4 && ay < 4
				&& bx < 4 && by < 4)
			if (((Math.abs(ax - bx) == 1) && Math.abs(ay - by) == 0)
					|| ((Math.abs(ax - bx) == 0) && Math.abs(ay - by) == 1))
				if (tab[ax][ay] == 0 || tab[bx][by] == 0) {
					int temp = tab[ax][ay];
					tab[ax][ay] = tab[bx][by];
					tab[bx][by] = temp;

					if (tab[bx][by] == 0) {
						pozycjaZeroX = bx;
						pozycjaZeroY = by;
					} else {
						pozycjaZeroX = ax;
						pozycjaZeroY = ay;
					}

					return 1;
				}
		return 0;
	}

	// 0 - nie da sie;
	// 1 - ok;
	public int zmienBezWspolrzednych(Strony strona) {
		switch (strona) {
		case LEWO: {
			if (zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX,
					pozycjaZeroY - 1) == 1) {
				return 1;
			}
			break;
		}
		case PRAWO: {
			if (zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX,
					pozycjaZeroY + 1) == 1) {
				return 1;
			}
			break;
		}
		case GORA: {
			if (zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX - 1,
					pozycjaZeroY) == 1) {
				return 1;
			}
			break;
		}
		case DOL: {
			if (zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX + 1,
					pozycjaZeroY) == 1) {
				return 1;
			}
			break;
		}
		}
		return 0;
	}

	// 0 - nie da sie;
	// 1 - ok;
	public int czyMogeRuszyc(Strony strona) {
		switch (strona) {
		case LEWO: {
			if (zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX,
					pozycjaZeroY - 1) == 1) {
				zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX,
						pozycjaZeroY + 1);
				return 1;
			}
			break;
		}
		case PRAWO: {
			if (zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX,
					pozycjaZeroY + 1) == 1) {
				zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX,
						pozycjaZeroY - 1);
				return 1;
			}
			break;
		}
		case GORA: {
			if (zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX - 1,
					pozycjaZeroY) == 1) {
				zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX + 1,
						pozycjaZeroY);
				return 1;
			}
			break;
		}
		case DOL: {
			if (zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX + 1,
					pozycjaZeroY) == 1) {
				zmien(pozycjaZeroX, pozycjaZeroY, pozycjaZeroX - 1,
						pozycjaZeroY);
				return 1;
			}
			break;
		}
		}
		return 0;
	}

	@Override
	public String toString() {
		String oo = "";
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				oo = oo + tab[i][j];
		return oo;
	}

	public Plansza() {
	}

	
	
	/*
	@Override
	public int hashCode() 
	{
		int tmp=0;
		int[] b = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23,29, 31, 37, 41, 43, 47};
		int licznik = 0;
		
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				{
				tmp= tmp + tab[i][j] * b[licznik];
				licznik++;

				}
				System.out.println(tmp);
		
		return tmp;		
	}
*/	

	@Override
	public int hashCode() {
		return this.rodzic;
		//		return this.wyliczKoszt();
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Plansza cloned = new Plansza();
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				cloned.tab[i][j] = tab[i][j];
			}
		cloned.pozycjaZeroX = pozycjaZeroX;
		cloned.pozycjaZeroY = pozycjaZeroY;
		cloned.rodzic = rodzic;
		cloned.koszt = koszt;
		return cloned;
	}


	@Override
	public boolean equals(Object arg0) 
	{
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) 
			{
				if(tab[i][j]!=((Plansza)arg0).tab[i][j])
				{
					return false;
				}
			}
			return true;
	}


	class PlanszaKosztComparator implements Comparator<Plansza> {
	    public int compare(Plansza o1, Plansza o2) {
	        return o1.koszt - o2.koszt;
	    }
	}


	@Override
	public int compare(Plansza o1, Plansza o2) {
		return Integer.compare(o1.koszt, o2.koszt);
//		return 0;
	}


	@Override
	public int compareTo(Plansza o) {
			return (this.koszt.compareTo(o.koszt));
//		return 0;
	}


		
}
