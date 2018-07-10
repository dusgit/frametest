package com.dus.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.dus.client.NettyClient;

public class SimpleListener implements ActionListener{

	private JTextField jTextField;
	public SimpleListener(JTextField jTextField){
		this.jTextField = jTextField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 获取输入框内容
		String text = jTextField.getText();
		NettyClient.cf.channel().writeAndFlush(text);
		Chat.jTextArea.append("me:"+text+"\n");
		jTextField.setText("");
	}

}
