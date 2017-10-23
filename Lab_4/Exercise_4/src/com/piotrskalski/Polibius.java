package com.piotrskalski;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Polibius implements Algorithm {

    private final static char[][] polib = {

            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'k'},
            {'l', 'm', 'n', 'o', 'p'},
            {'q', 'r', 's', 't', 'u'},
            {'v', 'w', 'x', 'y', 'z'}

    };

    // =================================================================================================================

    // method that looks for letters in the table
    public String searchLetter (Character letter) {
        for (int i = 1; i <= polib.length; i++) {
            for (int j = 1; j <= polib[0].length; j++) {
                if (letter.equals(polib[i-1][j-1])) {
                    return Integer.toString(i*10 + j);
                }
            }
        }
        return "00";
    }

    // =================================================================================================================

    // single word encoding method
    @Override
    public String crypt(String word) {

        // variable that holds string that will be returned after encryption
        String result = "";

        // before we begin any operations on the string, let's set it in lowercase
        word = word.toLowerCase();

        // replace j with i
        word.replace('j', 'i');

        // iteration over letters in word that we will encryption
        for (char i : word.toCharArray()) {
            result += searchLetter(i);
        }

        // returning encrypted word
        return result;
    }

    // =================================================================================================================

    // single word decrypting method
    @Override
    public String decrypt(String word) {

        // variable that holds string that will be returned after decryption
        String result = "";

        // single letter decryption
        for (int i = 0; i < word.length(); i+=2) {
            int row = Character.getNumericValue(word.charAt(i)) - 1;
            int col = Character.getNumericValue(word.charAt(i + 1)) - 1;
            result += polib[row][col];
        }
        
        // returning decrypted word
        return result;
    }
}
