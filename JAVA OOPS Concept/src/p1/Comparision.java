    package p1;
    public class Comparision {
      public static void main(String[] args) {
		String name1="Vikal Pandey1";
		String name2="Vikal Pandey1";
		int x=100;
		int y=100;
		System.out.println(name1==name2);//O/P=true
		System.out.println(name1.equals(name2));//O/P=true
		System.out.println(x==y);//O/P=true
	
		String name3=new String("Vikal");
		String name4=new String("Vikal");
		System.out.println(name3.equals(name4));//O/P=true
		System.out.println(name3==name4);//O/P=false
		
		Comp_SingleTonTest s1=Comp_SingleTonTest.getInstance();
		Comp_SingleTonTest s2=Comp_SingleTonTest.getInstance();
		System.out.println(s1==s2);//o/p=true
		System.out.println(s1);//o/p=p1.Comp_SingleTonTest@15db9742
		System.out.println(s2);//o/p=p1.Comp_SingleTonTest@15db9742
		

		
		
		
		
		
	}

}
