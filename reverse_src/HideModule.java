package me.veryyoung.wechat.luckymoney

public class HideModule{
	HideModule(){
		
	}
	static synthetic access$000(HideModule hideModule,String str){
		return hideModule.isTarget(str);
	}
	private boolean isTarget(String str){
		boolean v0;
		if(false == str.contains("veryyoung") && false == str.contains("xposed"){
			v0 = 0;
			return v0;
		}
		v0 = 1;
		return v0;	
	}
	public void hide(XC_LoadPackage$LoadPackageParam packageParam){
		v8 = 3;
		v7 = 2;
		v6 = 1;
		v5 = 0;
		
		Object obj1 = new Object[2];
		obj1[v5] = Integer.TYPE;
		HideModule$1 hideModule$1 = new HideModule$1(this);
		obj1[v6] = hideModule$1;
		XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",packageParam.classLoader,
		"getInstalledApplications",obj1);
		
		Object obj2 = new Object[2];
		obj2[v5] = Integer.TYPE;
		HideModule$2 hideModule$2 = new HideModule$2(this);
		obj2[v6] = hideModule$2;
		XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",packageParam.classLoader,
		"getInstalledPackages",obj2);
		
		Object obj3 = new Object[2];
		obj3[v5] = Integer.TYPE;
		HideModule$3 hideModule$3 = new HideModule$3(this);
		obj3[v6] = hideModule$3;
		XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",packageParam.classLoader,
		"getPackageInfo",obj3);
		
		Object obj4 = new Object[2];
		obj4[v5] = Integer.TYPE;
		HideModule$4 hideModule$4 = new HideModule$4(this);
		obj4[v6] = hideModule$4;
		XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",packageParam.classLoader,
		"getApplicationInfo",obj4);
		
		Object obj5 = new Object[2];
		obj5[v5] = Integer.TYPE;
		HideModule$5 hideModule$5 = new HideModule$5(this);
		obj5[v6] = hideModule$5;
		XposedHelpers.findAndHookMethod("android.app.ActivityManager",packageParam.classLoader,
		"getRunningServices",obj5);
		
		Object obj6 = new Object[2];
		obj6[v5] = Integer.TYPE;
		HideModule$6 hideModule$6 = new HideModule$6(this);
		obj6[v6] = hideModule$6;
		XposedHelpers.findAndHookMethod("android.app.ActivityManager",packageParam.classLoader,
		"getRunningTasks",obj6);
		
		Object obj7 = new Object[2];
		obj7[v5] = Integer.TYPE;
		HideModule$7 hideModule$7 = new HideModule$7(this);
		obj7[v6] = hideModule$7;
		XposedHelpers.findAndHookMethod("android.app.ActivityManager",packageParam.classLoader,
		"getRunningAppProcesses",obj7);
		
	}
	
	class HideModule$1 extends XC_MethodHook{
		final synthetic HideModule this$0;
		HideModule$1(HideModule theThis){
			this$0 = theThis;
		}
		protected afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			List v0 = methodHookParam.getResult();
			ArrayList v1 = new ArrayList();
			Iterator v2 = v0.iterator();
			while(null != v2.hasNext()){
				Object obj = v2.next();
				String strpackName = ((ApplicationInfo)obj).packageName();
				if(false != this$0.access$000(this$0,strpackName)){
					XposedBridge.log(new StringBuilder().append("Hid package: ").append(strpackName).toString());
				}else{
					v1.add(obj);
				}
			}
			methodHookParam.setResult(v1);
		}
	}
	
	class HideModule$2 extends XC_MethodHook{
		final synthetic HideModule this$0;
		HideModule$2(HideModule theThis){
			this$0 = theThis;
		}
		protected afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			List v0 = methodHookParam.getResult();
			ArrayList v1 = new ArrayList();
			Iterator v2 = v0.iterator();
			while(null != v2.hasNext()){
				Object obj = v2.next();
				String strpackName = ((PackageInfo)obj).packageName();
				if(false != this$0.access$000(this$0,strpackName)){//  # invokes: Lme/veryyoung/wechat/luckymoney/HideModule;->isTarget(Ljava/lang/String;)Z
					XposedBridge.log(new StringBuilder().append("Hid package: ").append(strpackName).toString());
				}else{
					v1.add(obj);
				}
			}
			methodHookParam.setResult(v1);
		}
	}
	
	class HideModule$3 extends XC_MethodHook{
		final synthetic HideModule this$0;
		HideModule$3(HideModule theThis){
			this$0 = theThis;
		}
		protected void afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			v3 = 0;
			Object[] obj = methodHookParam.args;
			String v0 = (String)obj[v3];
			if(false != this$0.access$000(this$0,v0)){// # invokes: Lme/veryyoung/wechat/luckymoney/HideModule;->isTarget(Ljava/lang/String;)Z
				Object[] obj1 = methodHookParam.args;
				obj1[v3] = "com.tencent.mm";//操作
				XposedBridge.log(new StringBuilder().append("Fake package: ").append(v0).append(" as ").
				append("com.tencent.mm").toString());
			}
		}
	}
	
	class HideModule$4 extends XC_MethodHook{
		final synthetic HideModule this$0;
		HideModule$4(HideModule theThis){
			this$0 = theThis;
		}
		protected void afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			v3 = 0;
			Object[] obj = methodHookParam.args;
			String v0 = (String)obj[v3];
			if(false != this$0.access$000(this$0,v0)){// # invokes: Lme/veryyoung/wechat/luckymoney/HideModule;->isTarget(Ljava/lang/String;)Z
				Object[] obj1 = methodHookParam.args;
				obj1[v3] = "com.tencent.mm";
				XposedBridge.log(new StringBuilder().append("Fake package: ").append(v0).append(" as ").
				append("com.tencent.mm").toString());
			}
		}
	}
	
	class HideModule$5 extends XC_MethodHook{
		final synthetic HideModule this$0;
		HideModule$5(HideModule theThis){
			this$0 = theThis;
		}
		protected void afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			List v0 = methodHookParam.getResult();
			ArrayList v1 = new ArrayList();
			Iterator v2 = v0.iterator();
			while(null != v2.hasNext()){
				Object obj = v2.next();
				String strpackName = ((RunningServiceInfo)obj).process();
				if(false != this$0.access$000(this$0,strpackName)){//  # invokes: Lme/veryyoung/wechat/luckymoney/HideModule;->isTarget(Ljava/lang/String;)Z
					XposedBridge.log(new StringBuilder().append("Hid service: ").append(strpackName).toString());
				}else{
					v1.add(obj);
				}
			}
			methodHookParam.setResult(v1);
		}
	}
	
	class HideModule$6 extends XC_MethodHook{
		final synthetic HideModule this$0;
		HideModule$6(HideModule theThis){
			this$0 = theThis;
		}
		protected void afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			List v0 = methodHookParam.getResult();
			ArrayList v1 = new ArrayList();
			Iterator v2 = v0.iterator();
			while(null != v2.hasNext()){
				Object obj = v2.next();
				String strpackName = ((ActivityManager$RunningTaskInfo)obj).baseActivity.flattenToString();
				if(false != this$0.access$000(this$0,strpackName)){//  # invokes: Lme/veryyoung/wechat/luckymoney/HideModule;->isTarget(Ljava/lang/String;)Z
					XposedBridge.log(new StringBuilder().append("Hid task: ").append(strpackName).toString());
				}else{
					v1.add(obj);
				}
			}
			methodHookParam.setResult(v1);
		}
	}
	
	class HideModule$7 extends XC_MethodHook{
		final synthetic HideModule this$0;
		HideModule$7(HideModule theThis){
			this$0 = theThis;
		}
		protected void afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			List v0 = methodHookParam.getResult();
			ArrayList v1 = new ArrayList();//android killer丢掉了泛型
			Iterator v2 = v0.iterator();
			while(null != v2.hasNext()){//原来是for循环
				Object obj = v2.next();
				String strpackName = ((ActivityManager$RunningAppProcessInfo)obj).processName();
				if(false != this$0.access$000(this$0,strpackName)){//  # invokes: Lme/veryyoung/wechat/luckymoney/HideModule;->isTarget(Ljava/lang/String;)Z
					XposedBridge.log(new StringBuilder().append("Hid process: ").append(strpackName).toString());
				}else{
					v1.add(obj);
				}
			}
			methodHookParam.setResult(v1);
		}
	}
}