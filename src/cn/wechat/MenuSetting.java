package cn.wechat;

import org.json.JSONException; 
import org.json.JSONObject; 

public class MenuSetting {

	public static String appId = "wxf453b8cc420c2f75";
    public static String appSecret= "0d889350d653419aa2a9dcac87f6b8a2"; 
    
	public static void main(String[] args) throws JSONException {
		add();
		//delete();
	}

    public static String getAccessToken() throws JSONException{
        NetWorkHelper netHelper = new NetWorkHelper();
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",appId,appSecret);
        String result = netHelper.getHttpsResponse(Url,"");
        System.out.println(result);
        //JSONObject json = JSONObject.fromObject(result);
        JSONObject json = new JSONObject(result);
        return  json.getString("access_token");
    }
    
    public static void delete() throws JSONException{
    		String s = getAccessToken();
        NetWorkHelper netHelper = new NetWorkHelper();
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s", s);
        String result = netHelper.getHttpsResponse(Url,"");
        System.out.println(result);
    }
    
    public static void add() throws JSONException{
    		String s = getAccessToken();
        NetWorkHelper netHelper = new NetWorkHelper();
        String json = "{"
        		+ "\"button\":["
        		+ "{"
        		+ "\"name\":\"趣味答题\","
        		+ "\"sub_button\":["
        		+ "{"	
                + "\"type\":\"view\","
                + "\"name\":\"开始答题\","
                + "\"url\":\"http://nzpx69.natappfree.cc/weather/qa.html\""
                + "}]"
        		+ "},"
        		+ "{"
        		+ "\"name\":\"我的排名\","
        		+ "\"sub_button\":["
        		+ "{"	
                + "\"type\":\"view\","
                + "\"name\":\"个人排名\","
                + "\"url\":\"http://www.hnust.cn\""
             	+ "},"
             	 + "{"
                 + "\"type\":\"view\","
                 + "\"name\":\"班级排名\","
                 + "\"url\":\"http://www.hnust.cn\""
              	+ "},"
             	+ "{"
                + "\"type\":\"view\","
                + "\"name\":\"设置\","
                + "\"url\":\"http://www.hnust.cn\""
             	+ "}]"
        		+ "},"
        		+ "{"
        		+ "\"name\":\"个人中心\","
        		+ "\"sub_button\":["
        		+ "{"	
                + "\"type\":\"view\","
                + "\"name\":\"关于我\","
                + "\"url\":\"http://www.hnust.cn/\""
                + "},"
             	+ "{"
                + "\"type\":\"view\","
                + "\"name\":\"联系我\","
                + "\"url\":\"http://www.hnust.cn/\""
             	+ "}]"
        		+ "}]"
        		+ "}";
        System.out.println(json);
         
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", s);      
        String result = netHelper.getHttpsResponsePostBody(Url, "POST", json);
        System.out.println(result);
    }
    
}

