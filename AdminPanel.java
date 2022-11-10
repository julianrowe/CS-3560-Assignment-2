import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class AdminPanel extends javax.swing.JFrame {
    
    private static AdminPanel adminInstance;
    private JFrame popUpFrame;
    protected static HashMap<String, User> users;
    protected static HashMap<String, User_Group> user_groups;
    static int totalMessageCount = 0;
    static double positiveMessageCount = 0;
    private String newUserName;
    private String newUserGroupName;
    private DefaultMutableTreeNode root;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTree jTree1;

    // Private constructor
    private AdminPanel() {
        if(adminInstance == null) {
           adminInstance = this;
           users = new HashMap<>();
           user_groups = new HashMap<>();
           initAdminPanel();
        }
    }

    // Static getter
    public static AdminPanel getInstance() {
        if (adminInstance == null) {
            adminInstance = new AdminPanel();
        }
        return adminInstance;
    }

    private void initAdminPanel() {
        setTitle("Mini Twitter");
        setResizable(false);

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = initJTree();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);
        jButton1.setText("Add User");
        jTextField1.setText("");
        jTextField2.setText("");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newUserName = jTextField1.getText();
                addUser(newUserName);
            }
        });
        jButton2.setText("Add Group");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newUserGroupName = jTextField2.getText();
                addUserGroup(newUserGroupName);
            }
        });
        jButton3.setText("Open User View");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedUser = (DefaultMutableTreeNode)jTree1.getSelectionPath().getLastPathComponent();
                jTree1.getLastSelectedPathComponent();
                UserView userView = UserView.getUserView(users.get(selectedUser.toString()));
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        userView.setVisible(true);
                    }
                });
            }
        });
        jButton4.setText("Show Messages Total");
        jButton4.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                popUpFrame, "Total Number of Messages: " + totalMessageCount
            );
        });
        jButton5.setText("Show User Total");
        jButton5.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                popUpFrame, "Total Number of Users: " + users.size()
            );
        });
        jButton6.setText("Show Positive Percentage");
        jButton6.addActionListener(e -> {
            double positiveMessagePercentage;
            if(totalMessageCount == 0)
                positiveMessagePercentage = 0;
            else
                positiveMessagePercentage = (positiveMessageCount/totalMessageCount)*100;
            JOptionPane.showMessageDialog(
                popUpFrame, "Positive Tweet Percentage: " + positiveMessagePercentage + "%"
            );
        });
        jButton7.setText("Show Group Total");
        jButton7.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                popUpFrame, "Total Number of Groups: " + user_groups.size()
            );
        });

        // Generated code using NetBeans Swing layout builder
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    public JTree initJTree() {
        User_Group rootGroup = new User_Group("Root");
        user_groups.put("Root", rootGroup);
        root = new DefaultMutableTreeNode(rootGroup.getDisplayName());

        DefaultTreeModel model = new DefaultTreeModel(root);
        model.setAsksAllowsChildren(true);
        jTree1 = new JTree(model);
        expandTree(jTree1);

        return jTree1;
    }

    public void expandTree(JTree tree) {
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.setExpandsSelectedPaths(true);
            tree.expandRow(i);
        }
    }
    
    private void addUser(String newUserName) {
        if (!users.containsKey(newUserName)) {
            User newUser = new User(newUserName);
            users.put(newUserName, newUser);

            DefaultMutableTreeNode selectedUser = (DefaultMutableTreeNode)jTree1.getSelectionPath().getLastPathComponent();
            selectedUser.add(new DefaultMutableTreeNode(jTextField1.getText(), false));
            jTextField1.setText("");
            DefaultTreeModel model = (DefaultTreeModel)jTree1.getModel();
            model.reload();
            expandTree(jTree1);
        }
    }

    private void addUserGroup(String newUserGroupName) {
        if (!user_groups.containsKey(newUserGroupName)) {
            User_Group newUserGroup = new User_Group(newUserGroupName);
            user_groups.put(newUserGroupName, newUserGroup);
            
            DefaultMutableTreeNode selectedUser = (DefaultMutableTreeNode)jTree1.getSelectionPath().getLastPathComponent();
            selectedUser.add(new DefaultMutableTreeNode(jTextField2.getText(), true));
            jTextField2.setText("");
            DefaultTreeModel model = (DefaultTreeModel)jTree1.getModel();
            model.reload();
            expandTree(jTree1);
        } 
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public HashMap<String, User_Group> getGroups() {
        return user_groups;
    }
}