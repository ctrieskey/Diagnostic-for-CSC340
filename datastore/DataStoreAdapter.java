package datastore;

/*
This class is where all of the operations are implemeted.
Furthermore this class follows a CRUD operartion format where this
class will be able to create, read, update, and delete entries from the database.
@author Taylor Headen
Lasted updated 5/1/2020
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DataStoreAdapter implements ActionListener {

    protected boolean activeFlag = true;
//Initializing of variables and JFrame text fields and labels
    JFrame window = new JFrame("Enter Car Information");
    JTextField VINTextField = new JTextField();
    JTextField makeTextField = new JTextField();
    JTextField modelTextField = new JTextField();
    JTextField yearTextField = new JTextField();

    JLabel VINNameLabel = new JLabel("Enter VIN");
    JLabel makeNameLabel = new JLabel("Enter make");
    JLabel modelNameLabel = new JLabel("Enter model");
    JLabel yearNameLabel = new JLabel("Enter year");

    JButton addData = new JButton("Add");
    JButton updateData = new JButton("Update");
    JButton loadData = new JButton("Load");
    JButton deleteData = new JButton("Delete");
    JLabel space = new JLabel();

    FileWriter fileWriter;
    FileReader fileReader;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

//Creation of JFrame
    DataStoreAdapter() {
        window.add(VINNameLabel);
        window.add(VINTextField);

        window.add(makeNameLabel);
        window.add(makeTextField);

        window.add(modelNameLabel);
        window.add(modelTextField);

        window.add(yearNameLabel);
        window.add(yearTextField);

        window.add(addData);
        window.add(updateData);
        window.add(loadData);
        window.add(deleteData);

        GridLayout grid = new GridLayout();
        grid.setRows(8);
        grid.setColumns(8);

        window.setLayout(grid);

        window.setSize(300, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        addData.addActionListener(this);
        loadData.addActionListener(this);
        updateData.addActionListener(this);
        deleteData.addActionListener(this);
    }

    public static void main(String[] args) {
        new DataStoreAdapter();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        saveActionPerformed(ae);
        readActionPerformed(ae);
        updateActionPerformed(ae);
        deleteActionPerformed(ae);
    }

    //This method demonstrates the create operation
 public void saveActionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals(addData.getActionCommand())) {

            File file = new File("C:\\Users\\Taylor\\Documents\\NetBeansProjects\\CppApplication_1\\The5UselessAlarmsYouSnoozeInTheMorning\\src\\datastore\\datastore.txt");
            DataStore datastore = new DataStore(VINTextField.getText(), makeTextField.getText(), modelTextField.getText(), yearTextField.getText());

            try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
                pw.println(datastore.toString());
                JOptionPane.showMessageDialog(null, "new user added");

            } catch (IOException ex) {

            }
        }
    }
//This method demonstrates the read operation

private void readActionPerformed(ActionEvent ae) {
        String data;
        DataStore datastore;
        if (ae.getActionCommand().equals(loadData.getActionCommand())) {
            while (activeFlag == false) {
                JOptionPane.showMessageDialog(null, "Entry not found:");
            }
        }

        if (VINTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter a VIN number:");
        } else {
            File file = new File("C:\\Users\\Taylor\\Documents\\NetBeansProjects\\CppApplication_1\\The5UselessAlarmsYouSnoozeInTheMorning\\src\\datastore\\datastore.txt");

            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                while ((data = br.readLine()) != null) {
                    datastore = new DataStore(data);
                    if (datastore.getVIN().equals(VINTextField.getText())) {

                        makeTextField.setText(datastore.getMake());
                        modelTextField.setText(datastore.getModel());
                        yearTextField.setText(datastore.getYear());
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Entry not found");
            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {
            }

        }
    }

    //This method demonstrates the update operation
public void updateActionPerformed(ActionEvent ae) {

        ArrayList<DataStore> userList = new ArrayList<>();

        if (!activeFlag) {
            JOptionPane.showMessageDialog(null, "enter a valid id and search");
        } else {
            File file = new File("C:\\Users\\Taylor\\Documents\\NetBeansProjects\\CppApplication_1\\JavaApplication48\\src\\textfileappendupdate\\prototype.txt");

            try {
                try (FileReader fr = new FileReader(file)) {
                    BufferedReader br = new BufferedReader(fr);
                    String data;

                    while ((data = br.readLine()) != null) {
                        DataStore tempUser = new DataStore(data);
                        if (tempUser.getVIN().equals(VINTextField.getText())) {
                            tempUser.setMake(makeTextField.getText());
                            tempUser.setModel(modelTextField.getText());
                            tempUser.setYear(yearTextField.getText());
                        }
                        userList.add(tempUser);
                    }
                }

                try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
                    userList.forEach((user) -> {
                        pw.println(user.toString());
                    });
                    JOptionPane.showMessageDialog(null, "user updated");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

//This method demonstrates the delete operation
    private void deleteActionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals(deleteData.getActionCommand())) {
            String delete_id = VINTextField.getText();

            ArrayList<DataStore> carEntry = new ArrayList<>();

            if (!activeFlag) {
                JOptionPane.showMessageDialog(null, "enter a valid id and search");
            } else {
                File file = new File("C:\\Users\\Taylor\\Documents\\NetBeansProjects\\CppApplication_1\\The5UselessAlarmsYouSnoozeInTheMorning\\src\\datastore\\datastore.txt");

                try {
                    try (FileReader fr = new FileReader(file)) {
                        BufferedReader br = new BufferedReader(fr);
                        String data;
                        DataStore tempUser;

                        while ((data = br.readLine()) != null) {
                            tempUser = new DataStore(data);
                            if (!tempUser.getVIN().equals(delete_id)) {
                                carEntry.add(tempUser);
                                System.out.println(carEntry + "false");
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null, "user deleted");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        }
    }
}
