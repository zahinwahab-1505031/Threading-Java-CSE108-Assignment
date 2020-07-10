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
class WorkItem{
   public int[] row ;
   public int[] column;
   public int rowNum;
   public int colNum;

   WorkItem(int[]a,int[]b,int i,int j){

      rowNum=i;
      colNum=j;
      row=a;
      column=b;
    }
     
}
