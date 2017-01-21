package ws.example;

public class TemperatureConverterServiceClient 
{
    public static void main(String[] args) 
    {
        TemperatureConverterStub stub;
        
        try 
        {
            double c_value = 32;
                    
            stub = new TemperatureConverterStub("http://localhost:8080/axis2/services/TemperatureConverter");
            
            TemperatureConverterStub.C2FConvertion c2f = new TemperatureConverterStub.C2FConvertion();
            c2f.setCValue(c_value); 
            
            TemperatureConverterStub.C2FConvertionResponse res = stub.c2FConvertion(c2f);  
            System.out.println("C Value : "+c_value+ "\tResult : " +res.get_return());
            
            TemperatureConverterStub.F2CConvertion f2c = new TemperatureConverterStub.F2CConvertion(); 
            f2c.setFValue(res.get_return());

            TemperatureConverterStub.F2CConvertionResponse res1 = stub.f2CConvertion(f2c);
            System.out.println("F Value : "+res.get_return()+ "\tResult : " +res1.get_return());
       } 
       catch (Exception e) 
       {
           e.printStackTrace();
       }
    }
}