/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krisar
 */
public class Notiz {
    private int notiz_ID_jks;
    private String titel_name;
    private String inhaltNotiz;
    private Kategorie kategorie;

    // Standardkonstruktor

    public Notiz(int notizID, String titel, String inhalt, Kategorie kategorie) {
        this.notiz_ID_jks = notizID;
        this.titel_name = titel;
        this.inhaltNotiz = inhalt;
        this.kategorie = kategorie;
    }
    

    // Getter und Setter
    public int getNotiz_ID_jks() {
        return notiz_ID_jks;
    }

    public void setNotiz_ID_jks(int notiz_ID_jks) {
        this.notiz_ID_jks = notiz_ID_jks;
    }

    public String getTitel_name() {
        return titel_name;
    }

    public void setTitel_name(String titel_name) {
        this.titel_name = titel_name;
    }

    public String getInhaltNotiz() {
        return inhaltNotiz;
    }

    public void setInhaltNotiz(String inhaltNotiz) {
        this.inhaltNotiz = inhaltNotiz;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }
    
}
