import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class MainMenu implements ActionListener
{
	JFrame fr;
	static JTable table=new JTable();
	static DefaultTableModel model=new DefaultTableModel();
	static JScrollPane pane=new JScrollPane(table);
	JMenuBar bar;
	JMenu menu;
	JMenuItem add,delete,update,report,exit;
	JPanel panel;
	CardLayout c=new CardLayout();

	MainMenu()
	{
		fr=new JFrame();	fr.setLayout(new FlowLayout());

		model.addColumn("Name");	model.addColumn("Rollno");
		model.addColumn("Marks");	model.addColumn("Grade");
		table.setModel(model);
		pane.setPreferredSize(new Dimension(250,150));

		panel=new JPanel();	panel.setLayout(c);
		panel.add(new Add().fr1,"Add");
		panel.add(new Delete().fr1,"Delete");
		panel.add(new Report().fr1,"Report");
		panel.add(new Update().fr1,"Update");
		bar=new JMenuBar();
		menu=new JMenu("Options");
		add=new JMenuItem("Add");	delete=new JMenuItem("Delete");
		update=new JMenuItem("Update");	report=new JMenuItem("Report");
		exit=new JMenuItem("Exit");

		add.addActionListener(this);	exit.addActionListener(this);
		delete.addActionListener(this);	update.addActionListener(this);
		report.addActionListener(this);

		menu.add(add);menu.add(delete);menu.add(update);menu.add(report);menu.add(exit);
		bar.add(menu);
		fr.setJMenuBar(bar);
	
		panel.setPreferredSize(new Dimension(250,250));
		fr.add(panel);
		fr.setSize(400,400);	fr.setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==add)
			c.show(panel,"Add");
		if(e.getSource()==delete)
			c.show(panel,"Delete");
		if(e.getSource()==update)
			c.show(panel,"Update");
		if(e.getSource()==report)
			c.show(panel,"Report");
		if(e.getSource()==exit)
			System.exit(0);
	}

	public static void main(String str[])
	{
		new MainMenu();
	}
}