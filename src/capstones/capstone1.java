package capstones;

import java.util.*;

public class capstone1 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		// ask user to input a word to be translated to pig latin
		// continue to loop and ask the user if they want to translate another word,
		// until the user exits
		// convert each word to lowercase BEFORE translating
		// if word STARTS WITH A VOWEL then simply add "way" to the end of the word
		// if word STARTS WITH A CONSONANT then move all of the consonants...
		// ...that appear before the first vowel to the end of the word, then add “ay”
		// to the end of the word
		// note: treat "y" as a consonant

		boolean flag = true;

		while (flag) {
			System.out.println("What word would you like to translate to pig latin?");
			String userInput = scnr.nextLine();

			if (startsWithVowel(userInput)) {
				System.out.println(userInput.toLowerCase() + "way");
			} else {

				int index = indexOfFirstVowel(userInput);
				String consonantBeginning = "null";
				if (index != -1) {
					consonantBeginning = userInput.substring(0, index);
				}
				System.out.println(userInput.substring(index) + consonantBeginning + "ay");
			}
		}
	}

//	String consonantEnd = userInput.substring(index);
//	System.out.println(consonantEnd);

	public static boolean startsWithVowel(String word) {
		boolean flag;
		char ch = word.charAt(0);
		// System.out.println(ch);
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U') {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	final static String vowels = "aeiouy";

	public static int indexOfFirstVowel(String word) {
		String loweredWord = word.toLowerCase();

		for (int index = 0; index < loweredWord.length(); index++) {
			if (vowels.contains(String.valueOf(loweredWord.charAt(index)))) {
				return index;
			}
		}

		// handle cases where a vowel is not found
		return -1;
	}

}
