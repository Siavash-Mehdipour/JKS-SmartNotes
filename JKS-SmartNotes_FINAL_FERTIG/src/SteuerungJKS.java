/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author krisar
 */
public class SteuerungJKS {

    public static final String SERVER = "localhost";
    public static final int PORT = 3306;
    public static final String DATENBANK = "jks_notiz_db";
    public static final String USER = "root";
    public static final String PASSWORT = "";

    public static String Username;
    public static GUI_LoginJKS login = new GUI_LoginJKS();
    public static GUI_HauptmenueJKS hauptmenue = new GUI_HauptmenueJKS();

    public static void main(String[] args) {
        hauptmenueLoeschen();
        login.setVisible(true);

    }

    public static void loginSchließen() {
        login.setVisible(false);
    }

    public static void hauptmenueSchließen() {
        hauptmenue.setVisible(false);
    }

    public static void hauptmenueLoeschen() {
        hauptmenue = null;
        System.gc();
        System.out.println("Hauptmenü gelöscht");
    }

}
