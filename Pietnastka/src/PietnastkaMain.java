import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;




public class PietnastkaMain {
		
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		Plansza pl = new Plansza();
		pl.wypelnijPoKolei();
		pl.wylosujDoZrobienia(105);

/*
 		int[][] nowa = new int[][] {{1, 5,	2,	3},	
		{4,	9,	6,	7},	
		{8,	13,	0,	10},	
		{12,14,	15,	11}};
		
		pl.tab = nowa;
		pl.pozycjaZeroX=2;
		pl.pozycjaZeroY=2;
*/		
		
		System.currentTimeMillis();
		Wyszukaj oo = new Wyszukaj(pl);
		long start=System.currentTimeMillis();
		oo.najnowsze();
		long stop=System.currentTimeMillis();
		System.out.println("Czas wykonania:"+(stop-start));
		
	}

}
