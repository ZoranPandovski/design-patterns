public class Person {

	private String firstName;
	private String lastName;

	private Person(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
	}

	public static Builder getBuilder() {
		return new Builder();
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}


	public static class Builder {
		private String firstName;
		private String lastName;

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public Person build() {
			Person build = new Person(this);
			return build;
		}
	}

	public static void main(String[] args) {
		Person person = Person.getBuilder().firstName("John").lastName("Doe").build();
		System.out.println(person.getFirstName() + " " + person.getLastName());
	}
}