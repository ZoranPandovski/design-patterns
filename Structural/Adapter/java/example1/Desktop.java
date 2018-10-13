public class Desktop implements Device {

	public void shutdown() {

		System.out.println("Shutdown for Desktop");
	}

	public void boot() {
		
		System.out.println("Booting for Desktop");
	}

	public void reboot() {
		
		System.out.println("Rebooting for Desktop");
	}
}
