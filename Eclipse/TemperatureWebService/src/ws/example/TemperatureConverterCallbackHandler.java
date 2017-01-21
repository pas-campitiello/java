
/**
 * TemperatureConverterCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */

    package ws.example;

    /**
     *  TemperatureConverterCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class TemperatureConverterCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public TemperatureConverterCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public TemperatureConverterCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for f2CConvertion method
            * override this method for handling normal response from f2CConvertion operation
            */
           public void receiveResultf2CConvertion(
                    ws.example.TemperatureConverterStub.F2CConvertionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from f2CConvertion operation
           */
            public void receiveErrorf2CConvertion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for c2FConvertion method
            * override this method for handling normal response from c2FConvertion operation
            */
           public void receiveResultc2FConvertion(
                    ws.example.TemperatureConverterStub.C2FConvertionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from c2FConvertion operation
           */
            public void receiveErrorc2FConvertion(java.lang.Exception e) {
            }
                


    }
    