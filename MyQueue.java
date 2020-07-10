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
class MyQueue {
    WorkItem[] n;
    int size;
    int pos;
    int put_count;
    int get_count;
    public MyQueue(int size) {
        this.size= size;
        n= new WorkItem[size];
        put_count=0;
        get_count=0;
        pos=-1;
    }

    synchronized WorkItem get() {
        while(get_count==put_count) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("InterruptedException caught");
            }
        }
        get_count++;
        notify();
        return n[pos--];
    }

    synchronized void put(WorkItem  m) {

        put_count++;
        n[++pos] = m;
        notify();
      
    }
}