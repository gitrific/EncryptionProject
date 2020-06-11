package io.github.gitrific;

public class Shift extends Algorithm {
    @Override
    public String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String message, int key) {
        return encrypt(message, 26 - (key % 26));
    }
}
