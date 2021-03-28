package com.tx.spring;

/**
 * 发送请求--DispatcherServlet中央处理器--调用HandlerMapping处理器映射器--返回HandlerExecutionChain（包含了所有的处理器拦截器对象）
 * --通过处理器适配器调用具体的处理器（具体的Controller）--返回ModelAndView给DispatcherServlet--
 * 调用视图解析器--解析视图--返回view对象--渲染视图--响应用户
 */
public class SpringMVCRunningProcess {
}
