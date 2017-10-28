public class FrontControllerPatternDemo {
   public static void main(String[] args) {
   
      FrontController frontController = new FrontController();
	  //Go home
      frontController.dispatchRequest("Home");
	  
	  //Go Tution
      frontController.dispatchRequest("Tution");
   }
}