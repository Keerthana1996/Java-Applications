import javax.swing.*;
import java.awt.event.*;

class ComboBox implements ActionListener
{
	JFrame fr,fr2;
	JComboBox c1,c2,c3;
	DefaultComboBoxModel m1,m2,m3;
	JButton manage,badd,brem;
	JLabel city,state,add,remove;
	JTextField t1,t2;


	ComboBox()
	{
		fr=new JFrame();	fr2=new JFrame();
		fr.setLayout(null);	fr2.setLayout(null);

		String citi1[]={"Bangalore","Mysore","Belgaum"};
		m1=new DefaultComboBoxModel(citi1);
		String citi2[]={"Mumbai","Pune","Nashik"};
		m2=new DefaultComboBoxModel(citi2);
		String citi3[]={"Lucknow","Kanpur","Allahabad"};
		m3=new DefaultComboBoxModel(citi3);

		String states[]={"Karnataka","Maharashtra","Uttar Pradesh"};
		c1=new JComboBox(states);	c3=new JComboBox(states);	c2=new JComboBox(m1);
		manage=new JButton("Manage");	badd=new JButton("Add");	brem=new JButton("Remove");
		city=new JLabel("City");	state=new JLabel("State");
		add=new JLabel("Add Element: ");	remove=new JLabel("Remove Element: ");
		t1=new JTextField();	t2=new JTextField();

		city.setBounds(70,30,50,20);
		c1.setBounds(30,70,110,40);
		state.setBounds(200,30,50,20);
		c2.setBounds(170,70,100,40);
		manage.setBounds(30,180,100,40);
		c3.setBounds(30,30,110,40);
		add.setBounds(30,90,100,30);
		t1.setBounds(150,90,100,30);
		badd.setBounds(270,90,100,30);
		brem.setBounds(270,140,100,30);
		t2.setBounds(150,140,100,30);
		remove.setBounds(30,140,100,30);

		fr.add(city);	fr.add(state);	fr.add(c1);	fr.add(c2);	fr.add(manage);
		fr2.add(c3);	fr2.add(t1);	fr2.add(t2);	fr2.add(add);	fr2.add(remove);
		fr2	.add(badd);	fr2.add(brem);

		c1.addActionListener(this);
		manage.addActionListener(this);
		badd.addActionListener(this);
		brem.addActionListener(this);

		fr.setSize(350,300);
		fr2.setSize(400,350);
		fr.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==c1)
		{
			String sel=(String)c1.getSelectedItem();
			if(sel.equals("Karnataka"))
				c2.setModel(m1);
			else if(sel.equals("Maharashtra"))
				c2.setModel(m2);
			else
				c2.setModel(m3);
		}
	
		else if(e.getSource()==manage)
		{	fr2.setVisible(true);	}

		else if(e.getSource()==badd)
		{
			String text= t1.getText();
			String sel= (String)c3.getSelectedItem();
			if(sel.equals("Karnataka"))
				m1.addElement(text);
			else if(sel.equals("Maharashtra"))
				m2.addElement(text);
			else
				m3.addElement(text);
		}
		else
		{
			String text= t2.getText();
			String sel= (String)c3.getSelectedItem();
			if(sel.equals("Karnataka"))
			{
				int index=find(text,m1);
				if(index!=-1)
					m1.removeElementAt(index);
			}
				
			else if(sel.equals("Maharashtra"))
			{
				int index=find(text,m2);
				if(index!=-1)
					m2.removeElementAt(index);
			}
				
			else
			{
				int index=find(text,m3);
				if(index!=-1)
					m3.removeElementAt(index);
			}
				
		}
	}

	int find(String text,DefaultComboBoxModel m)
	{
		for(int i=0;i<m.getSize();i++)
		{
			String ele=(String)m.getElementAt(i);
			if(text.equals(ele))
				return i;
		}
		return -1;
	}

	public static void main(String str[])
	{
		new ComboBox();
	}
}