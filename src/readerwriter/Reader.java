/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerwriter;

import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Amit
 */
public class Reader implements Runnable{
    
   
    Random rand = new Random();
   
   

    @Override
    public void run() {
        int item;
        while(true)
        {
            try{
                
                ReaderWriter.mutexForReaderCount.down();
                ReaderWriter.readerCount=ReaderWriter.readerCount+1;
                if(ReaderWriter.readerCount==1)
                {
                    ReaderWriter.mutextForDatabase.down();
                }

                ReaderWriter.mutexForReaderCount.up();
                System.out.println(Thread.currentThread().getName()+" Want to  Read: " );
                item=ReaderWriter.database.element();               
                Thread.sleep(100); 
                System.out.println(Thread.currentThread().getName()+" finish  Read: " );
                ReaderWriter.mutexForReaderCount.down();
                ReaderWriter.readerCount=ReaderWriter.readerCount-1;
                if(ReaderWriter.readerCount==0)
                {
                    ReaderWriter.mutextForDatabase.up();

                }
                ReaderWriter.mutexForReaderCount.up();
                Thread.sleep(rand.nextInt(10) + 1);
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        
    }
    
}
