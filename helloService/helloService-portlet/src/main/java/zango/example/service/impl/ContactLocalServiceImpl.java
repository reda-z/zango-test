package zango.example.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import zango.example.model.Contact;
import zango.example.service.base.ContactLocalServiceBaseImpl;

/**
 * The implementation of the contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link zango.example.service.ContactLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see zango.example.service.base.ContactLocalServiceBaseImpl
 * @see zango.example.service.ContactLocalServiceUtil
 */
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link zango.example.service.ContactLocalServiceUtil} to access the contact local service.
     */
	
	
	public Contact addContact(String lastName, String firstName, ServiceContext serviceContext) throws SystemException, PortalException{
		
		Contact contact = contactPersistence.create(counterLocalService.increment());
		contact.setLastName(lastName);
		contact.setFirstName(firstName);
		return this.addContact(contact);
		
	}
	
	
}
