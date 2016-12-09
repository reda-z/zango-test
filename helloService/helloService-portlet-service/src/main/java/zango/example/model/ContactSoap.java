package zango.example.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link zango.example.service.http.ContactServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see zango.example.service.http.ContactServiceSoap
 * @generated
 */
public class ContactSoap implements Serializable {
    private String _uuid;
    private long _contactId;
    private String _lastName;
    private String _firstName;

    public ContactSoap() {
    }

    public static ContactSoap toSoapModel(Contact model) {
        ContactSoap soapModel = new ContactSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setContactId(model.getContactId());
        soapModel.setLastName(model.getLastName());
        soapModel.setFirstName(model.getFirstName());

        return soapModel;
    }

    public static ContactSoap[] toSoapModels(Contact[] models) {
        ContactSoap[] soapModels = new ContactSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContactSoap[][] toSoapModels(Contact[][] models) {
        ContactSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContactSoap[models.length][models[0].length];
        } else {
            soapModels = new ContactSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContactSoap[] toSoapModels(List<Contact> models) {
        List<ContactSoap> soapModels = new ArrayList<ContactSoap>(models.size());

        for (Contact model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContactSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contactId;
    }

    public void setPrimaryKey(long pk) {
        setContactId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getContactId() {
        return _contactId;
    }

    public void setContactId(long contactId) {
        _contactId = contactId;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }
}
