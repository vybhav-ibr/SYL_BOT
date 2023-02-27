import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Vector;

import javax.swing.*;
//import java.util.*;

public class GUI implements ActionListener{
	private static JLabel instruction;
	private static JLabel instruction2;
	private static JLabel sent_label,sent_label_2,sent_label_3,sent_label_4;
	private static JTextField SentText,SentText2,SentText3,SentText4;
	private static JLabel conc_label,conc_label_2,conc_label_3,conc_label_4;
	private static JTextField ConcText,ConcText2,ConcText3,ConcText4;
	
	private static JButton button;
	private static JButton add_sent;
	private static JButton add_conc;
	private static JLabel success;
	
	private static JFrame frame;
	private static JPanel panel;
	private static int concStartY=80;
	private static int noS=1;
	private static int buttonStartY=110;
	private static int noC=1;
	
	

	public static void main(String[] args) {
		frame=new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel=new JPanel();
		
		frame.add(panel);
		frame.setTitle("SYL BOT");
		panel.setLayout(null);
		
		instruction =new JLabel("Make sure to keep the subjects and objects in Proper case");
		instruction.setBounds(10,12,1000,25);
		panel.add(instruction);
		instruction2 =new JLabel("Click the 'Add S' and 'Add C' buttons to add inputs");
		instruction2.setBounds(10,26,1000,25);
		panel.add(instruction2);
		
		sent_label=new JLabel("Sentence :");
		sent_label.setBounds(10,50,80,25);
		panel.add(sent_label);
		
		{
			sent_label_2=new JLabel("Sentence2 :");
			sent_label_3=new JLabel("Sentence3 :");
			sent_label_4=new JLabel("Sentence4 :");
			sent_label_2.setVisible(false);
			sent_label_3.setVisible(false);
			sent_label_4.setVisible(false);
			panel.add(sent_label_2);
			panel.add(sent_label_3);
			panel.add(sent_label_4);
		}
		
		frame.setVisible(true);
		
		conc_label=new JLabel("Conclusion :");
		conc_label.setBounds(10,concStartY,80,25);
		panel.add(conc_label);
		
		{
			conc_label_2=new JLabel("Conclusion2 :");
			conc_label_3=new JLabel("Conclusion3 :");
			conc_label_4=new JLabel("Conclusion4 :");
			conc_label_2.setVisible(false);
			conc_label_3.setVisible(false);
			conc_label_4.setVisible(false);
			panel.add(conc_label_2);
			panel.add(conc_label_3);
			panel.add(conc_label_4);
			
		}
		success=new JLabel("");
		success.setBounds(10,110,300,25);
		success.setFont(new Font("Times New Roman",Font.PLAIN, 20));
		success.setForeground(Color.red);
		panel.add(success);
		
		SentText=new JTextField(40);
		SentText.setBounds(100,50,165,25);
		panel.add(SentText);
		
		{
			SentText2=new JTextField(40);
			SentText3=new JTextField(40);
			SentText4=new JTextField(40);
			SentText2.setVisible(false);
			SentText3.setVisible(false);
			SentText4.setVisible(false);
			panel.add(SentText2);
			panel.add(SentText3);
			panel.add(SentText4);
		}
		
		ConcText=new JTextField(40);
		ConcText.setBounds(100,80,165,25);
		panel.add(ConcText);
		
		{
			ConcText2=new JTextField(40);
			ConcText3=new JTextField(40);
			ConcText4=new JTextField(40);
			ConcText2.setVisible(false);
			ConcText3.setVisible(false);
			ConcText4.setVisible(false);
			panel.add(ConcText2);
			panel.add(ConcText3);
			panel.add(ConcText4);
		}
		
		button=new JButton("Submit");
		button.setBounds(150,110,80,25);
		//button.setActionCommand("Submit");
		button.addActionListener(new GUI());
		panel.add(button);
		
		add_sent=new JButton("Add S");
		add_sent.setBounds(250,110,80,25);
		add_sent.setActionCommand("S");
		add_sent.addActionListener(new GUI());
		panel.add(add_sent);
		
		add_conc=new JButton("Add C");
		add_conc.setBounds(320,110,80,25);
		add_conc.setActionCommand("C");
		add_conc.addActionListener(new GUI());
		panel.add(add_conc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String Command=e.getActionCommand();
		if(Command.equalsIgnoreCase("Submit"))
		{
			state s1=new state(SentText.getText());
			state s2=new state(null),s3=new state(null),s4=new state(null);
			state c1=new state(ConcText.getText());
			state c2=new state(null),c3=new state(null),c4=new state(null);
			CallFunctions(s1);
			CallFunctions(c1);
			if(noS==2) 
				s2=new state(SentText2.getText());
			if(noS==3) 
			{
				s2=new state(SentText2.getText());
				s3=new state(SentText3.getText());
			}
			if(noS==4) 
			{
				s2=new state(SentText2.getText());
				s3=new state(SentText3.getText());
				s4=new state(SentText4.getText());
			}
			if(noC==2) 
				c2=new state(ConcText2.getText());
			if(noC==3) 
			{
				c2=new state(ConcText2.getText());
				c3=new state(ConcText3.getText());
			}
			if(noC==4) 
			{
				c2=new state(ConcText2.getText());
				c3=new state(ConcText3.getText());
				c4=new state(ConcText4.getText());
			}
		//System.out.println(s1.obj.length()+" "+c1.obj.length());
		//System.out.println();
		success.setText(CalcResult(s1,c1));
		}
		else if(Command.equalsIgnoreCase("S"))
		{
			if(noS<4)
			{
				concStartY+=30;
				if(noS==1)
				{
					sent_label_2.setBounds(10,concStartY-30,80,25);
					sent_label_2.setVisible(true);
					panel.add(sent_label_2);
					
					SentText2.setBounds(100,concStartY-30,165,25);
					SentText2.setVisible(true);
					panel.add(SentText2);
				}
				if(noS==2)
				{
					sent_label_3.setBounds(10,concStartY-30,80,25);
					sent_label_3.setVisible(true);
					panel.add(sent_label_3);
					
					SentText3.setBounds(100,concStartY-30,165,25);
					SentText3.setVisible(true);
					panel.add(SentText3);
				}
				if(noS==3)
				{
					sent_label_4.setBounds(10,concStartY-30,80,25);
					sent_label_4.setVisible(true);
					panel.add(sent_label_4);
					
					SentText4.setBounds(100,concStartY-30,165,25);
					SentText4.setVisible(true);
					panel.add(SentText4);
				}
				
				conc_label.setBounds(10,concStartY,80,25);
				ConcText.setBounds(100,concStartY,165,25);
				conc_label_2.setBounds(10,concStartY+30,80,25);
				ConcText2.setBounds(100,concStartY+30,165,25);
				conc_label_3.setBounds(10,concStartY+60,80,25);
				ConcText3.setBounds(100,concStartY+60,165,25);
				conc_label_4.setBounds(10,concStartY+90,80,25);
				ConcText4.setBounds(100,concStartY+90,165,25);
				buttonStartY+=30;
				button.setBounds(100,buttonStartY,80,25);
				add_sent.setBounds(200,buttonStartY,80,25);
				add_conc.setBounds(280,buttonStartY,80,25);
				success.setBounds(10,buttonStartY,300,25);
				noS++;
			}
		}
		else if(Command.equalsIgnoreCase("C"))
		{
			if(noC<4)
			{
				concStartY+=30;
				buttonStartY+=30;
				if(noC==1)
				{
					conc_label_2.setBounds(10,concStartY,80,25);
					conc_label_2.setVisible(true);
					panel.add(conc_label_2);
					
					ConcText2.setBounds(100,concStartY,165,25);
					ConcText2.setVisible(true);
					panel.add(ConcText2);
				}
				if(noC==2)
				{
					conc_label_3.setBounds(10,concStartY,80,25);
					conc_label_3.setVisible(true);
					panel.add(conc_label_3);
					
					ConcText3.setBounds(100,concStartY,165,25);
					ConcText3.setVisible(true);
					panel.add(ConcText3);
				}
				if(noC==3)
				{
					conc_label_4.setBounds(10,concStartY,80,25);
					conc_label_4.setVisible(true);
					panel.add(conc_label_4);
					
					ConcText4.setBounds(100,concStartY,165,25);
					ConcText4.setVisible(true);
					panel.add(ConcText4);
				}
				//System.out.print("Second button called");
				
				button.setBounds(100,buttonStartY,80,25);
				add_sent.setBounds(200,buttonStartY,80,25);
				add_conc.setBounds(280,buttonStartY,80,25);
				noC++;
			}
		}
	}
	public static void CallFunctions(state key)
	{key.extType();key.extSO();}
	public static String CalcResult(state s, state c) {
		//System.out.print(c.type+" "+s.type);
		if(c.type!=s.type) return("Conclusion is False");
		if((c.s.contains(s.obj)==false)||(c.s.contains(s.sub)==false)) return("False");
		if((c.sub.equals(c.sub))&&(c.obj.equals(s.obj)))
		{
			if((c.SubVal()>s.SubVal())||(c.ObjVal()>s.ObjVal())) return("False");
		}
		else if((c.SubVal()>s.ObjVal())||(c.ObjVal()>s.SubVal())) return("False");
		//return "Default was returned, check for errors";
		return "True";
	}
	///"METHOD HIDDEN"
	public static String JoinS(state s1,state s2)  
	{
		String content="Test case passed secessfully";
		content="before conditions";
		if(s1.obj.equals(s2.sub))
		{
			content="1st passed";
			if((s1.ObjVal()==100)||(s2.SubVal()==100))
			{
				content="2nd passed";
				if(!((s1.type==false)&&(s2.type==false)))
				{ 
					content =s1.s.substring(0,(s1.s.indexOf(s1.sub)+s1.sub.length()))
							+s2.s.substring((s2.s.indexOf(s2.sub)+s2.sub.length()));
				}
			}
		}
		if(s2.obj.equals(s1.sub))
		{
			if((s2.ObjVal()==100)||(s1.SubVal()==100))
			{
				if(!((s2.type==false)&&(s1.type!=false)))
				{ 
					content=s2.s.substring(0,(s2.s.indexOf(s2.sub)+s2.sub.length()))
							+s1.s.substring((s1.s.indexOf(s1.sub)+s1.sub.length()));
				}
			}
		}
		return(content);
	}
	///"METHOD HIDDEN"
	public static String JoinSelect(state s1,state s2,state s3,state s4, state c)
	{
		//Vector<String> choice=new Vector<String>();
		boolean s1CO,s1CS,s2CO,s2CS,s3CO,s3CS,s4CO,s4CS;
		s1CO=s1.s.contains(c.obj);
		s1CS=s1.s.contains(c.sub);
		
		s2CO=s2.s.contains(c.obj);
		s2CS=s2.s.contains(c.sub);
		
		s3CO=s3.s.contains(c.obj);
		s3CS=s3.s.contains(c.sub);
		
		s4CO=s4.s.contains(c.obj);
		s4CS=s4.s.contains(c.sub);
		
		/* LONG ASS CONDITION
		 ((s1.s.contains(c.obj)==false)&&(s2.s.contains(c.obj)==false)
				&&(s3.s.contains(c.obj)==false)&&(s4.s.contains(c.obj)==false))
				||((s1.s.contains(c.sub)==false)&&(s2.s.contains(c.sub)==false)
						&&(s3.s.contains(c.sub)==false)&&(s4.s.contains(c.sub)==false))
						*/
		 
		if((s1CO & s1CS)||(s2CO & s2CS)||(s3CO & s3CS)||(s4CO & s4CS))
		{
			if((s1CO)&!(s1CS))
			{
				//choice.add("s1");
				if(s2CS) return JoinS(s1,s2);
				if(s3CS) return JoinS(s1,s3);
				if(s4CS) return JoinS(s1,s4);
			}
			else if((s2CO)&!(s2CS))
			{
				//choice.add("s2");
				if(s1CS) return JoinS(s2,s1);
				if(s3CS) return JoinS(s2,s3);
				if(s4CS) return JoinS(s2,s4);
			}
			else if((s3CO)&!(s3CS))
			{
				//choice.add("s3");
				if(s1CS) return JoinS(s3,s1);
				if(s2CS) return JoinS(s3,s2);
				if(s4CS) return JoinS(s3,s4);
			}
			else if((s4CO)&!(s4CS))
			{
				//choice.add("s4");
				if(s1CS) return JoinS(s4,s1);
				if(s2CS) return JoinS(s4,s2);
				if(s3CS) return JoinS(s4,s3);
			}
		}
		//if(choice)
		return "CANT JOIN";// the arguments to be passed are determined in this function
	}

	
}






























