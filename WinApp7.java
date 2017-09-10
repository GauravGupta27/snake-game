import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class WinApp7 extends JFrame
{
	JLabel l[]=new JLabel[7];
	int x1[]={40,72,104,136,168,200,232};
	int y1[]={40,40,40,40,40,40,40};
	WinApp7()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p=new JPanel();
		p.setBackground(Color.white);
		p.setLayout(null);
		ImageIcon icon=new ImageIcon("gola.png");
		for(int i=0;i<7;i++)
		{
		l[i]=new JLabel();
		l[i].setIcon(icon);
		l[i].setBounds(x1[i],y1[i],32,32);
		p.add(l[i]);
		}
		addKeyListener(new MyListener());
		add(p);
		setSize(600,600);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int sw=(int)d.getWidth();
		int sh=(int)d.getHeight();
		setLocation((sw-600)/2,(sh-600)/2);
		setVisible(true);
		Timer t=new Timer(100,new TimerClass());
		t.start();
	}
class TimerClass implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
	if(kc==KeyEvent.VK_LEFT)	
	{
	 	x=x>0?x-32:600;
	}
	else if(kc==KeyEvent.VK_RIGHT)	
	{
		x=x<600?x+32:0;	
	}
	else if(kc==KeyEvent.VK_UP)	
	{
		y=y>0?y-32:600;	
	}
	else if(kc==KeyEvent.VK_DOWN)	
	{
		y=y<600?y+32:0;	
	}
	for(int i=6;i>0;i--)
	{
		x1[i]=x1[i-1];
		y1[i]=y1[i-1];
	}
	x1[0]=x;
	y1[0]=y;
	for(int i=0;i<7;i++)
	{
		l[i].setBounds(x1[i],y1[i],32,32);
	}
   }
}
	int kc=37,x=40,y=40;
	public class MyListener extends KeyAdapter
	{
	   public void keyPressed(KeyEvent e)
	   {
		kc=e.getKeyCode();
	   }		
	}
	public static void main(String a[])	
	{
		new WinApp7();
	}
}