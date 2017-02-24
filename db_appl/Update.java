import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Update implements ActionListener
{
	JPanel fr1;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton update,search;
	int pos;

	Update()
	{
		fr1=new JPanel();	
		fr1.setLayout(new FlowLayout());

		l1=new JLabel("Name");	t1=new JTextField(10);
		l2=new JLabel("Rollno");	t2=new JTextField(10);
		l3=new JLabel("Marks");	t3=new JTextField(10);	
		l4=new JLabel("Grade");	t4=new JTextField(10);
		l5=new JLabel("Enter Rollno");	t5=new JTextField(10);

		update=new JButton("Update");	search=new JButton("Search");

		fr1.add(l5);	fr1.add(t5);	fr1.add(search);
		fr1.add(l1);	fr1.add(t1);	
		fr1.add(l2);	fr1.add(t2);	
		fr1.add(l3);	fr1.add(t3);
		fr1.add(l4);	fr1.add(t4);
		fr1.add(update);		

		fr1.setSize(250,300);
		fr1.setVisible(true);

		update.addActionListener(this);	search.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==search)
		{
			String roll=t5.getText();
			int count=MainMenu.table.getRowCount();
			int flag=0;
			for(int i=0;i<count;i++)
			{
				if(roll.equals((String)MainMenu.table.getValueAt(i,1)))
				{
					flag=1;	pos=i;
					t1.setText((String)MainMenu.table.getValueAt(i,0));
					t2.setText((String)MainMenu.table.getValueAt(i,1));
					t3.setText((String)MainMenu.table.getValueAt(i,2));
					t4.setText((String)MainMenu.table.getValueAt(i,3));
					break;
				}		
			}
			if(flag==0)
					JOptionPane.showMessageDialog(fr1,"Record Not Found","Message Dialog Box" , JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
	
					MainMenu.table.setValueAt(t1.getText(),pos,0);
					MainMenu.table.setValueAt(t2.getText(),pos,1);
					MainMenu.table.setValueAt(t3.getText(),pos,2);
					MainMenu.table.setValueAt(t4.getText(),pos,3);
					JOptionPane.showMessageDialog(fr1,"Report Updated Successfully","Message Dialog Box" , JOptionPane.INFORMATION_MESSAGE);
	
		}
	}

	public static void main(String s[])
	{
		new Update();
	}
}