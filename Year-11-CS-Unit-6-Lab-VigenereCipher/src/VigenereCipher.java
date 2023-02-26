public class VigenereCipher {

    private String key;
    private String alphabet;

    public VigenereCipher(String key) {
        this.key = key.toLowerCase();
        this.alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key.toLowerCase();
    }

    public String encode(String message) {
        String encodedMessage = "";
        int j = 0;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (alphabet.indexOf(c) >= 0) {
                int index = (alphabet.indexOf(c) + alphabet.indexOf(key.charAt(j))) % alphabet.length();
                encodedMessage += alphabet.charAt(index);
                j = ++j % key.length();
            } else {
                encodedMessage += Character.toLowerCase(c);
            }
        }
        return encodedMessage;
    }

    public String decode(String message) {
        String decodedMessage = "";
        int j = 0;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (alphabet.indexOf(c) >= 0) {
                int index = (alphabet.indexOf(c) - alphabet.indexOf(key.charAt(j)) + alphabet.length()) % alphabet.length();
                decodedMessage += alphabet.charAt(index);
                j = ++j % key.length();
            } else {
                decodedMessage += Character.toLowerCase(c);
            }
        }
        return decodedMessage;
    }


}

