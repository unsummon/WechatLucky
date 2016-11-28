package me.veryyoung.wechat.luckymoney

public class SettingsActivity extends Activity{
	private SettingsFragment mSettingsFragment; 
	SettingsActivity(){
		super();
	}
	protected onCreate(Bundle saveInstance){
		super(saveInstance);
		setContentView(0x7f030019);
		if(saveInstance == 0){
			this.mSettingsFragment = new SettingsFragment();
			this.replaceFragment(0x7f0c0050,mSettingsFragment);
		}
	}
	public replaceFragment(int resourceLayoutId,Fragment setFragment){
		// .annotation build Landroid/annotation/TargetApi;
        //  value = 0xb
		// .end annotation
		getFragmentManager().beginTransaction().replace(resourceLayoutId,setFragment).commit();
	}
	
	public class SettingsFragment extends PreferenceFragment{ //android killer静态关键字未还原出来
		public SettingsFragment(){//init
			
		}
	
		public onCreate(Bundle saveInstance){
			super();
			this.getPreferenceManager().setSharedPreferencesMode(1);
			this.addPreferencesFromResource(0x7f050000);//R.xml.pref_setting
			
			// 便于看看匿名内部类 这里懒得优化，自行补脑
			Preference preference = this.findPreference("author");
			setOnPreferenceClickListener setOnPreOnClick = new SettingsActivity$SettingsFragment$1();
			preference.setOnPreferenceClickListener(setOnPreOnClick);
			
			Preference preference1 = this.findPreference("donate_alipay");
			setOnPreferenceClickListener setOnPreOnClick1 = new SettingsActivity$SettingsFragment$2();
			preference1.setOnPreferenceClickListener(setOnPreOnClick1);
			
			Preference preference2 = this.findPreference("donate_wechat");
			setOnPreferenceClickListener setOnPreOnClick2 = new SettingsActivity$SettingsFragment$3();
			preference2.setOnPreferenceClickListener(setOnPreOnClick2);
		}
		
		//接下来的接口实现 告诉编译器的一些注解
		//# annotations
		//.annotation system Ldalvik/annotation/EnclosingMethod;
		//	value = Lme/veryyoung/wechat/luckymoney/SettingsActivity$SettingsFragment;->onCreate(Landroid/os/Bundle;)V
		//.end annotation 
		
		//.annotation system Ldalvik/annotation/InnerClass;
		//accessFlags = 0x0   不可访问
		//name = null   无名类
		//.end annotation
		
		public Interface SettingsActivity$SettingsFragment$1 implements Preference$OnPreferenceClickListener{
			final synthetic SettingsActivity$SettingsFragment this$0；
			
			SettingsActivity$SettingsFragment$1(SettingsActivity$SettingsFragment theThis){
				this$0 = theThis;
			}
			public boolean onPreferenceClick(Preference preference){
				Intent intend = new Intend();
				intend.setAction("android.intent.action.VIEW");
				intend.setData(Uri.parse("https://github.com/veryyoung")); 
				this$0.startActivity(intend);
				return true;
			}
		}
		
		public Interface SettingsActivity$SettingsFragment$2 implements Preference$OnPreferenceClickListener{
			final synthetic SettingsActivity$SettingsFragment this$0；
			
			SettingsActivity$SettingsFragment$2(SettingsActivity$SettingsFragment theThis){
				this$0 = theThis;
			}
			public boolean onPreferenceClick(Preference preference){
				Intent intend = new Intend();
				intend.setAction("android.intent.action.VIEW");
				String str = "https://qr.alipay.com/apbvye346u4wqkcr9b"; 
				StringBuilder sb = new StringBuilder();
				sb.append("alipayqr://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&qrcode=");
				sb.append(str);
				intend.setData(Uri.parse(sb.toString())); 
				ComponentName comName = intend.resolveActivity(this$0.getActivity().getPackageManager());
				
				if(comName != null){
					this$0.startActivity(intend);
				}else{
					intend.setData(Uri.parse(str)); 
					this$0.startActivity(intent);
				}
				return true;
			}
		}
		
		public Interface SettingsActivity$SettingsFragment$3 implements Preference$OnPreferenceClickListener{
			final synthetic SettingsActivity$SettingsFragment this$0；
			
			SettingsActivity$SettingsFragment$2(SettingsActivity$SettingsFragment theThis){
				this$0 = theThis;
			}
			public boolean onPreferenceClick(Preference preference){
				int v3 = 1;
				Intent intend = new Intend();
				intend.setClassName("com.tencent.mm","com.tencent.mm.ui.LauncherUI");
				intend.putExtra("donate",v3);
				this$0.startActivity(intend);			
				return v3;
			}
		}
	}
}


