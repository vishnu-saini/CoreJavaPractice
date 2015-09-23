import java.util.List;

public class ContactBO {

	public List<Contact> getAllContacts() {
		ContactDAO dao = new ContactDAO();
		List<Contact> list = dao.getAllContacts();
		return list;
	}

	public void insertContact(Contact contact) {

		ContactDAO dao = new ContactDAO();
		dao.insertContact(contact);

	}

}