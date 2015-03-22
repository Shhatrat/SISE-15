import java.util.*;


public class BFS 
{
	public Plansza pl;
	ArrayList<String> lista;
	
	public BFS (Plansza poczatkowy)
	{
		this.pl= poczatkowy;
		lista = new ArrayList<>();
	}
	
	public void przeszukaj()
	{
		System.out.println("OK");
		Boolean posortowane = false;
		if(pl.sprawdz()==1){posortowane=true;}
		while(posortowane==false)
		{
			if(pl.sprawdz()==1){posortowane=true;}
			//mozliwosci ruchu
			if(pl.zmienBezWspolrzednych(Plansza.Strony.GORA) ==1)
			{
				if(!czyByl())	
				{
					
				}
				pl.zmienBezWspolrzednych(Plansza.Strony.DOL);
				
			}	
		}
		System.out.print("KONIEC");
		
	}
	
	public boolean czyByl()
	{
		if(lista.contains(pl.zwrocUstawienie()))
		{
			return true;
		}
		else
			return false;
		
	}
	
	
}
