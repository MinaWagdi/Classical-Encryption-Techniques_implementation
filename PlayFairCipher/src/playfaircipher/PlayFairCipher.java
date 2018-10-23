/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playfaircipher;

/**
 *
 * @author minarafla
 */
public class PlayFairCipher {

    /**
     * @param args the command line arguments
     */
    
    public static String removeWhiteSpaces(String s){
        return s.replaceAll("\\s", "");
    }
    
    public static String removeRepeatedLetters(String s){
        String NoDuplicates="";
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            boolean repeated = false;
            for (int j =0; j<i;j++){
                if(s.charAt(j)==c){
                    repeated =true;
                    break;
                }
            }
            if(repeated==false){
                NoDuplicates+=c;
            }
        }
        return NoDuplicates;
    }
    
    public static boolean isDuplicate(String s, char c){
        if(s.contains(""+c)){
            return true;
        }
        else
            return false;
    }
    
    public static void printArrayOfStrings(String[] s){
        for(int i =0;i<s.length;i++){
            if(s[i]!=null)
                System.out.println(s[i]);
            else 
                break;
        }
    }
    
    public static void printPlayFairMatrix(char[][] matrix){
        for(int i =0;i<5;i++){
            for (int j =0;j<5;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
    
    
    
    public static String[] MessagePreparation(String message){
        
        message = removeWhiteSpaces(message);
        String [] newMessage = new String[100];
        int newMessageIndex=0;
        for(int i =0;i<message.length();i+=2){
            char a = message.charAt(i);
            if(i==message.length()-1){
                newMessage[newMessageIndex]=Character.toString(a)+'x';
            }
            else{
                char b = message.charAt(i+1);
                if(message.charAt(i)!=message.charAt(i+1)){
                    newMessage[newMessageIndex]=Character.toString(a)+Character.toString(b);
                }
                else{
                    newMessage[newMessageIndex]=Character.toString(a)+'x';
                    i--;
                }
            }
            newMessageIndex++;
        }
        
        return newMessage;
    }
    
    public static char[][] playFairMatrixCreation(String key){
        
        key = removeWhiteSpaces(key);
        key=removeRepeatedLetters(key);
        
        char[][] payfair_matrix = new char[5][5];
        
        //put the key in the beginning of the matrix
        int StringIndex =0;
        int RowStoppedAt=0, ColStoppedeAt=0;
        boolean finished = false;
        for(int row =0;row<5;row++){
            for(int col =0;col<5;col++){
                if(StringIndex==(key.length()-1)){
                    payfair_matrix[row][col]=key.charAt(StringIndex++);
                    finished=true;
                    ColStoppedeAt=col;
                    RowStoppedAt=row;
                    break;
                }
                else
                    payfair_matrix[row][col]=key.charAt(StringIndex++);
            }
            if(finished)
                break;
            
        }
        //put the rest of the alphabet in the matrix
        char alphabet ='a';
        boolean repeated = false;
        if(ColStoppedeAt==4){
            ColStoppedeAt=0;
            RowStoppedAt++;
        }
        else{
            ColStoppedeAt++;
        }
        for(int r = RowStoppedAt; r<5;r++){
            for (int c = ColStoppedeAt;c<5;c++){
                if(isDuplicate(key, alphabet)||alphabet=='q'){
                    alphabet+=1;
                    c--;
                    continue;
                }
                else{
                    payfair_matrix[r][c]=alphabet;
                    alphabet+=1;
                }
            }
            
            ColStoppedeAt=0;
        }
        
        
        
        
        
        return payfair_matrix;
    }
    
    public static void runAlgorithm(String message, String key){
        // transform the message and the key to lower case
        char [][] FairMatrix = new char[5][5];
        FairMatrix=playFairMatrixCreation(key);
        
        String[] newMessage = MessagePreparation(message);
        int ActualLengthOfMessage =0;
        for ( int i =0; i<100;i++){
            if(newMessage[i]!=null){
                ActualLengthOfMessage++;
            }
            else{
                break;
            }
        }
        
        //We have the actualLength of Message, the matrix and the message. 
        //LET'S DO IT!
        
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        String message = "secret messages";
        printArrayOfStrings(MessagePreparation(message));
        
    }
    
}
