package practice.test;

import java.util.Date;

public class CaptureTimeStamp {

	public static void main(String[] args) {
		 String currentTime=new Date().toString().replace(" ", "_").replace(":", " ");
		 System.out.println(currentTime);
	}

}
