package abstraction;
public class a_user_class extends a_abstact_m_class {

	@Override
	public void add() {
		System.out.println("add m of abstract class");
		System.out.println("value of i= " + (i + 3));
		System.out.println("value of j= " + (j + 3));
	}
	@Override
	public void sub() {
		System.out.println("sub m of abstract class");
		a_abstact_m_class.s_a_Method();
	}
	public void div() {
		System.out.println("div m of user class");
	}
	
	
	public static void main(String[] args) {
		a_user_class obj = new a_user_class();
		obj.add();
		obj.sub();
		obj.mult();
		obj.div();
		obj.s_a_Method();
		a_abstact_m_class.s_a_Method();
	}

}
