package com.example.filter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

// Servlet <-- http 통신을 확장한 클래스 -- 좀더 많은 기능 좀더 편한 기능을 추가
// 자바언어로 웹 프로그래밍을 하기 위해 만들어진 클래스입니다.
// Filter 기능을 활용하기 위해서는 구현 받아야 한다.

// 로깅처리를 많이 한다.
// url 확인이라던지 특정 코드를 집어 넣어야 할 때 사용을 많이 한다.
@Slf4j
//@Component // 메모리에 올려달라! 컴포넌트 스캔시 Ioc
@WebFilter(urlPatterns = "/api/*") // 해당 주소만 필터 처리
public class GlobarFilter implements Filter{@Override
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		log.info("doFilter 호출 !!!");
		 
		ContentCachingRequestWrapper requestWrapper = 
				new ContentCachingRequestWrapper((HttpServletRequest)request);
		
		ContentCachingResponseWrapper responseWrapper =
				new ContentCachingResponseWrapper((HttpServletResponse)response);
		
		chain.doFilter(requestWrapper, responseWrapper);
		
		// 주의점 : doFilter 다음에 코드를 작성 해야한다.
		// req
		String url = requestWrapper.getRequestURI();
		log.info("request url : {}, request body : {}", url, responseWrapper.getContentAsByteArray());

		// res
		String resContent = new String(requestWrapper.getContentAsByteArray());
		int httpStatusCode = responseWrapper.getStatus();
		// 응답을 처리 하기 위해서 반드시 코드에 추가 해야 한다.
		responseWrapper.copyBodyToResponse();
		log.info("response status : {}, responseBody : {}", httpStatusCode, resContent);
		
}

//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		log.info("제일 먼저 request 에 대해 처리해 보기");
//		
//		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//		log.info("req : {}", httpServletRequest.getProtocol());
//		log.info("req : {}", httpServletRequest.getHeaderNames().toString());
//		
//		HttpServletResponse servletResponse = (HttpServletResponse) response;
//		log.info("res : {} ", servletResponse.getBufferSize());
//		// API Controller 까지 못가고 있음 !!!
//		// 기본적으로 한번 읽은 request 는 다시 읽을수 없다. !!!
//		// 해결 방안
//		
//	
//	}

}
