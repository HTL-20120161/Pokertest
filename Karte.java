import java.util.Random;


public class Karte {
	public String farbe;
	public String nr;
	
	Karte(){}


	Karte(String farbe, String nr)
	{
		this.farbe = farbe;
		this.nr = nr;
	}
	
	//Gets und sets

	public String getFarbe() {
		return farbe;
	}


	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}


	public String getNr() {
		return nr;
	}


	public void setNr(String nr) {
		this.nr = nr;
	}


	
		
	

}



