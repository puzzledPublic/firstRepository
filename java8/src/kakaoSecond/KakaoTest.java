package kakaoSecond;

/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class KakaoTest {
	public static void main(String[] args) throws ParseException {
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls();	//객체가 null일때도 json으로 파싱한다. (이 메소드를 호출하지 않으면 null은 무시한다.)
		builder.setPrettyPrinting(); //json을 출력시 보기 좋게 출력한다.
		builder.setFieldNamingStrategy(new FieldNamingStrategy() {	//@SerializedName 대신 쓸 수 있다.
			@Override
			public String translateName(Field f) {
				if(f.getName().equals("albumId")) {
					return "album_id";
				}
				return f.getName();
			}
		});
		
		Gson gson = builder.create();

		Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";
        
        Dataset dataset = new Dataset();
        dataset.album_id = "7596";
        dataset.album_title = "Album 1";
        
        AlbumImages image = new AlbumImages();
        image.image_id = "1";
        image.albumId = "7596";
        dataset.images.add(image);
        albums.dataset.add(dataset);
        
        System.out.println(gson.toJson(albums));
        
        StringBuilder sb = new StringBuilder();
        try {
	        URL url = new URL("http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=5");
//        	URL url = new URL("http://nghttp2.org/httpbin");
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("GET");
	        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
	        
	        con.connect();
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        if(responseCode == 403) {
	        	br = new BufferedReader(new InputStreamReader(con.getErrorStream(), Charset.forName("UTF-8")));	//response가 error 코드라면 getErrorStream으로 response값을 가져올 수 있다.
	        }else {
	        	br = new BufferedReader(new InputStreamReader(con.getInputStream(), Charset.forName("UTF-8")));
	        }
	        
	        String temp = "";
	        while((temp = br.readLine()) != null) {
	        	sb.append(temp);
	        }
	        
	        con.disconnect();
	        br.close();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        Albums albums2 = gson.fromJson(sb.toString(), Albums.class);
        System.out.println(gson.toJson(albums2));
	}
}

class Albums {
	public String title;
    public String message;
    public List<String> errors = new ArrayList<>();
    public String total;
    public int total_pages;
    public int page;
    public String limit;
    public List<Dataset> dataset = new ArrayList<>();
    
}

class Dataset {
	public String album_id;
	public String album_title;
	@SerializedName("album_images")	//json에 들어갈 필드 이름을 다르게 넣고 싶다면 @SerializedName을 쓰자
	public List<AlbumImages> images = new ArrayList<>();
}

class AlbumImages {
	public String image_id;
	public String user_id;
	public String albumId;
}
*/