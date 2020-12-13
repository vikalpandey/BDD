package string;

public class A_immutable {
	
	public static void main(String[] args) {
//		String s="vikal";
//		String s1=s;
//		s=s.concat("pandey"); 
//		System.out.println(s ); //O/p =vikalpandey
//		System.out.println(s1);//O/p =vikal
		
		String s="Java";
		String s0="Java";
		System.out.println(s);
		System.out.println(s0);
		
		String s1="Vikal";
		String s2="Pandey";
		String s3= s1.concat(" is a java programmer");
		 s1="Vikal 2";
		 String s4= s1.concat(" is a great *** java programmer");
		 
		 System.out.println(s1);
		 System.out.println(s2);
		 System.out.println(s3);
		 System.out.println(s4);
		 
		 
		 String name3=new String("Vikal");
		 String name4=new String("Vikal");
			System.out.println(name3.equals(name4));//O/P=true
		System.out.println(name3==name4);//O/P=false
		
		String name5="vikal";
		String name6="vikal";

		System.out.println(name5.equals(name6));//O/P=true
		System.out.println(name5==name6);//O/P=true
		
	}

}
