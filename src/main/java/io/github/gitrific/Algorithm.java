package io.github.gitrific;

public abstract class Algorithm {
    public abstract String encrypt (String message, int key);
    public abstract String decrypt (String message, int key);
}
