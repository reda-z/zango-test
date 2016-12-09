package zango.example.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @generated
 */
public class ContactWrapper implements Contact, ModelWrapper<Contact> {
    private Contact _contact;

    public ContactWrapper(Contact contact) {
        _contact = contact;
    }

    @Override
    public Class<?> getModelClass() {
        return Contact.class;
    }

    @Override
    public String getModelClassName() {
        return Contact.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("contactId", getContactId());
        attributes.put("lastName", getLastName());
        attributes.put("firstName", getFirstName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
        }

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }
    }

    /**
    * Returns the primary key of this contact.
    *
    * @return the primary key of this contact
    */
    @Override
    public long getPrimaryKey() {
        return _contact.getPrimaryKey();
    }

    /**
    * Sets the primary key of this contact.
    *
    * @param primaryKey the primary key of this contact
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _contact.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this contact.
    *
    * @return the uuid of this contact
    */
    @Override
    public java.lang.String getUuid() {
        return _contact.getUuid();
    }

    /**
    * Sets the uuid of this contact.
    *
    * @param uuid the uuid of this contact
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _contact.setUuid(uuid);
    }

    /**
    * Returns the contact ID of this contact.
    *
    * @return the contact ID of this contact
    */
    @Override
    public long getContactId() {
        return _contact.getContactId();
    }

    /**
    * Sets the contact ID of this contact.
    *
    * @param contactId the contact ID of this contact
    */
    @Override
    public void setContactId(long contactId) {
        _contact.setContactId(contactId);
    }

    /**
    * Returns the last name of this contact.
    *
    * @return the last name of this contact
    */
    @Override
    public java.lang.String getLastName() {
        return _contact.getLastName();
    }

    /**
    * Sets the last name of this contact.
    *
    * @param lastName the last name of this contact
    */
    @Override
    public void setLastName(java.lang.String lastName) {
        _contact.setLastName(lastName);
    }

    /**
    * Returns the first name of this contact.
    *
    * @return the first name of this contact
    */
    @Override
    public java.lang.String getFirstName() {
        return _contact.getFirstName();
    }

    /**
    * Sets the first name of this contact.
    *
    * @param firstName the first name of this contact
    */
    @Override
    public void setFirstName(java.lang.String firstName) {
        _contact.setFirstName(firstName);
    }

    @Override
    public boolean isNew() {
        return _contact.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _contact.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _contact.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _contact.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _contact.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _contact.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _contact.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _contact.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _contact.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _contact.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _contact.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ContactWrapper((Contact) _contact.clone());
    }

    @Override
    public int compareTo(zango.example.model.Contact contact) {
        return _contact.compareTo(contact);
    }

    @Override
    public int hashCode() {
        return _contact.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<zango.example.model.Contact> toCacheModel() {
        return _contact.toCacheModel();
    }

    @Override
    public zango.example.model.Contact toEscapedModel() {
        return new ContactWrapper(_contact.toEscapedModel());
    }

    @Override
    public zango.example.model.Contact toUnescapedModel() {
        return new ContactWrapper(_contact.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _contact.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _contact.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _contact.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContactWrapper)) {
            return false;
        }

        ContactWrapper contactWrapper = (ContactWrapper) obj;

        if (Validator.equals(_contact, contactWrapper._contact)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Contact getWrappedContact() {
        return _contact;
    }

    @Override
    public Contact getWrappedModel() {
        return _contact;
    }

    @Override
    public void resetOriginalValues() {
        _contact.resetOriginalValues();
    }
}
