public class Author implements Comparable<T> {

	private String name;
	private String email;
	private String gender;

	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(String name, String email, String gender) {

		this.setName(name);
		this.setEmail(email);
		this.setGender(gender);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


		@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + symbol;
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Card other = (Card) obj;
				if (symbol != other.symbol)
					return false;
				return true;
			}
			@Override
			public int compareTo(Card o) {
				int x=0;
				if ( symbol < o.symbol)
				{
					x=-1;
				}
				else
				{
					x=1;
				}
				
				return x;
			}
		}

}
