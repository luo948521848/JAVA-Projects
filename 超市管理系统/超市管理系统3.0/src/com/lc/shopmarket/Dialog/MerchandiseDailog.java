package com.lc.shopmarket.Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lc.shopmarket.DataExchage.MerchandiseDao;
import com.lc.shopmarket.JavaBean.Merchandise;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

/*
 *该类的功能以及特点描述：超市管理系统显示商品信息的对话框


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
public class MerchandiseDailog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6758474184641399419L;
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
	private JTextField textField_9;

	private Merchandise merchandise;

	public MerchandiseDailog(Merchandise m) {
		;

		merchandise=m;

		setBounds(100, 100, 556, 547);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle(m.getMerchandiseName()+"的基本信息");

		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u7801\uFF1A");
		lblNewLabel.setBounds(51, 85, 89, 18);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u7C7B\u578B\u7801\uFF1A");
		lblNewLabel_1.setBounds(51, 149, 72, 18);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u7C7B\u578B\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setBounds(51, 217, 89, 18);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u540D\u79F0:");
		lblNewLabel_3.setBounds(51, 288, 105, 18);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u96F6\u552E\u4EF7\uFF08\u5143\uFF09\uFF1A");
		lblNewLabel_4.setBounds(51, 363, 105, 18);
		contentPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u5546\u54C1\u89C4\u683C\uFF1A");
		lblNewLabel_5.setBounds(291, 85, 100, 18);
		contentPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u8BA1\u91CF\u5355\u4F4D\uFF1A");
		lblNewLabel_6.setBounds(291, 149, 100, 18);
		contentPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\u8FDB\u8D27\u4EF7\uFF1A");
		lblNewLabel_7.setBounds(291, 217, 100, 18);
		contentPanel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\u4FDD\u8D28\u671F\uFF1A");
		lblNewLabel_8.setBounds(291, 288, 72, 18);
		contentPanel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("\u5907\u6CE8\uFF1A");
		lblNewLabel_9.setBounds(291, 363, 72, 18);
		contentPanel.add(lblNewLabel_9);

		//商品编码
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(154, 82, 86, 24);
		textField.setText(m.getMerchandiseNumber());
		contentPanel.add(textField);
		textField.setColumns(10);
		//条形码
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(154, 146, 86, 24);
		textField_1.setText(m.getTreatyCode());
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		//商品类型
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(154, 214, 86, 24);
		textField_2.setText(m.getSortNumber());
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		//商品名称
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(154, 285, 86, 24);
		textField_3.setText(m.getMerchandiseName());
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		//零售价

		textField_4 = new JTextField();
		textField_4.setBounds(154, 360, 86, 24);
		textField_4.setText(m.getRetailPrice().toString());
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		//商品规格

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(405, 82, 86, 24);
		textField_5.setText(m.getMerchandiseSpec());
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		//计量单位

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(405, 146, 86, 24);
		textField_6.setText(m.getUnits());
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		//进货价

		textField_7 = new JTextField();
		textField_7.setBounds(405, 214, 86, 24);
		textField_7.setText(m.getPurchasePrice().toString());
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		//保质期
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(405, 285, 86, 24);
		textField_8.setText(m.getCheckTerm().toString());
		contentPanel.add(textField_8);
		textField_8.setColumns(10);
		//备注
		textField_9 = new JTextField();
		textField_9.setBounds(405, 360, 86, 24);
		textField_9.setText(m.getRemark());
		contentPanel.add(textField_9);
		textField_9.setColumns(10);

		//返回  
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(51, 438, 113, 27);
		contentPanel.add(btnNewButton);


		//商品下架
		JButton btnNewButton_1 = new JButton("\u4E0B\u67B6");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//根据商品的编码进行下架


				try {
					MerchandiseDao.getMerchandiseDao().removeMerchandise(merchandise.getMerchandiseNumber());
					
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

		//修改商品
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//根据商品的编码进行下架


				try {

					//在这里就要修改可能改变的参数
					merchandise.setRetailPrice(new BigDecimal(textField_4.getText().trim()));
					merchandise.setPurchasePrice(new BigDecimal(textField_7.getText().trim()));
					merchandise.setRemark(textField_9.getText().trim());

					MerchandiseDao.getMerchandiseDao().updateMerchandise(merchandise);
				
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
