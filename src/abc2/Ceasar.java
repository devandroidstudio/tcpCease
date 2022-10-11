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
    
    public Ceasar(String P, int k) {
        this.P = P;
        this.k = k;
    }

      public String MaHoa()
      {
          String str = "";
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
              str += letter;
           
              
              
          }
          return str;
      }

      public String GiaiMa()
      {
          String result = "";
          for (int i = 0; i < P.length(); i++) {
              char letter = P.charAt(i);
          
              
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
                  
                  
                  if(x < 0)
                  {
                      x +=26;
                      
                  }
                  letter = (char) (x + 'a');
//                     
              }
              result += letter;
              
              
              
          }
          return result;
      }
    
}
