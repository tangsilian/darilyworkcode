package matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zhengze {
	public static void main(String[] args) {
		String string = "'ava'+'avc'+dfdf+'avsdv'";
		// 用正则表达式匹配输入''内的值

		String pattern = "[^'**$']";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);
		// 现在创建 matcher 对象
		Matcher m = r.matcher(string);
		if (m.find()) {
			System.out.println("Found value: " + m.group().length());
		} else {
			System.out.println("NO MATCH");
		}
	}
}
