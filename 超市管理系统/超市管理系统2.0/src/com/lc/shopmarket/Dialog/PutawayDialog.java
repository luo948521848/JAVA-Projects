package com.lc.shopmarket.Dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lc.shopmarket.DataExchage.MerchandiseDao;
import com.lc.shopmarket.JavaBean.Merchandise;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
/*
*该类的功能以及特点描述：超市管理系统的商品上架的对话框


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
*1.实现多次添加，一次提交
*2.选定表中元素
*
*
*最后更改日期：
*/
public class PutawayDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7229296770838590595L;
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
    private JComboBox comboBox;
	
    //表格所需的变量
    private Vector<String>colunmNames;
    private Vector<Vector<String>>tableValue;
    private JTable table;

	public PutawayDialog() {
		setTitle("\u65B0\u589E\u5546\u54C1\u8868");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PutawayDialog.class.getResource("/images/1.jpg")));
		setBounds(100, 100, 939, 563);
		getContentPane().setLayout(new BorderLayout());
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
		
		//在JtabbedPane范围内添加表格
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.setBounds(220, 13, 687, 456);
	    table=new JTable();
		

		//用model给jtable填充数据，vector给model填充数据，vector给vector填充数据   
		//因为第一参数接收的是二维的参数，所以产生了vector给vector填充数据 
		colunmNames=new Vector<String>();
		colunmNames.add("商品编号");
		colunmNames.add("条形码");
		colunmNames.add("类别编号");
		colunmNames.add("商品名称");
		colunmNames.add("零售价");
		colunmNames.add("商品规格");
		colunmNames.add("计量单位");
		colunmNames.add("进货价");
		colunmNames.add("保质期");
		colunmNames.add("备注");
		
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
		
		
		
		
		
		
		
		JLabel label = new JLabel("\u5546\u54C1\u7F16\u7801");
		label.setBounds(14, 13, 72, 18);
		contentPanel.add(label);
		
		JLabel lblNewLabel = new JLabel("\u6761\u5F62\u7801");
		lblNewLabel.setBounds(14, 63, 72, 18);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7C7B\u522B\u7F16\u7801");
		lblNewLabel_1.setBounds(14, 110, 72, 18);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel_2.setBounds(14, 160, 72, 18);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u96F6\u552E\u4EF7");
		lblNewLabel_3.setBounds(14, 213, 72, 18);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5546\u54C1\u89C4\u683C");
		lblNewLabel_4.setBounds(14, 263, 72, 18);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BA1\u91CF\u5355\u4F4D");
		lblNewLabel_5.setBounds(14, 314, 72, 18);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u8FDB\u8D27\u4EF7");
		lblNewLabel_6.setBounds(14, 359, 72, 18);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u4FDD\u969C\u5929\u6570");
		lblNewLabel_7.setBounds(14, 406, 72, 18);
		contentPanel.add(lblNewLabel_7);
		
		JLabel label_1 = new JLabel("\u5907\u6CE8");
		label_1.setBounds(14, 451, 72, 18);
		contentPanel.add(label_1);
		
		//商品编码
		textField = new JTextField();
		textField.setBounds(100, 10, 86, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		//条形码
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 60, 86, 24);
		contentPanel.add(textField_1);
		//商品名称
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 157, 86, 24);
		contentPanel.add(textField_2);
		//零售价
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 210, 86, 24);
		contentPanel.add(textField_3);
		//商品规格
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 260, 86, 24);
		contentPanel.add(textField_4);
		//计量单位
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(100, 311, 86, 24);
		contentPanel.add(textField_5);
		//进货价
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(100, 356, 86, 24);
		contentPanel.add(textField_6);
		//保障天数
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(100, 403, 86, 24);
		contentPanel.add(textField_7);
		//备注
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(100, 445, 86, 24);
		contentPanel.add(textField_8);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u751F\u9C9C\u7C7B", "\u96F6\u98DF\u7C7B", "\u6C34\u679C\u7C7B", "\u996E\u6599\u7C7B"}));
		comboBox.setBounds(100, 107, 86, 24);
		contentPanel.add(comboBox);
		
		
		//添加
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 //获取输入框类容
			     String merchandiseNumber=textField.getText().trim();;//商品编码
				 String treatyCode=textField_1.getText().trim();;//条码
				 String sortNumber=comboBox.getSelectedItem().toString();;//类别编号
				 String merchandiseName=textField_2.getText().trim();;//商品名称
				 String SretailPric=textField_3.getText().trim();
				 //BigDecimal retailPrice=new BigDecimal(SretailPric);//零售价 
				 String merchandiseSpec=textField_4.getText().trim();;//商品规格
				 String units=textField_5.getText().trim();;//单位
				 String SpurchasePrice=textField_6.getText().trim();
				 // BigDecimal purchasePrice=new BigDecimal(SpurchasePrice);//进货价
				 String ScheckTerm=textField_7.getText().trim();
				 //BigDecimal checkTerm=new BigDecimal(ScheckTerm);//保质期
				 String remark=textField_8.getText().trim();;//备注	
				
				 //加入到表格中
				 Vector<String>row=new Vector<String>();
				 row.add(merchandiseNumber);
				 row.add(treatyCode);
				 row.add(sortNumber);
				 row.add(merchandiseName);
				 row.add(SretailPric);
				 row.add(merchandiseSpec);
				 row.add(units);
				 row.add(SpurchasePrice);
				 row.add(ScheckTerm);
				 row.add(remark);
				 tableValue.add(row);
				 
				 //加入到表格中
				 DefaultTableModel model = new DefaultTableModel(tableValue,colunmNames);
				 table.setModel(model);
				 

				 
				 //将文本框再次清空
				 textField.setText("");
				 textField_1.setText("");
				 textField_2.setText("");
				 textField_3.setText("");
				 textField_4.setText("");
				 textField_5.setText("");
				 textField_6.setText("");
				 textField_7.setText("");
				 textField_8.setText("");
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
				 textField.setText("");
				 textField_1.setText("");
				 textField_2.setText("");
				 textField_3.setText("");
				 textField_4.setText("");
				 textField_5.setText("");
				 textField_6.setText("");
				 textField_7.setText("");
				 textField_8.setText("");
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
				List<Merchandise>list=new ArrayList<Merchandise>();
				
				
				
				for(int i=0;i<size;i++)
				{
					 
				Merchandise m=new Merchandise();
				
				 m.setMerchandiseNumber(model.getValueAt(i,0).toString());//商品编码
				 m.setTreatyCode(model.getValueAt(i,1).toString());//条形码
				 m.setSortNumber(model.getValueAt(i,2).toString());	//类别编号
				 m.setMerchandiseName(model.getValueAt(i,3).toString());//商品名称
				 m.setRetailPrice(new BigDecimal(model.getValueAt(i,4).toString()));//零售价
				 m.setMerchandiseSpec(model.getValueAt(i,5).toString());//产品规格
				 m.setUnits(model.getValueAt(i,6).toString());//单位
				 m.setPurchasePrice(new BigDecimal(model.getValueAt(i,7).toString()));//进货价
				 m.setCheckTerm(new BigDecimal(model.getValueAt(i,8).toString()));//保质期
				 m.setRemark(model.getValueAt(i,9).toString());//备注
					 
				 list.add(m);	 
					
				}
              
						
			   //利用MerDao进行数据传输  失败记得数据回滚			
				
				MerchandiseDao dao=new MerchandiseDao();
				
				
				
				try {
					dao.AddMerchandiseDao(list);
					JOptionPane.showMessageDialog(null, "商品上架成功", "警告", JOptionPane.ERROR_MESSAGE);
					dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "商品上架失败", "警告", JOptionPane.ERROR_MESSAGE);
					
					 //将文本框清空
					 textField.setText("");
					 textField_1.setText("");
					 textField_2.setText("");
					 textField_3.setText("");
					 textField_4.setText("");
					 textField_5.setText("");
					 textField_6.setText("");
					 textField_7.setText("");
					 textField_8.setText("");
					 comboBox.setSelectedIndex(0);
					 
					
				}
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_3.setBounds(729, 476, 113, 27);
		contentPanel.add(btnNewButton_3);
	}
}
