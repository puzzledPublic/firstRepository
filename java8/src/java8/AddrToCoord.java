package java8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class AddrToCoord {

	public static void main(String args[])
	{
		/*
		try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\KHM\\Desktop\\서울시자전거공기주입기설치현황2.txt"))))
		    ;BufferedWriter out = new BufferedWriter(new FileWriter(new File("C:\\Users\\KHM\\Desktop\\AddrToCoord.txt"))))
		{
			ObjectMapper om = new ObjectMapper();
			String line = null;
			while((line=in.readLine())!=null)
			{
				loop(om, line,out);
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		coordToJs();

	}
	//다음api로 주소검색하여 좌표값 가져오기
	/*
	public static void loop(ObjectMapper om, String addr,BufferedWriter out)
	{
		try { 
			//ObjectMapper om = new ObjectMapper();
			//주소 인코딩
			String encodingResult = URLEncoder.encode(addr,"UTF-8");
			//url 생성
			URL url = new URL("https://apis.daum.net/local/v1/search/keyword.json?apikey=05773f117e634e194f7f2308134d4e7f&query="+encodingResult);
			//connection 생성
			URLConnection URLConnection =  url.openConnection();
			//json 응답을 받아 인코딩 후 파일에 저장
			try(BufferedReader in = new BufferedReader(new InputStreamReader(URLConnection.getInputStream(),"UTF-8")))
			{
				JsonNode jn = om.readTree(in);
				out.write(jn.path("channel").path("item").path(0).path("title").getTextValue()+","+
						jn.path("channel").path("item").path(0).path("latitude").getTextValue()+","+
						jn.path("channel").path("item").path(0).path("longitude").getTextValue()+"\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	//좌표들을 마커들로 등록하기 위해 js형식으로 바꿈
	public static void coordToJs()
	{
		try(BufferedReader in = new BufferedReader(new FileReader(new File("C:\\Users\\KHM\\Desktop\\AddrToCoord.txt")));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\KHM\\Desktop\\AddrToJs.js"), "UTF-8")))
		{
			out.write("var positions = [");
			String line = null;
			while((line=in.readLine())!=null)
			{
				String[] results = line.split(",");
				out.write("{ content:'<div>"+results[0]+"</div>', latlng:new daum.maps.LatLng("+results[1]+","+results[2]+")},");
			}
			out.write("];");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
