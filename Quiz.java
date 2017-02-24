import java.awt.event.*;
import javax.swing.*;

class Timer extends Thread
{
	int min=1,sec=00;
	Timer()
	{
		start();
	}

	public void run()
	{
		for(int i=0;i<60;i++)
		{
			Quiz.t.setText(min+":"+sec);
			
			try
			{
				sleep(1000);
			}
			catch(InterruptedException e)
			{}
			
			if(sec==0)
				{
					sec=59;
					min--;
				}
			else
				sec--;
		}
		Quiz.fr2.setVisible(true);
	}
}

class Quiz implements ActionListener
{
	JFrame fr1;
	static JFrame fr2;
	JLabel ques,corr,incorr;
	static JLabel t;
	JRadioButton a,b,c,d;
	ButtonGroup grp=new ButtonGroup();
	JCheckBox mark;
	int book=-1,count=0;
	JButton prev,next,submit,go,ok;
	String q[]={
		"Q1. What is the capital of India? ",
		"Q2. Which country has the largest population? ",
		"Q3. Which is the only mammal that lays eggs? ",
		"Q4. Who is known as the Father of Theoretical Computer? ",
		"Q5. Which is the biggest flower in the world? "
	};
	String ans[][]={
		{"Delhi","Banglore","Mumbai","Kolkata"},
		{"India","Russia","Brazil","China"},
		{"Whale","Lion","Platypus","Giraffe"},
		{"Bjarne Stroustrup","Bill Gates","Alan Turing","Charles Babbage"},
		{"Raflesia","Lotus","Orchids","Marigold"}
	};
	int cans[]={1,4,3,3,1};
	int user[]=new int[5];

	Quiz()
	{
		fr1=new JFrame("Quiz");
		fr2=new JFrame("Result");
		fr1.setLayout(null);	fr2.setLayout(null);
		fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ques=new JLabel(q[0]);	corr=new JLabel();	incorr=new JLabel();	t=new JLabel();
		a=new JRadioButton(ans[0][0]);	b=new JRadioButton(ans[0][1]);	
		c=new JRadioButton(ans[0][2]);	d=new JRadioButton(ans[0][3]);
		mark=new JCheckBox("Bookmark");
		prev=new JButton("Prev");	next=new JButton("Next");	submit=new JButton("Submit");
		ok=new JButton("OK");
		prev.setEnabled(false);
		go=new JButton("go Bookmark");	go.setEnabled(false);

		ques.setBounds(30,20,300,60);
		a.setBounds(30,80,150,40);			b.setBounds(30,140,150,40);
		c.setBounds(30,200,150,40);			d.setBounds(30,260,150,40);
		t.setBounds(400,30,30,40);
		mark.setBounds(30,340,100,40);
		go.setBounds(30,400,120,40);
		prev.setBounds(250,340,80,40);	next.setBounds(340,340,80,40);
		submit.setBounds(290,400,80,40);
		corr.setBounds(50,50,150,40);
		incorr.setBounds(50,120,150,40);
		ok.setBounds(70,170,60,40);

		grp.add(a);	grp.add(b);	grp.add(c);	grp.add(d);

		fr1.add(ques);	fr1.add(a);	fr1.add(b);	fr1.add(c);fr1.add(t);
		fr1.add(d);	fr1.add(mark);	fr1.add(go);	fr1.add(prev);
		fr1.add(next);	fr1.add(submit);	fr2.add(corr);	fr2.add(incorr); fr2.add(ok);

		mark.addActionListener(this);
		go.addActionListener(this);
		prev.addActionListener(this);
		next.addActionListener(this);
		submit.addActionListener(this);
		ok.addActionListener(this);

		fr1.setSize(500,500);	fr2.setSize(300,300);
		fr1.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==next)
			{	prev.setEnabled(true);	func_next();	}
		else if(e.getSource()==prev)
			{	next.setEnabled(true);	func_prev();	}
		else if(e.getSource()==submit)
			{	result();  }
		else if(e.getSource()==mark)
			{
				if(mark.isSelected())
					book=count;
				else
					book=-1;  
			}
		else if(e.getSource()==ok)
		{
			System.exit(0);
		}
		else
		{
			count=book;
			ques.setText(q[book]);
			a.setText(ans[book][0]);	b.setText(ans[book][1]);
			c.setText(ans[book][2]);	d.setText(ans[book][3]);
			mark.setEnabled(true);
			if(count==4)	next.setEnabled(false);
			else	next.setEnabled(true);
			if(count==0)	prev.setEnabled(false);
			else	prev.setEnabled(true);

		}
	}

	void func_next()
	{
		if(a.isSelected())		user[count]=1;
		else if(b.isSelected())	user[count]=2;
		else if(c.isSelected())	user[count]=3;
		else if(d.isSelected())	user[count]=4;

		++count;
		if(count==4)	next.setEnabled(false);
		else	next.setEnabled(true);
		if(count==book || book==-1)	{	mark.setEnabled(true);	go.setEnabled(false);	}
		else	{	mark.setEnabled(false);	go.setEnabled(true);	}

		ques.setText(q[count]);
		a.setText(ans[count][0]);	b.setText(ans[count][1]);
		c.setText(ans[count][2]);	d.setText(ans[count][3]);

		grp.clearSelection();
		if(user[count]!=0)
		{
			if(user[count]==1)	a.setSelected(true);
			else if(user[count]==2)	b.setSelected(true);
			else if(user[count]==3)	c.setSelected(true);
			else if(user[count]==4)	d.setSelected(true);
		}

	}

	void func_prev()
	{
		if(a.isSelected())		user[count]=1;
		else if(b.isSelected())	user[count]=2;
		else if(c.isSelected())	user[count]=3;
		else if(d.isSelected())	user[count]=4;

		--count;
		if(count==0)	prev.setEnabled(false);
		else	prev.setEnabled(true);
		if(count==book || book==-1)	{	mark.setEnabled(true);	go.setEnabled(false);	}
		else	{	mark.setEnabled(false);	go.setEnabled(true);	}

		ques.setText(q[count]);
		a.setText(ans[count][0]);	b.setText(ans[count][1]);
		c.setText(ans[count][2]);	d.setText(ans[count][3]);

		grp.clearSelection();
		if(user[count]!=0)
		{
			if(user[count]==1)	a.setSelected(true);
			else if(user[count]==2)	b.setSelected(true);
			else if(user[count]==3)	c.setSelected(true);
			else if(user[count]==4)	d.setSelected(true);
		}

	}

	void result()
	{
		if(a.isSelected())		user[count]=1;
		else if(b.isSelected())	user[count]=2;
		else if(c.isSelected())	user[count]=3;
		else if(d.isSelected())	user[count]=4;

		fr2.setVisible(true);
		int c=0;
		for(int i=0;i<5;i++)
		{
			if(user[i]==cans[i])
				c++;
		}
		corr.setText("Correct: "+c);
		incorr.setText("Incorrect: "+(5-c));
	}


	public static void main(String str[])
	{
		new Quiz();
		Timer t1=new Timer();
	}

}