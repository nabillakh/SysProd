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
expressionOut.print(equipeInstance?.nom)
printHtmlPart(8)
expressionOut.print(request.contextPath)
printHtmlPart(9)
expressionOut.print(equipeInstance?.nom)
printHtmlPart(10)
expressionOut.print(equipeInstance.id)
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(12)
expressionOut.print(equipeInstance.id)
printHtmlPart(13)
expressionOut.print(request.contextPath)
printHtmlPart(14)
expressionOut.print(equipeInstance.id)
printHtmlPart(15)
expressionOut.print(request.contextPath)
printHtmlPart(16)
expressionOut.print(equipeInstance.id)
printHtmlPart(17)
expressionOut.print(request.contextPath)
printHtmlPart(18)
invokeTag('remoteFunction','g',81,['controller':("message"),'action':("obtenirMessageEffectif"),'update':("contenu2")],-1)
printHtmlPart(19)
invokeTag('remoteFunction','g',98,['controller':("message"),'action':("obtenirMessageEffectif"),'update':("contenu2")],-1)
printHtmlPart(20)
invokeTag('remoteFunction','g',101,['controller':("equipe"),'action':("obtenirKanbanEquipe"),'params':("\'equipe=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(21)
invokeTag('remoteFunction','g',104,['controller':("effectif"),'action':("indicateurEffectif"),'params':("\'effectif=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(22)
invokeTag('remoteFunction','g',107,['controller':("effectif"),'action':("information"),'params':("\'effectif=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(23)
invokeTag('render','g',113,['template':("/menues/mainright")],-1)
printHtmlPart(24)
})
invokeTag('ifLoggedIn','sec',118,[:],1)
printHtmlPart(25)
createTagBody(1, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 2)
invokeTag('link','g',124,['action':("index"),'controller':("login")],2)
printHtmlPart(28)
})
invokeTag('ifNotLoggedIn','sec',1,[:],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1404688988045L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
