package parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
	
	public static void main(String args[]) throws IOException
	{
		
		
		URL url = new URL("http://universities.hipolabs.com/search?name=middle");
		URLConnection connection= url.openConnection();
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		  Gson gson = new Gson();
		  
		 // University  univ = gson.fromJson(in, University.class);
		
		  List<University> objList = gson.fromJson(in, new TypeToken<List<University>>(){}.getType());
			
			System.out.println(objList);
			
			for(University  univ : objList)
			{
				System.out.println(univ);
				System.out.println(univ.name);
			}
		  in.close();
		  
		
	}

}
