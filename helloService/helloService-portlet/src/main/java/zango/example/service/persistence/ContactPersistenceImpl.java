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

import zango.example.NoSuchContactException;

import zango.example.model.Contact;
import zango.example.model.impl.ContactImpl;
import zango.example.model.impl.ContactModelImpl;

import zango.example.service.persistence.ContactPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactPersistence
 * @see ContactUtil
 * @generated
 */
public class ContactPersistenceImpl extends BasePersistenceImpl<Contact>
    implements ContactPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ContactUtil} to access the contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ContactImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ContactModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "contact.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "contact.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(contact.uuid IS NULL OR contact.uuid = '')";
    private static final String _SQL_SELECT_CONTACT = "SELECT contact FROM Contact contact";
    private static final String _SQL_SELECT_CONTACT_WHERE = "SELECT contact FROM Contact contact WHERE ";
    private static final String _SQL_COUNT_CONTACT = "SELECT COUNT(contact) FROM Contact contact";
    private static final String _SQL_COUNT_CONTACT_WHERE = "SELECT COUNT(contact) FROM Contact contact WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "contact.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contact exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Contact exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ContactPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Contact _nullContact = new ContactImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Contact> toCacheModel() {
                return _nullContactCacheModel;
            }
        };

    private static CacheModel<Contact> _nullContactCacheModel = new CacheModel<Contact>() {
            @Override
            public Contact toEntityModel() {
                return _nullContact;
            }
        };

    public ContactPersistenceImpl() {
        setModelClass(Contact.class);
    }

    /**
     * Returns all the contacts where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the contacts where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of contacts
     * @param end the upper bound of the range of contacts (not inclusive)
     * @return the range of matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the contacts where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of contacts
     * @param end the upper bound of the range of contacts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findByUuid(String uuid, int start, int end,
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

        List<Contact> list = (List<Contact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Contact contact : list) {
                if (!Validator.equals(uuid, contact.getUuid())) {
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

            query.append(_SQL_SELECT_CONTACT_WHERE);

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
                query.append(ContactModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contact>(list);
                } else {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first contact in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contact
     * @throws zango.example.NoSuchContactException if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByUuid_First(uuid, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the first contact in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Contact> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last contact in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contact
     * @throws zango.example.NoSuchContactException if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByUuid_Last(uuid, orderByComparator);

        if (contact != null) {
            return contact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactException(msg.toString());
    }

    /**
     * Returns the last contact in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contact, or <code>null</code> if a matching contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Contact> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the contacts before and after the current contact in the ordered set where uuid = &#63;.
     *
     * @param contactId the primary key of the current contact
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next contact
     * @throws zango.example.NoSuchContactException if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact[] findByUuid_PrevAndNext(long contactId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchContactException, SystemException {
        Contact contact = findByPrimaryKey(contactId);

        Session session = null;

        try {
            session = openSession();

            Contact[] array = new ContactImpl[3];

            array[0] = getByUuid_PrevAndNext(session, contact, uuid,
                    orderByComparator, true);

            array[1] = contact;

            array[2] = getByUuid_PrevAndNext(session, contact, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Contact getByUuid_PrevAndNext(Session session, Contact contact,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTACT_WHERE);

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
            query.append(ContactModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(contact);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Contact> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the contacts where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Contact contact : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(contact);
        }
    }

    /**
     * Returns the number of contacts where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching contacts
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

            query.append(_SQL_COUNT_CONTACT_WHERE);

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
     * Caches the contact in the entity cache if it is enabled.
     *
     * @param contact the contact
     */
    @Override
    public void cacheResult(Contact contact) {
        EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactImpl.class, contact.getPrimaryKey(), contact);

        contact.resetOriginalValues();
    }

    /**
     * Caches the contacts in the entity cache if it is enabled.
     *
     * @param contacts the contacts
     */
    @Override
    public void cacheResult(List<Contact> contacts) {
        for (Contact contact : contacts) {
            if (EntityCacheUtil.getResult(
                        ContactModelImpl.ENTITY_CACHE_ENABLED,
                        ContactImpl.class, contact.getPrimaryKey()) == null) {
                cacheResult(contact);
            } else {
                contact.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all contacts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ContactImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ContactImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the contact.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Contact contact) {
        EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactImpl.class, contact.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Contact> contacts) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Contact contact : contacts) {
            EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
                ContactImpl.class, contact.getPrimaryKey());
        }
    }

    /**
     * Creates a new contact with the primary key. Does not add the contact to the database.
     *
     * @param contactId the primary key for the new contact
     * @return the new contact
     */
    @Override
    public Contact create(long contactId) {
        Contact contact = new ContactImpl();

        contact.setNew(true);
        contact.setPrimaryKey(contactId);

        String uuid = PortalUUIDUtil.generate();

        contact.setUuid(uuid);

        return contact;
    }

    /**
     * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param contactId the primary key of the contact
     * @return the contact that was removed
     * @throws zango.example.NoSuchContactException if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact remove(long contactId)
        throws NoSuchContactException, SystemException {
        return remove((Serializable) contactId);
    }

    /**
     * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the contact
     * @return the contact that was removed
     * @throws zango.example.NoSuchContactException if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact remove(Serializable primaryKey)
        throws NoSuchContactException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Contact contact = (Contact) session.get(ContactImpl.class,
                    primaryKey);

            if (contact == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(contact);
        } catch (NoSuchContactException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Contact removeImpl(Contact contact) throws SystemException {
        contact = toUnwrappedModel(contact);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(contact)) {
                contact = (Contact) session.get(ContactImpl.class,
                        contact.getPrimaryKeyObj());
            }

            if (contact != null) {
                session.delete(contact);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (contact != null) {
            clearCache(contact);
        }

        return contact;
    }

    @Override
    public Contact updateImpl(zango.example.model.Contact contact)
        throws SystemException {
        contact = toUnwrappedModel(contact);

        boolean isNew = contact.isNew();

        ContactModelImpl contactModelImpl = (ContactModelImpl) contact;

        if (Validator.isNull(contact.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            contact.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (contact.isNew()) {
                session.save(contact);

                contact.setNew(false);
            } else {
                session.merge(contact);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ContactModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((contactModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { contactModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { contactModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
            ContactImpl.class, contact.getPrimaryKey(), contact);

        return contact;
    }

    protected Contact toUnwrappedModel(Contact contact) {
        if (contact instanceof ContactImpl) {
            return contact;
        }

        ContactImpl contactImpl = new ContactImpl();

        contactImpl.setNew(contact.isNew());
        contactImpl.setPrimaryKey(contact.getPrimaryKey());

        contactImpl.setUuid(contact.getUuid());
        contactImpl.setContactId(contact.getContactId());
        contactImpl.setLastName(contact.getLastName());
        contactImpl.setFirstName(contact.getFirstName());

        return contactImpl;
    }

    /**
     * Returns the contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the contact
     * @return the contact
     * @throws zango.example.NoSuchContactException if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact findByPrimaryKey(Serializable primaryKey)
        throws NoSuchContactException, SystemException {
        Contact contact = fetchByPrimaryKey(primaryKey);

        if (contact == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return contact;
    }

    /**
     * Returns the contact with the primary key or throws a {@link zango.example.NoSuchContactException} if it could not be found.
     *
     * @param contactId the primary key of the contact
     * @return the contact
     * @throws zango.example.NoSuchContactException if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact findByPrimaryKey(long contactId)
        throws NoSuchContactException, SystemException {
        return findByPrimaryKey((Serializable) contactId);
    }

    /**
     * Returns the contact with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the contact
     * @return the contact, or <code>null</code> if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Contact contact = (Contact) EntityCacheUtil.getResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
                ContactImpl.class, primaryKey);

        if (contact == _nullContact) {
            return null;
        }

        if (contact == null) {
            Session session = null;

            try {
                session = openSession();

                contact = (Contact) session.get(ContactImpl.class, primaryKey);

                if (contact != null) {
                    cacheResult(contact);
                } else {
                    EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
                        ContactImpl.class, primaryKey, _nullContact);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
                    ContactImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return contact;
    }

    /**
     * Returns the contact with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param contactId the primary key of the contact
     * @return the contact, or <code>null</code> if a contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contact fetchByPrimaryKey(long contactId) throws SystemException {
        return fetchByPrimaryKey((Serializable) contactId);
    }

    /**
     * Returns all the contacts.
     *
     * @return the contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the contacts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of contacts
     * @param end the upper bound of the range of contacts (not inclusive)
     * @return the range of contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the contacts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link zango.example.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of contacts
     * @param end the upper bound of the range of contacts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contact> findAll(int start, int end,
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

        List<Contact> list = (List<Contact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONTACT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONTACT;

                if (pagination) {
                    sql = sql.concat(ContactModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contact>(list);
                } else {
                    list = (List<Contact>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the contacts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Contact contact : findAll()) {
            remove(contact);
        }
    }

    /**
     * Returns the number of contacts.
     *
     * @return the number of contacts
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

                Query q = session.createQuery(_SQL_COUNT_CONTACT);

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
     * Initializes the contact persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.zango.example.model.Contact")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Contact>> listenersList = new ArrayList<ModelListener<Contact>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Contact>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ContactImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
