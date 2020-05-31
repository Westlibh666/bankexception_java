package Exception_train;

public class Exception_test {
	
	int num;
	

	@SuppressWarnings("finally")
	public int method() {
		
		try {
			num = 1;
			return num;
		} catch (Exception e) {
			num = 2;
			return num;// TODO: handle exception
		}
		finally {
			num = 3;
			return num;
		}
	}
	
	public static void main(String[] args) {
		Exception_test eT = new Exception_test();
		int n = eT.method();
		System.out.println(n);
	}
}
