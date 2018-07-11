import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import junit.framework.*;
public class SportsEventManagerTest {

	@Test
	public void checkaddGame()
	{
		SportsEventManager s=new SportsEventManager();
		assertEquals(0,s.addGame("game", 100));
		
		assertEquals(100,s.addGame("name1", -10));
		assertEquals(200,s.addGame("name1", 101));
		//assertEquals(null,s.searchGame("name1"));
		assertEquals(99,s.addGame(null, 100));
		
		//assertEquals(101,s.searchGame("game1"));
		for(int i=0;i<18;i++)
		{
			String s1="game"+i;
			assertEquals(0,s.addGame(s1, 100));
			
		}
		assertEquals(0,s.addGame("game20",100));
	}
	
	@Test
	public void checkAddPlayers()
	{
		SportsEventManager s=new SportsEventManager();
	assertEquals(0,s.addGame("game1", 100));
	String games[]=new String[1];
	games[0]="game1";
	assertEquals("abc added successfully",s.addPlayer("abc",games));
	assertEquals("abc already exists",s.addPlayer("abc", games));
	games[0]="game2";
	assertEquals("Error you cannot be registered for game2",s.addPlayer("xyz",games));
	
		
	}

	
	@Test
	public void checkAddSchedule()
	{
		SportsEventManager s=new SportsEventManager();
		assertEquals(0,s.addGame("game3", 100));
		String gameNames[]=new String[1];
		gameNames[0]="game3";
		assertEquals("abc added successfully",s.addPlayer("abc",gameNames));
		assertEquals("Monday added successfully",s.addSchedule("Monday", gameNames));
		assertEquals("Monday  already scheduled",s.addSchedule("Monday", gameNames));
		gameNames[0]="game4";
		assertEquals("Error you cannot be registered for game4",s.addSchedule("Tuesday", gameNames));
	}


	@Test
	public void checkdisplayGameWiseSchedule()
	{
		SportsEventManager s=new SportsEventManager();
		assertEquals(0,s.addGame("game1",100));
	    String gameNames[]=new String[1];
	    gameNames[0]="game1";
	    assertEquals("abc added successfully",s.addPlayer("abc", gameNames));
	    assertEquals("Thursday added successfully",s.addSchedule("Thursday",gameNames));
	    assertEquals("Players Names: abc"+ "\nDay Names: Thursday",s.displayGameWiseSchedule("game1"));
	    assertEquals("Error : This game is not valid",s.displayGameWiseSchedule("game5"));
	}


	
	@Test
	public void checkdisplayDayWiseSchedule()
	{
		SportsEventManager s=new SportsEventManager();
		assertEquals(0,s.addGame("game1", 100));
	
		String gameNames[]=new String[1];
		gameNames[0]="game1";
		assertEquals("abc added successfully",s.addPlayer("abc", gameNames));
		assertEquals("Thursday added successfully",s.addSchedule("Thursday",gameNames));
		
	
		assertEquals("Game = game1"+" abc\n" ,s.displayDayWiseSchedule("Thursday"));
		assertEquals("Error : This day is not valid",s.displayDayWiseSchedule("Tuesday"));
		
	}

	
@Test	
public void checkdisplayPlayerWiseSchedule()
{
	SportsEventManager s=new SportsEventManager();
	assertEquals(0,s.addGame("game1", 100));
	String gameNames[]=new String[1];
	gameNames[0]="game1";
	assertEquals("abc added successfully",s.addPlayer("abc",gameNames));
	assertEquals("Thursday added successfully",s.addSchedule("Thursday", gameNames));
	assertEquals("Game : game1"+" Thursday\n",s.displayPlayerWiseSchedule("abc"));
	assertEquals("Error : This player is not valid",s.displayPlayerWiseSchedule("pqr"));
}
	

@Test
public void checksearchGame()
{
	SportsEventManager s=new SportsEventManager();
	
	assertEquals(0, s.addGame("game1", 100));
	Game g=s.searchGame("game1");
	assertEquals("game1",g.getName());
	
	
}
	

@Test
public void checkSearchPlayer()
{
	SportsEventManager s=new SportsEventManager();
	assertEquals(0,s.addGame("game1", 100));
	String gameNames[]=new String[1];
	gameNames[0]="game1";
	assertEquals("abc added successfully",s.addPlayer("abc", gameNames));
	Player p=s.searchPlayer("abc");
	assertEquals("abc",p.getName());
}

@Test
public void checkSearchDay()
{
	SportsEventManager s=new SportsEventManager();
	assertEquals(0,s.addGame("game1", 100));
	String gameNames[]=new String[1];
	gameNames[0]="game1";
	assertEquals("Monday added successfully",s.addSchedule("Monday", gameNames));
	DaySchedule d=s.searchDay("Monday");
	assertEquals("Monday",d.getName());
}


}

