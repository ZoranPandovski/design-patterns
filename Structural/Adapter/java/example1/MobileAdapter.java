/**
 * 
 * Thi class represnt the adpter between Mobile and Devices.
 * <br>
 * 
 * This interface {@link Device} already in systems, the create this 
 * adapter is necessary to Mobile used in routine existents
 * 
 * */
public class MobileAdapter implements Device {

	private Mobile mobile;
	
	public MobileAdapter(Mobile mobile) {

		this.mobile = mobile;
	}

	public void shutdown() {
		
		mobile.turOff();
	}

	/**
	 * 
	 * This method have a rule business specific to
	 * Mobile
	 *  	 
	 * */
	public void boot() {
		
		boolean auth = ruleToAuth();
		mobile.boot(auth);
	}

	public void reboot() {

		mobile.restart();
	}

	/**
	 * 
	 * Method to satisfy the depenceny   
	 * 
	 * */
	private boolean ruleToAuth() {

		// implementations...
		return true;
	}
}
