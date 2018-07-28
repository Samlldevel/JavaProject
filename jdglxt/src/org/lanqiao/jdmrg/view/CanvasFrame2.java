package org.lanqiao.jdmrg.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.lanqiao.jdmrg.common.RoomerAccount;
/**
 * 主程序(客户界面)
 * 
 * @author wzg
 */

public class CanvasFrame2 extends JFrame {
	private static final long serialVersionUID = 1L;
	/**画布*/
	private JPanel jp = new JPanel();
	
	public static JPanel p1=new JPanel();
	
	public static JPanel p2=new JPanel();
	
	public static JFrame jfff= new JFrame();
	
    public CanvasFrame2(String sss) {
    	jfff = this;
    	RoomerAccount.accountNum = sss;
    	this.setTitle("欢迎来到夏天酒店");
    	this.setSize(1056, 668);
    	this.setResizable(false);
    	this.setLocationRelativeTo(null);
    	this.setLayout(null);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	p1.setLayout(null);
    	p2.setLayout(null);
    	
    	p1.setSize(210, 640);
    	p2.setSize(840, 640);
    	
    	p1.setLocation(0, 0);
    	p2.setLocation(210, 0);
    	
    	this.add(p1);
    	this.add(p2);
    	this.setVisible(true);
    }
    
    public static void  addPanelLeft(JPanel p) {
    	p1.removeAll();
    	p1.add(p);
    	p1.repaint();
    }
    
    public static void delePanelRight(JPanel p) {
    	p2.removeAll();
    	p2.add(p);
    	p2.repaint();
    }
    
    public static void deleAllPanelRight() {
    	p2.removeAll();
    }
    
    public static void addPanelRight(JPanel p) {
    	p2.add(p);
    	p2.repaint();
    }
    
    public static void delePanel(JPanel p,JPanel p3) {
    	p2.remove(p);
    	p2.add(p3);
    	p2.repaint();
    }
    
//	public static void addPanelLeft(JPanel p) {
//		j1.add(p);
//		p.repaint();
//	}
//	
//	public static void addPanelRight(JPanel p) {
//		j2.add(p);
//		p.repaint();
//	}
	
	public static void deletePanelRight(JPanel p) {
		p2.remove(p);
		p2.repaint();
	}
	
	public static void hidePanelRight(JPanel p,JPanel p2) {
//		j2.remove(p);
		p.setVisible(false);
		p2.add(p2);
		p2.repaint();
	}
    
    
//    public static void main(String[] args) {
//    	
//    	    new CanvasFrame2();
//    	   
//              addPanelLeft(new ClientFrame ());
//             
//	}
}

