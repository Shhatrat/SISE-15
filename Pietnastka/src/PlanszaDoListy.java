
public class PlanszaDoListy 
{
	public int rodzic;
	public Plansza plansza;
	
	public PlanszaDoListy(int rodzic, Plansza plansza) 
	{
		super();
		this.rodzic = rodzic;
		this.plansza = plansza;
	}

	@Override
	public String toString() {
		return "PlanszaDoListy [plansza=" + plansza + "]";
	}
	
	
	
}