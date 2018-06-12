package com.lc.shopmarket.Dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.lc.shopmarket.DataExchage.InventoryDao;
import com.lc.shopmarket.DataExchage.MerchandiseDao;
import com.lc.shopmarket.JavaBean.Purchase;
/*
*该类的功能以及特点描述：超市管理系统的商品库存信息的对话框


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
*@date(开发日期)：2018/5/29
*改进：
*
*
*
*最后更改日期：
*/
public class InventoryDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3891315286629746550L;


	private final JPanel contentPanel = new JPanel();


	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
     
	private Purchase  purchase;
	private InventoryDao dao;
	public InventoryDialog(Purchase p) {
		dao=new InventoryDao();
		this.purchase=p;
		
		//窗口标签以及窗口居中
		//让窗口居中
		 Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight=dem.height;
		int sWidth=dem.width;
		int fHeight=this.getHeight();
		int fWidth=this.getWidth();
		this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);
		
		setBounds(100, 100, 556, 547);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle(p.getProductName()+"的库存信息");
		
		JLabel lblNewLabel = new JLabel("\u5E93\u5B58\u7F16\u7801\uFF1A");
		lblNewLabel.setBounds(51, 85, 89, 18);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setBounds(51, 149, 89, 18);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_2.setBounds(51, 217, 89, 18);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6570\u91CF\uFF1A");
		lblNewLabel_3.setBounds(51, 288, 105, 18);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u96F6\u552E\u4EF7\uFF08\u5143\uFF09\uFF1A");
		lblNewLabel_4.setBounds(51, 363, 105, 18);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u65F6\u95F4\uFF1A");
		lblNewLabel_5.setBounds(291, 85, 100, 18);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u7C7B\u522B\uFF1A");
		lblNewLabel_6.setBounds(291, 217, 100, 18);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u8FDB\u8D27\u4EF7\uFF1A");
		lblNewLabel_7.setBounds(291, 149, 100, 18);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u5236\u5355\u4EBA");
		lblNewLabel_8.setBounds(291, 288, 72, 18);
		contentPanel.add(lblNewLabel_8);
		
		//仓库编号
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(154, 82, 86, 24);
		textField.setText(purchase.getBackSaleId());
		contentPanel.add(textField);
		textField.setColumns(10);
		//商品编号
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(154, 146, 86, 24);
		textField_1.setText( purchase.getProductId());
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		//商品名称
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(154, 214, 86, 24);
		textField_2.setText( purchase.getProductName());
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		//数量
		textField_3 = new JTextField();
		textField_3.setBounds(154, 285, 86, 24);
		textField_3.setText( purchase.getNumber().toString());
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		//零售价	
		textField_4 = new JTextField();
		textField_4.setBounds(154, 360, 86, 24);
		textField_4.setText( purchase.getPrice().toString());
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		//时间
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(405, 82, 86, 24);
		textField_5.setText( purchase.getJtDate());
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		//类别
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(405, 214, 86, 24);
		textField_6.setText( purchase.getNextBack());
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		//进货价
		
		textField_7 = new JTextField();
		textField_7.setBounds(405, 146, 86, 24);
		textField_7.setText( purchase.getSuperMarket().toString());
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		//制单人
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(405, 285, 86, 24);
		textField_8.setText( purchase.getReason());
		contentPanel.add(textField_8);
		textField_8.setColumns(10);
		
		//返回  
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(51, 438, 113, 27);
		contentPanel.add(btnNewButton);
		
		
		//清除商品
		JButton btnNewButton_1 = new JButton("\u6E05\u9664\u5546\u54C1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//根据商品的编码进行下架
				
				
				try {
					
					dao.removePurchase(textField.getText().trim());
					JOptionPane.showMessageDialog(null, "商品下架成功", "提示", JOptionPane.ERROR_MESSAGE);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "商品下架失败", "警告", JOptionPane.ERROR_MESSAGE);
					dispose();
					new MidMerchandiseDialog("撤销").setVisible(true);
				}
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(215, 438, 113, 27);
		contentPanel.add(btnNewButton_1);
		
		//修改库存
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u5E93\u5B58");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				try {
					
					//在这里就要修改可能改变的参数
					purchase.setSuperMarket(new BigDecimal(textField_7.getText().trim()));
					purchase.setNumber(new BigDecimal(textField_3.getText().trim()));//数量
					purchase.setPrice(new BigDecimal(textField_4.getText().trim()));
				
					dao.updatePurchase(purchase);
					JOptionPane.showMessageDialog(null, "商品修改成功", "提示", JOptionPane.ERROR_MESSAGE);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "商品修改失败", "警告", JOptionPane.ERROR_MESSAGE);
					dispose();
					new MidMerchandiseDialog("修改").setVisible(true);
				}
				
			}
		});
		btnNewButton_2.setBounds(378, 438, 113, 27);
		contentPanel.add(btnNewButton_2);
	}

}
