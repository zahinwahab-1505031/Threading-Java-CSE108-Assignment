/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1505031;

/**
 *
 * @author Zahin
 */
class WorkerThread implements Runnable {

    MyQueue p;
    Thread t;
    int r1;
    int c1;
    int r2;
    int c2;
    int noOfWorks;
    
    WorkItem [] obj1 ;
    int [][] product;
    WorkerThread(MyQueue p,int noOfWorks,int r1,int c1,int r2,int c2,int[][]product) {
        this.r1=r1;
        this.r2=r2;
        this.c1=c1;
        this.c2=c2;
        this.p = p;
        obj1= new WorkItem[r1*r2];
        this.noOfWorks=noOfWorks;
        this.product=product;
        
        t=new Thread(this, "WorkerThread");
        t.start();
    }

    public void run() {
        try {
            
            int i=0;
            
            while (i<noOfWorks) {
                int sum=0;
                obj1[i]=p.get();
                for(int j=0;j<c1;j++){
                      sum+=(obj1[i].row[j] * obj1[i].column[j]);
                    
                }
                product[obj1[i].rowNum-1][obj1[i].colNum-1] = sum;
               
                i++;
            }     
          notify();
        } catch(Exception e) {
            
        }
    }
        
    
}
