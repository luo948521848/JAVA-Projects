package com.lc.shopmarket.Dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.lc.shopmarket.DataExchage.UserDao;
import com.lc.shopmarket.JavaBean.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
/*
 *该类的功能以及特点描述：超市管理系统添加用户对话框


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
public class AddUserDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1707421076379314803L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	private JPasswordField passwordField;
	private JComboBox comboBox ;
	private String DEFAULT_TIME_FORMAT = "yyyy-MM-dd";  
	private String time;  

	public AddUserDialog() {
		setBounds(100, 100, 520, 465);
		getContentPane().setLayout(new BorderLayout());
		setTitle("注册用户");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		//窗口标签以及窗口居中
		//让窗口居中
		Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight=dem.height;
		int sWidth=dem.width;
		int fHeight=this.getHeight();
		int fWidth=this.getWidth();
		this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);
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


		//卡号
		textField = new JTextField();
		textField.setBounds(102, 53, 86, 24);
		contentPanel.add(textField);
		textField.setColumns(10);

		//持卡人
		textField_1 = new JTextField();
		textField_1.setBounds(102, 100, 86, 24);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		//证件号
		textField_2 = new JTextField();
		textField_2.setBounds(102, 156, 86, 24);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		//密码
		passwordField = new JPasswordField();
		passwordField.setBounds(102, 217, 86, 24);
		contentPanel.add(passwordField);
		passwordField.setColumns(10);
		//开卡日期
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(102, 271, 86, 24);
		contentPanel.add(textField_4);
		Date date=new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat(  
				DEFAULT_TIME_FORMAT); 
		time=dateFormatter.format(date);
		textField_4.setText(time);
		textField_4.setColumns(10);

		//用户类型复选框
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"普通用户", "超级ViP"}));
		comboBox.setBounds(346, 53, 86, 24);
		contentPanel.add(comboBox);
		//期限
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText("1\u5E74");
		textField_6.setBounds(346, 97, 86, 24);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		//积分
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("0");
		textField_7.setBounds(346, 156, 86, 24);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		//折扣率
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setText("90");
		textField_8.setBounds(346, 217, 86, 24);
		contentPanel.add(textField_8);
		textField_8.setColumns(10);
		//备注
		JTextArea textArea = new JTextArea();
		textArea.setBounds(346, 286, 86, 66);
		contentPanel.add(textArea);


		//取消按钮
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnNewButton.setBounds(34, 331, 113, 27);
		contentPanel.add(btnNewButton);


		//注册按钮
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//进行用户注册
				String cardId=textField.getText().trim();//卡号
				String userName=textField_1.getText().trim();//用户名
				String iDcard=textField_2.getText().trim();//证件号
				//passwordField是二进制形式 所以要进行转换
				char[]m=passwordField.getPassword();
				String password=new String(m);

				String CardDate=textField_4.getText().trim();//注册日期
				String userGrade=comboBox.getSelectedItem().toString();

				String term=textField_6.getText().trim();//期限
				String integral=textField_7.getText().trim();//积分
				String agio=textField_8.getText().trim();//折扣


				User user=new User(cardId,userName,iDcard,password,CardDate,userGrade,term,integral,agio);

				//通过UserDao进行用户注册

			
				try {
					UserDao.getUserDao().add(user);
					
					//注册成功
					JOptionPane.showMessageDialog(null, "VIP注册成功", "提示", JOptionPane.ERROR_MESSAGE);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					//注册失败
					JOptionPane.showMessageDialog(null, "VIP注册失败", "警告", JOptionPane.ERROR_MESSAGE);

					//对前四个选项进行清空
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					passwordField.setText("");




				}








			}
		});
		btnNewButton_1.setBounds(204, 331, 113, 27);
		contentPanel.add(btnNewButton_1);



	}

}
