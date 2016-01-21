package tools;

import java.io.IOException;
import java.util.Properties;

public final class Configuration {
	private Properties parameters;
	private static Configuration instance = null;
	
	private Configuration(){
		parameters = new Properties();
		try {
			parameters.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Configuration getInstance(){
		if (instance == null) instance = new Configuration();
		return instance;
	}
	
	public String getParameter(String name){
		return parameters.getProperty(name);
	}
	
	public void setParameter(String name, String value){
		parameters.setProperty(name, value);
	}
}