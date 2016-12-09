package zango.example.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import zango.example.model.Books;

import zango.example.service.BooksLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BooksActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public BooksActionableDynamicQuery() throws SystemException {
        setBaseLocalService(BooksLocalServiceUtil.getService());
        setClass(Books.class);

        setClassLoader(zango.example.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("bookId");
    }
}
