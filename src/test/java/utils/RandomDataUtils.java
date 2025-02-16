package utils;

import tests.TestBase;

import java.security.SecureRandom;

public class RandomDataUtils extends TestBase {
    public  String randomString(int stringLength){
        String AB ="1234567890QWERTZUIOPASDFGHJKKLYXCVBBNMasdfghjklyxcvbnmqwertzuiop";
        SecureRandom rnd = new SecureRandom();
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<stringLength; i++){
            builder.append(AB.charAt((rnd.nextInt(AB.length()))));
        }
        return randomString(stringLength);
    }
}
