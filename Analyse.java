
public class Analyse {
	public static int paar,doppelpaar,drilling,poker,fullhouse,flush,straße,straightFlush,roylflush,highkart;
	public static int z;
	public static void main(String[] args) 
	{
		int anzVersuche= 100000;
		Patch p = new Patch();
		Karte[] karten = new Karte[52];
		Karte[] hand = new Karte[5];
		Methoden m = new Methoden();
		JDBC j = new JDBC();
		int pz=0,dpz=0,fhz=0,poz=0,flz=0,sz=0,sfz=0,rfz=0,dz=0;


		for(int i = 0; i< anzVersuche; i++){

			karten = p.kartenErzeugen();

			hand = p.handSuchen(karten);

			switch(m.ParrDrillingPoker(hand))
			{
			//paar
			case(1):
				pz++;
			break;
			//zwei paare
			case(2):
				dpz++;
			break;
			//drilling
			case(3):
				dz++;
			break;
			//poker
			case(4):
				poz++;
			break;
			//fullhouse
			case(5):
				fhz++;
			break;

			}

			if((m.IstFlush(hand)== true) && (m.Straße(hand)== false))
			{
				flz++;
			}
			if((m.IstFlush(hand)== true) && (m.Straße(hand)== true))
			{
				sfz++;
			}
			if((m.IstFlush(hand)== false) && (m.Straße(hand)== true))
			{
				sz++;
			}
			if((m.Royal(hand)==true) && (m.IstFlush(hand)==true))
			{
				rfz++;
			}



		}

		paar = pz;
		doppelpaar= dpz;
		drilling= dz;
		poker = poz;
		fullhouse = fhz;
		flush = flz;
		straße =sz;
		straightFlush = sfz;
		roylflush = rfz;
		highkart = anzVersuche - paar-doppelpaar-drilling-poker-fullhouse-flush-straße-straightFlush-roylflush;
		j.dadenbankErzeugen();
		j.tableErzeugen();
		j.insertTable();
		//j.drop();
		j.select();



	}



}

