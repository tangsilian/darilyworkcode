package matches;

import java.io.IOException;
import java.util.Scanner;

public class systemin {

	/**
	 * Scannar
	 */
	public static void main(String[] args) {
		System.out.println("请输入：");
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLine());
	}

	/**
	 * 读取返回int
	 * 
	 * @return
	 */
	public int ReturnInt() {
		int i = 0;
		try {
			// 读取返回的是int类型的
			i = System.in.read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 强制转换
		System.out.println((char) i);
		return i;
	}

	/**
	 * 用数组作为缓冲
	 * 
	 * @throws IOException
	 */
	public void byteBuffer() throws IOException {
		// 先写一个缓冲空间
		byte[] bytebuffer = new byte[1024];

		// 读取数据

		int n = System.in.read(bytebuffer);

		// int to String
		String string = new String(bytebuffer, 0, n);

		System.out.println(string);
	}

}
