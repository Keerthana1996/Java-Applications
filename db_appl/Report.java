import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class Report implements ActionListener
{
	JPanel fr1;
	JCheckBox sort;
	JRadioButton asc,desc;

	Report()
	{
		fr1=new JPanel();	
		fr1.setLayout(new FlowLayout());	

		sort=new JCheckBox("Sort");
		asc=new JRadioButton("Ascending");	desc=new JRadioButton("Descending");
		ButtonGroup grp=new ButtonGroup();
		grp.add(asc);	grp.add(desc);
		asc.setVisible(false);		desc.setVisible(false);

		fr1.add(MainMenu.pane);	fr1.add(asc);	fr1.add(desc);	fr1.add(sort);

		fr1.setSize(300,400);	
		fr1.setVisible(true);

		sort.addActionListener(this);	asc.addActionListener(this);
		desc.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==sort)
		{
			if(sort.isSelected())
			{
				asc.setVisible(true);	desc.setVisible(true); 
			}
			else
			{
				asc.setVisible(false);	desc.setVisible(false); 				
			}
		}

	else if(e.getSource()==desc)
		{
			int count=MainMenu.table.getRowCount();
			for(int j=0;j<count;j++)
			{
				int greatest=Integer.valueOf((String)MainMenu.table.getValueAt(j,2));
				for(int i=j+1;i<count;i++)
				{
					if(Integer.valueOf((String)MainMenu.table.getValueAt(i,2))>greatest)
					{
						greatest=Integer.valueOf((String)MainMenu.table.getValueAt(i,2));
						MainMenu.model.moveRow(i,i,j);
					}
				}	
			}
		}
	else 
		{
			int count=MainMenu.table.getRowCount();
			for(int j=0;j<count;j++)
			{
				int smallest=Integer.valueOf((String)MainMenu.table.getValueAt(j,2));
				for(int i=j+1;i<count;i++)
				{
					if(Integer.valueOf((String)MainMenu.table.getValueAt(i,2))<smallest)
					{
						smallest=Integer.valueOf((String)MainMenu.table.getValueAt(i,2));
						MainMenu.model.moveRow(i,i,j);
					}
				}	
			}
		}
	}

	public static void main(String str[])
	{
		new Report();
	}
}