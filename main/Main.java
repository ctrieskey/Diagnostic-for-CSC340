package main;

import GUI.WelcomeWindow;
import forms.ProtoWindow;

/**
 * Creates and displays a new window
 * @author Kevin Wright
 * Last Updated 2/26/2020
 */
public class Main {
    public static void main(String[] args) {
        //Creates a new window object
        WelcomeWindow welc = new WelcomeWindow();
        //Displays the JFrame window
        welc.setVisible(true);
    }
}
