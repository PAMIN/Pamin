package br.ufpb.lavid.pamin.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class LocalizaCoordUtil {
	
    private static final String GEO_CODE_SERVER = "http://maps.googleapis.com/maps/api/geocode/json?";

    public  String[] getCoordinates(String endereco, String bairro, String cidade, String estado){
    	String code = endereco+","+bairro+","+cidade+","+estado;
    	String response = null;
    	while(response == null)
    		response = getLocation(code);
    	String[] result = parseLocation(response);
    	
    	return result;
    }

    private static String getLocation(String code) {
    	
        String address = buildUrl(code);

        String content = null;

        try
        {
            URL url = new URL(address);

            InputStream stream = url.openStream();

            try
            {
                int available = stream.available();

                byte[] bytes = new byte[available];

                stream.read(bytes);

                content = new String(bytes);
            }
            finally
            {
                stream.close();
            }

            return (String) content.toString();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static String buildUrl(String code) {
    	
        StringBuilder builder = new StringBuilder();

        builder.append(GEO_CODE_SERVER);

        builder.append("address=");
        builder.append(code.replaceAll(" ", "+"));
        builder.append("&sensor=false");

        return builder.toString();
    }

    private static String[] parseLocation(String response) {
     
        String[] lines = response.split("\n");

        //Se der erro o método vai retornar null
        String lat = null;
        String lng = null;

        for (int i = 0; i < lines.length; i++) {
            if ("\"location\" : {".equals(lines[i].trim()))
            {
            	while(lat == null) {
                lat = getOrdinate(lines[i+1]);
            	}
            	while(lng==null) {
                lng = getOrdinate(lines[i+2]);
            	}
                break;
            }
        }

        return new String[] {lat, lng};
    }

    private static String getOrdinate(String s) {
        
    	String[] split = s.trim().split(" ");

        if (split.length < 1)
        {
            return null;
        }

        String ord = split[split.length - 1];

        if (ord.endsWith(","))
        {
            ord = ord.substring(0, ord.length() - 1);
        }

        // Check that the result is a valid double
        Double.parseDouble(ord);

        return ord;
    }
}