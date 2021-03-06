package com.introspy.custom_hooks;

import com.introspy.core.HookConfig;

public class CustomHookList {

	static public HookConfig[] getHookList() {
		return _hookList;
	}

	static private HookConfig[] _hookList = new HookConfig[] {

	new HookConfig(true, // set to true to enable the hook
			// "java.lang.String", "equals", new Class<?>[] { Object.class },
			"java.io.File", "delete", new Class<?>[] {},
			// class, method name, arguments
			new HookExampleImpl(),
			// instance of the implementation extending IntroHook (here in
			// HookExampleInpl.java)
			"file Hook"), };
}
