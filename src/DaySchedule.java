
public class DaySchedule {
	String dayName;
	Game[] games;
	public DaySchedule(String dayName, Game[] g) {
		super();
		this.dayName = dayName;
		this.games = g;
	}

	public String getName() {
		return dayName;
	}
	
}
