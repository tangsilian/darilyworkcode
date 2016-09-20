package com.example.ndk;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class checkthestartslef extends Activity {
	ListView listView;
	String boot_permission = "android.permission.RECEIVE_BOOT_COMPLETED";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_main);
		listView = (ListView) findViewById(R.id.list);
		// ����������Adapter
		listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getAppInfo()));
	}

	// �õ���������app����Ϣ
	private String[] getAppInfo() {
		int count = 0;// ��¼�ж��ٸ�app
		// �õ��Ѱ�װ�������Ϣ
		List<ApplicationInfo> allAppList = getPackageManager()
				.getInstalledApplications(0);
		// �½�һ��ArrayList����
		List<String> autoBootAppList = new ArrayList<String>();
		// �����Ѱ�װ��app���app��Ȩ���ﺬ��boot_permission�Ҳ�Ϊϵͳapp
		for (ApplicationInfo appinfo : allAppList) {

			if (PackageManager.PERMISSION_GRANTED == getPackageManager()
					.checkPermission(boot_permission, appinfo.packageName)) {
				if ((appinfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
					autoBootAppList.add(appinfo.packageName);
				}
			} else {
				autoBootAppList.add("��" + count + "��app");
				count++;
			}

		}
		return autoBootAppList.toArray(new String[autoBootAppList.size()]);
	}
}