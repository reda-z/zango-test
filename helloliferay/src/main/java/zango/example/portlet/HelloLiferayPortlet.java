package zango.example.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import zango.example.service.BooksLocalServiceUtil;
import zango.example.service.ContactLocalServiceUtil;


public class HelloLiferayPortlet extends MVCPortlet {

	Log _log = LogFactoryUtil.getLog(HelloLiferayPortlet.class);
	
	public void processName(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException{
		
		String lastName = ParamUtil.get(actionRequest, "lastName", "COQUELIN");
		String firstName = ParamUtil.get(actionRequest, "firstName", "Eric");
		
		if (Validator.isNull(lastName)){
			lastName="COQUELIN";
		}
		
		
		_log.debug("nom: " + lastName +", prénom: " + firstName);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		ContactLocalServiceUtil.addContact(lastName, firstName, serviceContext);
		
	}
	
	public void processBook(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException{
		String bookName = ParamUtil.get(actionRequest, "bookName", "The msytery");
		String bookAuthor = ParamUtil.get(actionRequest, "bookAuthor", "Reda Virtuoso");
		String bookResume = ParamUtil.get(actionRequest, "bookResume", "An awesome book talking about nothing at all!");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		BooksLocalServiceUtil.addBooks(bookName, bookAuthor, bookResume, serviceContext);
		
	}
	
    public void deleteBook(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException {    	
    	System.out.println("Delete is called !");
        /*long bookId = ParamUtil.getLong(actionRequest, "bookId");
        BooksLocalServiceUtil.deleteBooks(bookId);
        _log.info("#################Book Deleted Successfully#########################");*/
    }
	
}
