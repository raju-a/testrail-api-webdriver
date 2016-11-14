package testrail_Communication_Api;
import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class Program {
	
	APIClient client;
	JSONObject obj;
	
	public void intializeClient(String url){
		 client = new APIClient(url);
	}
	
	public void setUser(String usr,String pwd){
		client.setUser(usr);
		client.setPassword(pwd);
	}
	
//	public JSONObject createjson(String fun,String result,String comment){
//		 obj= new JSONObject();
//		 obj.put("comment", comment);
//		 
//
//		
//		if(result.equals("pass")){
//			obj.put("status_id", new Integer(1));
//		}
//		
//		else if (result.equals("fail")){
//			obj.put("status_id", new Integer(5));
//		}
//		
//		return obj;
//	}
//	
	
	
    public long add_run(int pid,int suiteid,String run_name,String r_description,int r_assignedto_id,boolean r_include_all) throws MalformedURLException, IOException, APIException{
    	obj= new JSONObject();
    	obj.put("suite_id", suiteid);
    	obj.put("name", r_description);
    	obj.put("assignedto_id", r_assignedto_id);
    	obj.put("include_all", r_include_all);
    	//obj.put("case_ids", r_case_ids);
    	JSONObject response= (JSONObject) client.sendPost("add_run/"+pid, obj);
    	long rid=(long)response.get("id");
    	System.out.print("Run id "+rid);
    	return rid;
    	//createjsonn()
		
	}
	
	
	public void add_result_for_Case(long rid,int tid,String status,String cmt) throws MalformedURLException, IOException, APIException{
		//createjson(status,cmt);
		 obj= new JSONObject();
		 obj.put("comment", cmt);
		if(status.equals("pass")){
			obj.put("status_id", new Integer(1));
		}
		
		else if (status.equals("fail")){
			obj.put("status_id", new Integer(5));
		}
		client.sendPost("add_result_for_case/"+rid+"/"+tid, obj);
	}
	
	
	
	
	
//	public static void main(String[] args) throws Exception
//	{
//		APIClient client = new APIClient("https://testraildemobyraju.testrail.net/");
//		client.setUser("raju.pillai@a-cti.com");
//		client.setPassword("Raju@9003113557");
//		
//		JSONObject c = (JSONObject) client.sendGet("get_case/1");
//		System.out.println(c.get("title"));		
//		
//		
//		Map data = new HashMap();
//		data.put("status_id", new Integer(1));
//		data.put("comment", "This test worked fine!");
//		JSONObject r = (JSONObject) client.sendPost("add_result_for_case/1/1", data);
//	}
}
