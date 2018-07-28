package org.lanqiao.jdmrg.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.common.TimeDeal;


/**
 * 居住时间段、类型
 * @author 9组
 *
 */
public class ReserveTimeType extends JPanel {
	/**当前窗口画布*/
	private JPanel thisPanel;
	/**文本框数组*/
	private JTextField[] jt;
	/**下拉框字符串*/
	private String s = "标准单人间";
	/**时间格式*/
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	public ReserveTimeType() {

		thisPanel = this;
		// 设置画布属性
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);

		// 调用方法
		showLabel();
		showText();
		showCombox();
		showOKbnt();

		// 添加画布到窗口画布
//		TestFrame.addPanelRight(this);
//		repaint();
	}
	
	/**
	 * 绘制标签
	 */
	public void showLabel() {
		JLabel[] jlb = new JLabel[3];
		for(int i = 0 ; i < 3; i++) {
			jlb[i] = new JLabel();
			jlb[i].setSize(200,200);
			jlb[i].setLocation(200, i*150+50);
			jlb[i].setFont(new Font("黑体",Font.BOLD,24));
			this.add(jlb[i]);
		}
		jlb[0].setText("入住时间");
		jlb[1].setText("离开时间");
		jlb[2].setText("房间类型");
	}
	
	/**
	 * 绘制文本框
	 */
	public void showText() {
		jt = new JTextField[2];
		for(int i = 0; i < 2; i++) {
			Date time = TimeDeal.addAndSubtractDaysByCalendar(new Date(), i);
			jt[i] = new JTextField(sdf.format(time));
			jt[i].setSize(350, 50);
			jt[i].setLocation(350, i*150+125);
			jt[i].setFont(new Font("黑体",Font.BOLD,24));
			this.add(jt[i]);
		}
		
		jt[0].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(jt[0].getText().equals(sdf.format(new Date()))) {
					jt[0].setText("");
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jt[1].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(jt[1].getText().equals(sdf.format(TimeDeal.addAndSubtractDaysByCalendar(new Date(), 1)))) {
					jt[1].setText("");
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	/**
	 * 房间类型下拉框
	 */
	public void showCombox() {
		String str1[] = {"标准单人间", "标准双人间", "豪华单人间", "豪华双人间", "三人间", "总统套房"};  
		JComboBox<String> jcb = new JComboBox<String>(str1);  
		jcb.setSize(350, 50);
		jcb.setLocation(350, 425);
		jcb.setFont(new Font("黑体",Font.BOLD,24));
		jcb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
//				System.out.println(e.getItem());
				s =  (String) e.getItem();
			}});
		this.validate();
		this.add(jcb);
		this.repaint();
	}
	
	
	/**
	 * 确认按钮
	 */
	public void showOKbnt() {
		JButton jb = new JButton();
		jb.setSize(200, 50);
		jb.setLocation(370, 530);
		jb.setFont(new Font("黑体",Font.BOLD,24));
		jb.setIcon(new ImageIcon("src/images/确认.png"));
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exeOKbnt();
            }
        });
		this.add(jb);
	}
	
	/**按钮执行*/
	public void exeOKbnt() {
		String[] ss = new String[10];
		ss[0] = jt[0].getText();
		ss[1] = jt[1].getText();
		ss[2] = s;
		if(isRational(ss[0],ss[1])) {
			TestFrame.hidePanelRight(thisPanel, new QueryRoomState(ss,thisPanel));
		}else {
			JOptionPane.showMessageDialog(null, "日期格式不对，请重新输入！","警告",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 判断日期是否合理
	 */
	public boolean isRational(String first,String last) {
		if(!TimeDeal.isValidDate(first)) {
			return false;
		}
		if(!TimeDeal.isValidDate(last)) {
			return false;
		}
		try {
			if(!TimeDeal.isRational(sdf.parse(first),sdf.parse(last))) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = null;
		try {
			img = new ImageIcon(RoomerAccount.bg).getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, 840,640,null);
		repaint();
	}
}
