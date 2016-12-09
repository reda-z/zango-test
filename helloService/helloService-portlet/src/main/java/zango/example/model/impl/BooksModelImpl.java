package zango.example.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import zango.example.model.Books;
import zango.example.model.BooksModel;
import zango.example.model.BooksSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Books service. Represents a row in the &quot;helloService_Books&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link zango.example.model.BooksModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BooksImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BooksImpl
 * @see zango.example.model.Books
 * @see zango.example.model.BooksModel
 * @generated
 */
@JSON(strict = true)
public class BooksModelImpl extends BaseModelImpl<Books> implements BooksModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a books model instance should use the {@link zango.example.model.Books} interface instead.
     */
    public static final String TABLE_NAME = "helloService_Books";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", Types.VARCHAR },
            { "bookId", Types.BIGINT },
            { "bookName", Types.VARCHAR },
            { "bookAuthor", Types.VARCHAR },
            { "bookResume", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table helloService_Books (uuid_ VARCHAR(75) null,bookId LONG not null primary key,bookName VARCHAR(75) null,bookAuthor VARCHAR(75) null,bookResume VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table helloService_Books";
    public static final String ORDER_BY_JPQL = " ORDER BY books.bookId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY helloService_Books.bookId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.zango.example.model.Books"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.zango.example.model.Books"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.zango.example.model.Books"),
            true);
    public static long UUID_COLUMN_BITMASK = 1L;
    public static long BOOKID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.zango.example.model.Books"));
    private static ClassLoader _classLoader = Books.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Books.class };
    private String _uuid;
    private String _originalUuid;
    private long _bookId;
    private String _bookName;
    private String _bookAuthor;
    private String _bookResume;
    private long _columnBitmask;
    private Books _escapedModel;

    public BooksModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Books toModel(BooksSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Books model = new BooksImpl();

        model.setUuid(soapModel.getUuid());
        model.setBookId(soapModel.getBookId());
        model.setBookName(soapModel.getBookName());
        model.setBookAuthor(soapModel.getBookAuthor());
        model.setBookResume(soapModel.getBookResume());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Books> toModels(BooksSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Books> models = new ArrayList<Books>(soapModels.length);

        for (BooksSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _bookId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setBookId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _bookId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Books.class;
    }

    @Override
    public String getModelClassName() {
        return Books.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("bookId", getBookId());
        attributes.put("bookName", getBookName());
        attributes.put("bookAuthor", getBookAuthor());
        attributes.put("bookResume", getBookResume());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long bookId = (Long) attributes.get("bookId");

        if (bookId != null) {
            setBookId(bookId);
        }

        String bookName = (String) attributes.get("bookName");

        if (bookName != null) {
            setBookName(bookName);
        }

        String bookAuthor = (String) attributes.get("bookAuthor");

        if (bookAuthor != null) {
            setBookAuthor(bookAuthor);
        }

        String bookResume = (String) attributes.get("bookResume");

        if (bookResume != null) {
            setBookResume(bookResume);
        }
    }

    @JSON
    @Override
    public String getUuid() {
        if (_uuid == null) {
            return StringPool.BLANK;
        } else {
            return _uuid;
        }
    }

    @Override
    public void setUuid(String uuid) {
        if (_originalUuid == null) {
            _originalUuid = _uuid;
        }

        _uuid = uuid;
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    @JSON
    @Override
    public long getBookId() {
        return _bookId;
    }

    @Override
    public void setBookId(long bookId) {
        _bookId = bookId;
    }

    @JSON
    @Override
    public String getBookName() {
        if (_bookName == null) {
            return StringPool.BLANK;
        } else {
            return _bookName;
        }
    }

    @Override
    public void setBookName(String bookName) {
        _bookName = bookName;
    }

    @JSON
    @Override
    public String getBookAuthor() {
        if (_bookAuthor == null) {
            return StringPool.BLANK;
        } else {
            return _bookAuthor;
        }
    }

    @Override
    public void setBookAuthor(String bookAuthor) {
        _bookAuthor = bookAuthor;
    }

    @JSON
    @Override
    public String getBookResume() {
        if (_bookResume == null) {
            return StringPool.BLANK;
        } else {
            return _bookResume;
        }
    }

    @Override
    public void setBookResume(String bookResume) {
        _bookResume = bookResume;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Books.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Books toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Books) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        BooksImpl booksImpl = new BooksImpl();

        booksImpl.setUuid(getUuid());
        booksImpl.setBookId(getBookId());
        booksImpl.setBookName(getBookName());
        booksImpl.setBookAuthor(getBookAuthor());
        booksImpl.setBookResume(getBookResume());

        booksImpl.resetOriginalValues();

        return booksImpl;
    }

    @Override
    public int compareTo(Books books) {
        long primaryKey = books.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Books)) {
            return false;
        }

        Books books = (Books) obj;

        long primaryKey = books.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        BooksModelImpl booksModelImpl = this;

        booksModelImpl._originalUuid = booksModelImpl._uuid;

        booksModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Books> toCacheModel() {
        BooksCacheModel booksCacheModel = new BooksCacheModel();

        booksCacheModel.uuid = getUuid();

        String uuid = booksCacheModel.uuid;

        if ((uuid != null) && (uuid.length() == 0)) {
            booksCacheModel.uuid = null;
        }

        booksCacheModel.bookId = getBookId();

        booksCacheModel.bookName = getBookName();

        String bookName = booksCacheModel.bookName;

        if ((bookName != null) && (bookName.length() == 0)) {
            booksCacheModel.bookName = null;
        }

        booksCacheModel.bookAuthor = getBookAuthor();

        String bookAuthor = booksCacheModel.bookAuthor;

        if ((bookAuthor != null) && (bookAuthor.length() == 0)) {
            booksCacheModel.bookAuthor = null;
        }

        booksCacheModel.bookResume = getBookResume();

        String bookResume = booksCacheModel.bookResume;

        if ((bookResume != null) && (bookResume.length() == 0)) {
            booksCacheModel.bookResume = null;
        }

        return booksCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", bookId=");
        sb.append(getBookId());
        sb.append(", bookName=");
        sb.append(getBookName());
        sb.append(", bookAuthor=");
        sb.append(getBookAuthor());
        sb.append(", bookResume=");
        sb.append(getBookResume());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("zango.example.model.Books");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bookId</column-name><column-value><![CDATA[");
        sb.append(getBookId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bookName</column-name><column-value><![CDATA[");
        sb.append(getBookName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bookAuthor</column-name><column-value><![CDATA[");
        sb.append(getBookAuthor());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bookResume</column-name><column-value><![CDATA[");
        sb.append(getBookResume());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
