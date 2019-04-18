package aop;


public class Test {
	
	@AdminOnly
	public void caculate() {
		double s = 1;
		for (int i = 0; i < 100; i++) {
			s = Math.PI * 10 % 100 + s;
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		System.out.println("---start---");
		Test test = new Test();
		test.caculate();
		System.out.println("---end---");
	}
}
