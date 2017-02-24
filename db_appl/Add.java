import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Add implements ActionListener
{
	JPanel fr1;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton add,reset;

	Add()
	{
		fr1=new JPanel();	
		fr1.setLayout(new FlowLayout());

		l1=new JLabel("Name");	t1=new JTextField(10);
		l2=new JLabel("Rollno");	t2=new JTextField(10);
		l3=new JLabel("Marks");	t3=new JTextField(10);	
		l4=new JLabel("Grade");	t4=new JTextField(10);

		add=new JButton("Add");	reset=new JButton("Reset");

		fr1.add(l1);	fr1.add(t1);	
		fr1.add(l2);	fr1.add(t2);	
		fr1.add(l3);	fr1.add(t3);
		fr1.add(l4);	fr1.add(t4);
		fr1.add(add);	fr1.add(reset);

		fr1.setSize(200,300);
		fr1.setVisible(true);

		add.addActionListener(this);	reset.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==add)
		{
			String str[]=new String[4];
			str[0]=t1.getText();	str[1]=t2.getText();
			str[2]=t3.getText();	str[3]=t4.getText();
			MainMenu.model.addRow(str);
			JOptionPane.showMessageDialog(fr1,"Report Added Successfully","Message Dialog Box" , JOptionPane.INFORMATION_MESSAGE);		}
		
		else
		{
			t1.setText("");	t2.setText("");	t3.setText("");	t4.setText("")
;		}
	}

	public static void main(String str[])
	{
		new Add();
	}
}