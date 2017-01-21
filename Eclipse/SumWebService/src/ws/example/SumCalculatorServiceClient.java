package ws.example;

public class SumCalculatorServiceClient 
{
    public static void main(String[] args) 
    {
        //TemperatureConverterStub stub;
    	SumCalculatorStub stub;
        
        try 
        {
            //double c_value = 32;
        	//stub = new TemperatureConverterStub("http://localhost:8080/axis2/services/TemperatureConverter");
        	//stub = new SumCalculatorStub("http://localhost:8080/axis2/services/SumCalculator");
        	//stub = new SumCalculatorStub("http://localhost:9000/soap/SumCalculator");
        	stub = new SumCalculatorStub("http://localhost:8280/soap/SumCalculator");
        	System.out.println(stub);
        	double num1_value = 32;
        	double num2_value = -19;
        	
            //TemperatureConverterStub.C2FConvertion c2f = new TemperatureConverterStub.C2FConvertion();
            //c2f.setCValue(c_value); 
        	SumCalculatorStub.GetSum somma = new SumCalculatorStub.GetSum();
        	somma.setNum1(num1_value);
        	somma.setNum2(num2_value);
        	
            //TemperatureConverterStub.C2FConvertionResponse res = stub.c2FConvertion(c2f);  
            //System.out.println("C Value : "+c_value+ "\tResult : " +res.get_return());
        	SumCalculatorStub.GetSumResponse res = stub.getSum(somma);
        	System.out.println("num1 + num2 = " + num1_value + " + " + num2_value + " = " + res.get_return());
        	
            /*
            TemperatureConverterStub.F2CConvertion f2c = new TemperatureConverterStub.F2CConvertion(); 
            f2c.setFValue(res.get_return());

            TemperatureConverterStub.F2CConvertionResponse res1 = stub.f2CConvertion(f2c);
            System.out.println("F Value : "+res.get_return()+ "\tResult : " +res1.get_return());
            */
       }
       catch (Exception e) 
       {
           e.printStackTrace();
       }
    }
}