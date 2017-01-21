import java.text.*;

public class sqlDateTest 
{
	java.sql.Date d;
	String pattern = "yyyyMMdd";
  
	public sqlDateTest(String data) 
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try 
		{
			d = new java.sql.Date(sdf.parse(data).getTime());
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
  
	public static void main (String[] args) 
	{
		sqlDateTest sd = new sqlDateTest("19981001");
		System.out.println(sd);
	}
}