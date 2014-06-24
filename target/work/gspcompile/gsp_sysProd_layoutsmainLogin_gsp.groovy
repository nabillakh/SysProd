import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_layoutsmainLogin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/mainLogin.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',7,['default':("SysProd")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("HandheldFriendly"),'content':("True")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("MobileOptimized"),'content':("320")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")],-1)
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',66,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-capable"),'content':("yes")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',67,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-status-bar-style"),'content':("black")],-1)
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',69,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-title"),'content':("Jarvis")],-1)
printHtmlPart(6)
invokeTag('layoutHead','g',77,[:],-1)
printHtmlPart(7)
invokeTag('javascript','g',78,[:],-1)
printHtmlPart(7)
invokeTag('layoutResources','r',79,[:],-1)
printHtmlPart(8)
expressionOut.print(request.contextPath)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',87,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
invokeTag('layoutBody','g',93,[:],-1)
printHtmlPart(11)
invokeTag('layoutResources','r',95,[:],-1)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',242,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043386L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
