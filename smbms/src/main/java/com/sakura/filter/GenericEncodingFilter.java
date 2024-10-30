package com.sakura.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GenericEncodingFilter implements Filter {

    @Override
    public void destroy() {

    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        处理response的字符编码
        HttpServletResponse myResponse = (HttpServletResponse) response;

        myResponse.setContentType("text/html;charset=UTF-8");
//        转型为与协议相关对象
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        对request对象包装增强
        HttpServletRequest myRequest = new Myrequest(httpServletRequest) ;
        chain.doFilter(request, response);
    }

//自定义request对象
    class Myrequest extends HttpServletRequestWrapper {
        private     HttpServletRequest request;
        private     boolean hasEncode;
        public Myrequest(HttpServletRequest request) {
            super(request);//super必须写
            this.request = request;
        }
    //对需要增强方法进行覆盖
    @Override
    public Map getParameterMap() {
//先获的请求方式
        String method=request.getMethod();
        if (method.equalsIgnoreCase("post")) {
            //post请求
            try {
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        if (method.equalsIgnoreCase("get")) {
            //get请求
            Map<String,String[]> parameterMap=request.getParameterMap();
            if (!hasEncode){//确保get手动编码逻辑只运行一次
                for (String key : parameterMap.keySet()) {
                    String[] values = parameterMap.get(key);
                    if (values!=null && values.length>0) {
                        for (int i = 0; i < values.length; i++) {
//处理get乱码
                            try {
                                values[i]=new String(values[i].getBytes("ISO-8859-1"),"utf-8");
                            } catch (UnsupportedEncodingException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
hasEncode=true;
            }
            return parameterMap;
        }
        return super.getParameterMap();
    }

    //取一个值
    @Override
    public String getParameter(String name) {
            Map<String,String[]> parameterMap=getParameterMap();
            String[] values=parameterMap.get(name);
            if (values==null) {
                return null;
            }
            return values[0];//取回参数的第一个值
    }
    //取所有值
    @Override
    public String[] getParameterValues(String name) {
        Map<String,String[]> parameterMap=getParameterMap();
        String[] values=parameterMap.get(name);
        return values;
    }
}


}
