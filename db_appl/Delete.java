import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Delete implements ActionListener
{
	JPanel fr1;
	JLabel l1;
	JTextField t1;
	JButton del;

	Delete()
	{
		fr1=new JPanel();	
		fr1.setLayout(new FlowLayout());

		l1=new JLabel("Enter rollno");	t1=new JTextField(10);
		del=new JButton("Delete");

		fr1.add(l1);	fr1.add(t1);	fr1.add(del);	

		fr1.setSize(200,200);
		fr1.setVisible(true);

		del.addActionListener(this);	
	}

	public void actionPerformed(ActionEvent e)
	{
		
			String str=t1.getText();
			int count=MainMenu.table.getRowCount();
			int flag=0;
			for(int i=0;i<count;i++)
			{
				if( ((String)MainMenu.table.getValueAt(i,1)).equals(str) )
				{
					MainMenu.model.removeRow(i);
					flag=1;	break;
				}
			}
			if(flag==1)
				JOptionPane.showMessageDialog(fr1,"Record Deleted Successfully","Message Dialog Box" , JOptionPane.INFORMATION_MESSAGE);		
			else
				JOptionPane.showMessageDialog(fr1,"Record Not Found","Message Dialog Box" , JOptionPane.INFORMATION_MESSAGE);		

	}

	public static void main(String str[])
	{
		new Delete();
	}
}