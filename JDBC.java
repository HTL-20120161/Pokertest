import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC
{
	public static int i = 0;
	;
	 
	 public static long unicetimestep = System.currentTimeMillis();
	 
	public static Analyse a = new Analyse();
	
	public static void datenbankErzeugen()
	{
		Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    //System.out.println("Opened database successfully");
	  
	}
	
	public static void tableErzeugen() 
	{
		Connection c = null;
	    Statement stmt = null;
	   try {
	     // Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:poker.db");
	    // System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "Create TABLE IF NOT EXISTS VERSUCHE " +
	                   "(NR INT PRIMARY KEY     NOT NULL," +
	                   " HighKart 		INT NOT NULL    ,"+
	                   " Paare          INT    NOT NULL, " + 
	                   " DoppelPaare   INT     NOT NULL, " + 
	                   " Drillinge      INT NOT NULL, " + 
	                   " Poker			INT NOT NULL,"+
	                   "FullHouse 	    INT NOT NULL,"+
	                   "Flush			INT NOT NULL,"+
	                   "Straﬂe 		    INT NOT NULL,"+
	                   "StraightFlush  INT NOT NULL,"+
	                   "RoyalFlush	INT NOT NULL)";
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.close();
	   } catch ( Exception e ) {
	     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	     System.exit(0);
	    }
	   // System.out.println("Table created successfully");
	  }
		
	public static void insertTable()
	{  
	
		
		Connection c = null;
		Statement stmt = null;
		try {
			//Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:poker.db");
			c.setAutoCommit(false);
						

				stmt = c.createStatement();
				String sql = "INSERT INTO Versuche (NR,HighKart,Paare,DoppelPaare,Drillinge,Poker,FullHouse,Flush,Straﬂe,StraightFlush,RoyalFlush) " +  
							 "VALUES ("+unicetimestep+","+a.highkart+","+a.paar+","+a.doppelpaar+ "," +a.drilling+","+a.poker+","+a.fullhouse+","+a.flush+","+a.straﬂe+","+a.straightFlush+","+a.roylflush+");"; 
				stmt.executeUpdate(sql);

				i++;


			stmt.close();
			c.commit();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);


		}
	}
	
	public static void select()
	{

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:poker.db");
			c.setAutoCommit(false);
		//	System.out.println("Opened database successfully");

			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Versuche;" );
			
			while ( rs.next() ) {
				int id = rs.getInt("NR");
				int hk = rs.getInt("HighKart");
				int  paar = rs.getInt("Paare");
				int doppelpaar = rs.getInt("DoppelPaare");
				int drillinge = rs.getInt("Drillinge");
				int poker = rs.getInt("Poker");
				int fullhouse = rs.getInt("FullHouse");
				int flush = rs.getInt("Flush");
				int straﬂe = rs.getInt("Straﬂe");
				int sFlush = rs.getInt("StraightFlush");
				int rFlush = rs.getInt("RoyalFlush");
				
				System.out.println( "ID = " + id + " HighKart="+hk+"	Paare = " + paar+"   Dopppelparre="+doppelpaar+"  Drillinge="+drillinge+"  Poker="+poker+"  FullHouse="+fullhouse+"  Flush="+flush+"  Straﬂe="+straﬂe+"  StraightFlush="+sFlush+"  RoyalFlush="+rFlush);
				System.out.println();
			}
			


			rs.close();
			stmt.close();
			
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		//System.out.println("Operation done successfully");
	}
	
		public static void drop()
		{
			Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:poker.db");
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      String sql = "Drop TABLE IF  EXISTS VERSUCHE; " ;
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Table droped successfully");
		  
		}

	
}
