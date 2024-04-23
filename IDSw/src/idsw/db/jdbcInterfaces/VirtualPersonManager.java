package idsw.db.jdbcInterfaces;

import idsw.db.pojos.Virtual_Person;

public interface VirtualPersonManager {
	
	public Virtual_Person getVirtualPerson(int idVirtual_person);
	public void addVirtualPerson(Virtual_Person virtual_person);


}
