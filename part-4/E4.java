
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E4 extends JFrame implements ActionListener {
    JTextField name;
    JTextField email;
    JPasswordField password;

    JRadioButton female;
    JRadioButton male;

    JCheckBox python;
    JCheckBox java;
    JCheckBox cpp;

    JButton submit;

    GridBagConstraints c;

    public E4() {
        setTitle("Register App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0;
        panel.add(new JLabel("Name:"), c);
        c.gridx = 1;
        name = new JTextField(20);
        panel.add(name, c);

        c.gridx = 0; c.gridy = 1;
        panel.add(new JLabel("Email:"), c);
        c.gridx = 1;
        email = new JTextField(20);
        panel.add(email, c);

        c.gridx = 0; c.gridy = 2;
        panel.add(new JLabel("Password:"), c);
        c.gridx = 1;
        password = new JPasswordField(20);
        panel.add(password, c);

        c.gridx = 0; c.gridy = 3;
        panel.add(new JLabel("Gender:"), c);
        c.gridx = 1;
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(female);
        bg1.add(male);
        JPanel genderPanel = new JPanel();
        genderPanel.add(female);
        genderPanel.add(male);
        panel.add(genderPanel, c);

        c.gridx = 0; c.gridy = 4;
        panel.add(new JLabel("Interests:"), c);
        c.gridx = 1;
        java = new JCheckBox("Java"); python = new JCheckBox("Python"); cpp = new JCheckBox("C++");
        JPanel interestPanel = new JPanel();
        interestPanel.add(java); interestPanel.add(python); interestPanel.add(cpp);
        panel.add(interestPanel, c);

        c.gridx = 1; c.gridy = 5;
        c.anchor = GridBagConstraints.CENTER;
        submit = new JButton("Submit");
        submit.addActionListener(this);
        panel.add(submit, c);

        name.addActionListener(e -> email.requestFocusInWindow());
        email.addActionListener(e -> password.requestFocusInWindow());
        password.addActionListener(e -> female.requestFocusInWindow());

        add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String rname = name.getText();
        if (rname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name");
            return;
        }
        String remail = email.getText();
        if (remail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your email");
            return;
        }
        String rpassword = password.getText();
        if (rpassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your password");
            return;
        }
        String rgender = "";
        if (female.isSelected()) {
            rgender += "Female";
        }else if(male.isSelected()){
            rgender += "Male";
        }
        if (rgender.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your gender");
            return;
        }
        String rinterest = "";
        if(python.isSelected()){
            rinterest += " Python";
        }
        if(java.isSelected()){
            rinterest += " Java";
        }
        if(cpp.isSelected()){
            rinterest += " C++";
        }
        if(rinterest.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your interests");
            return;
        }
        JOptionPane.showMessageDialog(this,
                "name: " + rname + "\nemail: " + remail + "\ngender: " + rgender
                        + "\ninterest:" + rinterest + "\n"
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new E4().setVisible(true));
    }

}
