package com.reroute.tools;

//import org.apache.log4j.Logger;

public class StringUtil {
//	static Logger log = Logger.getLogger(StringUtil.class.getName());

	//--------------------------------------------
	public static boolean isLetter(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isLetter(c)) return false;
	    }
	    return true;
	}
	//--------------------------------------
	public String zeroPad (int value, int size) {
		  String s = "0000000000"+value;
		  return s.substring(s.length() - size);
		}
	//--------------------------------------
	public String zeroPad (String value, int size) {
		  String s = "0000000000"+value.trim();
		  return s.substring(s.length() - size);
		}

	//--------------------------------------
	public String zeroPack (String value, int size) {
		  String s = value.trim()+"0000000000";
		  return s.substring(0,size);
		}
	//--------------------------------------
	public String zeroPack (int value, int size) {
		  String s = value+"0000000000";
		  return s.substring(0,size);
		}
	//--------------------------------------
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);
	}

	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);
	}

	//--------------------------------------------
	public static String cleanUpString(String pStrIn)
	{
	  	String output = pStrIn.replaceAll("[^\\p{ASCII}]", "");

	    return output;
	}
}
