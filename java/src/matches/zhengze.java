package matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zhengze {
	public static void main(String[] args) {
		String string = "'ava'+'avc'+dfdf+'avsdv'";
		// ���������ʽƥ������''�ڵ�ֵ

		String pattern = "[^'**$']";
		// ���� Pattern ����
		Pattern r = Pattern.compile(pattern);
		// ���ڴ��� matcher ����
		Matcher m = r.matcher(string);
		if (m.find()) {
			System.out.println("Found value: " + m.group().length());
		} else {
			System.out.println("NO MATCH");
		}
	}
}