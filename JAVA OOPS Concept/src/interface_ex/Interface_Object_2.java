package interface_ex;

public class Interface_Object_2 {

	public static void main(String[] args) {
		Interface_Object_1.display();

		Interface_Object_1 obj_Interface = new Interface_Object_1() {

			@Override
			public void method1() {
				System.out.println("method 1 implementastion in sub class");
			}

	
		};
		System.out.println(obj_Interface.i);
		
		
		
	}


}
