package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavUtility {
public int getRandomNumber()
{
	Random random=new Random();
	int ranDomNumber= random.nextInt(5000);
	return ranDomNumber;
}
public String GetSystemDateYYYYDDMM()
{
	Date dateobj =new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String data=sdf.format(dateobj);
	return  data;
	 
}
public String getrequiredYYYYDDMM(int days)
{
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	sim.format(date);
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
	String requiredate=sim.format(cal.getTime());
	return requiredate;

}
}
