package zango.example.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import zango.example.model.Books;

import java.util.List;

/**
 * The persistence utility for the books service. This utility wraps {@link BooksPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BooksPersistence
 * @see BooksPersistenceImpl
 * @generated
 */
public class BooksUtil {
    private static BooksPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Books books) {
        getPersistence().clearCache(books);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Books> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Books> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Books> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Books update(Books books) throws SystemException {
        return getPersistence().update(books);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Books update(Books books, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(books, serviceContext);
    }

    /**
    * Returns all the bookses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching bookses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<zango.example.model.Books> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the bookses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of bookses
    * @param end the upper bound of the range of bookses (not inclusive)
    * @return the range of matching bookses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<zango.example.model.Books> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the bookses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of bookses
    * @param end the upper bound of the range of bookses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bookses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<zango.example.model.Books> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first books in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching books
    * @throws zango.example.NoSuchBooksException if a matching books could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first books in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching books, or <code>null</code> if a matching books could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last books in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching books
    * @throws zango.example.NoSuchBooksException if a matching books could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last books in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching books, or <code>null</code> if a matching books could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the bookses before and after the current books in the ordered set where uuid = &#63;.
    *
    * @param bookId the primary key of the current books
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next books
    * @throws zango.example.NoSuchBooksException if a books with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books[] findByUuid_PrevAndNext(
        long bookId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException {
        return getPersistence()
                   .findByUuid_PrevAndNext(bookId, uuid, orderByComparator);
    }

    /**
    * Removes all the bookses where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of bookses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching bookses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Caches the books in the entity cache if it is enabled.
    *
    * @param books the books
    */
    public static void cacheResult(zango.example.model.Books books) {
        getPersistence().cacheResult(books);
    }

    /**
    * Caches the bookses in the entity cache if it is enabled.
    *
    * @param bookses the bookses
    */
    public static void cacheResult(
        java.util.List<zango.example.model.Books> bookses) {
        getPersistence().cacheResult(bookses);
    }

    /**
    * Creates a new books with the primary key. Does not add the books to the database.
    *
    * @param bookId the primary key for the new books
    * @return the new books
    */
    public static zango.example.model.Books create(long bookId) {
        return getPersistence().create(bookId);
    }

    /**
    * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param bookId the primary key of the books
    * @return the books that was removed
    * @throws zango.example.NoSuchBooksException if a books with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books remove(long bookId)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException {
        return getPersistence().remove(bookId);
    }

    public static zango.example.model.Books updateImpl(
        zango.example.model.Books books)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(books);
    }

    /**
    * Returns the books with the primary key or throws a {@link zango.example.NoSuchBooksException} if it could not be found.
    *
    * @param bookId the primary key of the books
    * @return the books
    * @throws zango.example.NoSuchBooksException if a books with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books findByPrimaryKey(long bookId)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException {
        return getPersistence().findByPrimaryKey(bookId);
    }

    /**
    * Returns the books with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param bookId the primary key of the books
    * @return the books, or <code>null</code> if a books with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static zango.example.model.Books fetchByPrimaryKey(long bookId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(bookId);
    }

    /**
    * Returns all the bookses.
    *
    * @return the bookses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<zango.example.model.Books> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<zango.example.model.Books> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the bookses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bookses
    * @param end the upper bound of the range of bookses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of bookses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<zango.example.model.Books> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the bookses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of bookses.
    *
    * @return the number of bookses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static BooksPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (BooksPersistence) PortletBeanLocatorUtil.locate(zango.example.service.ClpSerializer.getServletContextName(),
                    BooksPersistence.class.getName());

            ReferenceRegistry.registerReference(BooksUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(BooksPersistence persistence) {
    }
}
