package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static String encrypt (String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        int N = message.length();

        for (int i = 0; i < N; i++) {
            encryptedMessage.append(Character.toString(message.charAt(i) + key));
        }

        return encryptedMessage.toString();
    }

    public static String decrypt (String cyphertext, int key) {
        StringBuilder decryptedMessage = new StringBuilder();
        int N = cyphertext.length();

        for (int i = 0; i < N; i++) {
            decryptedMessage.append(Character.toString(cyphertext.charAt(i) - key));
        }

        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        String method = "";
        int key = 0;
        String data = "", inPath = "", outPath = "", result = "";

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    method = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    inPath = args[i + 1];
                    break;
                case "-out":
                    outPath = args[i + 1];
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + args[i]);
            }
        }

        if (data == "") {
            File file = new File(inPath);
            try (Scanner scanner = new Scanner(file)) {
                data = scanner.nextLine();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        switch (method) {
            case "":
            case "enc":
                result = encrypt(data, key);
                break;
            case "dec":
                result = decrypt(data, key);
                break;
            default:
                System.out.println("method name invalid");
                break;
        }

        if (outPath != "") {
            File file = new File(outPath);
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.print(result);
            } catch (IOException e) {
                System.out.printf("An exception occurs %s", e.getMessage());
            }

        } else {
            System.out.println(result);
        }

    }
}
