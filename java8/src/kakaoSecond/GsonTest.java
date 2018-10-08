package kakaoSecond;

/*import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GsonTest {
	static class Home {
		String tv, desk, computer;
		Room room;
		public String getTv() {
			return tv;
		}

		public void setTv(String tv) {
			this.tv = tv;
		}

		public String getDesk() {
			return desk;
		}

		public void setDesk(String desk) {
			this.desk = desk;
		}

		public String getComputer() {
			return computer;
		}

		public void setComputer(String computer) {
			this.computer = computer;
		}
		@Override
		public String toString() {
			return tv + " " + desk + " " + computer + " " + room.toString();
		}
		
	}
	static class Room {
		String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return name;
		}
	}
	//jsonElement를 상속받는 클래스 => JsonArray, JsonNull, JsonObject, JsonPrimitive
	public static void main(String[] args) {
		
//		//클래스를 이용하지 않고 위의 클래스들로 json을 만들 수 있다.
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.serializeNulls().create();
		String json = "{\"tv\":\"television\",\"desk\":\"deskdesk\",\"computer\":\"laptop\", \"room\": {\"name\":\"myroom\"}}";
		
		Home home = gson.fromJson(json, Home.class);
		System.out.println(home.toString());
		
		JsonArray jsonArray = new JsonArray();
		jsonArray.add("desk");
		jsonArray.add("computer");
		jsonArray.add("tv");
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("company", jsonArray);
		Home home2 = new Home();
		home.tv = "1";
		home.computer = "2";
		jsonObject.add("home", gson.toJsonTree(home));
		System.out.println(gson.toJson(jsonObject));
	}
}*/



