import java.util.*;


public class BFS 
{
	public Plansza pl;
	public List<PlanszaDoListy> lista;
	
	
	
	
	public BFS(Plansza pl) 
	{
		this.pl = pl;
		this.lista = new ArrayList<PlanszaDoListy>();
	}
	
	public void ewwqewqe()
	{
		
	}

	public void przeszukaj()
	{
		lista.add(new PlanszaDoListy(0, pl));
		pl.zmienBezWspolrzednych(Plansza.Strony.DOL);
		lista.add(new PlanszaDoListy(1, pl));
		pl.zmienBezWspolrzednych(Plansza.Strony.DOL);
		lista.add(new PlanszaDoListy(1, pl));
		System.out.print(lista.toString());
		
	//	System.out.print("KONIEC, ilosc krokow=" + licznik);
		
	}	
	
}
