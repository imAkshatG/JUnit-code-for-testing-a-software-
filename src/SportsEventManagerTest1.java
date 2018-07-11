import static org.junit.Assert.*;

import org.junit.Test;

public class SportsEventManagerTest1 {
	
	@Test
	public void checkaddGame()
	{
		SportsEventManager s=new SportsEventManager();
		assertEquals(0,s.addGame("a1",100));
		assertEquals(200,s.addGame("a1", 110));
		assertEquals(99,s.addGame(null, 100));
		for(int i=0;i<18;i++)
		{
			String g="game"+i;
			assertEquals(0,s.addGame(g,100));
		}
		
		assertEquals(0,s.addGame("game20", 100));
	}

	@Test
	public void checkaddPlayers()
	{
		SportsEventManager s=new SportsEventManager();
		s.addGame("game1", 100);
        String games[]=new String[1];
        games[0]="game1";
       assertEquals("abc added successfully",s.addPlayer("abc",games));
       assertEquals("abc already exists",s.addPlayer("abc",games));
       games[0]="game2";
       assertEquals("Error you cannot be registered for game2",s.addPlayer("xyz",games));
       
       
	}

	@Test
	public void checkaddSchedule()
	{
		SportsEventManager s=new SportsEventManager();
		assertEquals(0,s.addGame("game1", 100));
		String games[]=new String[1];
		games[0]="game1";
		assertEquals("day1 added successfully",s.addSchedule("day1", games));
		assertEquals("day1  already scheduled",(s.addSchedule("day1", games)));
		games[0]="game2";
		assertEquals("Error you cannot be registered for game2",s.addSchedule("day2", games));
		
	}
	
@Test
public void checkdisplayGameWiseSchedule()
{
	SportsEventManager s=new SportsEventManager();
	assertEquals(0,s.addGame("game1", 100));
	String games[]=new String[1];
	games[0]="game1";
	
	assertEquals("a1 added successfully",s.addPlayer("a1", games));
	assertEquals("day1 added successfully",s.addSchedule("day1", games));
	assertEquals("Players Names: a1"+"\nDay Names: day1",s.displayGameWiseSchedule("game1"));
	assertEquals("Error : This game is not valid",s.displayGameWiseSchedule("gaem2"));
}
	
@Test
public void checkdisplayDayWiseSchedule()
{
	SportsEventManager s=new SportsEventManager();
    assertEquals(0,s.addGame("game1", 100));
    String games[]=new String[1];
    games[0]="game1";
    assertEquals("a1 added successfully",s.addPlayer("a1", games));
    assertEquals("day1 added successfully",s.addSchedule("day1", games));
    assertEquals("Game = game1 "+"a1\n",s.displayDayWiseSchedule("day1"));
    assertEquals("Error : This day is not valid",s.displayDayWiseSchedule("day2"));
}
	
@Test
public void checkdisplayPlayerWiseSchedule()
{
	SportsEventManager s=new SportsEventManager();
	assertEquals(0,s.addGame("game1", 100));
	String games[]=new String[1];
	games[0]="game1";
	assertEquals("a1 added successfully",s.addPlayer("a1", games));
	assertEquals("day1 added successfully",s.addSchedule("day1", games));
	assertEquals("Game : game1 "+"day1\n",s.displayPlayerWiseSchedule("a1"));
	assertEquals("Error : This player is not valid",s.displayPlayerWiseSchedule("a2"));
	
	
}
}
