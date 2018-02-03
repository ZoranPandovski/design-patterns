public class FrontController {
	
   private Dispatcher dispatcher;

   //receives request and call dispatcher to dispatch request to the appropriate destination
   public FrontController(){
      dispatcher = new Dispatcher();
   }
   //You may have addtional methods like authentication or tracking request
   private boolean isAuthenticUser(){
      System.out.println("User is authenticated successfully.");
      return true;
   }

   private void trackRequest(String request){
      System.out.println("You are going : " + request);
   }

   public void dispatchRequest(String request){
      //log each request
      trackRequest(request);
      
      //authenticate the user
      if(isAuthenticUser()){
         dispatcher.dispatch(request);
      }	
   }
}