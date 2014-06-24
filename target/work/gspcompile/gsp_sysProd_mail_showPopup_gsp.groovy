import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mail_showPopup_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mail/_showPopup.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(eventInstance.title)
printHtmlPart(1)
invokeTag('formatDate','g',6,['date':((occurrenceStart).toDate()),'format':("E, MMM d, hh:mma")],-1)
printHtmlPart(2)
invokeTag('formatDate','g',7,['date':((occurrenceEnd).toDate()),'format':("E, MMM d, hh:mma")],-1)
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('link','g',10,['action':("show"),'id':(eventInstance.id),'params':([occurrenceStart: occurrenceStart, occurrenceEnd: occurrenceEnd])],1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043396L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
