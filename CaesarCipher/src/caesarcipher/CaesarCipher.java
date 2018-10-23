/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarcipher;

/**
 *
 * @author minarafla
 */
public class CaesarCipher {
    
    public static String caesar_cypher(String plain_text, int key) {
        
        StringBuilder EncryptedString = new StringBuilder(plain_text);
        for ( int i =0; i<plain_text.length();i++){
            
            if(plain_text.charAt(i)==' '|| plain_text.charAt(i)=='\n'){
                continue;
            }
            else if((char)(plain_text.charAt(i)+key)>'z'){
                int diff = 'z'- plain_text.charAt(i);
                int new_key = key-diff-1;
                EncryptedString.setCharAt(i,(char)('a'+new_key));
            }
            else
                EncryptedString.setCharAt(i,(char)(plain_text.charAt(i)+key));
        }
        return EncryptedString.toString();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String s = "meet me after the toga party";
       System.out.println("String is : "+s+"\nEncrypted is : "+caesar_cypher(s,3));

    }
    
}
