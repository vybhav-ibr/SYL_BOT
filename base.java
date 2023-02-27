import java.util.Scanner;
class state
{
	String s;
	boolean type;
	String sub;
	String obj;
	state(String sInp)
	{
		s=sInp;
	}
	void extType()
	{
		if((s.indexOf("No")>=0)||(s.indexOf("not")>=0))
		{
			type=false;
		}
		else type=true;
	}
	void extSO()
	{
		int subStart=-1;
		int subEnd=-1;
		if(s.indexOf("No")>=0)
		{
			subStart=s.indexOf("No")+2;
			//System.out.print(subStart);
		}
		else if(s.indexOf("All")>=0) 
		{
			subStart=s.indexOf("All")+3;
			//System.out.print(subStart);
		}
		else if(s.indexOf("Some")>=0)
		{
			subStart=s.indexOf("Some")+4;
			//System.out.print(subStart);
		}
		if(s.indexOf("is")>=0) subEnd=s.indexOf("is");
		else if(s.indexOf("are")>=0) subEnd=s.indexOf("are");		//System.out.print(s.indexOf("Some"));
		sub=s.substring((subStart+1),subEnd);
		//sub=sub.replace("\\s", "");
		//sub=sub.replace(" ", "");
		//System.out.println(sub);
		
		int objStart=-69;
		//int objEnd=-1;
		if((s.indexOf("is")>=0)&&(s.indexOf("not")<0))
		{
			objStart=s.indexOf("is")+2;
			//System.out.print(subStart);
		}
		else if(s.indexOf("not")>=0) 
		{
			objStart=s.indexOf("not")+3;
			//System.out.print(subStart);
		}
		else if(s.indexOf("are")>=0)
		{
			objStart=s.indexOf("are")+4;
			//System.out.print(subStart);
		}
		//if(s.indexOf("is")>=0) subEnd=s.indexOf("is");
		//else if(s.indexOf("are")>=0) subEnd=s.indexOf("are");		//System.out.print(s.indexOf("Some"));
		obj=s.substring((objStart+1));
		//System.out.println(obj+" PRINTED FROM METHOD");
		//obj=obj.replace("\\s", "");
		//obj=obj.replace(" ", "");
		
		
		//System.out.print("The sentence is ");
		//if(type==true) System.out.print("Positive");
		//if(type==false) System.out.print("Negative");
	}
	int SubVal()
	{
		if(s.contains("Some"))
			return 50;
		else if(s.contains("No"))
			return 100;
		else if(s.contains("All"))
			return 100;
		return -1;
	}
	int ObjVal()
	{
		if(type==true)
			return 50;
		else if(type==false)
			return 100;
		return -1;
	}
}
public class base {
	
	public static void CallFunctions(state key)
	{key.extType();key.extSO();}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		state s2=new state("Some Dogs are not Cats");
		state s1=new state("All Dogs is Horse");
		state c1=new state("No Dogs are not Cats");
		CallFunctions(s1);
		CallFunctions(s2);
		CallFunctions(c1);
		
		
		//System.out.println(s1.sub+" "+s1.obj);
		//System.out.println(s2.sub+" "+s2.obj);
		
		/*  Checking the JoinS function
		System.out.println(s1.obj+" "+s2.sub);
		System.out.println(s1.ObjVal()+" "+s2.SubVal());
		System.out.println(s1.type+ " " +s2.type);*/
		
		//System.out.println(s1.obj.equals(s2.sub));
		//System.out.println(s2.obj.length()+" "+s1.sub.length());
		System.out.println(s2.sub);
		System.out.println(c1.sub);
		System.out.println(s2.obj);
		System.out.println(c1.obj);
		//
		//System.out.println(JoinS(s1,s2));
		//*/
		
		/*s.extType();
		s.extSO();
		System.out.print("Sub val is :"+s.SubVal()+"\n"+"Obj val is :"+s.ObjVal());
		*/
		//state baby=new state(JoinS(s1,s2));
		//CallFunctions(baby);
		//System.out.println(baby.s);
		//System.out.println(CalcResult(s2,c1));
	}
	public static String CalcResult(state s, state c) {
		//System.out.print(c.type+" "+s.type);
		if(c.type!=s.type) return("Conclusion is False");
		if((c.s.contains(s.obj)==false)||(c.s.contains(s.sub)==false)) return("Conclusion is False");
		if((c.sub.equals(c.sub))&&(c.obj.equals(s.obj)))
		{
			if((c.SubVal()>s.SubVal())||(c.ObjVal()>s.ObjVal())) return("Conclusion is False");
		}
		else if((c.SubVal()>s.ObjVal())||(c.ObjVal()>s.SubVal())) return("Conclusion is False");
		//return "Default was returned, check for errors";
		return "Conclusion is True";
	}
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
}

