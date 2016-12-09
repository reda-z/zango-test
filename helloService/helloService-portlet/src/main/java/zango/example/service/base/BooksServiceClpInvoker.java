package zango.example.service.base;

import zango.example.service.BooksServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BooksServiceClpInvoker {
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;

    public BooksServiceClpInvoker() {
        _methodName24 = "getBeanIdentifier";

        _methodParameterTypes24 = new String[] {  };

        _methodName25 = "setBeanIdentifier";

        _methodParameterTypes25 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return BooksServiceUtil.getBeanIdentifier();
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            BooksServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
