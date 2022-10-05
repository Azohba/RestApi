package helpers;

import java.util.Random;

public class CommonHelper {
    public int getRandomNumber(Integer bound){
        String SALTCHARS = "123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < bound) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return Integer.parseInt(saltStr);
    }

    public String getRandomString(Integer lenghtParam) {
        String SALTCHARS = "abcdefghijklmnoprstuvyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < lenghtParam) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
