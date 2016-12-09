package zango.example.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import zango.example.model.Books;
import zango.example.service.base.BooksLocalServiceBaseImpl;

/**
 * The implementation of the books local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link zango.example.service.BooksLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see zango.example.service.base.BooksLocalServiceBaseImpl
 * @see zango.example.service.BooksLocalServiceUtil
 */
public class BooksLocalServiceImpl extends BooksLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link zango.example.service.BooksLocalServiceUtil} to access the books local service.
     */
public Books addBooks(String bookName, String bookAuthor,String bookResume ,ServiceContext serviceContext) throws SystemException, PortalException{
		
		Books book = booksPersistence.create(counterLocalService.increment());
		book.setBookAuthor(bookAuthor);
		book.setBookName(bookName);
		book.setBookResume(bookResume);
		return this.addBooks(book);
		
	} 
}
