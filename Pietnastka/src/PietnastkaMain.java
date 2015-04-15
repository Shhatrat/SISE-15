import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;




public class PietnastkaMain {
		
	public static void main(String[] args)  throws CloneNotSupportedException 
	{


/*
 		int[][] nowa = new int[][] {{1, 5,	2,	3},	
		{4,	9,	6,	7},	
		{8,	13,	0,	10},	
		{12,14,	15,	11}};
		
		pl.tab = nowa;
		pl.pozycjaZeroX=2;
		pl.pozycjaZeroY=2;
*/		
		
		
		ArrayList<Integer> wyniki = new ArrayList<>();
		ArrayList<Integer> wyniki2 = new ArrayList<>();
		
		for(int i=0; i<10; i++)
		{
		Plansza pl = new Plansza();
		pl.wypelnijPoKolei();
		pl.wylosujDoZrobienia(10);		
		Wyszukaj oo = new Wyszukaj(pl);
		Wyszukaj oo2 = new Wyszukaj((Plansza) pl.clone());		
		
		System.currentTimeMillis();
		long start=System.currentTimeMillis();
		if(oo.bfs()==1)
		{
			long stop=System.currentTimeMillis();
			wyniki.add((int) (stop-start));
		}
		else
		{
			wyniki.add(-1);
		};
		
		
		System.currentTimeMillis();
		long start2=System.currentTimeMillis();
		if(oo2.heurystyczny()==1)
		{
			long stop2=System.currentTimeMillis();
			wyniki2.add((int) (stop2-start2));
		}
		else
		{
			wyniki2.add(-1);
		};
		
//		System.out.print(oo.bfs());
		//oo.heurystyczny();
		//System.out.println("\nCzas wykonania:"+(stop-start));
		}
		System.out.print("\n\n\n\n\n");
		System.out.println(wyniki.toString());
		System.out.print(wyniki2.toString());
	}


}
