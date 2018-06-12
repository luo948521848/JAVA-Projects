package com.lc.shopmarket.Dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.lc.shopmarket.DataExchage.InventoryDao;
import com.lc.shopmarket.DataExchage.MerchandiseDao;
import com.lc.shopmarket.JavaBean.Merchandise;
import com.lc.shopmarket.JavaBean.Purchase;
/*
*该类的功能以及特点描述：超市管理系统查询库存输入的库存Id的对话框


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
*1.
*2.
*
*
*最后更改日期：
*/

public class MidInventoryDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5548730197534689837L;

	private final JPanel contentPanel = new JPanel();

	private JTextField textField;
	public MidInventoryDialog(String Ord) {
		
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setTitle(Ord);
		//窗口标签以及窗口居中
		//让窗口居中
		 Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight=dem.height;
		int sWidth=dem.width;
		int fHeight=this.getHeight();
		int fWidth=this.getWidth();
		this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);
		
		JLabel lblvip = new JLabel("仓库编号：");
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
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取输入框框内容
				//进行用户查询
				
				String PurchaseID=textField.getText().trim();
				
				if(PurchaseID.equals(""))
				{
					//输入内容不得为空
					JOptionPane.showMessageDialog(null, "输入框不得为空", "警告", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					//根据商品编码来查询商品基本信息
	
				  Purchase purchase=new InventoryDao().lookPurchase(PurchaseID);					
					if(purchase!=null)
					{
						
						//打开库存对话框（可以进行下架工作）
						
                        
						  new InventoryDialog(purchase).setVisible(true);
						  dispose();
						
					}
					else
					{
						
						//查询商品不存在
						JOptionPane.showMessageDialog(null, "商品不存在", "警告", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						
					}
					
					
					
					
				}
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(268, 175, 113, 27);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblvip_1 = new JLabel(Ord);
		lblvip_1.setFont(new Font("黑体", Font.PLAIN, 24));
		lblvip_1.setBounds(142, 33, 153, 27);
		getContentPane().add(lblvip_1);

	}

}
