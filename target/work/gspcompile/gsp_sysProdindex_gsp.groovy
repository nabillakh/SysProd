import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProdindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
invokeTag('javascript','g',7,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('render','g',12,['template':("/menues/mainleft")],-1)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('username','sec',26,[:],-1)
printHtmlPart(9)
})
invokeTag('ifLoggedIn','sec',28,[:],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(12)
})
invokeTag('link','g',47,['controller':("effectif"),'action':("show"),'id':(sec.loggedInUserInfo(field:"id")),'title':("Mon mur")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(14)
})
invokeTag('link','g',54,['controller':("kanban"),'action':("obtenirKanbanEffectif"),'id':(sec.loggedInUserInfo(field:"id")),'title':("Projets")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(16)
})
invokeTag('link','g',62,['controller':("effectif"),'action':("indicateurEffectif"),'id':(sec.loggedInUserInfo(field:"id")),'title':("Mes indicateurs")],2)
printHtmlPart(17)
invokeTag('hiddenField','g',145,['name':("kanban"),'id':("monKanban")],-1)
printHtmlPart(18)
invokeTag('remoteFunction','g',158,['controller':("message"),'action':("obtenirMessage"),'update':("newsfeed1")],-1)
printHtmlPart(19)
invokeTag('remoteFunction','g',199,['controller':("message"),'action':("posterMessage"),'params':("\'message=\'+message"),'update':("temp")],-1)
printHtmlPart(20)
invokeTag('remoteFunction','g',208,['controller':("message"),'action':("obtenirMessage"),'update':("newsfeed")],-1)
printHtmlPart(21)
invokeTag('render','g',257,['template':("/menues/mainright")],-1)
printHtmlPart(22)
})
invokeTag('ifLoggedIn','sec',259,[:],1)
printHtmlPart(23)
createTagBody(1, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 2)
invokeTag('link','g',265,['action':("index"),'controller':("login")],2)
printHtmlPart(26)
})
invokeTag('ifNotLoggedIn','sec',266,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1404782097935L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
