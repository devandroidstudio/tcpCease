/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abc2;
import java.io.Serializable;
/**
 *
 * @author vomin
 */
public class Texts implements Serializable{
    private String str;
    private Integer key;
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Texts(String str, Integer key) {
        this.str = str;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Texts{" + "str=" + str + ", key=" + key + '}';
    }

    
    
}
