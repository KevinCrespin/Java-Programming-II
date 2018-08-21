class T {
	int x;
}

public class P_04 Passing_Parameters {
	
	public static void main(String[] args) {
		int a = 10;
		m1(a);
		System.out.println("a: " + a);
		T t = new T();
		t.x = 10;
		m2(t);
		System.out.println("x: " + t.x);
	}
	
	public static void m1(int a) {
		a = 100;
	}
	
	public static void m2(T t) {
		t.x = 100;
	}
	
}