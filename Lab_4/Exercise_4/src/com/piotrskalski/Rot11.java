package com.piotrskalski;

public class Rot11 implements Algorithm {

    // class fields that hold alphabet and rotation
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    private static final int rotation = 11;

    // =================================================================================================================

    public String support (String word, int move) {

        // variable that holds string that will be returned after encryption
        String result = "";

        // before we begin any operations on the string, let's set it in lowercase
        word = word.toLowerCase();

        // iteration over letters in word that we will encryption
        for (char i : word.toCharArray()) {

            // index of letter in alphabet after encryption it may be greater then length of alphabet
            int index = alpha.indexOf(i) + move;

            // we ensure tat the index of letter is smaller than the length of the alphabet
            index = (index + alpha.length()) % alpha.length();

            // adding encrypted letter
            result += alpha.charAt(index);
        }

        // returning encrypted word
        return result;
    }

    // =================================================================================================================

    // single word encoding method
    @Override
    public String crypt(String word) {
        return support(word, rotation);
    }

    // =================================================================================================================

    // single word decrypting method
    @Override
    public String decrypt(String word) {
        return support(word, -rotation);
    }
}
