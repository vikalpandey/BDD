package abstraction;

public abstract class a_abstact_m_class {

	public  abstract void add();

	public abstract void sub();

	int i = 10;
	final int j = 11;
	static int k = 20;

	public void mult() {
		System.out.println("multi method of abstrcat class ");
		System.out.println("i=" + (i + 2));
		System.out.println("value of j= " + ((j + 2) + (k + 2)));
	}

	public static void s_a_Method() {
		System.out.println("s_a_Method method of abstrcat class ");
	}

}
