package zango.example.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import zango.example.service.ClpSerializer;
import zango.example.service.ContactLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ContactClp extends BaseModelImpl<Contact> implements Contact {
    private String _uuid;
    private long _contactId;
    private String _lastName;
    private String _firstName;
    private BaseModel<?> _contactRemoteModel;
    private Class<?> _clpSerializerClass = zango.example.service.ClpSerializer.class;

    public ContactClp() {
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
    public long getPrimaryKey() {
        return _contactId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setContactId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _contactId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_contactRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getContactId() {
        return _contactId;
    }

    @Override
    public void setContactId(long contactId) {
        _contactId = contactId;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setContactId", long.class);

                method.invoke(_contactRemoteModel, contactId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLastName() {
        return _lastName;
    }

    @Override
    public void setLastName(String lastName) {
        _lastName = lastName;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setLastName", String.class);

                method.invoke(_contactRemoteModel, lastName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFirstName() {
        return _firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setFirstName", String.class);

                method.invoke(_contactRemoteModel, firstName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getContactRemoteModel() {
        return _contactRemoteModel;
    }

    public void setContactRemoteModel(BaseModel<?> contactRemoteModel) {
        _contactRemoteModel = contactRemoteModel;
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

        Class<?> remoteModelClass = _contactRemoteModel.getClass();

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

        Object returnValue = method.invoke(_contactRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContactLocalServiceUtil.addContact(this);
        } else {
            ContactLocalServiceUtil.updateContact(this);
        }
    }

    @Override
    public Contact toEscapedModel() {
        return (Contact) ProxyUtil.newProxyInstance(Contact.class.getClassLoader(),
            new Class[] { Contact.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ContactClp clone = new ContactClp();

        clone.setUuid(getUuid());
        clone.setContactId(getContactId());
        clone.setLastName(getLastName());
        clone.setFirstName(getFirstName());

        return clone;
    }

    @Override
    public int compareTo(Contact contact) {
        long primaryKey = contact.getPrimaryKey();

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

        if (!(obj instanceof ContactClp)) {
            return false;
        }

        ContactClp contact = (ContactClp) obj;

        long primaryKey = contact.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", contactId=");
        sb.append(getContactId());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("zango.example.model.Contact");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactId</column-name><column-value><![CDATA[");
        sb.append(getContactId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastName</column-name><column-value><![CDATA[");
        sb.append(getLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstName</column-name><column-value><![CDATA[");
        sb.append(getFirstName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
