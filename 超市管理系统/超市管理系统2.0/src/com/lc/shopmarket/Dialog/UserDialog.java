package com.lc.shopmarket.Dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.lc.shopmarket.DataExchage.UserDao;
import com.lc.shopmarket.JavaBean.User;
/*
*该类的功能以及特点描述：超市管理系统用户信息展示对话框

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
*@date(开发日期)：2018/5/23
*改进：
*1.动态显示数据信息
*2.
*
*
*最后更改日期：
*/
public class UserDialog extends JDialog {


	
	
	private static final long serialVersionUID = -370034933657178908L;
		private final JPanel contentPanel = new JPanel();
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;

		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;
		private JTextField textField_7;
		private JTextField textField_8;

		private User user=null;
		private JPasswordField passwordField;


		public UserDialog(User user1) {
			this.user=user1;
			setBounds(100, 100, 520, 465);
			getContentPane().setLayout(new BorderLayout());
			setTitle(user.getUserName()+"的基本信息");
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			{
				JLabel label = new JLabel("\u5361\u53F7");
				label.setBounds(34, 56, 72, 18);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("\u6301\u5361\u4EBA");
				label.setBounds(34, 103, 72, 18);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("\u8BC1\u4EF6\u53F7");
				label.setBounds(34, 159, 72, 18);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("\u5F00\u5361\u65E5\u671F");
				label.setBounds(34, 271, 72, 24);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("\u7C7B\u578B");
				label.setBounds(260, 56, 72, 18);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("\u671F\u9650");
				label.setBounds(260, 100, 72, 18);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("\u79EF\u5206");
				label.setBounds(260, 159, 72, 18);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("\u6298\u6263\u7387");
				label.setBounds(260, 220, 72, 18);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("\u5BC6\u7801");
				label.setBounds(34, 220, 72, 18);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("\u5907\u6CE8");
				label.setBounds(260, 274, 72, 18);
				contentPanel.add(label);
			}
			
			//窗口标签以及窗口居中
			//让窗口居中
			 Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
			int sHeight=dem.height;
			int sWidth=dem.width;
			int fHeight=this.getHeight();
			int fWidth=this.getWidth();
			this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);
			//卡号
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(102, 53, 86, 24);
			contentPanel.add(textField);
			textField.setColumns(10);
			textField.setText(user.getCardId());
			//持卡人
			textField_1 = new JTextField();
			textField_1.setBounds(102, 100, 86, 24);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
			textField_1.setText(user.getUserName());
			//证件号
			//如何实现部分显示
			textField_2 = new JTextField();
			textField_2.setBounds(102, 156, 122, 24);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
			
			String id=user.getIdcard();
			int size=id.length();
			String id1=id.substring(0,4);
			String id2=id.substring(size-5,size-1);
			String id3=id1+"********"+id2;
			textField_2.setText(id3);
			
			
			
			//密码

			passwordField = new JPasswordField();
			passwordField.setBounds(102, 217, 86, 24);
			contentPanel.add(passwordField);
			passwordField.setColumns(10);
			passwordField.setText(user.getPassword());
			//开卡日期
			textField_4 = new JTextField();
			textField_4.setEditable(false);
			textField_4.setBounds(102, 271, 86, 24);
			contentPanel.add(textField_4);
			textField_4.setText(user.getCardDate());
			textField_4.setColumns(10);
			
			//用户类型

			textField_5 = new JTextField();
			textField_5.setEditable(false);
			textField_5.setText(user.getUserGrade());
			textField_5.setBounds(346, 53, 86, 24);
			textField_5.setColumns(10);
			contentPanel.add(textField_5);
	
			//期限
			textField_6 = new JTextField();
			textField_6.setEditable(false);
			textField_6.setText(user.getTerm());
			textField_6.setBounds(346, 97, 86, 24);
			contentPanel.add(textField_6);
			textField_6.setColumns(10);
			//积分
			textField_7 = new JTextField();
			textField_7.setEditable(false);
			textField_7.setText(user.getIntegral());
			textField_7.setBounds(346, 156, 86, 24);
			contentPanel.add(textField_7);
			textField_7.setColumns(10);
			//折扣率
			textField_8 = new JTextField();
			textField_8.setEditable(false);
			textField_8.setText(user.getAgio());
			textField_8.setBounds(346, 217, 86, 24);
			contentPanel.add(textField_8);
			textField_8.setColumns(10);
			//备注
			JTextArea textArea = new JTextArea();
			textArea.setBounds(346, 286, 86, 66);
			contentPanel.add(textArea);
			
			
			//修改按钮
			JButton btnNewButton = new JButton("\u4FEE\u6539");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//只能修改3个属性  持卡人、证件、密码
					String userName=textField_1.getText().trim();//用户名
				    String iDcard=textField_2.getText().trim();//证件号
					//passwordField是二进制形式 所以要进行转换
					char[]m=passwordField.getPassword();
					String password=new String(m);
					user.setUserName(userName);
					user.setIdcard(iDcard);
					user.setPassword(password);
					
					
					//用UserDao进行用户更新
					try {
						UserDao userDao=new UserDao();
						userDao.update(user);
						//修改成功提示
						JOptionPane.showMessageDialog(null, "VIP修改成功", "提示", JOptionPane.ERROR_MESSAGE);
						dispose();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
						//修改失败提示
						JOptionPane.showMessageDialog(null, "VIP修改失败", "警告", JOptionPane.ERROR_MESSAGE);
						textField_1.setText("");
						textField_2.setText("");
						passwordField.setText("");
					}
					
					
					
					
					
					
				}
			});
			btnNewButton.setBounds(195, 365, 113, 27);
			contentPanel.add(btnNewButton);
			
			
			//删除按钮
			JButton btnNewButton_1 = new JButton("\u5220\u9664");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//获取主键 通过主键对用户进行注销
					
					String cardId=user.getIdcard();
					
					try {
						UserDao userDao=new UserDao();
						userDao.removeUser(cardId);
						JOptionPane.showMessageDialog(null, "VIP注销成功", "提示", JOptionPane.ERROR_MESSAGE);
						dispose();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "VIP注销失败", "警告", JOptionPane.ERROR_MESSAGE);
					}
					
						
					
						
						
					}
				    	
				  


				    
				    
					
					
				
			});
			btnNewButton_1.setBounds(356, 365, 113, 27);
			contentPanel.add(btnNewButton_1);
			
			
			//返回按钮
			JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					dispose();
					
				}
			});
			btnNewButton_2.setBounds(34, 365, 113, 27);
			contentPanel.add(btnNewButton_2);
			
			
	}
}
