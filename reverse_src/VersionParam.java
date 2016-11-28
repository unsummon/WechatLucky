pakage me.veryyoung.wechat.luckymoney

public class VersionParam{
	public static String getMessageClass;
	public static String getNetworkByModelMethod;
	public static String receiveUIFunctionName;
	public static String receiveUIParamName;
	static{//clinit
		receiveUIFunctionName = "c";
		getNetworkByModelMethod = "vS";
		receiveUIParamName = "com.tencent.mm.v.k";
		getMessageClass = "com.tencent.mm.e.b.bv";
	}
	public VersionParam(){
		super();
	}
	public static init(String str){
		int hashCode = str.hashCode();
		int index = -1;
		switch(hashCode){//sparse-switch
			case 0x5ec5cc94:
				if(str.equals("6.3.23")){
					index = 0;
				}
				break;
			case 0x5ec5cc96:
				if(str.equals("6.3.25")){
					index = 1;
				}
				break;
			case 0x5ec5cc98:
				if(str.equals("6.3.27")){
					index = 2;
				}
				break;
			case 0x5ec5cc99:
				if(str.equals("6.3.28")){
					index = 3;
				}
				break;
			case 0x5ec5ccb0:
				if(str.equals("6.3.30")){
					index = 4;
				}
			default:
				break;
		}
		switch(index){
			case 0:
				receiveUIFunctionName = "d";
				getNetworkByModelMethod = "vE";
				receiveUIParamName = "com.tencent.mm.t.j";
				getMessageClass = "com.tencent.mm.e.b.bl";
				break;
			case 1:
				receiveUIFunctionName = "d";
				getNetworkByModelMethod = "vF";
				receiveUIParamName = "com.tencent.mm.t.j";
				getMessageClass = "com.tencent.mm.e.b.bl";
					
				break;
			case 2:
				receiveUIFunctionName = "e";
				getNetworkByModelMethod = "yj";
				receiveUIParamName = "com.tencent.mm.u.k";
				getMessageClass = "com.tencent.mm.e.b.br";
				break;
			case 3:
				receiveUIFunctionName = "c";
				getNetworkByModelMethod = "vP";
				receiveUIParamName = "com.tencent.mm.v.k";
				getMessageClass = "com.tencent.mm.e.b.bu";
				break;
			case 4:
				receiveUIFunctionName = "c";
				getNetworkByModelMethod = "vS";
				receiveUIParamName = "com.tencent.mm.v.k";
				getMessageClass = "com.tencent.mm.e.b.bv";
				break;
			default:
				receiveUIFunctionName = "c";
				getNetworkByModelMethod = "vS";
				receiveUIParamName = "com.tencent.mm.v.k";
				getMessageClass = "com.tencent.mm.e.b.bv";
				break;
		}
	}
}