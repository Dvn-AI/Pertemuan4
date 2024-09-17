/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_pertemuan4;



/**
 *
 * @author DAGH
 */
public class Try_Catch_Pembagian {
  public static void main (String[]args){
      int a = 20, b = 0, c;
      
      try{
          if(b == 0){
              throw new ArithmeticException("Pembagi tidak boleh nol");
          }
          c = a/b;
          System.out.println("Hasil = "+ c);
      }catch (ArithmeticException e){
          System.out.println("Error : "+ e.getMessage());
      }
  }
}

