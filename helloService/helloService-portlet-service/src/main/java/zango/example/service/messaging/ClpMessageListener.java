package zango.example.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import zango.example.service.BooksLocalServiceUtil;
import zango.example.service.BooksServiceUtil;
import zango.example.service.ClpSerializer;
import zango.example.service.ContactLocalServiceUtil;
import zango.example.service.ContactServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            BooksLocalServiceUtil.clearService();

            BooksServiceUtil.clearService();
            ContactLocalServiceUtil.clearService();

            ContactServiceUtil.clearService();
        }
    }
}
