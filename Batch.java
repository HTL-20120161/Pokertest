
public class Batch
{
	static Karte[] karten = new Karte[52];
	public static Karte[] hand = new Karte[5];
	
	public static Karte[] kartenErzeugen() {
		
	int j = 2;

	for(int i = 0 ; i < 13; i++)
	{ 
		if(i == 9)
		{
			karten[i] = new Karte("Herz","B");

		}
		else if(i==10)
		{
			karten[i] = new Karte("Herz","D");

		}
		else if(i==11)
		{
			karten[i] = new Karte("Herz","K");

		}
		else if(i==12)
		{
			karten[i] = new Karte("Herz","A");
		}
		else{

			karten[i] = new Karte("Herz",""+j);
			j++;
		}
	}

	j=2;
	
	for(int i = 13 ; i < 26; i++)
	{ 

		if(i == 22)
		{
			karten[i] = new Karte("Laub","B");

		}
		else if(i==23)
		{
			karten[i] = new Karte("Laub","D");

		}
		else if(i==24)
		{
			karten[i] = new Karte("Laub","K");

		}
		else if(i==25)
		{
			karten[i] = new Karte("Laub","A");
		}
		else{

			karten[i] = new Karte("Laub",""+j);
			j++;
		}
	}

	j=2;
	for(int i = 26 ; i < 39; i++)
	{ 
		if(i == 35)
		{
			karten[i] = new Karte("Pik","B");

		}
		else if(i==36)
		{
			karten[i] = new Karte("Pik","D");

		}
		else if(i==37)
		{
			karten[i] = new Karte("Pik","K");

		}
		else if(i==38)
		{
			karten[i] = new Karte("Pik","A");
		}
		else{

			karten[i] = new Karte("Pik",""+j);
			j++;
		}
	}

	j=2;
	
	for(int i = 39 ; i < 52; i++)
	{ 

		if(i == 48)
		{
			karten[i] = new Karte("Karo","B");

		}
		else if(i==49)
		{
			karten[i] = new Karte("Karo","D");

		}
		else if(i==50)
		{
			karten[i] = new Karte("Karo","K");

		}
		else if(i==51)
		{
			karten[i] = new Karte("Karo","A");
		}
		else{

			karten[i] = new Karte("Karo",""+j);
			j++;
		}
		
	}
	return karten;
	}

    public static Karte[] handSuchen(Karte[] karten)
    {
    	int zz = karten.length;
		int z = karten.length-1;
		Karte[] hand = new Karte[5];

		for (int i = 0; i < hand.length; i++)
		{
			int erg = (int) (Math.random()*zz);	
			hand[i] = karten[erg] ;
			karten[erg] = karten[z];
			z--;
			zz--;	
		}

		return hand;
    }

   
}

