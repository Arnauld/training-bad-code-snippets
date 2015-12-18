package snippets.solid.p4_isp;

import snippets.solid.p4_isp.httpservletrequest.StringUtils;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class RequestUtil {

    public static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equals("XMLHttpRequest"));
    }

    public static String determineRemoteIp(HttpServletRequest request) {
        if (request == null) {
            return "UNK";
        }
        String clientIp = null;
        if (StringUtils.isNotEmpty(request.getHeader("$WSRH"))) {
            // 这是使用WebSphere PlugIn转发时才会使用的特殊Header名
            clientIp = request.getHeader("$WSRH");
            // 以下是一些常见HTTP代理(反向代理)转发时使用的Header名
        } else if (StringUtils.isNotEmpty(request.getHeader("X-FORWARDED-FOR"))) {
            clientIp = request.getHeader("X-FORWARDED-FOR");
        } else if (StringUtils.isNotEmpty(request.getHeader("X-REAL-IP"))) {
            clientIp = request.getHeader("X-REAL-IP");
        } else if (StringUtils.isNotEmpty(request.getHeader("HTTP_CLIENT_IP"))) {
            clientIp = request.getHeader("HTTP_CLIENT_IP");
        } else if (StringUtils.isNotEmpty(request.getHeader("HTTP_X_FORWARDED_FOR"))) {
            clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        } else if (StringUtils.isNotEmpty(request.getHeader("HTTP_X_FORWARDED"))) {
            clientIp = request.getHeader("HTTP_X_FORWARDED");
        } else if (StringUtils.isNotEmpty(request.getHeader("HTTP_FORWARDED_FOR"))) {
            clientIp = request.getHeader("HTTP_FORWARDED_FOR");
        } else if (StringUtils.isNotEmpty(request.getHeader("HTTP_FORWARDED"))) {
            clientIp = request.getHeader("HTTP_FORWARDED");
        }

        return clientIp;
    }
}
