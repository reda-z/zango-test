package zango.example.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import zango.example.model.Contact;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Contact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @generated
 */
public class ContactCacheModel implements CacheModel<Contact>, Externalizable {
    public String uuid;
    public long contactId;
    public String lastName;
    public String firstName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", contactId=");
        sb.append(contactId);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Contact toEntityModel() {
        ContactImpl contactImpl = new ContactImpl();

        if (uuid == null) {
            contactImpl.setUuid(StringPool.BLANK);
        } else {
            contactImpl.setUuid(uuid);
        }

        contactImpl.setContactId(contactId);

        if (lastName == null) {
            contactImpl.setLastName(StringPool.BLANK);
        } else {
            contactImpl.setLastName(lastName);
        }

        if (firstName == null) {
            contactImpl.setFirstName(StringPool.BLANK);
        } else {
            contactImpl.setFirstName(firstName);
        }

        contactImpl.resetOriginalValues();

        return contactImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        contactId = objectInput.readLong();
        lastName = objectInput.readUTF();
        firstName = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(contactId);

        if (lastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lastName);
        }

        if (firstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(firstName);
        }
    }
}
