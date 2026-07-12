/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krisar
 */
public class Kategorie {
    private int K_ID;
    private String Name;

    public Kategorie(int K_ID, String Name) {
        this.K_ID = K_ID;
        this.Name = Name;
    }

    public int getK_ID() {
        return K_ID;
    }

    public void setK_ID(int K_ID) {
        this.K_ID = K_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
}
