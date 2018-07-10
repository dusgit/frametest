package com.dus.frame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chat {
	
	public static JTextArea jTextArea;
	
	public void initChat(){
		JFrame frame = new JFrame("We chat");
		frame.setSize(400, 340);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
        JPanel panel = new JPanel();  
        panel.setLayout(null);
        // 创建 JLabel
        JLabel userLabel = new JLabel("");
        userLabel.setBounds(5,5,374,25);
        userLabel.setBackground(new Color(233));
        userLabel.setVisible(true);
        userLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.add(userLabel);
        
        // 创建文本域用于用户输入
        jTextArea = new JTextArea(2,8);
        jTextArea.setBounds(5,40,374,200);
        jTextArea.setBorder(BorderFactory.createLineBorder(Color.gray));
        //创建滚动
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(5,40,374,200);
        scrollPane.setViewportView(jTextArea);
        panel.add(scrollPane);
//        panel.add(jTextArea);
        // 添加单行输入框
        JTextField jtf = new JTextField();
        jtf.setBounds(8, 250, 270, 30);
        panel.add(jtf);
        //添加发送按钮
        JButton loginButton = new JButton("发送");
        loginButton.setBounds(298, 250, 80, 25);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new SimpleListener(jtf));
        
        panel.add(loginButton);
        frame.setContentPane(panel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Chat chat = new Chat();
		chat.initChat();
	}
	
}

