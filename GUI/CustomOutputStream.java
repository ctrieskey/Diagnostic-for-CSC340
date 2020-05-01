package GUI;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 * The CustomOutputStream class is used to transfer console output into a
 * jTextArea
 *
 * Last Updated: 4/27/2020
 *
 * @author Lavante Hammond
 */
public class CustomOutputStream extends OutputStream {

    private JTextArea textArea;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        //writes output to a text area
        textArea.append(String.valueOf((char) b));
        //Scrolls text are to end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
