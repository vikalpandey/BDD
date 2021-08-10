package interface_ex;

public interface Interface_Object_1 {
	

static int i=5;
static void display() {
System.out.println("I am a static method in Interface");
}

public abstract void method1();

public default void method2() {                         // default method in interface 
    System.out.println("default method");
}
 
public static void method3() {                             // Static method in interface    will call only using interface name
    System.out.println("static method");
}




}
