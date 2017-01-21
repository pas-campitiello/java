 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.Date;
  
 public class FormattaDate
{ 
     public static String format_date(String inputDate)
     {
         String outputDate = "";
         SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

         try 
         {
             Date date=format.parse(inputDate);
 
             format.applyPattern("yyyy-MM-dd");
 
             outputDate = format.format(date);
 
         }
         catch (ParseException e) 
         {
        	 System.out.println(e);
         }
 
         return outputDate;
     }
 
     public static void main(String[] args) 
     {
         System.out.println(format_date("20091010"));
     }
}

