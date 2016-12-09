package zango.example.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BooksService}.
 *
 * @author Brian Wing Shun Chan
 * @see BooksService
 * @generated
 */
public class BooksServiceWrapper implements BooksService,
    ServiceWrapper<BooksService> {
    private BooksService _booksService;

    public BooksServiceWrapper(BooksService booksService) {
        _booksService = booksService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _booksService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _booksService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _booksService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BooksService getWrappedBooksService() {
        return _booksService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBooksService(BooksService booksService) {
        _booksService = booksService;
    }

    @Override
    public BooksService getWrappedService() {
        return _booksService;
    }

    @Override
    public void setWrappedService(BooksService booksService) {
        _booksService = booksService;
    }
}
