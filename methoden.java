
public class Methoden 
{

	public static boolean Royal (Karte[] hand)
	{
		if((hand[0].nr).equals( "10") && (hand[1].nr).equals( "B") && (hand[2].nr).equals( "D") && (hand[3].nr).equals( "K") && (hand[4].nr).equals( "A"))
		{
			return true;
		}
		return false;
	}


	public static boolean Straﬂe(Karte[] hand)
	{
		if((hand[0].nr).equals( "2") && (hand[1].nr).equals( "3") && (hand[2].nr).equals( "4") && (hand[3].nr).equals( "5") && (hand[4].nr).equals( "6"))
		{
			return true;
		}
		else if((hand[0].nr).equals( "3") && (hand[1].nr).equals( "4") && (hand[2].nr).equals( "5") && (hand[3].nr).equals( "6") && (hand[4].nr).equals( "7"))
		{
			return true;
		}
		else if((hand[0].nr).equals( "4") && (hand[1].nr).equals( "5") && (hand[2].nr).equals( "6") && (hand[3].nr).equals( "7") && (hand[4].nr).equals( "8"))
		{
			return true;
		}
		else if((hand[0].nr).equals( "5") && (hand[1].nr).equals( "6") && (hand[2].nr).equals( "7") && (hand[3].nr).equals( "8") && (hand[4].nr).equals( "9"))
		{
			return true;
		}
		else if((hand[0].nr).equals( "6") && (hand[1].nr).equals( "7") && (hand[2].nr).equals( "8") && (hand[3].nr).equals( "9") && (hand[4].nr).equals( "10"))
		{
			return true;
		}
		else if((hand[0].nr).equals( "7") && (hand[1].nr).equals( "8") && (hand[2].nr).equals( "9") && (hand[3].nr).equals( "10") && (hand[4].nr).equals( "B"))
		{
			return true;
		}
		else if((hand[0].nr).equals( "8") && (hand[1].nr).equals( "9") && (hand[2].nr).equals( "10") && (hand[3].nr).equals( "B") && (hand[4].nr).equals( "D"))
		{
			return true;
		}
		else if((hand[0].nr).equals( "9") && (hand[1].nr).equals( "10") && (hand[2].nr).equals( "B") && (hand[3].nr).equals( "D") && (hand[4].nr).equals( "K"))
		{
			return true;
		}
		else if((hand[0].nr).equals( "10") && (hand[1].nr).equals( "B") && (hand[2].nr).equals( "D") && (hand[3].nr).equals( "K") && (hand[4].nr).equals( "A"))
		{
			return true;
		}

		return false;
	}


	public static int ParrDrillingPoker(Karte hand[])

	{
		int zaehler = 1;
		int paarzaehler = 0;
		int drillingszaeler = 0;
		int pokerzaehler = 0;

		for(int i = 0; i< hand.length; i++)
		{

			for(int j = i+1; j < hand.length ; j++)
			{
				if (((hand[i].nr).equals(hand[j].nr))&&(hand[j].nr!= "0"))
				{
					hand[j].nr = "0";
					zaehler++;
				}

			}

			switch (zaehler) 
			{
			case 2 :
				paarzaehler ++;
				break;
			case 3 :
				drillingszaeler++;
				break;
			case 4 :
				pokerzaehler++;
				break;
			}
			zaehler =1;
		}

		if( (paarzaehler == 1) && (drillingszaeler ==1))
		{
			return 5;
		}
		else if(paarzaehler == 1 )
		{
			return 1;
		}
		else if(paarzaehler > 1)
		{
			return 2;
		}
		else if(drillingszaeler >= 1 )
		{
			return 3;
		}
		else if(pokerzaehler >= 1 )
		{
			return 4;
		}
		
		return 0;

	} 

	public static boolean IstFlush(Karte[] hand)
	{ 
		String f1,f2,f3,f4,f5;

		f1 = hand[0].farbe;
		f2 = hand[1].farbe;
		f3 = hand[2].farbe;
		f4 = hand[3].farbe;
		f5 = hand[4].farbe;

		if(f1.equals(f2) && f1.equals(f3) && f1.equals(f4) && f1.equals(f5))
		{
			return true;
		}

		return false;
	}



}
