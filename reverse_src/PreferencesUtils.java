package me.veryyoung.wechat.luckymoney
public PreferencesUtils{
	private static XSharedPreferences instance;
	static{
		instance = 0;
	}
	public PreferencesUtils(){
		
	}
	public static boolean delay(){
		return PreferencesUtils.getInstance().getBoolean("delay",0x0);
	}
	public static int delayTime(){
		return PreferencesUtils.getInstance().getInt("delay_time",0x0);
	}
	private static XSharedPreferences getInstance(){
		if(0 == instance){
			instance = new XSharedPreferences(PreferencesUtils.getPackage().getName());
			instance.makeWorldReadable();
		}else{
			instance.reload();
		}
		return instance;
	}
	public static boolean notMute(){
		return PreferencesUtils.getInstance().getBoolean("not_mute",0);
	}
	
	public static boolean notSelf(){
		return PreferencesUtils.getInstance().getBoolean("not_self",0);
	}
	
	public static boolean notWhisper(){
		return PreferencesUtils.getInstance().getBoolean("not_whisper",0);
	}
		
	public static boolean open(){
		return PreferencesUtils.getInstance().getBoolean("open",0);
	}
	
	public static boolean quickOpen(){
		return PreferencesUtils.getInstance().getBoolean("quick_open",1);
	}
	
}
