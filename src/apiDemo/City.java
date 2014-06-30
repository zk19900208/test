package apiDemo;

class Country {
	Name name=new Name();
	Country(Name n) {
		System.out.println(name+";"+n);
		name=n;
		System.out.println(name);
	}
	void value() {
		System.out.println(name);
		name.change("China");
	}
}

class City extends Country {
	static Name n=new Name();
	City() {
		super(n);
	}
	public static void main(String[] args) {
		City c=new City();
		c.value();
		System.out.println(n.name);
	}
}

class Name {
	String name;
	public void change(String s) {
		name=s;
	}
}
