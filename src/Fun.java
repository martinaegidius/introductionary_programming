public class Fun {
	public static void main(String[] args) {
		int n = 1;
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%10d %10d\n", n, fun(n));
			n *= 10;
		}
	}
		public static int fun(int n) {
			int r = 0;
			while (n > 0) {
				n /= 2;
				r++;
			}
		return r;
	}
}