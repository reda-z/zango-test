package zango.example.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link zango.example.service.http.BooksServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see zango.example.service.http.BooksServiceSoap
 * @generated
 */
public class BooksSoap implements Serializable {
    private String _uuid;
    private long _bookId;
    private String _bookName;
    private String _bookAuthor;
    private String _bookResume;

    public BooksSoap() {
    }

    public static BooksSoap toSoapModel(Books model) {
        BooksSoap soapModel = new BooksSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setBookId(model.getBookId());
        soapModel.setBookName(model.getBookName());
        soapModel.setBookAuthor(model.getBookAuthor());
        soapModel.setBookResume(model.getBookResume());

        return soapModel;
    }

    public static BooksSoap[] toSoapModels(Books[] models) {
        BooksSoap[] soapModels = new BooksSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static BooksSoap[][] toSoapModels(Books[][] models) {
        BooksSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new BooksSoap[models.length][models[0].length];
        } else {
            soapModels = new BooksSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static BooksSoap[] toSoapModels(List<Books> models) {
        List<BooksSoap> soapModels = new ArrayList<BooksSoap>(models.size());

        for (Books model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new BooksSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _bookId;
    }

    public void setPrimaryKey(long pk) {
        setBookId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getBookId() {
        return _bookId;
    }

    public void setBookId(long bookId) {
        _bookId = bookId;
    }

    public String getBookName() {
        return _bookName;
    }

    public void setBookName(String bookName) {
        _bookName = bookName;
    }

    public String getBookAuthor() {
        return _bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        _bookAuthor = bookAuthor;
    }

    public String getBookResume() {
        return _bookResume;
    }

    public void setBookResume(String bookResume) {
        _bookResume = bookResume;
    }
}
