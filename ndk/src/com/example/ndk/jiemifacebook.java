package com.example.ndk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 这段带是用来解密rootnik的
 * 
 * @author tangsikang
 * 
 */
public class jiemifacebook {
	private static byte[] a;

	static {
		a = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
	}

	public static void main(String[] args) {
		System.out
				.println(b("rAQxGe4eB8bHF8bxn9Ti+QTQM1mRdsX3UgMWt2CkMpq7Pwv/4ZCn6hFfbvZg zEww"));
	}

	public static String b(String arg5) {
		String v0_2;
		try {
			byte[] v0_1 = a(arg5);
			IvParameterSpec v1 = new IvParameterSpec(a);
			SecretKeySpec v2 = new SecretKeySpec("MARKETCC".getBytes(), "DES");
			Cipher v3 = Cipher.getInstance("DES/CBC/PKCS5Padding");
			v3.init(2, ((Key) v2), ((AlgorithmParameterSpec) v1));
			v0_2 = new String(v3.doFinal(v0_1), "utf-8");
		} catch (Exception v0) {
			v0.printStackTrace();
			v0_2 = "";
		}

		return v0_2;
	}

	public static byte[] a(String arg5) throws IOException {
		ByteArrayOutputStream v0 = new ByteArrayOutputStream();
		aa(arg5, ((OutputStream) v0));

		byte[] v1 = v0.toByteArray();
		try {
			v0.close();
		} catch (IOException v0_1) {
			System.err.println("Error while decoding BASE64: "
					+ v0_1.toString());
		}

		return v1;
	}

	private static void aa(String arg5, OutputStream arg6) throws IOException {
		int v4 = 61;
		int v0 = 0;
		int v1 = arg5.length();
		while (true) {
			if (v0 < v1 && arg5.charAt(v0) <= 32) {
				++v0;
				continue;
			}

			if (v0 != v1) {
				int v2 = (aaa(arg5.charAt(v0)) << 18)
						+ (aaa(arg5.charAt(v0 + 1)) << 12)
						+ (aaa(arg5.charAt(v0 + 2)) << 6)
						+ aaa(arg5.charAt(v0 + 3));
				arg6.write(v2 >> 16 & 255);
				if (arg5.charAt(v0 + 2) != v4) {
					arg6.write(v2 >> 8 & 255);
					if (arg5.charAt(v0 + 3) != v4) {
						arg6.write(v2 & 255);
						v0 += 4;
						continue;
					}
				}
			}

			return;
		}
	}

	private static int aaa(char arg3) {
		int v0;
		if (arg3 < 65 || arg3 > 90) {
			if (arg3 >= 97 && arg3 <= 122) {
				return arg3 - 71;
			}

			if (arg3 >= 48 && arg3 <= 57) {
				return arg3 + 4;
			}

			switch (arg3) {
			case 43: {
				return 62;
			}
			case 47: {

				v0 = 63;
			}
			case 61: {
				return 0;
			}
			}

			throw new RuntimeException("unexpected code: " + arg3);
		} else {
			v0 = arg3 - 65;
		}

		return v0;
	}
}
