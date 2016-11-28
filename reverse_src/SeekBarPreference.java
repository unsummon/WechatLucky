package me.veryyoung.wechat.luckymoney
import android.widget.SeekBar
import android.widget.textView
public class SeekBarPreference extends DialogPreference{
	private String hintText;
	private String prefKind;
	private SeekBar seekBar;
	private TextView textView;
	
	public void SeekBarPreference(Context context,AttributeSet attributeSet){
		DialogPreference(context,attributeSet);
		hintText = "拆开红包";
		
		setDialogLayoutResource(0x7f030023);//R.layout.preference_seekbar
		for(int v0 = 0; v0 < attributeSet.getAttributeCount(); v0 ++){
			if(true == attributeSet.getAttributeName(v0).equalsIgnoreCase("pref_kind")){
				prefKind = attributeSet.getAttributeValue(v0);
				return;
			}
		}
	}
	static synthetic String access$000(SeekBarPreference seekBarPreference){		
		return seekBarPreference.hintText;
	}
	
	static synthetic TextView access$100(SeekBarPreference seekBarPreference){		
		return seekBarPreference.textView;
	}
	protected void onBindDialogView(View view){
		int progress ;
		onBindDialogView(view);
		SeekBar seekBar = (SeekBar)findViewById(0x7f0c005e);//R.id.delay_seekBar
		this.seekBar = seekBar;
		progress = getSharedPreferences.getInt(prefKind,0);
		this.seekBar.setProgress(progress));
		this.textView = (TextView)findViewById(0x7f0c005f);//R.id.pref_seekbar_textview
		
		if(0  == progress){
			textView.setText(new StringBuilder().append("立即").append(hintText).toString());
		}else{
			this.textView.setText(new StringBuilder().append("延迟").append(progress).append("毫秒").append(hintText).toString());//分析时缺少了一个延迟时间
		}
		SeekBarPreference$1 seekBarPreference$1 = new SeekBarPreference$1();
		this.SeekBar.setOnSeekBarChangeListener(seekBarPreference$1);
		
	}
	protected void onDialogClosed(boolean flag){
		if(true == flag){
			getEditor().putInt(prefKind,this.SeekBar.getProgress()).commit();
		}
		super(flag);
	}
	
	class SeekBarPreference$1(){
		final synthetic SeekBarPreference this$0;
		
		SeekBarPreference$1(SeekBarPreference theThis){
			this$0 = theThis;
		}
		public void onProgressChanged(SeekBar seekBar,int isChange,boolean flag){
			if(null  == isChange){
				this$0.access$100().setText(new StringBuilder().append("立即").append(this$0.access$000()).toString());
			}else{
				this$0.access$100().setText(new StringBuilder().append("延迟").append(isChange).append("毫秒").append(this$0.access$000()).toString());
			}
		}
		public onStartTrackingTouch(SeekBar seekBar){
			
		}
		
		public onStopTrackingTouch(SeekBar seekBar){
			
		}
	}
}