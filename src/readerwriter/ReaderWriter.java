/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerwriter;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Amit
 */
public class ReaderWriter {

    /**
     * @param args the command line arguments
     */
    public static Semaphore mutextForDatabase =new Semaphore(1,1);
    public static Semaphore mutexForReaderCount =new Semaphore(1,1);
    
    public static Queue<Integer> database = new LinkedList<Integer>();
    public static int readerCount=0;
    public static void main(String[] args) {
        // TODO code application logic here
        Reader reader1=new Reader();
        Reader reader2=new Reader();
        
        Writer write1=new Writer();
        Writer write2=new Writer();
        
        new Thread(write1,"Writer 1").start();
        
        new Thread(reader1,"Reader 1").start();
        
        new Thread(write2,"Writer 2").start();
               
        new Thread(reader2,"Reader 2").start();
    }
    
}
