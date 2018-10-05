package kakaoSecond;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class KakaoTest2 {
	public static void main(String[] args) {
		
//		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
		KakaoApiHelper kah = new KakaoApiHelper();
//		ConcurrentHashMap<String, String> conMap = new ConcurrentHashMap<>();
//		executor.execute(() -> {
//			String str = kah.getIP();
//			conMap.put("getIP", str);
//		});
//		executor.execute(() -> {
//			String str = kah.deleteMethodTest();
//			conMap.put("deleteMethod", str);
//		});
//		executor.execute(() -> {
//			String str = kah.getMethodTest();
//			conMap.put("getMethod", str);
//		});
//		executor.execute(() -> {
//			String str = kah.getRedirect();
//			conMap.put("getRedirect", str);
//		});
//		try{
//			executor.awaitTermination(4L, TimeUnit.SECONDS);
//			executor.shutdown();
//			for(String key : conMap.keySet()) {
//				System.out.println(conMap.get(key));
//			}
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(kah.getIP());
		System.out.println(kah.getMethodTest());
		System.out.println(kah.deleteMethodTest());
		System.out.println(kah.getHTML());
	}
}

class KakaoApiHelper {
	public enum HttpMethodHelper { GET, POST, DELETE };
	public static final String hostURL = "http://nghttp2.org/httpbin";
	public static final String originIPURL = "/ip";
	public static final String userAgentURL = "/user-agent";
	public static final String headersURL = "/headers";
	public static final String getURL = "/get";
	public static final String postURL = "/post";
	public static final String deleteURL = "/delete";
	public static final String htmlURL = "/html";
	public static final String redirectURL = "/redirect/6";
	public static final String imageURL = "/image";
	public static final String imagePNGURL = "/image/png";
	public static final String delayURL = "/delay/3";
	
	public String getDelay() {
		return request(delayURL);
	}
	public String getRedirect() {
		return request(redirectURL);
	}
	public String getIP() {
		return request(originIPURL);
	}
	
	public String getUserAgent() {
		return request(userAgentURL);
	}
	
	public String getHeadersURL() {
		return request(headersURL);
	}
	
	public String getMethodTest() {
		return request(getURL);
	}
	
	public String postMethodTest() {
		return request(postURL, HttpMethodHelper.POST, null);
	}
	
	public String deleteMethodTest() {
		return request(deleteURL, HttpMethodHelper.DELETE);
	}
	
	public String getHTML() {
		return request(htmlURL);
	}
	public String getImage() {
		return request(imageURL);
	}

	public String request(String subURL) {
		return request(subURL, HttpMethodHelper.GET, null);
	}
	
	public String request(String subURL, HttpMethodHelper httpMethod) {
		return request(subURL, httpMethod, null, null);
	}
	
	public String request(String subURL, HttpMethodHelper httpMethod, String params) {
		return request(subURL, httpMethod, params, null);
	}
	
	public String request(String subURL, HttpMethodHelper httpMethod, String params, String body) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			URL url = new URL(hostURL + subURL);
			HttpURLConnection con= (HttpURLConnection) url.openConnection();
			con.setRequestMethod(httpMethod.toString());
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
			con.setRequestProperty("charset", "utf-8");
			if(body != null && body.length() > 0 && httpMethod == HttpMethodHelper.POST) {
				con.setDoOutput(true);
				bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
				bw.write(body);
				bw.flush();
			}
			
			int resCode = con.getResponseCode();
			System.out.println(resCode);
			if(resCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String temp;
			while((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			
			return sb.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br != null) { try{ br.close(); }catch(Exception e) {}; }
			if(bw != null) { try{ bw.close(); }catch(Exception e) {}; }
		}
		
		return null;
	}
}
