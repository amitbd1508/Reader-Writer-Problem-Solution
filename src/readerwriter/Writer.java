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
 * @author Roxana Ghani
 */
public class Writer implements Runnable{
    
  
   
    Random rand = new Random();
    
    
    
    

    @Override
    public void run() {
        while(true)
        {
            try{
            
                int item=rand.nextInt(100)+1;
                ReaderWriter.mutextForDatabase.down();
                ReaderWriter.database.add(item);
                System.out.println(Thread.currentThread().getName()+" Write: " + item);
                ReaderWriter.mutextForDatabase.up();
                System.out.println(Thread.currentThread().getName()+"  finish Write: " + item);
                
                Thread.sleep(rand.nextInt(10) + 1);
                
            
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
