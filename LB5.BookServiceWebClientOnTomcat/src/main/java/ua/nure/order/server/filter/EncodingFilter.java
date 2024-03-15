package ua.nure.order.server.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String encoding;
	private boolean debugEnabled = false;
	private final Logger log = LoggerFactory.getLogger(EncodingFilter.class);

    public EncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		String requestEncoding = request.getCharacterEncoding();
		log.debug("Request encoding : {}",requestEncoding);
		if (requestEncoding == null) {
			
//			traceMessage(request);
			
			log.debug("Set encoding : {}",encoding);
			request.setCharacterEncoding(encoding);
			
//			traceMessage(request);
		}
		
		// pass the request along the filter chain
		log.debug("Pass to next filter");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
		log.debug("Get encoding from Init Parameter : {}",encoding);
	}
}
