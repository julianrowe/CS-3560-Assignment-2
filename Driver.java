import javax.swing.*;
import java.awt.FlowLayout;

public class Driver {
    public static void main(String[] args) {
        AdminPanel admin = AdminPanel.getInstance();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                admin.setVisible(true);
            }
        });
    }
}