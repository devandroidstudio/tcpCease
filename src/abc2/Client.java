/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abc2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vomin
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
         Socket client = new Socket("localhost", 8888);
        OutputStream outputStream = client.getOutputStream();
        ObjectOutputStream dout = new ObjectOutputStream(outputStream);
//        DataInputStream input = new DataInputStream(client.getInputStream());
        
         InputStream inputStream = client.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Scanner sc = new Scanner(System.in);
        String str;
        int key = 0;
        Ceasar ceasar = new Ceasar();
        try {
            System.out.print("Nhap chuoi :");
            str = sc.nextLine();
            System.out.print("Nhap key: ");
            key = sc.nextInt();
            ceasar.Nhap(str, key);
//            System.out.println(ceasar.MaHoa());
            String tcode = ceasar.MaHoa();
//            System.out.println(tcode);
            Texts t = new Texts(tcode, key);
            
            dout.writeObject(t);
            dout.flush();
            
            List<Texts> listOfText = (List<Texts>) objectInputStream.readObject();
            listOfText.forEach((msg)-> System.out.println("character: "+msg.getStr() + " key:" + msg.getKey()));
            
            
            
        } catch (Exception e) {
            str = sc.nextLine();
        }
    }
    
}
