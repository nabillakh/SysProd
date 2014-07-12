import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_messageobtenirMessageEffectif_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/message/obtenirMessageEffectif.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',60,['name':("kanban"),'id':("monKanban")],-1)
printHtmlPart(1)
invokeTag('remoteFunction','g',73,['controller':("message"),'action':("obtenirMessage"),'update':("newsfeed1")],-1)
printHtmlPart(2)
invokeTag('remoteFunction','g',106,['controller':("message"),'action':("posterMessage"),'params':("\'message=\'+message"),'update':("temp")],-1)
printHtmlPart(3)
invokeTag('remoteFunction','g',115,['controller':("message"),'action':("obtenirMessage"),'update':("newsfeed")],-1)
printHtmlPart(4)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043417L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
