package com.lc.shopmarket.Dialog;



import javax.swing.JButton;
import javax.swing.JDialog;


import com.lc.shopmarket.DataExchage.UserDao;
import com.lc.shopmarket.JavaBean.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 *该类的功能以及特点描述：超市管理系统查询用户时输入VIP号的对话框


 *该类是否被编译测试：否
 *@see(与之相关联的类)：   来源：
 *                     中间：
 *                     去处：
 *开发公司或单位：成007个人
 *版权：成007

 *@author(作者)：成007
 *@since（该文件使用的jdk）：JDK1.8
 *@version（版本）：1.0
 *@数据库查询方式：mysql+Hibernate
 *@date(开发日期)：2018/5/22
 *改进：
 *1.
 *2.
 *
 *
 *最后更改日期：
 */
public class MidUserDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9015782795236349657L;
	private JTextField textField;
	public MidUserDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setTitle("查询VIP信息");
		//窗口标签以及窗口居中
		//让窗口居中
		Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight=dem.height;
		int sWidth=dem.width;
		int fHeight=this.getHeight();
		int fWidth=this.getWidth();
		this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);

		JLabel lblvip = new JLabel("\u7528\u6237VIP\u53F7\uFF1A");
		lblvip.setFont(new Font("黑体", Font.PLAIN, 18));
		lblvip.setBounds(61, 105, 105, 18);
		getContentPane().add(lblvip);

		textField = new JTextField();
		textField.setBounds(212, 104, 169, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		//取消按钮
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//关闭对话框
				dispose();

			}
		});
		btnNewButton.setBounds(61, 175, 113, 27);
		getContentPane().add(btnNewButton);

		//确认按钮
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取输入框框内容
				//进行用户查询

				String UserID=textField.getText().trim();

				if(UserID.equals(""))
				{
					//输入内容不得为空
					JOptionPane.showMessageDialog(null, "输入框不得为空", "警告", JOptionPane.ERROR_MESSAGE);
				}
				else
				{

					User user=UserDao.getUserDao().look(UserID);
						

					if(user!=null)
					{
						//查询成功打开用户信息对话框
						UserDialog dialog=new UserDialog(user);
						dialog.setVisible(true);

						//关闭本对话框
						dispose();

					}
					else
					{
						//查询失败进行警告提示
						JOptionPane.showMessageDialog(null, "该VIP用户不存在", "警告", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
					}


				}




			}
		});
		btnNewButton_1.setBounds(268, 175, 113, 27);
		getContentPane().add(btnNewButton_1);

		JLabel lblvip_1 = new JLabel("\u67E5\u8BE2VIP\u4FE1\u606F");
		lblvip_1.setFont(new Font("黑体", Font.PLAIN, 24));
		lblvip_1.setBounds(142, 33, 138, 27);
		getContentPane().add(lblvip_1);
	}
}
