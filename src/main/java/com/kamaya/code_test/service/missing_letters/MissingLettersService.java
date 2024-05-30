package com.kamaya.code_test.service.missing_letters;

import org.springframework.stereotype.Service;

@Service
public class MissingLettersService {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	public String getMissingLetters(String input){
		// Early output if there is no letter in the input, where the whole alphabet is returned
		if(input.isBlank()){
			return ALPHABET;
		}

		String response = "";
		char[] alphabetArray = ALPHABET.toCharArray();

		for (char character : alphabetArray) {
			int timesRepeatCharacter = 0;
			for (int indexInput = 0; indexInput < input.length(); indexInput++) {
				char characterToValidate = Character.toLowerCase(input.charAt(indexInput));
				if (character == characterToValidate) {
					timesRepeatCharacter++;
				}
			}

			//If the character does not appear in the input word, we concatenate the character to the response string of missing letters
			response = timesRepeatCharacter > 0 ? response : response.concat(String.valueOf(character));
		}

		return response;
	}
}
