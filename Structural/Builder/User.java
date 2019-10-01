public class User {
	/**
	 * Fields
	 */
	private String firstName;
	private String lastName;
	private int age;

	/**
	 * Constructor with Builder
	 * It will call make() and create default Constructor
	 * @param builder builder
	 */
	private User(final Builder builder) {
		firstName = builder.firstName;
		lastName = builder.lastName;
		age = builder.age;
	}

	/**
	 * It will pass all three args and also check
	 * validation for firstName as defined create()
	 * @param firstName firstName
	 * @param lastName lastName
	 * @param age age
	 */
	private User(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	/**
	 * Builder class to call it directly.
	 */
	public static class Builder {
		private String firstName;
		private String lastName;
		private int age;

		public Builder setFirstName(final String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(final String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setAge(final int age) {
			this.age = age;
			return this;
		}

		public User make() {
			return new User(this);
		}

		public User create() {
			User user = new User(firstName, lastName, age);
			if (user.firstName.isEmpty()) {
				throw new IllegalStateException(
						"First name can not be empty!");
			}
			return user;
		}
	}
}