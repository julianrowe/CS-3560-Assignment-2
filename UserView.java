import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserView extends javax.swing.JFrame {

    private User user;
    private static UserView userViewInstance;
    private static LinkedList<String> tweetStrings = new LinkedList<>();
    private static LinkedList<String> followingStrings = new LinkedList<>();
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;

    public UserView(User user) {
        this.user = user;

        initUserView(user);
    }

    // Doesn't check if instance is null so you can open multiple userViews
    public static UserView getUserView(User user) {
        userViewInstance = new UserView(user);
        return userViewInstance;
    }

    // Generated code using NetBeans Swing layout builder
    private void initUserView(User user) {
        setTitle("User View - " + user.getDisplayName());
        setResizable(false);

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                followingStrings.add(jTextField1.getText());
                jTextField1.setText("");
                updateFollowing();
            }
        });
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tweetStrings.add("(" + user.getLastUpdateTime() + ") " + user.getDisplayName() + ": " + jTextField2.getText());
                AdminPanel.totalMessageCount++;
                isMessagePositive(jTextField2.getText());
                jTextField2.setText("");
                updateTweets();
            }
        });
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        jTextField1.setText("");

        jButton1.setText("Follow User");

        updateFollowing();
        jScrollPane1.setViewportView(jList1);

        jButton2.setText("Post Tweet");

        jTextField2.setText("");

        updateTweets();
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void updateFollowing() {
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return followingStrings.size(); }
            public String getElementAt(int i) { return followingStrings.get(i); }
        });
    }

    private void updateTweets() {
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return tweetStrings.size(); }
            public String getElementAt(int i) { return tweetStrings.get(i); }
        });
    }

    private void isMessagePositive(String message) {
        String[] positiveWords = {"good", "great", "excellent", };
        for(int i = 0; i < positiveWords.length; i++)
		{
            if(message.contains(positiveWords[i]))
		        AdminPanel.positiveMessageCount++;
		}
    }
}