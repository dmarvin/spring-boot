package com.djm.springbootstart.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

public class HighlightingCompositeConverterEx extends ForegroundCompositeConverterBase<ILoggingEvent> {

	 private static final String[] KEY_WORDS = { "No active profile set", "The following profiles are active", "创建数据库", "Tomcat started on port(s)", "Initializing Spring embedded WebApplicationContext", "Mapping servlet: 'webServlet' to [/h2-console/*]", "Overriding bean definition for bean" };

	 protected String getForegroundColorCode(ILoggingEvent event) {
	    for (String keyWord : KEY_WORDS) {
	      if (event.getMessage().contains(keyWord)) {
	        return "1;31";
	      }
	    }
	    return "39";
	  }

}
