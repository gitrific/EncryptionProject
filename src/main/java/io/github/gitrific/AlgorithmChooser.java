package io.github.gitrific;

public class AlgorithmChooser {
    public static Algorithm choose(String type) throws IllegalArgumentException {
        String _type = type.toUpperCase();

        switch(_type) {
            case "SHIFT":
                return new Shift();
            case "UNICODE":
                return new Unicode();
            default:
                throw new IllegalArgumentException("Incorrect argument: " + type);
        }
    }
}
