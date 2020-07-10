/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1505031;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Zahin
 */

public class Main {

  
    
    
    public static void main(String[] args) {
        //Scanner in=new Scanner(System.in);
        Scanner in=null;
		try {
			in = new Scanner(new File("C:\\Users\\Zahin\\Downloads\\Test IO\\Test IO\\input_2.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("Enter no.of worker threads to be created: ");
        int W=in.nextInt();
        System.out.println("Enter row and column of first matrix:");
        int row1=in.nextInt();
        int col1=in.nextInt();
        int[][] matrix1=new int[row1][col1];
        System.out.println("Enter first matrix:");
        for(int j=0;j<row1;j++){
           for(int i=0;i<col1;i++){
               matrix1[j][i]=in.nextInt();        
            }
        }
        System.out.println("Enter row and column of second matrix:");
        int row2=in.nextInt();
        int col2=in.nextInt(); 
       
        System.out.println("Enter second matrix:");
        int[][] matrix2=new int[row2][col2];
        for(int j=0;j<row2;j++){
            for(int i=0;i<col2;i++){
                matrix2[j][i]=in.nextInt();        
            }
        }
        int [][] matrix2t=new int[col2][row2];
        for(int i=0;i<col2;i++){
            for(int j=0;j<row2;j++){
             
              matrix2t[i][j] = matrix2[j][i];
             
            }
        }
        int t= row2;
        row2=col2;
        col2=t;
        int k=(row1*row2)/W;
        int[][] resultArray = new int [row1][row2];
        MyQueue p = new MyQueue(row1*row2);
        WorkerThread[] b = new WorkerThread[W];
       
        WorkItem [] obj = new WorkItem[row1*row2];
        int i = 0;
        for(int j=0;j<row1;j++){
           for(int f=0;f<row2;f++){
               obj[i] = new WorkItem(matrix1[j],matrix2t[f],j+1,f+1);
                i++; 
            }
        }
        
        
         for(int var=0;var<W;var++){
            b[var]= new WorkerThread(p,k,row1,col1,row2,col2,resultArray); 
        } 
        i=0;
        try { 
            while (i<row1*row2) {
                p.put(obj[i]);
                i++;
            }
        
           } catch(Exception e) {
           
           
        }
 
       try{
             for(int var=0;var<W;var++){
                b[var].t.join();
        }
        }catch(InterruptedException e){
            
        }
           System.out.println("Resultant matrix: ");
            for(int m=0;m<row1;m++){
                for (int n = 0; n < row2; n++) {
                    System.out.print(resultArray[m][n] + " ");
                }
                System.out.println(" ");
            }
        int[][] productMatrix=new int[row1][row2];
    //    System.out.println("Resultant matrix using single thread: ");
       for (int var3 =0 ; var3< row1; var3++ ) {   
           for ( int var4 = 0; var4< row2; var4++ ) {     
               int sum = 0;
             for ( int var5 = 0; var5 < col1; var5++ ) {    
                  sum += (matrix1[var3][var5] * matrix2t[var4][var5]);
              }
             productMatrix[var3][var4] = sum;
            }
        }
        System.out.println("Resultant matrix using single thread: ");

        for (int var1 =0 ; var1< row1; var1++ ) {   
         for ( int var2 = 0; var2 < row2; var2++ ) {       
               System.out.print(productMatrix[var1][var2]+" ");
            }
          System.out.println(" ");
         
      }

    }
  
}
