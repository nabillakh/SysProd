import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_loginauthentifier_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/authentifier.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("HandheldFriendly"),'content':("True")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("MobileOptimized"),'content':("320")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")],-1)
printHtmlPart(6)
invokeTag('captureMeta','sitemesh',82,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-capable"),'content':("yes")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',83,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-status-bar-style"),'content':("black")],-1)
printHtmlPart(7)
invokeTag('captureMeta','sitemesh',85,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-title"),'content':("Jarvis")],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',92,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
expressionOut.print(postUrl)
printHtmlPart(11)
expressionOut.print(rememberMeParameter)
printHtmlPart(12)
if(true && (hasCookie)) {
printHtmlPart(13)
}
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',346,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043388L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
