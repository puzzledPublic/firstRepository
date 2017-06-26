package java8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonTest {
	public static void main(String args[]) throws IOException
	{
		//HashMap<String, String> list = new HashMap<>();
		ObjectMapper om = new ObjectMapper();
		File file = new File("C:\\Users\\KHM\\Desktop\\����������Ű������Ա⼳ġ��Ȳ.json");
		/*
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));

			String line = null;
			while((line = br.readLine())!=null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\KHM\\Desktop\\����������Ű������Ա⼳ġ��Ȳ2.txt")))){
		
		//JsonNode jn = om.readTree(file);
		//System.out.println(jn.path("DATA").path(0).toString());
			JsonNode jn = om.readTree(file);
			for(int i = 0 ; i< 570; i++)
			{
				if(jn.path(i).path("SET_LOC").getTextValue()=="")
				{
					bw.write(jn.path(i).path("LOCATION").getTextValue()+"\r\n");
				}
				else if(jn.path(i).path("LOCATION").getTextValue()=="")
				{
					bw.write(jn.path(i).path("SET_LOC").getTextValue()+"\r\n");
				}
				else
				{
					bw.write(jn.path(i).path("SET_LOC").getTextValue()+", "+jn.path(i).path("LOCATION").getTextValue()+"\r\n");
				}
			}

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}