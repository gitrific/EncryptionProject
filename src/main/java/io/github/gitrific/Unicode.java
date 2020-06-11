package io.github.gitrific;

public class Unicode extends Algorithm{

    @Override
    public String encrypt (String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        int N = message.length();

        for (int i = 0; i < N; i++) {
            encryptedMessage.append(Character.toString(message.charAt(i) + key));
        }

        return encryptedMessage.toString();
    }

    @Override
    public String decrypt (String cyphertext, int key) {
        StringBuilder decryptedMessage = new StringBuilder();
        int N = cyphertext.length();

        for (int i = 0; i < N; i++) {
            decryptedMessage.append(Character.toString(cyphertext.charAt(i) - key));
        }

        return decryptedMessage.toString();
    }
}
