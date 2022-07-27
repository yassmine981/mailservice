
/**
 * MailServerCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package mailservice;

    /**
     *  MailServerCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MailServerCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MailServerCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MailServerCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for sending_an_email method
            * override this method for handling normal response from sending_an_email operation
            */
           public void receiveResultsending_an_email(
                    mailservice.MailServerStub.Sending_an_emailResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sending_an_email operation
           */
            public void receiveErrorsending_an_email(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for remove_an_email method
            * override this method for handling normal response from remove_an_email operation
            */
           public void receiveResultremove_an_email(
                    mailservice.MailServerStub.Remove_an_emailResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from remove_an_email operation
           */
            public void receiveErrorremove_an_email(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleting_all_received_mails method
            * override this method for handling normal response from deleting_all_received_mails operation
            */
           public void receiveResultdeleting_all_received_mails(
                    mailservice.MailServerStub.Deleting_all_received_mailsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleting_all_received_mails operation
           */
            public void receiveErrordeleting_all_received_mails(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for reading_all_emails method
            * override this method for handling normal response from reading_all_emails operation
            */
           public void receiveResultreading_all_emails(
                    mailservice.MailServerStub.Reading_all_emailsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from reading_all_emails operation
           */
            public void receiveErrorreading_all_emails(java.lang.Exception e) {
            }
                


    }
    