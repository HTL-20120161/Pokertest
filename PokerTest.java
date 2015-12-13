import java.lang.reflect.Array;


public class PokerTest {



	public static void main(String[] args) 
	{

		// Variablen 
		
			
			

		String[] zahlen = new String[5];
		String[] farben = new String[5];
		int[] karten = new  int[52];
		int[] hand = new int[5];

		// Dem Kartenarray die "Karten" zuweisen

		for (int i = 0; i< karten.length; i++)
		{
			karten[i]=i+1;
			//System.out.print(karten[i]);
		}

		//Die Handkarten von der Methode in ein neues Array übernehmen

		hand = HandArray(karten);

		// Gibt die aktuelle Hand aus (ungeordnet)

		System.out.println("Karten:");

		for (int i = 0 ; i< 5; i++)
		{
			System.out.print(" "+hand[i]+"    ");
		}

		//Ausgaben

		System.out.println();
		System.out.println();
		System.out.println("Hand:");


		//Farben übergeben und ausgebn
		for (int i = 0 ; i < hand.length; i++)
		{

			farben[i] = Farben(hand[i]);
			System.out.print(" "+Farben(hand[i])+" ");

		}

		//Hand ausgeben
		System.out.println();

		for(int i = 0; i < hand.length; i++)
		{
			System.out.print(" "+Zahl(hand[i])+"    ");
		}

		System.out.println("\n");

		//String ad[] = {"Karo","Karo","Karo","Karo","Karo"};
		System.out.println("Analyse:\n");
		System.out.print("Flush:  ");
		if(IstFlush(farben)== true)
		{
			System.out.println("OHHH JA");
		}
		else
		{
			System.out.println("NOPE");
		}
		//int[] abc = {0,13,26,17,4};  konstruierter Full House
		
		System.out.println(""+ParrDrillingPoker(hand));

		//int asd[] = {9,10,11,12,13}; konstroierte Straße
		System.out.print("Straße: ");
		
		
		if(Straße(hand)== true)
		{
			System.out.println("OHHH JA");
		}
		else
		{
			System.out.println("NOPE");
		}
		//Prüft ob es ein Straight Flush ist

		if((Straße(hand)== true)&&(IstFlush(farben)== true))
		{
			System.out.println("Straight Flush");
		}
		//Prüft ob es ein Royal Flush ist
		
		if((IstFlush(farben)== true) && (Royal(hand) == true))
		{
			System.out.println("Royal Flush");
		}
		


	}
	//Methoden

	public static boolean Royal(int hand[])
	{
		int platzhalter;

		for(int i = 0; i < hand.length; i++)
		{for(int j =0; j<hand.length; j++)
		{
			if(hand[i]<hand[j])
			{
				platzhalter = hand[j];
				hand[j] = hand[i];
				hand[i] = platzhalter;
			}
		}
			
		}
		if( (hand[0]%13 == 0) && (hand[1]%13 == 9) && (hand[2]%13 == 10) && (hand[3]%13 == 11) && (hand[4]%13 == 12))
		{
			return true;
		}
		return false;
	}
	public static boolean Straße(int hand[]) 
	{
		int platzhalter;

		for(int i = 0; i < hand.length; i++)
		{for(int j =0; j<hand.length; j++)
		{
			if(hand[i]<hand[j])
			{
				platzhalter = hand[j];
				hand[j] = hand[i];
				hand[i] = platzhalter;
			}
		}
			
		}
		
		if((hand[0]%13 == (hand[1]%13 )-1) && (hand[1]%13 == (hand[2]%13) -1) && (hand[2]%13 == (hand[3]%13) -1) && (hand[3]%13 == (hand[4]%13) -1) )
		{
			return true;
		}
		
		
		else if ( (hand[0]%13 == 0) && (hand[1]%13 == 9) && (hand[2]%13 == 10) && (hand[3]%13 == 11) && (hand[4]%13 == 12))
		{
			return true;
		}
		
		return false;

	}
	public static String ParrDrillingPoker(int hand[])
	{
		int zaehler = 1;
		int paarzaehler = 0;
		int drillingszaeler = 0;
		int pokerzaehler = 0;

		for(int i = 0; i< hand.length; i++)
		{
			
			for(int j = i+1; j < hand.length ; j++)
			{
				if ((hand[i]%13 == hand[j]%13) && (hand[i] != -1) && hand[i] != hand[j])
				{
					hand[j] = -1;
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
			return "Full House";
		}
		else if(paarzaehler == 1 )
		{
			return "1 Paar";
		}
		else if(paarzaehler > 1)
		{
			return "2 Paare";
		}
		else if(drillingszaeler >= 1 )
		{
			return "1 Drilling";
		}
		else if(pokerzaehler >= 1 )
		{
			return " Poker";
		}
		if( (paarzaehler == 1) && (drillingszaeler ==1))
		{
			return "something";
		}
		return "NIXX";
		
	} 
	public static int[] HandArray(int[] karten) 
	{
		int zz = 51;
		int z = karten.length-1;
		int[] hand = new int[5];

		for (int i = 0; i < 5; i++)
		{
			int erg = (int) (Math.random()*zz);	
			hand[i] = karten[erg] ;
			karten[erg]=karten[z];
			z--;
			zz--;	
		}

		return hand;

	}
	public static String Farben(int zahl)

	{

		if(zahl <= 13)
		{
			return "Karo";
		}

		else if((zahl >13)&&(zahl)<=26)
		{
			return "Pik";
		}
		else if((zahl > 26)&&(zahl<=39))
		{
			return "Herz";
		}
		else if (zahl>39)
		{
			return "Kreuz";
		}

		return "Keine Karten";

	}
	public static String Zahl(int zahl)

	{
		if(zahl%13 == 1)
		{
			return "2";
		}
		if(zahl%13 == 2)
		{
			return "3";
		}
		if(zahl%13 == 3)
		{
			return "4";
		}if(zahl%13 == 4)
		{
			return "5";
		}if(zahl%13 == 5)
		{
			return "6";
		}if(zahl%13 == 6)
		{
			return "7";
		}if(zahl%13 == 7)
		{
			return "8";
		}if(zahl%13 == 8)
		{
			return "9";
		}if(zahl%13 == 9)
		{
			return "10";
		}if(zahl%13 == 10)
		{
			return "B";
		}
		if(zahl%13 == 11)
		{
			return "D";
		}
		if(zahl%13 == 12)
		{
			return "K";
		}
		if(zahl%13 == 0)
		{
			return "A";
		}

		return "nix";
	}
	public static boolean IstFlush(String[] farben)
	{ 
		String f1,f2,f3,f4,f5;

		f1 = farben[0];
		f2 = farben[1];
		f3 = farben[2];
		f4 = farben[3];
		f5 = farben[4];

		if(f1 == f2 && f1== f3 && f1== f4 && f1 == f5)
		{
			return true;
		}

		return false;
	}
}
