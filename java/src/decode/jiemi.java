package decode;

public class jiemi {
	static byte[] a = new byte[] { 109, 115, 109, 109, 106 };
	static byte[] e = new byte[] { 99, 104, 109, 111, 100, 32, 48, 55, 55, 55,
			32 };

	public static void main(String[] args) {
		System.out.println(a(new String(a)));
		System.out.println(String.valueOf(new String(e)));
		String string = (1 > 0) ? "q" : "r";
		System.out.println(string);
	}

	public static String a(String arg3) {
		byte[] v1 = arg3.getBytes();
		int v0;
		for (v0 = 0; v0 < v1.length; ++v0) {
			v1[v0] = ((byte) (v1[v0] + 6));
		}

		return new String(v1);
	}
}