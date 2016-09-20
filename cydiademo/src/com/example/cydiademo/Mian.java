package com.example.cydiademo;

import java.lang.reflect.Method;

import com.saurik.substrate.MS;

public class Mian {
	static void initialize() {
		MS.hookClassLoad("com.example.ndk.jiemiActivity",
				new MS.ClassLoadHook() {
					public void classLoaded(Class<?> resources) {
						Method getString;
						try {
							getString = resources.getMethod("getString",
									Integer.TYPE);
							// new Class[] { String.class }
						} catch (NoSuchMethodException e) {
							getString = null;
						}

						if (getString != null) {
							final MS.MethodPointer old = new MS.MethodPointer();

							MS.hookMethod(resources, getString,
									new MS.MethodHook() {
										public Object invoked(Object resources,
												Object... args)
												throws Throwable {
											Integer string = (Integer) old
													.invoke(resources, args);
											return string + 100;
										}
									}, old);
						}
					}
				});
	}
}