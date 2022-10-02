/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abc2;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vomin
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Server is empty");
        Ceasar ceasar = new Ceasar();

        while (true) {
            Socket client = server.accept();
            System.out.println("Server have been connected with client");
            InputStream inputStream = client.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                OutputStream outputStream = client.getOutputStream();
                ObjectOutputStream dout = new ObjectOutputStream(outputStream);
//            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            Texts t = (Texts) objectInputStream.readObject();
            ceasar.WirteData(t.getStr(), t.getKey());
            
            List<Texts> listText = new ArrayList<>();
            int count = 0;
            int max = 0;
            Map<String, Integer> map = new HashMap<String, Integer>();

            String str = ceasar.GiaiMa().toUpperCase();
            System.out.println(str);
            char temp;
            char[] ch = str.toCharArray();
            for (char c : ch) {

                for (int i = 0; i < ceasar.GiaiMa().length(); i++) {
                    temp = ceasar.GiaiMa().charAt(i);
                    if (temp == c) {
                        count++;

                    }
                }
                if (count >= max) {
                    max = count;
                    map.put(String.valueOf(c), max);
                }
                count = 0;
            }
            Set<String> set = map.keySet();
            for (String key : set) {
                System.out.println(key + "" + map.get(key));
                listText.add(new Texts(key, map.get(key)));
            }
            dout.writeObject(listText);
            listText.forEach((msg)-> System.out.println(msg.getStr() + "key:" + msg.getKey()));
            
        }
    }

}
