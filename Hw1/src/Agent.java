package vilia002.hw1;

import java.io.FileNotFoundException;
import java.util.Calendar;

/**
* Describes a randomly generated person.
*
* The Agent has gender, birthday, name, city of birth, city of residence,
* and major.
* 
* @author Vasilis Ilia
* @version 1.0
* @since 2/09/2023
*/
public class Agent {	
	private String gender;
	private int[] birthday;
	private String name;
	private String cityBorn;
	private String cityNow;	
	private String major;
	
	/**
	 * Class constructor specifying Agent's characteristics.
	 * 	 
	 * @param  gender the gender of the Agent
	 * @param  birthday the birthday of the Agent. An array with the day at index 0, 
	 * the month at index 1 and year at index 2.
	 * @param  name the name of the Agent
	 * @param  cityBorn the city of birth of the Agent
	 * @param  cityNow the city of residence of the Agent
	 * @param  major the major of the Agent
	 */
	public Agent(String gender, int[] birthday, String name, String cityBorn,
				 String cityNow, String major) {
		this.gender = gender;
		this.birthday = birthday;
		this.name = name;
		this.cityBorn = cityBorn;
		this.cityNow = cityNow;
		this.major = major;		
	}

	/**
	 * Gets the gender of the Agent
	 * 
	 * @return Agent's gender	
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Gets the birthday of the Agent.
	 * 
	 * @return Agent's birthday.  The date the Agent was born, in {@link String} form.
	 */
	public String getBirthday() {
		String month = "";
		
		String[] months = {"January", "February", "March", "April", "May", "June", "July"
				, "August", "September", "October", "November", "December"};
		
		month = months[birthday[1] - 1];
		
		return birthday[0] + " of " + month + ", " + birthday[2];		
	}
	
	/**
	 * Gets the name of the Agent.
	 * 
	 * @return the Agent's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the city of birth of the Agent.
	 * 
	 * @return the Agent's city of birth
	 */
	public String getCityBorn() {
		return cityBorn;
	}	
	
	/**
	 * Gets the current city of residence of the Agent.
	 * 
	 * @return the Agent's current city of residence
	 */
	public String getCityNow() {
		return cityNow;
	}
	
	/**
	 * Gets the major of the Agent.
	 * 
	 * @return the Agent's major
	 */
	public String getMajor() {
		return major;
	}
	
	/**
	 * Agent introduces themselves.
	 * 
	 * @return a string that includes the Agent's name
	 */
	public String sayHello() {
		return agentSays("Hello my name is " + name + "!");				
	}
	
	/**
	 * Agent says their gender.
	 * 
	 * @return a string that includes the Agent's gender
	 */
	public String sayGender() {
		return agentSays("I am a " + gender + ".");		
	}
	
	/**
	 * Agent says their city of birth.
	 * 
	 * @return a string that includes the Agent's city of birth
	 */
	public String sayCityBorn() {
		return agentSays("I am from " + cityBorn + ".");		
	}
	
	/**
	 *  Agent says the date they were born. 
	 *  	
	 * @return a string that includes the Agent's birthday
	 */
	public String sayAge() {
		return agentSays("I was born on the " + getBirthday() + ".");		
	}
	
	/**
	 * Agent says their age. 
	 * 
	 * Calculates Agent's age by subtracting the current year from the year the 
	 * Agent was born. Makes use of {@link Calendar} to get the current year.
	 * 
	 * @return a string that includes the Agent's age in years
	 */
	public String howOldAreYou() {		
		int yearsOld = Calendar.getInstance().get(Calendar.YEAR) - birthday[2];
		return agentSays("I am " + yearsOld + " years old.");	
	}
	
	/**
	 * Agent says their major.
	 * 
	 * @return a string that includes the Agent's major
	 */
	public String sayMajor() {
		return agentSays("I am majoring in " + major + ".");		
	}
	
	/**
	 * Agent says their current city of residence.
	 * 
	 * @return a string that includes Agent's current city of residence
	 */
	public String sayCityNow() {
		return agentSays("I live in " + cityNow + ".");		
	}
	
	/**
	 * Prefixes a string with "Agent says: and suffixes it with ".	 
	 * 
	 * @param str Agent's sentence
	 * @return a string with the added prefix, Agent's sentence and added suffix
	 */
	public String agentSays(String str) {
		return name + " says: " + '"' + str + '"';
	}
	
	/**
	 * Agent introduces themselves.
	 * 
	 * Makes use of all the methods that give information about the Agent.
	 */
	public void whoAreYou() {
		System.out.println(sayHello());
		System.out.println(sayGender());
		System.out.println(sayCityBorn());
		System.out.println(sayAge());
		System.out.println(howOldAreYou());
		System.out.println(sayMajor());
		System.out.println(sayCityNow());
	}
	
	/**
	 * Generates an Agent.
	 * 
	 * All of the Agent's information are chosen randomly. Name, city of birth, 
	 * city of residence and major are generated using {@link WordList}.
	 * 
	 * @return the created Agent with the randomly chosen information
	 * @throws FileNotFoundException If a file for the characteristics of the 
	 * Agent is not found or is inaccessible.
	 */
	public static Agent generateAgent() throws FileNotFoundException {
		String gender;
		int[] birthday = new int[3];
		String name;
		String cityBorn;
		String cityNow;	
		String major;
		
		if (Math.random() > 0.5)
			gender = "male";
		else
			gender = "female";
		
		birthday = getRandomBirthday();
		
		WordList names;		
	
		if (gender == "male") 
			names = new WordList("MaleNames.txt");
		else
			names = new WordList("FemaleNames.txt");
		
		WordList cities = new WordList("Cities.txt");
		WordList majors = new WordList("Majors.txt");
		
		name = names.getRandomWord();
		cityBorn = cities.getRandomWord();
		cityNow = cities.getRandomWord();
		major = majors.getRandomWord();
		
		return new Agent(gender, birthday, name, cityBorn, cityNow, major);			
	}
	
    /*
     *  Private method for calculating a random date for the Agent's birthday.
     *  Returns an integer array of size 3.	
     */
	private static int[] getRandomBirthday() {
		int day, month, year;
		
		month = getRandomInteger(1, 12);
		
		// Depending on the month, the possible number for the day of the date varies.
		switch (month) {
			case 1, 3, 5, 7, 8, 10, 12:
				day = getRandomInteger(1, 31);
				break;
			case 2:
				day = getRandomInteger(1, 28);
				break;
			default:
				day = getRandomInteger(1, 30);
		}
		
		int maxAge = 110;
		
		//  The year of the date gets calculated by subtracting from the current year 
		//  a random number from 1 to maxAge
		year = Calendar.getInstance().get(Calendar.YEAR) - getRandomInteger(1, maxAge);
		
		int[] birthday = {day, month, year};
		
		return birthday;		
	}
	
	/*
	 *  Private method for calculating a random integer number from start integer
	 *  in the range specified.
	 */
	private static int getRandomInteger(int start, int range) {
		return (int) (start + (Math.random() * range));
	}	
}
