public class HighScore{
	private String name;
	private int score;
	public HighScore(String name, int score){
		this.name = name;
		this.score = score;
	}
	public String getName(){
		return name;
	}
	public int getScore(){
		return score;
	}
	public String toString(){
		return "Name: "+name+",Score: "+score;
	}
	public static void main(String[]args){
		/*
		String[] names = {"Jamal", "Emily", "Ruchi", "Mateo"};
		int[] scores = {100, 89, 78, 82};
		// Using Regular for Loops
		for(int i = 0; i < names.length; i++){
			System.out.println("Name: "+names[i] + ", Score: "+scores[i]);
		}
		*/

		HighScore[] highScores = {new HighScore("Jamal",100), new HighScore("Emily", 89), new HighScore("Ruchi",79), new HighScore("Mateo", 82)};

		// "for each score in the highScores array"
		for(HighScore score: highScores){
			//System.out.println(score);
			System.out.println("PERSON: "+score.getName()+",SCORE: "+score.getScore());
		}
		// Enhanced for loops cannot change/manipulate values. These are only temporary changes
		for(HighScore sri: highScores){
			if(sri.getScore() < 94)
				sri = new HighScore("Jimmy John", 99);
			System.out.println(sri);
		}
		System.out.println("Reprinted List");
		for(HighScore score: highScores){
			System.out.println(score);
		}
	}
}