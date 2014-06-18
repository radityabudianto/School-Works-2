/*****************************************************

Raditya Budianto
100836539
Assignment 2

******************************************************************/



import java.io.*;
import java.lang.*;

public class Assignment2 implements Runnable {
    Object Chef1,Chef2,Chef3;
    String Ingredients1,Ingredients2;
    int x,y ;
    boolean empty=true;//table is empty
    
    public Assignment2(){
    Ingredients1= new String();    
    Ingredients2=new String();    
    }

    public synchronized void getIngredients() 
    {    //wait when table is empty
        while(empty)
        {    try{
                wait();
            }catch(InterruptedException e){}
        }
        
        
    //Chef making sandwich and eating
        
        //wait chef1 eating sandwich
        if(x!=1 && y!=1){            
            int c1=1+(int) (Math.random()*10);
            System.out.println("Chef 1 make and eat the sandwich Eating time="+c1+"ms");
            try {
                Thread.sleep(c1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //wait chef1 eating sandwich
        if(x!=2 && y!=2){
            int c2=1+(int) (Math.random()*10);
            System.out.println("Chef 2 make and eat the sandwich Eating time="+c2+"ms");
            try {
                Thread.sleep(c2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //wait chef1 eating sandwich
        if(x!=3 && y!=3){
            int c3=1+(int) (Math.random()*10);
            System.out.println("Chef 3 make and eat the sandwich Eating time="+c3+"ms");
            try {
                Thread.sleep(c3);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        notifyAll();
        empty=true;    
    }
    
    
    public synchronized void putIngredients()
    {
        //wait if table is not empty yet
        while(!empty)
        {    try{
                wait();
            }catch(InterruptedException e){}
        }
        
        
            
        //generate ingredients
        x=1+(int) (Math.random()*3);
        y=1+(int) (Math.random()*3);
        
        while(true)
        {
            if(y!=x)
            {
                break;
            }
            else
            {
                y=1+(int) (Math.random()*3);
            }    
        }    
        
        if(x==1){Ingredients1="Bread";}
        if(x==2){Ingredients1="PeanutButter";}
        if(x==3){Ingredients1="Jam";}
        
        if(y==1){Ingredients2="Bread";}
        if(y==2){Ingredients2="PeanutButter";}
        if(y==3){Ingredients2="Jam";}
        
        System.out.println("Agent Put "+x+" and ="+y);
        notifyAll();
        empty=false;
    }
        
        
        
        
        
    
    public void run() {
        while(true)
        {
            putIngredients();
            getIngredients();
        }
        
        
    }
    
    
    
    public static void main(String[] args)
    {
        Thread x= new Thread(new Assignment2());
        x.start();
    }

}