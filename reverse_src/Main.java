package me.veryyoung.wechat.luckymoney

public class Main implements IXposedHookLoadPackage{
	 private static final String LUCKY_MONEY_RECEIVE_UI_CLASS_NAME = "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI";
	 public static final String WECHAT_PACKAGE_NAME = "com.tencent.mm";
	 private static String wechatVersion;
	 
	 static{
		 wechatVersion = "";
	 }
	 public Main(){
		 
	 }
	 
	 static synthetic boolean access$000(Main main ,String str){
		 return main.isGroupTalk(str);
	 }
	 
	 static synthetic String access$100(Main main ,String str){
		 return main.getFromXml(str);
	 }
	 private String getFromXml(String msg,String name){
		 int eventType = 1;
		 String substring = msg.substring(msg.indexOf("<msg>"))
		 XmlPullParserFactory  xfactory = XmlPullParserFactory().newInstance();// 搞错了new XmlPullParserFactory
		 XmlPullParser xParser = xfactory.setNamespaceAware(1);
		 int nType = xfactory.newPullParser().setInput(new StringReader(substring)).getEventType();
		 String strRet = "";
		 while(nType != eventType ){//XmlPullParser.END_DOCUMENT
			 if(nType == 2){
				if (true == xParser.getName().equals(name)){
					xParser.nextToken();
					return xParser.getText();
				}else{
					nType = xParser.next();
				}
		 }
		 return strRet;
		
	 }
	 private boolean isGroupTalk(String talk){
		 return talk.endsWith("@chatroom");
	 }
	 
	 public void handleLoadPackage(XC_LoadPackage$LoadPackageParam packageparam){
		 int v7 = 2;
		 int v6 = 1;
		 int v5 = 0;
		 if(true == packageparam.packageName().equals( "com.tencent.mm")){
			 if(!TextUtils.isEmpty(wechatVersion()){
				 Class classz = XposedHelpers.findClass("android.app.ActivityThread",0);
				
				 Context context = classz.callMethod(classz.callStaticMethod("currentActivityThread",new Object[v5]),"getSystemContext",new Object[v5]);
				 PackageManager pManager = context.getPackageManager();
				 PackageInfo pInfo = pManager.getPackageInfo(packageparam.packageName(),v5);
				 String versionName = pInfo.versionName;
				 XposedBridge.log(new StringBuilder().append("Found wechat version:").append(versionName).toString());
				 wechatVersion = versionName;
				 VersionParam.init(versionName);//这里搞错了，不是调构造，应该是调用init
				 
				 ClassLoader classLoader = packageparam.classLoader;
				 Object[] obj1 = new Object[v7];
				 obj1[v5] = Bundle.class;
				 Main$1 main$1 = new Main$1(Main.this,packageparam);
				 obj1[v6] = main$1;
				 XposedHelpers.findAndHookMethod("com.tencent.mm.ui.LauncherUI",classLoader,"onCreate",obj1);
				 //发现没有 new XC_MethodHook() 到这里变成了obj1
				 
				 
				 Object[] obj2 = new Object[v7];
				 obj2[v5] = Cursor.class;
				 Main$2 main$2 = new Main$2(Main.this,packageparam);
				 obj2[v6] = main$2;
				 XposedHelpers.findAndHookMethod(VersionParam.getMessageClass(),classLoader,"b",obj2);
				 
				 Object[] obj3 = new Object[5];
				 obj3[v5] = Integer.TYPE;
				 obj3[v6] = Integer.TYPE;
				 obj3[v7] = String.class;
				 obj3[3] = VersionParam.receiveUIParamName;
				 obj3[4] = new Main$3();
				 XposedHelpers.findAndHookMethod("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI",
												classLoader,VersionParam.receiveUIFunctionName,obj3);
												
				 new HideModule().hide(packageparam);
			 }
		 }
	 }
	 //捐钱给  “yang_xiongwei” 呵呵
	 class Main$1 extends XC_MethodHook{
		 final synthetic Main this$0;
		 Main$1(Main theThis){
			this$0 = theThis；
		 }
		 protected void afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			 Activity activity = (Activity)methodHookParam.thisObject;
			 if(activity != 0){//少了activity判断
				Intent intend = activity.getIntent();
				if(intend != 0){
					String className = intend.getComponent().getClassName();
					if(!TextUtils.isEmpty(className)){
						if(className.equals("com.tencent.mm.ui.LauncherUI")){
							if(Intent.hasExtra("donate")){
								Intend v1 =  new Intend();
								v1.setClassName(activity,"com.tencent.mm.plugin.remittance.ui.RemittanceUI");
								v1.putExtra("scene",1);
								v1.putExtra("pay_scene",2);
								v1.putExtra("scan_remittance_id","011259012001125901201468688368254");
								v1.putExtra("fee",10.0f);
								v1.putExtra("receiver_name","yang_xiongwei");
								v1.removeExtra("donate");
								activity.startActivity(v1);
								activity.finish();
							}
						}
					} 
				}
				
			 }
			 
		 }
	 }
	 
	class Main$2 extends XC_MethodHook{
		 final synthetic Main this$0;
		 final synthetic XC_LoadPackage$LoadPackageParam val$lpparam；
		 
		 Main$2(Main theThis,XC_LoadPackage$LoadPackageParam packageParam){
			 val$lpparam = packageParam;
			 this$0 = theThis；
		 }
		 protected void afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			 v11 = 4;
			 v10 = 3;
			 v9 = 2;
			 v8 = 1;
			 v1 = 0;
			if(0 == PreferencesUtils.open()){
				return ;
			}
			 int v0 = ((Integer)XposedHelpers.getObjectField(methodHookParam.thisObject,"field_type")).intValue();
			 if(v0 != 0x1a000031 && v0 != 0x1c000031){
				 return ;
			 }
			 v0 = ((Integer)XposedHelpers.getObjectField(methodHookParam.thisObject,"field_status")).intValue();
			 //强转没有分析出来
			 if(false != PreferencesUtils.notSelf() && v0 == v11){
				 return ;
			 }
			 v0 = ((Integer)XposedHelpers.getObjectField(methodHookParam.thisObject,"field_isSend")).intValue();
			 
			 boolean v2 = PreferencesUtils.notSelf();
			 if(v2 != false && v0 != 0){
				 return ;
			 }
			 
			 (String)v2 = (XposedHelpers.getObjectField(methodHookParam.thisObject,"field_talker").toString();
			 if(0 != PreferencesUtils.notWhisper()){
				 if(false == this$0.access$000(this$0,v2)){//isGroupTalk
					 return ;
				 }
			 }
			 
			 if(false == this$0.access$000(this$0,v2) && v0 != 0){
				 return ;
			 }
			 
			 if(false != this$0.access$000(this$0,v2) && false != PreferencesUtils.notMute()){
				 Class clasz = XposedHelpers.findClass("com.tencent.mm.storage.ak",methodHookParam.classLoader);
				(Object)v0 = XposedHelpers.callStaticMethod(clasz,"F",new Object[v8]{methodHookParam.thisObject});
				Object obj = new Object[v11];
				obj[v1] = v2;
				obj[v8] = v0;
				obj[v9] = Integer.valueOf(v10);
				obj[v10] = Boolean.valueOf(v1);
				(Object)v0 = XposedHelpers.callStaticMethod(XposedHelpers.findClass("com.tencent.mm.booter.notification.c",methodHookParam.classLoader),"a",obj);
				if(false != ((Boolean)v0).booleanValue()){
					(String)v0 = XposedHelpers.getObjectField(methodHookParam.thisObject,"field_content").toString()
					v0 = this$0.access$100(this$0,v0,"nativeurl");
					Uri v3 = Uri.parse(v0);
					int v4 = Integer.parseInt(v3.getQueryParameter("msgtype"));
					int v5 = Integer.parseInt(v3.getQueryParameter("channelid"));
					(String)v3 = v3.getQueryParameter("sendid");
					Class clasz1 = XposedHelpers.findClass("com.tencent.mm.plugin.luckymoney.c.ab",methodHookParam.classLoader);
					Object obj1 = new Object[8];
					obj1[v1] = Integer.valueOf(v4);
					obj1[v8] = Integer.valueOf(v5);
					obj1[v9] = v3;
					obj1[v10] = v0;
					obj1[v11] = "";
					obj1[5] = "";
					obj1[6] = v2;
					obj1[7] = "v1.0";
					(Object)v2 = XposedHelpers.newInstance(clasz1,obj1);
					if(false != ((boolean)v0 = PreferencesUtils.delay())){
						(int )v0 = PreferencesUtils.delayTime();	
					}else{
						v0 = v1;
					}
					Class clasz2 = XposedHelpers.findClass("com.tencent.mm.model.ah",methodHookParam.classLoader);
					(Object)v3 = XposedHelpers.callStaticMethod(clasz2,VersionParam.getNetworkByModelMethod,new Object[v1]);
					XposedHelpers.callMethod(v3,"a",new Object[]{v2,Integer.valueOf(v0)});
				}
			 }
			return ;	
		 }
	}
	
	class Main$3 extends XC_MethodHook{
		final synthetic Main this$0;
		Main$3 (Main theThis){
			this$0 = theThis;
		}
		
		protected afterHookedMethod(XC_MethodHook$MethodHookParam methodHookParam){
			if(false != PreferencesUtils.quickOpen()){
				Field v0 = XposedHelpers.findFirstFieldByExactType(methodHookParam.thisObject,Button);
				Button btn = (Button)v0.get(methodHookParam.thisObject);
				if(false != btn.isShown() && false != btn.isClickable()){
					btn.performClick();//打开红包吗？
				}
			}
			return;
		}
	}
}