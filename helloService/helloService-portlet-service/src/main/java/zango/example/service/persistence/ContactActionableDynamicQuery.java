package zango.example.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import zango.example.model.Contact;

import zango.example.service.ContactLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ContactActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ContactActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ContactLocalServiceUtil.getService());
        setClass(Contact.class);

        setClassLoader(zango.example.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("contactId");
    }
}
