public class Dispatcher {
   
   //create two objects one for Home and one for Tution
   
   private GoHome goHome;  
   private GoTution goTution;
   
   /*This method called when you want to dispatch
      request either to home or stundent object.
   */
   public Dispatcher(){
      //initialize your both objects
	  
      goHome = new GoHome();  
      goTution = new GoTution();
   }

   public void dispatch(String request){
   
      /* By default you will go home but
	    you may goto tution if you have ant
	  */
      if(request.equalsIgnoreCase("Tution")){
         goTution.show();
      }
      else{
         goHome.show();
      }	
   }
}