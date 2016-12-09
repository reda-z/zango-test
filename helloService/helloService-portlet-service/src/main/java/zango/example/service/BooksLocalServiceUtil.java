package zango.example.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Books. This utility wraps
 * {@link zango.example.service.impl.BooksLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BooksLocalService
 * @see zango.example.service.base.BooksLocalServiceBaseImpl
 * @see zango.example.service.impl.BooksLocalServiceImpl
 * @generated
 */
public class BooksLocalServiceUtil {
    private static BooksLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link zango.example.service.impl.BooksLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the books to the database. Also notifies the appropriate model listeners.
    *
    * @param books the books
    * @return the books that was added
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books addBooks(
        zango.example.model.Books books)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addBooks(books);
    }

    /**
    * Creates a new books with the primary key. Does not add the books to the database.
    *
    * @param bookId the primary key for the new books
    * @return the new books
    */
    public static zango.example.model.Books createBooks(long bookId) {
        return getService().createBooks(bookId);
    }

    /**
    * Deletes the books with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param bookId the primary key of the books
    * @return the books that was removed
    * @throws PortalException if a books with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books deleteBooks(long bookId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteBooks(bookId);
    }

    /**
    * Deletes the books from the database. Also notifies the appropriate model listeners.
    *
    * @param books the books
    * @return the books that was removed
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books deleteBooks(
        zango.example.model.Books books)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteBooks(books);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static zango.example.model.Books fetchBooks(long bookId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchBooks(bookId);
    }

    /**
    * Returns the books with the primary key.
    *
    * @param bookId the primary key of the books
    * @return the books
    * @throws PortalException if a books with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books getBooks(long bookId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getBooks(bookId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the bookses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bookses
    * @param end the upper bound of the range of bookses (not inclusive)
    * @return the range of bookses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<zango.example.model.Books> getBookses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBookses(start, end);
    }

    /**
    * Returns the number of bookses.
    *
    * @return the number of bookses
    * @throws SystemException if a system exception occurred
    */
    public static int getBooksesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBooksesCount();
    }

    /**
    * Updates the books in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param books the books
    * @return the books that was updated
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books updateBooks(
        zango.example.model.Books books)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateBooks(books);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static zango.example.model.Books addBooks(
        java.lang.String bookName, java.lang.String bookAuthor,
        java.lang.String bookResume,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addBooks(bookName, bookAuthor, bookResume, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static BooksLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    BooksLocalService.class.getName());

            if (invokableLocalService instanceof BooksLocalService) {
                _service = (BooksLocalService) invokableLocalService;
            } else {
                _service = new BooksLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(BooksLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(BooksLocalService service) {
    }
}
