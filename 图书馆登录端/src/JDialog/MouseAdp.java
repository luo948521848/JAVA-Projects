package JDialog;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import DataExchange.Look_book;

public class MouseAdp implements MouseListener {
	private String name=null;
    private String bookname=null;
	public MouseAdp(String n, String book) {
		// TODO 自动生成的构造函数存根
		name=n;
		bookname=book;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
		new Look_book(bookname,name);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

}
