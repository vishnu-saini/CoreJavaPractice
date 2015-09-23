import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Address {

	private Integer doorNumber;
	private String street;
	private String city;
	private String district;
	private String state;
	private Integer pinCode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int doorNumber, String street, String city, String district,
			String state, int pinCode) {
		this.doorNumber = doorNumber;
		this.street = street;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
	}

	public int getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public static void searchDistrict(List<Address> addressList, String state) {
		Set<String> districtList = new TreeSet<String>();
		for (Address address : addressList) {
			if (address.getState().equals(state)) {
				districtList.add(address.getDistrict());
			}
		}
		if (districtList.isEmpty()) {
			System.out.println("No records found");
		} else {
			System.out.println("List of districts in " + state + " are");
			for (String distrct : districtList) {
				System.out.println(distrct);
			}
		}
	}

	public static void searchCity(List<Address> addressList, String district) {
		Set<String> cityList = new TreeSet<String>();
		for (Address address : addressList) {
			if (address.getDistrict().equals(district)) {
				cityList.add(address.getCity());
			}
		}
		if (cityList.isEmpty()) {
			System.out.println("No records found");
		} else {
			System.out.println("List of cities in " + district + " are");
			for (String city : cityList) {
				System.out.println(city);
			}
		}

	}

}
