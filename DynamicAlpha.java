import java.awt.*;
import java.awt.event.*;

class DynamicAlpha2 implements KeyListener
{
	Frame fr;
	Label l1,l2,l3,l4,l5;
	TextField t;
	int v,d,s,c;
	static char prev;

	public DynamicAlpha2()
	{
		fr=new Frame("Dynamic-Alpha-Digit-Counter");
		fr.setLayout(null);

		l1=new Label("Enter Text ");
		l2=new Label("No. of Vowels ");
		l3=new Label("No. of Consonants ");
		l4=new Label("No. of Spaces ");
		l5=new Label("No. of Digits ");
		t=new TextField();

		l1.setBounds(30,50,100,30);
		t.setBounds(30,100,300,30);
		l2.setBounds(30,210,300,30);
		l3.setBounds(30,250,300,30);
		l4.setBounds(30,290,300,30);
		l5.setBounds(30,330,300,30);

		fr.add(l1);	fr.add(l2);	fr.add(l3);	fr.add(l4);	fr.add(l5);
		fr.add(t);	

		t.addKeyListener(this);

		fr.setSize(400,400);
		fr.setVisible(true);
	}
	
	public void keyTyped(KeyEvent e)
 	{}
 	public void keyReleased(KeyEvent e)
 	{}
 	
	public void keyPressed(KeyEvent e)
	{
		char ch=e.getKeyChar();
		
		if(ch==e.VK_BACK_SPACE)
		{
			if((t.getText()).length()<2)
				{
				    l2.setText("No. Of Vowels: 0");v=0;
				    l3.setText("No. of Consonants: 0");c=0;
				    l5.setText("No. Of Digits: 0");d=0;
				    l4.setText("No. Of Spaces: 0");s=0;
					return;
				}
			int temp=FindCharType(prev);
			switch(temp)
			{
				case 1: --v;
					    l2.setText("No. Of Vowels: "+v);
					    break;
				case 2: --d;
						l5.setText("No. Of Digits: "+d);
						break;
				case 3: --s;
						l4.setText("No. Of Spaces: "+s);
						break;
				case 4: --c;
						l3.setText("No. Of Consonants: "+c);
						break;
			}
			String str=t.getText();
			prev=str.charAt(str.length()-2);
		}

		else
		{
			int temp=FindCharType(ch);
			switch(temp)
			{
				case 1: v++;
					    l2.setText("No. Of Vowels: "+v);
					    break;
				case 2: d++;
						l5.setText("No. Of Digits: "+d);
						break;
				case 3: s++;
						l4.setText("No. Of Spaces: "+s);
						break;
				case 4: c++;
						l3.setText("No. Of Consonants: "+c);
						break;
			}
			prev=ch;
		}
	}

	int FindCharType(char ch)
	{
		if(ch=='A' || ch=='a' || ch=='e' || ch=='E' || ch=='i' || ch=='I' 
				|| ch=='o' || ch=='O' || ch=='u' || ch=='U')
				return 1;

		else if(Character.isDigit(ch))
			return 2;
		else if(Character.isWhitespace(ch))
			return 3;
		else
			return 4;
	}


	public static void main(String str[])
	{
		new DynamicAlpha2();
	}
}