package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import entity.Url;

public class EncurtarUrl {
		

	private final String PATH="https://is.gd/create.php?format=simple&url=";
	
	public String shortURL(String url) throws Exception {
		URL u = new URL(PATH+url);
		HttpURLConnection con = (HttpURLConnection) u.openConnection();

		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}
	
	public static void main(String[] args) throws Exception {
		try {
			String longurl = "http://www.imagenswhatsapp.blog.br/wp-content/uploads/2016/11/Camaro-Imagens-Baixar-Papel-De-Parede.jpg";
			String shorturl = new EncurtarUrl().shortURL(longurl);

			Url u = new Url();
			u.setUrl_longa(longurl);
			u.setUrl_curta(shorturl);
			
			System.out.println("URL Longa: " + u.getUrl_longa());
			System.out.println("URL Curta: " + u.getUrl_curta());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}