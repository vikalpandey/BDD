package string;

public class A_immutable {
	
	public static void main(String[] args) {
		String s="vikal";
		String s1=s;
		s=s.concat("pandey"); 
		System.out.println(s ); //O/p =vikalpandey
		System.out.println(s1);//O/p =vikal
		
		
	}

}
