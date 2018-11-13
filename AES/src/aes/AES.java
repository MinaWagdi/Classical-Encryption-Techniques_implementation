/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

import java.math.BigInteger;

/**
 *
 * @author minarafla
 */
public class AES {
    
    public int[][] MixCol =
        {
            {0x02,0x03,0x01,0x01},
            {0x01,0x02,0x03,0x01},
            {0x01,0x01,0x2,0x3},
            {0x03,0x01,0x01,0x02}
        };
    
    public String xorHex(String a, String b) {
        // TODO: Validation
        char[] chars = new char[a.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = toHex(fromHex(a.charAt(i)) ^ fromHex(b.charAt(i)));
        }
        return new String(chars);
    }

    private  int fromHex(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }
        throw new IllegalArgumentException();
    }

    private char toHex(int nybble) {
        if (nybble < 0 || nybble > 15) {
            throw new IllegalArgumentException();
        }
        return "0123456789ABCDEF".charAt(nybble);
    }
    
    private int[][]ConvertHexStringMatrixToHexIntegerMatrix(String [][]StateMatrix){
        int [][]StateMatrixInt=new int[4][4];
        for(int i =0;i<4;i++){
            for(int j =0;j<4;j++){
                StateMatrixInt[i][j]=Integer.parseInt(StateMatrix[i][j], 16);
            }
        }
        return StateMatrixInt;
    }
    
    //1
    public static String StringTextToHex(String text){
        String hex="";
        if(text.length()==16){
            for (int i = 0; i < text.length(); i++) {
                int character_int = ((int) text.charAt(i));
                if (character_int >= 65 && character_int < 91) {
                    character_int-=65;
                }
                else{
                    System.out.println("The text contains characters other than capital letters");
                }
//                hex += Integer.toHexString(character_int);
                hex+=String.format("%02X", ""+character_int);

            }
            return hex;
        }
            //return String.format("%040x", new BigInteger(1, text.getBytes(/*YOUR_CHARSET?*/)));
        else 
            return "String is not 16 input bytes";
    }
    
    //2
    public static String[][] BlockToState(String hex){
        String StateMatrix[][]= new String [4][4];
        int StringIndex=0;
        for(int i =0;i<4;i++){
            for(int j =0;j<4;j++){
                StateMatrix[j][i]= ""+hex.charAt(StringIndex)+hex.charAt(StringIndex+1);
                StringIndex+=2;//because each letter in the hexadecimal is 2 characters
            }
        }
        
        
        return StateMatrix;
    }
    
    
    public static void AddRoundKey(String[][] State, String[][] Key){
        
        
    }
    
    public void SubBytes(String[][] State){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                 State[i][j]=SBox.getValueFromSBox(State[i][j]);
            }
        }
    }
    
    public String[][] shiftRows(String[][] State) {
        String [][] State_copy=State.clone();
        for (int i = 0; i < 4; i++) {
            for(int j =0;j<4;j++){
                State[i][j]=State_copy[i][(j+i)%4];
            }
        }
        return State;
    }
    
    public int [][] multiply(int [][]State, int[][]MixColumns){
        int [][] res = new int[4][4];
        for(int i=0;i<4;i++ ){
            for(int j =0;j<4;j++){
                res[i][j]=MixColumns[i][j]*State[j][i];
            }
        }
        return res;
        
    }
    
    public void MixCol(String[][]State){
        int[][] StateInt =multiply(ConvertHexStringMatrixToHexIntegerMatrix(State),MixCol);
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        System.out.println(""+StringTextToHex("AESUSESAMATRIXZZ"));
        
    }
    
}
