import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UnitTests {
    public static void main(String[] args) {
    	MyClass.checkRegCode("1111111111111111111");
        JFrame v1 = new JFrame("Key check");
        JButton v0 = new JButton("Click to activate");
        v0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Component component = null;
                if(MyClass.checkRegCode(JOptionPane.showInputDialog(component, "Enter the product key: ", 
                        "xxxx-xxxx-xxxx-xxxx", 1))) {
                    JOptionPane.showMessageDialog(component, "Well done that was the correct key", "Key check", 
                            1);
                }
                else {
                    JOptionPane.showMessageDialog(component, "               Sorry that was the incorrect key \nRemember it is a crime to use software without paying for it", 
                            "Key check", 1);
                }
            }
        });
        JPanel v2 = new JPanel();
        v2.add(((Component)v0));
        v1.add(((Component)v2));
        v1.setSize(300, 100);
        v1.setDefaultCloseOperation(3);
        v1.setVisible(true);
    }

}

