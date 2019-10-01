public class HowToUse {
	private void testingUser() {

		/**
		 * It will create object without validation of first name
		 */
		User user = new User.Builder()
				.setFirstName("Leonardo")
				.setLastName("da Vinci")
				.setAge(67)
				.make();

		/**
		 * It will create object with validation of first name
		 */
		User userNew = new User.Builder()
				.setFirstName("Leonardo")
				.setLastName("da Vinci")
				.setAge(67)
				.create();

	}
}