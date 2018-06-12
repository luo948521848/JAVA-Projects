package com.lc.shopmarket.Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lc.shopmarket.DataExchage.InventoryDao;
import com.lc.shopmarket.DataExchage.MerchandiseDao;
import com.lc.shopmarket.JavaBean.Merchandise;
import com.lc.shopmarket.JavaBean.Purchase;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/*
*该类的功能以及特点描述：超市管理系统进货的操作窗口


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
*1.关于如何监听文本框的变化
*2.
*
*
*最后更改日期：
*/



public class PutInventoryDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4137200640570539082L;


	private final JPanel contentPanel = new JPanel();

	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
    private JComboBox comboBox;

    private String DEFAULT_TIME_FORMAT = "yyyy-MM-dd";  
    private String DEFAULT_TIME_FORMAT1 = "yyyyMMdd"; 
    private String time;  
    private String time1; 
	
    //表格所需的变量
    private Vector<String>colunmNames;
    private Vector<Vector<String>>tableValue;
    private JTable table;
	public PutInventoryDialog(String reason) {

			setTitle("新商品进货");
			setIconImage(Toolkit.getDefaultToolkit().getImage(PutawayDialog.class.getResource("/images/1.jpg")));
			setBounds(100, 100, 939, 563);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			
			
			//在JtabbedPane范围内添加表格
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(220, 13, 687, 456);
		    table=new JTable();
			

			//用model给jtable填充数据，vector给model填充数据，vector给vector填充数据   
			//因为第一参数接收的是二维的参数，所以产生了vector给vector填充数据 
			colunmNames=new Vector<String>();
			colunmNames.add("仓库编号");
			colunmNames.add("商品编号");
			colunmNames.add("商品名称");
			colunmNames.add("数量");
			colunmNames.add("价格");
			colunmNames.add("时间");
			colunmNames.add("进货价");
			colunmNames.add("类别");
			colunmNames.add("制单人");

			
			//定义二维部分
			tableValue =new Vector<Vector<String>>();//定义表格数据向量
			//定义一行的数据类容
			//修改table(增加)即可
			DefaultTableModel model = new DefaultTableModel(tableValue,colunmNames);
			table.setModel(model);
			
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
	         //水平滚动条根据需要才显示
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
			//垂直滚动条根据需要才显示
			tabbedPane.add(scrollPane);
			
			contentPanel.add(tabbedPane);
			
			
			
			
			
			
			
			JLabel label = new JLabel("\u4ED3\u5E93\u7F16\u53F7");
			label.setBounds(14, 13, 72, 18);
			contentPanel.add(label);
			
			JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7");
			lblNewLabel.setBounds(14, 63, 72, 18);
			contentPanel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
			lblNewLabel_1.setBounds(14, 110, 72, 18);
			contentPanel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("\u6570\u91CF");
			lblNewLabel_2.setBounds(14, 160, 72, 18);
			contentPanel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("\u96F6\u552E\u4EF7");
			lblNewLabel_3.setBounds(14, 213, 72, 18);
			contentPanel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("\u65F6\u95F4");
			lblNewLabel_4.setBounds(14, 263, 72, 18);
			contentPanel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("\u8FDB\u8D27\u4EF7");
			lblNewLabel_5.setBounds(14, 314, 72, 18);
			contentPanel.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("\u7C7B\u522B");
			lblNewLabel_6.setBounds(14, 359, 72, 18);
			contentPanel.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("\u5236\u5355\u4EBA");
			lblNewLabel_7.setBounds(14, 406, 72, 18);
			contentPanel.add(lblNewLabel_7);
			
			Date date=new Date();
	        SimpleDateFormat dateFormatter = new SimpleDateFormat(  
	                DEFAULT_TIME_FORMAT1); 
			time=dateFormatter.format(date);
			//仓库编号
			//通过时间和商品编号自动形成仓库编号
			textField = new JTextField();
			textField.setBounds(100, 10, 106, 24);
			textField.setText(time);
			contentPanel.add(textField);
			textField.setColumns(10);
			//商品编号
			textField_1 = new JTextField();
			textField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					

					String text=textField_1.getText().trim();
					
					textField.setText(time+text);
					
				}
			});
			
			
			textField_1.setColumns(10);
			textField_1.setBounds(100, 60, 86, 24);
			contentPanel.add(textField_1);
			
			//商品名称
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(100, 107, 86, 24);
			contentPanel.add(textField_6);
			//数量
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(100, 157, 86, 24);
			contentPanel.add(textField_2);
			//零售价
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(100, 210, 86, 24);
			contentPanel.add(textField_3);
			//时间
			textField_4 = new JTextField();
		
	        SimpleDateFormat dateFormatter1 = new SimpleDateFormat(  
	                DEFAULT_TIME_FORMAT); 
			time1=dateFormatter1.format(date);
			textField_4.setEditable(false);
			textField_4.setColumns(10);
			textField_4.setBounds(100, 260, 86, 24);
			textField_4.setText(time1);
			contentPanel.add(textField_4);
			//进货价
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(100, 311, 86, 24);
			contentPanel.add(textField_5);

			//制单人
			textField_7 = new JTextField();
			textField_7.setEditable(false);
			textField_7.setText(reason);
			textField_7.setColumns(10);
			textField_7.setBounds(100, 403, 86, 24);
			contentPanel.add(textField_7);
			//商品类别
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u751F\u9C9C\u7C7B", "\u96F6\u98DF\u7C7B", "\u6C34\u679C\u7C7B", "\u996E\u6599\u7C7B"}));
			comboBox.setBounds(100, 356, 86, 24);
			contentPanel.add(comboBox);
			
			
			//添加
			JButton btnNewButton = new JButton("\u6DFB\u52A0");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					 //获取输入框类容
				     String backID=textField.getText().trim();;//仓库编码
					 String productID=textField_1.getText().trim();;//商品编码
					 String productName=textField_6.getText().trim();//商品名称
					 
					 String number=textField_2.getText().trim();;//数量
					 String SretailPric=textField_3.getText().trim();
					 //BigDecimal retailPrice=new BigDecimal(SretailPric);//零售价 
					 
					 String date=textField_4.getText().trim();;//时间
					 String SuperMarket=textField_5.getText().trim();;//进货价
					 
					 String type=comboBox.getSelectedItem().toString().trim();//类别
					 // BigDecimal purchasePrice=new BigDecimal(SpurchasePrice);//进货价
					
					 String reason=textField_7.getText().trim();//制单人
					

					
					 //加入到表格中
					 Vector<String>row=new Vector<String>();
					 row.add(backID);
					 row.add(productID);
					 row.add(productName);
					 row.add(number);
					 row.add(SretailPric);
					 
					 row.add(date);//时间
					 
					 row.add(SuperMarket);//进货价
					 row.add(type);//类别
					 row.add(reason);//制单人

					 tableValue.add(row);
					 
					 //加入到表格中
					 DefaultTableModel model = new DefaultTableModel(tableValue,colunmNames);
					 table.setModel(model);
					 

					 
					 //将文本框再次清空
					 textField.setText(time);
					 textField_1.setText("");
					 textField_2.setText("");
					 textField_3.setText("");
					 
					 textField_5.setText("");
					 textField_6.setText("");
				

					 comboBox.setSelectedIndex(0);
				}
			});
			btnNewButton.setBounds(73, 476, 113, 27);
			contentPanel.add(btnNewButton);
			
			//重置
			JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		 
					 //将文本框清空
					 textField.setText(time);
					 textField_1.setText("");
					 textField_2.setText("");
					 textField_3.setText("");
					 
					 textField_5.setText("");
					 textField_6.setText("");
					 

					 comboBox.setSelectedIndex(0);
				}
			});
			btnNewButton_1.setBounds(285, 476, 113, 27);
			contentPanel.add(btnNewButton_1);
			
			//删除
			JButton btnNewButton_2 = new JButton("\u5220\u9664");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//难点如何确定选定的表中的商品
					
					
					int[] selection = table.getSelectedRows();
					DefaultTableModel model = (DefaultTableModel)table.getModel();//获取defaulttablemodel
					
					
					
					for(int i:selection)
					{
						model.removeRow(i);//删除某行
					}
					table.setModel(model);
					
					
					
					
				}
			});
			btnNewButton_2.setBounds(500, 476, 113, 27);
			contentPanel.add(btnNewButton_2);
			
			//提交
			JButton btnNewButton_3 = new JButton("\u63D0\u4EA4");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int size = table.getRowCount(); 
					System.out.println("表格的行数为："+size);
					DefaultTableModel model = (DefaultTableModel)table.getModel();//获取defaulttablemodel
					List<Purchase>list=new ArrayList<Purchase>();
					
					
					for(int i=0;i<size;i++)
					{
						Purchase purchase=new Purchase();
						purchase.setBackSaleId(model.getValueAt(i,0).toString());//仓库编号
						purchase.setProductId(model.getValueAt(i,1).toString());//商品编号
						purchase.setProductName(model.getValueAt(i,2).toString());//商品名称
						purchase.setNumber(new BigDecimal(model.getValueAt(i,3).toString()));//数量
						purchase.setPrice(new BigDecimal(model.getValueAt(i,4).toString()));//零售价
						purchase.setJtDate(model.getValueAt(i,5).toString());//时间
						purchase.setSuperMarket(new BigDecimal(model.getValueAt(i,6).toString()));//进货价
						purchase.setNextBack(model.getValueAt(i,7).toString());
						purchase.setReason(model.getValueAt(i,8).toString());
						
						
	                    list.add(purchase);
						
					}
	              
							
				   //利用InventoryDao进行数据传输  失败记得数据回滚			
					try {
						InventoryDao dao=new InventoryDao();
						dao.PurchaseDao(list);
						JOptionPane.showMessageDialog(null, "新商品进货成功", "提示", JOptionPane.ERROR_MESSAGE);
						dispose();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "新商品进货失败", "提示", JOptionPane.ERROR_MESSAGE);
						 //将文本框清空
						 textField.setText(time);
						 textField_1.setText("");
						 textField_2.setText("");
						 textField_3.setText("");
						
						 textField_5.setText("");
						 textField_6.setText("");
						;

						 comboBox.setSelectedIndex(0);
					}
					

					
					

					
					
					
					
					
					
					
					
					
					
				}
			});
			btnNewButton_3.setBounds(729, 476, 113, 27);
			contentPanel.add(btnNewButton_3);
		}
	

}
