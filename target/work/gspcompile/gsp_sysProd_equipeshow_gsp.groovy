import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_equipeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/equipe/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
invokeTag('javascript','g',6,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('render','g',10,['template':("/menues/mainleft")],-1)
printHtmlPart(7)
expressionOut.print(request.contextPath)
printHtmlPart(8)
expressionOut.print(equipeInstance?.nom)
printHtmlPart(9)
expressionOut.print(equipeInstance.id)
printHtmlPart(10)
expressionOut.print(request.contextPath)
printHtmlPart(11)
expressionOut.print(equipeInstance.id)
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
expressionOut.print(equipeInstance.id)
printHtmlPart(14)
expressionOut.print(request.contextPath)
printHtmlPart(15)
expressionOut.print(equipeInstance.id)
printHtmlPart(16)
expressionOut.print(request.contextPath)
printHtmlPart(17)
invokeTag('remoteFunction','g',74,['controller':("message"),'action':("obtenirMessageEffectif"),'update':("contenu2")],-1)
printHtmlPart(18)
invokeTag('remoteFunction','g',91,['controller':("message"),'action':("obtenirMessageEffectif"),'update':("contenu2")],-1)
printHtmlPart(19)
invokeTag('remoteFunction','g',94,['controller':("equipe"),'action':("obtenirKanbanEquipe"),'params':("\'equipe=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(20)
invokeTag('remoteFunction','g',97,['controller':("effectif"),'action':("indicateurEffectif"),'params':("\'effectif=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(21)
invokeTag('remoteFunction','g',100,['controller':("effectif"),'action':("information"),'params':("\'effectif=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(22)
invokeTag('render','g',106,['template':("/menues/mainright")],-1)
printHtmlPart(23)
})
invokeTag('ifLoggedIn','sec',111,[:],1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('link','g',117,['action':("index"),'controller':("login")],2)
printHtmlPart(27)
})
invokeTag('ifNotLoggedIn','sec',1,[:],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401957490603L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
