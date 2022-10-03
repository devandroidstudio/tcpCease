/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abc2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author vomin
 */
public class Ceasar {
//    
    private String P; 
    

      private int k;

      private String C="";
      
    
    public void WirteData(String s, int key)
    {
        C = s;
        k = key;
    }
      

      public void Nhap(String str, int key){

            P = str;
            k = key;

      }
      public void clean()
      {
          this.P = "";
          this.C = "";
      }
      
      

//      public String MaHoa(){
//
//            P = P.toUpperCase();//Chuyển thành chữ in hoa
//               System.out.println(C);
//               
//            for(int i = 0;i<P.length();i++)
//
//                if(Character.isUpperCase(P.charAt(i)))
//                {
//                      C += (char) ('A' + (P.charAt(i) - 'A' + k) % 26);
//                }
//                else if(Character.isLowerCase(P.charAt(i)))
//                {
//                    C += (char) ('a' + (P.charAt(i) - 'a' + k) % 26);
//                }
//                
//
//            return C;
//
//      }
      public String MaHoa()
      {
          
          for (int i = 0; i < P.length(); i++) {
              char letter = P.charAt(i);
              
              
              if(Character.isUpperCase(letter))
              {
                  int x = letter - 'A' + k;
                  
                  x %= 26;
                 
                  letter = (char) (x + 'A');
                  
              }else if(Character.isLowerCase(letter))
              {
                  int x = letter - 'a' + k;
                  
                  x %=26;
                 
                  letter = (char) (x + 'a');
                  
              }
              C += letter;
           
              
              
          }
          System.out.println(P);
          return C;
      }

//      public String GiaiMa(){
//
//            String kq="";
//
//            for(int i = 0;i<C.length();i++)
//
//                  if(Character.isUpperCase(C.charAt(i)))
//                  {
//                      kq += (char) ('A' + (C.charAt(i) - 'A' + (26-k)) % 26);
//                  }
//                  else if(Character.isLowerCase(C.charAt(i)))
//                          {
//                            kq += (char) ('a' + (C.charAt(i) - 'a' + (26-k)) % 26);
//                          }
//
//            return kq;
//
//      }
      public String GiaiMa()
      {
          String result = "";
          for (int i = 0; i < C.length(); i++) {
              char letter = C.charAt(i);
//              System.out.println(letter);
              
              if(Character.isUpperCase(letter))
              {
                  int x = letter - 'A' - k;
                  if(x < 0)
                  {
                      x += 26;
                  }
                  
                 
                  letter = (char) (x + 'A');
                  
              }else if(Character.isLowerCase(letter))
              {
                  int x = letter - 'a' - k;
//                  System.out.println(x+"");
                  if(x < 0)
                  {
                      x +=26;
                  }
//                  System.out.println(x+"%26");
                  letter = (char) (x + 'a');
                  
              }
              result += letter;
//              System.out.println(result);
              
              
          }
          return result;
      }
    
}
