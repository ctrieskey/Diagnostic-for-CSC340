package gui;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;


public class CustomOutputStream extends OutputStream{
    private JTextArea textArea;

    public CustomOutputStream(JTextArea textArea){
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException{
        //Redirects to output to textArea
        textArea.append(String.valueOf((char)b));
        //scolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}