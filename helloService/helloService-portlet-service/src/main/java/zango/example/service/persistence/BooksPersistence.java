package zango.example.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import zango.example.model.Books;

/**
 * The persistence interface for the books service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BooksPersistenceImpl
 * @see BooksUtil
 * @generated
 */
public interface BooksPersistence extends BasePersistence<Books> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BooksUtil} to access the books persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the bookses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching bookses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<zango.example.model.Books> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<zango.example.model.Books> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<zango.example.model.Books> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first books in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching books
    * @throws zango.example.NoSuchBooksException if a matching books could not be found
    * @throws SystemException if a system exception occurred
    */
    public zango.example.model.Books findByUuid_First(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException;

    /**
    * Returns the first books in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching books, or <code>null</code> if a matching books could not be found
    * @throws SystemException if a system exception occurred
    */
    public zango.example.model.Books fetchByUuid_First(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last books in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching books
    * @throws zango.example.NoSuchBooksException if a matching books could not be found
    * @throws SystemException if a system exception occurred
    */
    public zango.example.model.Books findByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException;

    /**
    * Returns the last books in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching books, or <code>null</code> if a matching books could not be found
    * @throws SystemException if a system exception occurred
    */
    public zango.example.model.Books fetchByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public zango.example.model.Books[] findByUuid_PrevAndNext(long bookId,
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException;

    /**
    * Removes all the bookses where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bookses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching bookses
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the books in the entity cache if it is enabled.
    *
    * @param books the books
    */
    public void cacheResult(zango.example.model.Books books);

    /**
    * Caches the bookses in the entity cache if it is enabled.
    *
    * @param bookses the bookses
    */
    public void cacheResult(java.util.List<zango.example.model.Books> bookses);

    /**
    * Creates a new books with the primary key. Does not add the books to the database.
    *
    * @param bookId the primary key for the new books
    * @return the new books
    */
    public zango.example.model.Books create(long bookId);

    /**
    * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param bookId the primary key of the books
    * @return the books that was removed
    * @throws zango.example.NoSuchBooksException if a books with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public zango.example.model.Books remove(long bookId)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException;

    public zango.example.model.Books updateImpl(zango.example.model.Books books)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the books with the primary key or throws a {@link zango.example.NoSuchBooksException} if it could not be found.
    *
    * @param bookId the primary key of the books
    * @return the books
    * @throws zango.example.NoSuchBooksException if a books with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public zango.example.model.Books findByPrimaryKey(long bookId)
        throws com.liferay.portal.kernel.exception.SystemException,
            zango.example.NoSuchBooksException;

    /**
    * Returns the books with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param bookId the primary key of the books
    * @return the books, or <code>null</code> if a books with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public zango.example.model.Books fetchByPrimaryKey(long bookId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the bookses.
    *
    * @return the bookses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<zango.example.model.Books> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<zango.example.model.Books> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<zango.example.model.Books> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the bookses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of bookses.
    *
    * @return the number of bookses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
