package petstore;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class petStore {
	int id;
	String name;

	public petStore(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Test
	public void createPet() {
			petStore catagory = new petStore(89, "sfjs");
			new HashMap<String , Object>();
//				catagory.put("id", 89);
//				catagory.put("name","skja");

		ArrayList<String> url = new ArrayList<String>();
		url.add("skgjhdg");
		Object[] tags = {new petStore(9,"sfdjsd")};

		JSONObject j = new JSONObject();
		j.put("id", 3);
		j.put("category", catagory);
//		j.put("name", "doggie");
		j.put("photoUrls", url);
//		j.put("tags", tags);
		j.put("status", "avaiable");

		/*
		 * { "id": 0, "category": { "id": 0, "name": "string" }, "name": "doggie",
		 * "photoUrls": [ "string" ], "tags": [ { "id": 0, "name": "string" },{} ],
		 * "status": "available" }
		 */
	}
}
