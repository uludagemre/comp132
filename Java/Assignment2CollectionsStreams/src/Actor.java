
public class Actor {
	private String name;
	private String surName;
	
	public Actor(String name, String surName) {
		this.name = name;
		this.surName = surName;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String toString() {
		return name+ " "+surName;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Actor actor = (Actor) o;
        return surName.equals(actor.surName) &&
               name.equals(actor.name);
    }
	
}
