package custom;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.google.api.client.json.*;
import com.google.api.client.json.jackson2.*;

import com.google.api.services.gmail.*;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;

public class gmailApi {

	private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    public static final String user = "me";
    static Gmail service = null;
    private static File filePath = new File(System.getProperty("user.dir")+"/credentials.json");
    private static String ClientID = "1079720496062-gsj9pdrv1gkaq16490e1187h5m43h0jv.apps.googleusercontent.com";
    private static String Secret = "fhRXJBVkoKpAgFwENdwNXJLD";
    private static String RefreshToken = "1//03945qFGNFuxnCgYIARAAGAMSNwF-L9IrcjrvXppr_RUuDFf-TL1z3-7M2tjV0PMhyvgMyIskPiI-VpapXX9u3QP3wVsEOuwUFas"; 
 
    
    public static String getEmailOTP()throws IOException, GeneralSecurityException
    {
    	InputStream in = new FileInputStream(filePath);
    	GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
    	
    	Credential Authorize = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
    	.setJsonFactory(JSON_FACTORY)
    	.setClientSecrets(clientSecrets.getDetails().getClientId().toString(),
    		clientSecrets.getDetails().getClientSecret().toString())
    	.build()
    	.setAccessToken(GetAccessToken())
    	.setRefreshToken(RefreshToken);
     	
    	final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, Authorize)
                .setApplicationName(APPLICATION_NAME)
                .build();
    	
     	Gmail.Users.Messages.List request = service.users().messages().list(user).setQ("from: " + "info@rapidassurance.ai");
    	
    	ListMessagesResponse messageResponse = request.execute();
    	request.setPageToken(messageResponse.getNextPageToken());
    	
    	String messageId = messageResponse.getMessages().get(0).getId();
    	
    	Message message = service.users().messages().get(user, messageId).execute();
    	
    	String OTP = message.getSnippet();
        String returnOTP = OTP.replaceAll("[^0-9]", "");

    	return returnOTP;
    }
 
    private static String GetAccessToken()
    {
    	try {
	    	Map<String,Object> params = new LinkedHashMap<>();
	    	params.put("grant_type", "refresh_token");
	    	params.put("client_id", ClientID);
	    	params.put("client_secret", Secret);
	    	params.put("refresh_token", RefreshToken);
	    	
	    	StringBuilder postData = new StringBuilder();
	    	for (Map.Entry<String, Object> param : params.entrySet())
	    	{
	    		if(postData.length() != 0)
	    		{
	    			postData.append('&');
	    		}
	    		
				postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
				
	    		postData.append('=');
	    		postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
        	}
	    	
	    	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	    	
	    	URL url = new URL("https://accounts.google.com/o/oauth2/token");
	    	HttpURLConnection con = (HttpURLConnection)url.openConnection();
	    	con.setDoOutput(true);
	    	con.setUseCaches(false);
	    	con.setRequestMethod("POST");
	    	con.getOutputStream().write(postDataBytes);
	    	
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    	StringBuffer buffer = new StringBuffer();
	    	for (String line = reader.readLine(); line != null; line = reader.readLine())
	    	{
	    		buffer.append(line);
	    	}
	    	
	    	JSONObject json = new JSONObject(buffer.toString());
	    	String accessToken = json.getString("access_token");
	    	return accessToken;
	    	
    	
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
}
