package io.github.gitrific;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String method = "";
        int key = 0;
        String data = "", inPath = "", outPath = "", result = "", algType = "";

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
                case "-alg":
                    algType = args[i + 1];
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

        Algorithm algorithm = AlgorithmChooser.choose(algType);

        switch (method) {
            case "":
            case "enc":
                result = algorithm.encrypt(data, key);
                break;
            case "dec":
                result = algorithm.decrypt(data, key);
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