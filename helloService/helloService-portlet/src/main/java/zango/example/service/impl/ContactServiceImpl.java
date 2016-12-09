package zango.example.service.impl;

import zango.example.service.base.ContactServiceBaseImpl;

/**
 * The implementation of the contact remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link zango.example.service.ContactService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see zango.example.service.base.ContactServiceBaseImpl
 * @see zango.example.service.ContactServiceUtil
 */
public class ContactServiceImpl extends ContactServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link zango.example.service.ContactServiceUtil} to access the contact remote service.
     */
}
