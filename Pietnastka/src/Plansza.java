import java.util.Random;

public class Plansza {
	int[][] tab = new int[4][4];
	int pozycjaZeroX;
	int pozycjaZeroY;

	public enum Strony
	{
		GORA, LEWO, PRAWO, DOL;

	    public static  Strony getRandom() {
	        return values()[(int) (Math.random() * values().length)];	
	    }
	}

	public void wylosujPoczatkowe() 
	{

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
			for (int j = 0; j < 4; j++)
			{
				if(tab[i][j]==0)
				{
					pozycjaZeroX=i;
					pozycjaZeroY=j;					
				}
			}
			
		
	}
	
	public void wypelnijPoKolei()
	{
		int licz=0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
			{
				tab[i][j]=licz;
				licz++;
			}
		pozycjaZeroX = 0;
		pozycjaZeroY = 0;
	}

	
	////////////////	////////////////	////////////////	////////////////
	////////////////	////////////////	////////////////	////////////////
	////////////////	////////////////	////////////////	////////////////
	////////////////	////////////////	////////////////	////////////////

	public void wylosujDoZrobienia(int iloscKrokow)
	{
		for(int i = 0 ; i<iloscKrokow ; i++)
		{
			while(zmienBezWspolrzednych(Strony.getRandom())==0);
		}
	   

	}

	public void wypisz() {
		for (int i = 0; i < 4; i++) {
			System.out.println();
			for (int j = 0; j < 4; j++)
				System.out.print(tab[i][j]+"\t");
		}
	}
	
	//0 - nie da sie;
	//1 - ok;
	// sprawdza czy jest 0 i czy czy pola sa obok siebie
	public int zmien(int ax, int ay, int bx, int by)
	{
		if(ax>=0 && ay>=0 && bx>=0 && by>=0 && ax<4 && ay<4 && bx<4 && by<4 )
		if(((Math.abs(ax-bx)==1)&&Math.abs(ay-by)==0) || ((Math.abs(ax-bx)==0)&&Math.abs(ay-by)==1) )
		if(tab[ax][ay]==0 || tab[bx][by]==0)
		{
			int temp = tab[ax][ay];
			tab[ax][ay] = tab[bx][by];
			tab[bx][by] = temp;
			
			if(tab[bx][by] == 0 ) 
			{
				pozycjaZeroX=bx;
				pozycjaZeroY=by;	
			}
			else
			{
				pozycjaZeroX=ax;
				pozycjaZeroY=ay;				
			}
				
			return 1;
		}
		return 0;
	}
	
	//0 - nie da sie;
	//1 - ok;
	public int zmienBezWspolrzednych(Strony strona)
	{
		switch (strona)
		{
		case LEWO:{if(zmien(pozycjaZeroX,pozycjaZeroY, pozycjaZeroX,pozycjaZeroY-1 )==1){ return 1;} break;}
		case PRAWO: {if(zmien(pozycjaZeroX,pozycjaZeroY, pozycjaZeroX,pozycjaZeroY+1)==1){return 1;} break;}
		case GORA: {if(zmien(pozycjaZeroX,pozycjaZeroY, pozycjaZeroX-1,pozycjaZeroY)==1){return 1;} break;}
		case DOL:{if(zmien(pozycjaZeroX,pozycjaZeroY, pozycjaZeroX+1,pozycjaZeroY)==1){return 1;} break;}
		}
		return 0;
	}
}
