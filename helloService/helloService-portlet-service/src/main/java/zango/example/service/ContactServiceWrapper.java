package zango.example.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContactService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactService
 * @generated
 */
public class ContactServiceWrapper implements ContactService,
    ServiceWrapper<ContactService> {
    private ContactService _contactService;

    public ContactServiceWrapper(ContactService contactService) {
        _contactService = contactService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _contactService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _contactService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _contactService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ContactService getWrappedContactService() {
        return _contactService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedContactService(ContactService contactService) {
        _contactService = contactService;
    }

    @Override
    public ContactService getWrappedService() {
        return _contactService;
    }

    @Override
    public void setWrappedService(ContactService contactService) {
        _contactService = contactService;
    }
}
