import java.util.Scanner;

/**
* A program to carry on conversations with a human user.
* This version: Uses advanced search for keywords
*
* @author Laurie White
* @version April 2012
*/
public class Magpie3{
	/**
	* Get a default greeting
	*
	* @return a greeting
	*/
	public String getGreeting(){
		return "Hello, let's talk.";
	}
	/**
	* Gives a response to a user statement
	*
	* @param statement the user statement
	* @return a response based on the rules given
	*/
	public String getResponse(String statement){
		String response = "";
		statement = statement.toLowerCase();
		if (findKeyword(statement, "no") >= 0)
			response = "Why so negative?";
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
			response = "Tell me more about your family.";
		else if (findKeyword(statement, "dog") >= 0 || findKeyword(statement, "cat") >= 0)//response 1
			response = "Tell me more about your pets.";
		else if (findKeyword(statement, "ms. robles") >= 0)//response 2
			response = "They sound like a good teacher.";
		else if (findKeyword(statement, "why") >= 0)//response 3
			response = "Why not?";
		else if (findKeyword(statement, "weather") >= 0)//response 4
			response = "The weather is always changing.";
		else if (findKeyword(statement, "stupid") >= 0)//response 5
			response = "You're stupid.";
		else if (findKeyword(statement, "i want") >= 0){//magpie 4 I Want Something
			String want = statement.substring(findKeyword(statement, "i want")+6);
			if (want.indexOf(".") > 0)
				want = want.substring(0, want.indexOf("."));
			response = "Would you really be happy if you had" + want + "?";
		}else if (findKeyword(statement, "i") >= 0 && findKeyword(statement, "you") >= 4){//magpie 4 I Something You
			String want = statement.substring(findKeyword(statement, "i")+2, findKeyword(statement, "you"));
			response = "Why do you " + want + "me?";
		}else if (statement.trim().length() > 0)
			response = getRandomResponse();
		else if(findKeyword(statement.trim(), "") >= 0)//response 6
			response = "Say something, please.";
		return response;
	}
	/**
	* Search for one word in phrase. The search is not case sensitive.
	* This method will check that the given goal is not a substring of
	* a longer string (so, for example, "I know" does not contain "no").
	*
	* @param statement the string to search
	* @param goal the string to search for
	* @param startPos the character of the string to begin the
	* 		search at
	* @return the index of the first occurrence of goal in
	* 		statement or -1 if it's not found
	*/
	private int findKeyword(String statement, String goal, int startPos){
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		// Refinement--make sure the goal isn't part of a word
		while (psn >= 0){
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0){
				before = phrase.substring(psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()){
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			/* determine the values of psn, before, and after at this point */
			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) // before is not a letter
				&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))){
				return psn;
			}
			 // The last position didn't work, so let's find
			 // the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(),psn + 1);
		}
		return -1;
	}
   /**
	* Search for one word in phrase. The search is not case sensitive.
	* This method will check that the given goal is not a substring of
	* a longer string (so, for example, "I know" does not contain "no").
	* The search begins at the beginning of the string.
	*
	* @param statement the string to search
	* @param goal the string to search for
	* @return the index of the first occurrence of goal in
	* 	statement or -1 if it's not found
	*/
	private int findKeyword(String statement, String goal){
	  return findKeyword(statement, goal, 0);
	}

	/**
	* Pick a default response to use if nothing else fits.
	*
	* @return a non-committal string
	*/
	private String getRandomResponse(){
	  final int NUMBER_OF_RESPONSES = 8;
	  double r = Math.random();
	  int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
	  String response = "";

		if (whichResponse == 0){
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1){
			response = "Hmmm.";
		}
		else if (whichResponse == 2){
			response = "Do you really think so?";
		}
		else if (whichResponse == 3){
			response = "You don't say.";
		}
		else if (whichResponse == 4){//added response 1
			response = "Okay.";
		}
		else if (whichResponse == 5){//added response 2
			response = "I don't care.";
		}
		else if (whichResponse == 6){//added response 3
			response = "Really?";
		}
		else if (whichResponse == 7){//added response 4
			response = "Wow!";
		}
		return response;
	}

	public static void main(String[] args){
	 Magpie3 maggie = new Magpie3();
	 System.out.println(maggie.findKeyword("yesterday is today's day before.", "day", 0));
	}
}
