package world.enn.rest.webservices.restfulwebservices.versioning;



public class PersonV2 {

	private Name name;


	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
