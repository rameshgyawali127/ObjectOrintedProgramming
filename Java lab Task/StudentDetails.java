import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class StudentDetails {
    static void createStudentDetailsForm() {
        // Create the main frame
        JFrame f = new JFrame("Student Details Form");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700, 600);

        // Labels for input fields
        JLabel nameLabel = new JLabel("Name of Student:");
        nameLabel.setBounds(50, 70, 120, 30);
        JLabel regNoLabel = new JLabel("Registration No:");
        regNoLabel.setBounds(50, 130, 120, 30);
        JLabel emailLabel = new JLabel("College Email ID:");
        emailLabel.setBounds(50, 200, 120, 30);
        JLabel sectionLabel = new JLabel("Section:");
        sectionLabel.setBounds(360, 70, 120, 30);
        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(360, 130, 120, 30);
        JLabel ageLabel = new JLabel("Student Age:");
        ageLabel.setBounds(360, 200, 120, 30);

        // Text fields for user input
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(170, 70, 100, 30);
        JTextField regNoTextField = new JTextField();
        regNoTextField.setBounds(170, 130, 100, 30);
        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(170, 200, 100, 30);

        // Combo boxes for user selection
        String[] sections = {"Section-A", "Section-B", "Section-C", "Section-D", "Section-E", "Others"};
        JComboBox<String> sectionComboBox = new JComboBox<>(sections);
        sectionComboBox.setBounds(480, 70, 90, 30);

        String[] departments = {"IT", "CSE", "CIVIL", "CSD", "ME", "AERO", "OTHERS"};
        JComboBox<String> departmentComboBox = new JComboBox<>(departments);
        departmentComboBox.setBounds(480, 130, 90, 30);

        Integer[] ages = {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        JComboBox<Integer> ageComboBox = new JComboBox<>(ages);
        ageComboBox.setBounds(480, 200, 90, 30);

        // Save button to save student details
        JButton saveButton = new JButton("SAVE");
        saveButton.setBounds(80, 420, 80, 30);

        // Adding active listener to the save button
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String regNo = regNoTextField.getText();
                String email = emailTextField.getText();
                String section = (String) sectionComboBox.getSelectedItem();
                String department = (String) departmentComboBox.getSelectedItem();
                int age = (Integer) ageComboBox.getSelectedItem();

                // Validate inputs
                if (!name.isEmpty() && !regNo.isEmpty() && !email.isEmpty()) {
                    // Use a JFileChooser to let the user select a file
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showSaveDialog(f);

                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();

                        try (FileWriter writer = new FileWriter(selectedFile, true)) {
                            // Write student details to the selected file
                            writer.write("Student Name: " + name + "\n");
                            writer.write("Registration No: " + regNo + "\n");
                            writer.write("College Email ID: " + email + "\n");
                            writer.write("Section: " + section + "\n");
                            writer.write("Department: " + department + "\n");
                            writer.write("Age: " + age + "\n");
                            writer.write("\n"); // Add a blank line between entries
                            JOptionPane.showMessageDialog(f, "Successfully Saved The Details");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Please select a file to save the details.");
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Please fill in all fields.");
                }
            }
        });

        // Close button to exit the application
        JButton closeButton = new JButton("CLOSE");
        closeButton.setBounds(360, 420, 80, 30);

        // Adding action listener to the Close button
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        // Add components to the frame
        f.add(nameLabel);
        f.add(regNoLabel);
        f.add(emailLabel);
        f.add(sectionLabel);
        f.add(departmentLabel);
        f.add(ageLabel);
        f.add(saveButton);
        f.add(closeButton);
        f.add(nameTextField);
        f.add(regNoTextField);
        f.add(emailTextField);
        f.add(sectionComboBox);
        f.add(departmentComboBox);
        f.add(ageComboBox);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createStudentDetailsForm());
    }
}
