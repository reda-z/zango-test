package zango.example.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import zango.example.model.Books;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Books in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Books
 * @generated
 */
public class BooksCacheModel implements CacheModel<Books>, Externalizable {
    public String uuid;
    public long bookId;
    public String bookName;
    public String bookAuthor;
    public String bookResume;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", bookId=");
        sb.append(bookId);
        sb.append(", bookName=");
        sb.append(bookName);
        sb.append(", bookAuthor=");
        sb.append(bookAuthor);
        sb.append(", bookResume=");
        sb.append(bookResume);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Books toEntityModel() {
        BooksImpl booksImpl = new BooksImpl();

        if (uuid == null) {
            booksImpl.setUuid(StringPool.BLANK);
        } else {
            booksImpl.setUuid(uuid);
        }

        booksImpl.setBookId(bookId);

        if (bookName == null) {
            booksImpl.setBookName(StringPool.BLANK);
        } else {
            booksImpl.setBookName(bookName);
        }

        if (bookAuthor == null) {
            booksImpl.setBookAuthor(StringPool.BLANK);
        } else {
            booksImpl.setBookAuthor(bookAuthor);
        }

        if (bookResume == null) {
            booksImpl.setBookResume(StringPool.BLANK);
        } else {
            booksImpl.setBookResume(bookResume);
        }

        booksImpl.resetOriginalValues();

        return booksImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        bookId = objectInput.readLong();
        bookName = objectInput.readUTF();
        bookAuthor = objectInput.readUTF();
        bookResume = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(bookId);

        if (bookName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(bookName);
        }

        if (bookAuthor == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(bookAuthor);
        }

        if (bookResume == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(bookResume);
        }
    }
}
