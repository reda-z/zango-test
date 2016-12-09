package zango.example.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Books}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Books
 * @generated
 */
public class BooksWrapper implements Books, ModelWrapper<Books> {
    private Books _books;

    public BooksWrapper(Books books) {
        _books = books;
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

    /**
    * Returns the primary key of this books.
    *
    * @return the primary key of this books
    */
    @Override
    public long getPrimaryKey() {
        return _books.getPrimaryKey();
    }

    /**
    * Sets the primary key of this books.
    *
    * @param primaryKey the primary key of this books
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _books.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this books.
    *
    * @return the uuid of this books
    */
    @Override
    public java.lang.String getUuid() {
        return _books.getUuid();
    }

    /**
    * Sets the uuid of this books.
    *
    * @param uuid the uuid of this books
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _books.setUuid(uuid);
    }

    /**
    * Returns the book ID of this books.
    *
    * @return the book ID of this books
    */
    @Override
    public long getBookId() {
        return _books.getBookId();
    }

    /**
    * Sets the book ID of this books.
    *
    * @param bookId the book ID of this books
    */
    @Override
    public void setBookId(long bookId) {
        _books.setBookId(bookId);
    }

    /**
    * Returns the book name of this books.
    *
    * @return the book name of this books
    */
    @Override
    public java.lang.String getBookName() {
        return _books.getBookName();
    }

    /**
    * Sets the book name of this books.
    *
    * @param bookName the book name of this books
    */
    @Override
    public void setBookName(java.lang.String bookName) {
        _books.setBookName(bookName);
    }

    /**
    * Returns the book author of this books.
    *
    * @return the book author of this books
    */
    @Override
    public java.lang.String getBookAuthor() {
        return _books.getBookAuthor();
    }

    /**
    * Sets the book author of this books.
    *
    * @param bookAuthor the book author of this books
    */
    @Override
    public void setBookAuthor(java.lang.String bookAuthor) {
        _books.setBookAuthor(bookAuthor);
    }

    /**
    * Returns the book resume of this books.
    *
    * @return the book resume of this books
    */
    @Override
    public java.lang.String getBookResume() {
        return _books.getBookResume();
    }

    /**
    * Sets the book resume of this books.
    *
    * @param bookResume the book resume of this books
    */
    @Override
    public void setBookResume(java.lang.String bookResume) {
        _books.setBookResume(bookResume);
    }

    @Override
    public boolean isNew() {
        return _books.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _books.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _books.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _books.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _books.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _books.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _books.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _books.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _books.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _books.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _books.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new BooksWrapper((Books) _books.clone());
    }

    @Override
    public int compareTo(zango.example.model.Books books) {
        return _books.compareTo(books);
    }

    @Override
    public int hashCode() {
        return _books.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<zango.example.model.Books> toCacheModel() {
        return _books.toCacheModel();
    }

    @Override
    public zango.example.model.Books toEscapedModel() {
        return new BooksWrapper(_books.toEscapedModel());
    }

    @Override
    public zango.example.model.Books toUnescapedModel() {
        return new BooksWrapper(_books.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _books.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _books.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _books.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BooksWrapper)) {
            return false;
        }

        BooksWrapper booksWrapper = (BooksWrapper) obj;

        if (Validator.equals(_books, booksWrapper._books)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Books getWrappedBooks() {
        return _books;
    }

    @Override
    public Books getWrappedModel() {
        return _books;
    }

    @Override
    public void resetOriginalValues() {
        _books.resetOriginalValues();
    }
}
