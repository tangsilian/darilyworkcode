package com.example.testdelete;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	public Context context = this;
	public String filename = "uzi";
	public String filecontent = "woyouyitouxiaomaolv";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

	}

	// 我們這裡用mainfest聲明然後switch的方法判斷button的點擊事件click
	public void click(View v) throws UnsupportedEncodingException, IOException {
		switch (v.getId()) {
		case R.id.createfile:
			// 文件存儲 文件默认会存储到/data/data/package/files中；
			createnewfile();
			Toast.makeText(getApplicationContext(), "點擊了增加文件按鈕", 0).show();
			break;
		case R.id.deletefile:
			// 先找到/data/data/package/files文件并刪除裡面的uzi文件
			// deleteFile(getFilesDir());

			File file = new File(getFilesDir() + "/uzi");
			file.delete();
			String fString = file.getName();
			Toast.makeText(getApplicationContext(), fString, 0).show();

			break;
		default:
			break;
		}
	}

	private void createnewfile() throws UnsupportedEncodingException,
			IOException {
		// TODO Auto-generated method stub
		FileOutputStream out = null;
		try {
			out = context.openFileOutput(filename, Context.MODE_PRIVATE);
			out.write(filecontent.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteFile(File file) {
		if (file.exists()) { // 判断文件是否存在
			if (file.isFile()) { // 判断是否是文件
				file.delete(); // delete()方法 你应该知道 是删除的意思;
			} else if (file.isDirectory()) { // 否则如果它是一个目录
				File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件

					this.deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			// file.delete();
		} else {
			Log.d("file", "文件不存在！" + "\n");
		}
	}
}
