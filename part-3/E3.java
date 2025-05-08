
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E3 extends JFrame implements ActionListener {
    JButton Greenbutton;
    JButton Bluebutton;
    JButton Redbutton;
    JPanel mainpanel;

    public E3() {
        mainpanel = new JPanel();


        Greenbutton = new JButton("Green");
        Bluebutton = new JButton("Blue");
        Redbutton = new JButton("Red");

        Greenbutton.setActionCommand("Green");
        Bluebutton.setActionCommand("Blue");
        Redbutton.setActionCommand("Red");

        Greenbutton.addActionListener(this);
        Bluebutton.addActionListener(this);
        Redbutton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(Greenbutton);
        buttonPanel.add(Bluebutton);
        buttonPanel.add(Redbutton);

        setLayout(new BorderLayout());
        add(mainpanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);

        setTitle("Change color");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Green":
                mainpanel.setBackground(Color.GREEN);
                break;
            case "Blue":
                mainpanel.setBackground(Color.BLUE);
                break;
            case "Red":
                mainpanel.setBackground(Color.RED);
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new E3().setVisible(true));

    }
}
