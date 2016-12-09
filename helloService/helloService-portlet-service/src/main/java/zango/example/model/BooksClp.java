package zango.example.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import zango.example.service.BooksLocalServiceUtil;
import zango.example.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class BooksClp extends BaseModelImpl<Books> implements Books {
    private String _uuid;
    private long _bookId;
    private String _bookName;
    private String _bookAuthor;
    private String _bookResume;
    private BaseModel<?> _booksRemoteModel;
    private Class<?> _clpSerializerClass = zango.example.service.ClpSerializer.class;

    public BooksClp() {
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_booksRemoteModel != null) {
            try {
                Class<?> clazz = _booksRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_booksRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getBookId() {
        return _bookId;
    }

    @Override
    public void setBookId(long bookId) {
        _bookId = bookId;

        if (_booksRemoteModel != null) {
            try {
                Class<?> clazz = _booksRemoteModel.getClass();

                Method method = clazz.getMethod("setBookId", long.class);

                method.invoke(_booksRemoteModel, bookId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBookName() {
        return _bookName;
    }

    @Override
    public void setBookName(String bookName) {
        _bookName = bookName;

        if (_booksRemoteModel != null) {
            try {
                Class<?> clazz = _booksRemoteModel.getClass();

                Method method = clazz.getMethod("setBookName", String.class);

                method.invoke(_booksRemoteModel, bookName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBookAuthor() {
        return _bookAuthor;
    }

    @Override
    public void setBookAuthor(String bookAuthor) {
        _bookAuthor = bookAuthor;

        if (_booksRemoteModel != null) {
            try {
                Class<?> clazz = _booksRemoteModel.getClass();

                Method method = clazz.getMethod("setBookAuthor", String.class);

                method.invoke(_booksRemoteModel, bookAuthor);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBookResume() {
        return _bookResume;
    }

    @Override
    public void setBookResume(String bookResume) {
        _bookResume = bookResume;

        if (_booksRemoteModel != null) {
            try {
                Class<?> clazz = _booksRemoteModel.getClass();

                Method method = clazz.getMethod("setBookResume", String.class);

                method.invoke(_booksRemoteModel, bookResume);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getBooksRemoteModel() {
        return _booksRemoteModel;
    }

    public void setBooksRemoteModel(BaseModel<?> booksRemoteModel) {
        _booksRemoteModel = booksRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _booksRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_booksRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            BooksLocalServiceUtil.addBooks(this);
        } else {
            BooksLocalServiceUtil.updateBooks(this);
        }
    }

    @Override
    public Books toEscapedModel() {
        return (Books) ProxyUtil.newProxyInstance(Books.class.getClassLoader(),
            new Class[] { Books.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BooksClp clone = new BooksClp();

        clone.setUuid(getUuid());
        clone.setBookId(getBookId());
        clone.setBookName(getBookName());
        clone.setBookAuthor(getBookAuthor());
        clone.setBookResume(getBookResume());

        return clone;
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

        if (!(obj instanceof BooksClp)) {
            return false;
        }

        BooksClp books = (BooksClp) obj;

        long primaryKey = books.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
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
