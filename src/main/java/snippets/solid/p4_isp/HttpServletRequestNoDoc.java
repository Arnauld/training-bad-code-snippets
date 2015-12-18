package snippets.solid.p4_isp;

import snippets.solid.p4_isp.httpservletrequest.Cookie;
import snippets.solid.p4_isp.httpservletrequest.HttpSession;
import snippets.solid.p4_isp.httpservletrequest.ServletRequest;

import java.util.Enumeration;

public interface HttpServletRequestNoDoc extends ServletRequest {
    String BASIC_AUTH = "BASIC";
    String FORM_AUTH = "FORM";
    String CLIENT_CERT_AUTH = "CLIENT_CERT";
    String DIGEST_AUTH = "DIGEST";
    String getAuthType();
    Cookie[] getCookies();
    long getDateHeader(String name);
    String getHeader(String name);
    Enumeration getHeaders(String name);
    Enumeration getHeaderNames();
    int getIntHeader(String name);
    String getMethod();
    String getPathInfo();
    String getPathTranslated();
    String getContextPath();
    String getQueryString();
    String getRemoteUser();
    boolean isUserInRole(String role);
    java.security.Principal getUserPrincipal();
    String getRequestedSessionId();
    String getRequestURI();
    StringBuffer getRequestURL();
    String getServletPath();
    HttpSession getSession(boolean create);
    HttpSession getSession();
    boolean isRequestedSessionIdValid();
    boolean isRequestedSessionIdFromCookie();
    boolean isRequestedSessionIdFromURL();
    boolean isRequestedSessionIdFromUrl();
}
