package com.piotrskalski;

// interface for encryption classes
public interface Algorithm {

    // single word encoding method
    String crypt(String word);

    // single word decrypting method
    String decrypt(String word);
}
