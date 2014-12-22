import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParseAndRead {

	private static final String filePath = "/users/appikonda/documents/Gifs.json";

	public static void main(String[] args) {

		try {

			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			JSONArray celebArray = (JSONArray) jsonObject.get("celebrity");

			Iterator iter = celebArray.iterator();

			while (iter.hasNext()) {
				JSONObject innerObject = (JSONObject) iter.next();
				String name = (String) innerObject.get("name");
				System.out.println("name : " + name);

				JSONArray contentArray = (JSONArray) innerObject.get("content");

				for (int i = 0; i < contentArray.size(); i++) {
					JSONObject gifContentObject = (JSONObject) contentArray.get(i);
					String gifNumString = (String) gifContentObject.get("gifNum");
					int gifNum = Integer.parseInt(gifNumString);
					String url = (String) gifContentObject.get("url");
					System.out.println("gifNum : " + gifNum + " url:" + url);
				}
				
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

	}

}