import java.io.*;
public class testStream {
public static void main(String args[]) { 
    InputStream is = System.in; // KeyBoard = System.in 
    while (true) { 
    try {int ch = is.read(); if (ch ==-1 || ch =='q') break; 
    System.out.print((char)ch); 
        } 
    catch (IOException ie) { 
    System.out.print("Error: "+ie);
        } 
    } 
}
}