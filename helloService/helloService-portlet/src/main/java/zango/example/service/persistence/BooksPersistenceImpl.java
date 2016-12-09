package zango.example.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import zango.example.NoSuchBooksException;

import zango.example.model.Books;
import zango.example.model.impl.BooksImpl;
import zango.example.model.impl.BooksModelImpl;

import zango.example.service.persistence.BooksPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the books service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BooksPersistence
 * @see BooksUtil
 * @generated
 */
public class BooksPersistenceImpl extends BasePersistenceImpl<Books>
    implements BooksPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BooksUtil} to access the books persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BooksImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
            BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
            BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
            BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
            BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
            BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            BooksModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
            BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "books.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "books.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(books.uuid IS NULL OR books.uuid = '')";
    private static final String _SQL_SELECT_BOOKS = "SELECT books FROM Books books";
    private static final String _SQL_SELECT_BOOKS_WHERE = "SELECT books FROM Books books WHERE ";
    private static final String _SQL_COUNT_BOOKS = "SELECT COUNT(books) FROM Books books";
    private static final String _SQL_COUNT_BOOKS_WHERE = "SELECT COUNT(books) FROM Books books WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "books.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Books exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Books exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BooksPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Books _nullBooks = new BooksImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Books> toCacheModel() {
                return _nullBooksCacheModel;
            }
        };

    private static CacheModel<Books> _nullBooksCacheModel = new CacheModel<Books>() {
            @Override
            public Books toEntityModel() {
                return _nullBooks;
            }
        };

    public BooksPersistenceImpl() {
        setModelClass(Books.class);
    }

    /**
     * Returns all the bookses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching bookses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Books> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Books> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Books> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Books> list = (List<Books>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Books books : list) {
                if (!Validator.equals(uuid, books.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_BOOKS_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(BooksModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Books>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Books>(list);
                } else {
                    list = (List<Books>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Books findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBooksException, SystemException {
        Books books = fetchByUuid_First(uuid, orderByComparator);

        if (books != null) {
            return books;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBooksException(msg.toString());
    }

    /**
     * Returns the first books in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching books, or <code>null</code> if a matching books could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Books fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Books> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Books findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBooksException, SystemException {
        Books books = fetchByUuid_Last(uuid, orderByComparator);

        if (books != null) {
            return books;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchBooksException(msg.toString());
    }

    /**
     * Returns the last books in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching books, or <code>null</code> if a matching books could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Books fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Books> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Books[] findByUuid_PrevAndNext(long bookId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBooksException, SystemException {
        Books books = findByPrimaryKey(bookId);

        Session session = null;

        try {
            session = openSession();

            Books[] array = new BooksImpl[3];

            array[0] = getByUuid_PrevAndNext(session, books, uuid,
                    orderByComparator, true);

            array[1] = books;

            array[2] = getByUuid_PrevAndNext(session, books, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Books getByUuid_PrevAndNext(Session session, Books books,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BOOKS_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(BooksModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(books);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Books> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the bookses where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Books books : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(books);
        }
    }

    /**
     * Returns the number of bookses where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching bookses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BOOKS_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the books in the entity cache if it is enabled.
     *
     * @param books the books
     */
    @Override
    public void cacheResult(Books books) {
        EntityCacheUtil.putResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
            BooksImpl.class, books.getPrimaryKey(), books);

        books.resetOriginalValues();
    }

    /**
     * Caches the bookses in the entity cache if it is enabled.
     *
     * @param bookses the bookses
     */
    @Override
    public void cacheResult(List<Books> bookses) {
        for (Books books : bookses) {
            if (EntityCacheUtil.getResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
                        BooksImpl.class, books.getPrimaryKey()) == null) {
                cacheResult(books);
            } else {
                books.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all bookses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BooksImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BooksImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the books.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Books books) {
        EntityCacheUtil.removeResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
            BooksImpl.class, books.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Books> bookses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Books books : bookses) {
            EntityCacheUtil.removeResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
                BooksImpl.class, books.getPrimaryKey());
        }
    }

    /**
     * Creates a new books with the primary key. Does not add the books to the database.
     *
     * @param bookId the primary key for the new books
     * @return the new books
     */
    @Override
    public Books create(long bookId) {
        Books books = new BooksImpl();

        books.setNew(true);
        books.setPrimaryKey(bookId);

        String uuid = PortalUUIDUtil.generate();

        books.setUuid(uuid);

        return books;
    }

    /**
     * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param bookId the primary key of the books
     * @return the books that was removed
     * @throws zango.example.NoSuchBooksException if a books with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Books remove(long bookId)
        throws NoSuchBooksException, SystemException {
        return remove((Serializable) bookId);
    }

    /**
     * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the books
     * @return the books that was removed
     * @throws zango.example.NoSuchBooksException if a books with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Books remove(Serializable primaryKey)
        throws NoSuchBooksException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Books books = (Books) session.get(BooksImpl.class, primaryKey);

            if (books == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBooksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(books);
        } catch (NoSuchBooksException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Books removeImpl(Books books) throws SystemException {
        books = toUnwrappedModel(books);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(books)) {
                books = (Books) session.get(BooksImpl.class,
                        books.getPrimaryKeyObj());
            }

            if (books != null) {
                session.delete(books);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (books != null) {
            clearCache(books);
        }

        return books;
    }

    @Override
    public Books updateImpl(zango.example.model.Books books)
        throws SystemException {
        books = toUnwrappedModel(books);

        boolean isNew = books.isNew();

        BooksModelImpl booksModelImpl = (BooksModelImpl) books;

        if (Validator.isNull(books.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            books.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (books.isNew()) {
                session.save(books);

                books.setNew(false);
            } else {
                session.merge(books);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !BooksModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((booksModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { booksModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { booksModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }
        }

        EntityCacheUtil.putResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
            BooksImpl.class, books.getPrimaryKey(), books);

        return books;
    }

    protected Books toUnwrappedModel(Books books) {
        if (books instanceof BooksImpl) {
            return books;
        }

        BooksImpl booksImpl = new BooksImpl();

        booksImpl.setNew(books.isNew());
        booksImpl.setPrimaryKey(books.getPrimaryKey());

        booksImpl.setUuid(books.getUuid());
        booksImpl.setBookId(books.getBookId());
        booksImpl.setBookName(books.getBookName());
        booksImpl.setBookAuthor(books.getBookAuthor());
        booksImpl.setBookResume(books.getBookResume());

        return booksImpl;
    }

    /**
     * Returns the books with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the books
     * @return the books
     * @throws zango.example.NoSuchBooksException if a books with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Books findByPrimaryKey(Serializable primaryKey)
        throws NoSuchBooksException, SystemException {
        Books books = fetchByPrimaryKey(primaryKey);

        if (books == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchBooksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return books;
    }

    /**
     * Returns the books with the primary key or throws a {@link zango.example.NoSuchBooksException} if it could not be found.
     *
     * @param bookId the primary key of the books
     * @return the books
     * @throws zango.example.NoSuchBooksException if a books with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Books findByPrimaryKey(long bookId)
        throws NoSuchBooksException, SystemException {
        return findByPrimaryKey((Serializable) bookId);
    }

    /**
     * Returns the books with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the books
     * @return the books, or <code>null</code> if a books with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Books fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Books books = (Books) EntityCacheUtil.getResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
                BooksImpl.class, primaryKey);

        if (books == _nullBooks) {
            return null;
        }

        if (books == null) {
            Session session = null;

            try {
                session = openSession();

                books = (Books) session.get(BooksImpl.class, primaryKey);

                if (books != null) {
                    cacheResult(books);
                } else {
                    EntityCacheUtil.putResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
                        BooksImpl.class, primaryKey, _nullBooks);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
                    BooksImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return books;
    }

    /**
     * Returns the books with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param bookId the primary key of the books
     * @return the books, or <code>null</code> if a books with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Books fetchByPrimaryKey(long bookId) throws SystemException {
        return fetchByPrimaryKey((Serializable) bookId);
    }

    /**
     * Returns all the bookses.
     *
     * @return the bookses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Books> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Books> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Books> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Books> list = (List<Books>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BOOKS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BOOKS;

                if (pagination) {
                    sql = sql.concat(BooksModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Books>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Books>(list);
                } else {
                    list = (List<Books>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the bookses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Books books : findAll()) {
            remove(books);
        }
    }

    /**
     * Returns the number of bookses.
     *
     * @return the number of bookses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_BOOKS);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the books persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.zango.example.model.Books")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Books>> listenersList = new ArrayList<ModelListener<Books>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Books>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BooksImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
