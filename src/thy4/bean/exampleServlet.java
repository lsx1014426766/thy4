package thy4.bean;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


public class exampleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
	    	ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
	        // XHTML is the default mode, but we will set it anyway for better understanding of code
	        templateResolver.setTemplateMode("XHTML");
	        templateResolver.setPrefix("/WEB-INF/");
	        templateResolver.setSuffix(".html");
	        templateResolver.setCacheTTLMs(3600000L);
	        TemplateEngine templateEngine = new TemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver);
	        WebContext ctx = new WebContext(req, resp, getServletConfig().getServletContext(), req.getLocale());
	        // This will be prefixed with /WEB-INF/ and suffixed with .html
	        ctx.setVariable("today", Calendar.getInstance());  
	        List<String> arrayList = new ArrayList<String>();  
	        arrayList.add("Value Sample 1");  
	        arrayList.add("Value Sample 2");  
	        List<String> albumIntrolist = new ArrayList<String>(); 
	        albumIntrolist.add("albumIntrolist Sample 2");  
	        albumIntrolist.add("albumIntrolist Sample 2");  
	        TreeSet<String> set = new TreeSet<String>();  
	        set.add("Set Sample 1");  
	        set.add("Set Sample 2");  
	        set.add("Set Sample 3");  
	  
	        ctx.setVariable("contextValue", "Store Context Value");  
	        ctx.setVariable("listExample", arrayList);  
	        ctx.setVariable("setExample", set); 
	        ctx.setVariable("albumIntrolist", albumIntrolist);  
	  
	        req.getSession().setAttribute("sessionValue", "Store Session Value"); 
	        templateEngine.process("thymeleaf", ctx, resp.getWriter());
	        resp.setContentType("text/html;charset=UTF-8");
	        resp.setHeader("Pragma", "no-cache");
	        resp.setHeader("Cache-Control", "no-cache");
	        resp.setDateHeader("Expires", 1000);
		}
	}