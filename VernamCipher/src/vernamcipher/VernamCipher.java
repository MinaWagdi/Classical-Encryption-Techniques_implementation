/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vernamcipher;

import java.util.Scanner;

/**
 *
 * @author minarafla
 */
public class VernamCipher {

    /**
     * @param args the command line arguments
     */
    static String message="";
    static String key="";
    
    public static String XOR_BinaryStrings(String a, String b) {
        String result = "";
        if (a.length() != b.length()) {
            System.out.println("ERRRROOORRRR!!!!!Trying to XOR 2 binary numbers that don't have the same number of bits!!!!!");
        }
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            char z;
            if (x != y) {
                z = '1';
            } else {
                z = '0';
            }
            result += z;
        }

        return result;
    }
    public static String TransformTextToBinary(String text) {
        byte[] bytes = text.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        System.out.println("'" + text + "' to binary: " + binary);
        return binary.toString();
    }
    
    public static String removeSpaces(String s){
        
        
        return s.replaceAll("\\s+","");
    }
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter the message");
        message = reader.next();
        System.out.println("Enter the key :");
        key = reader.next();
        
        System.out.println("Transform all text to its binary representation.. ");
        String message_bin = TransformTextToBinary(message);
        String key_bin = TransformTextToBinary(key);
        System.out.println("Binary representation of the message is "+message_bin);
        System.out.println("Binary representation of the key is     "+key_bin);
        
        String cipherVernam = XOR_BinaryStrings(message_bin, key_bin);
        System.out.println("Cipher text is     "+cipherVernam);
        
       
        
    }

}
