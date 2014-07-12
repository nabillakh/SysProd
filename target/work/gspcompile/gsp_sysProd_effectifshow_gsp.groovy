import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_effectifshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/effectif/show.gsp" }
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
expressionOut.print(effectifInstance?.prenom)
printHtmlPart(8)
expressionOut.print(effectifInstance?.nom)
printHtmlPart(9)
expressionOut.print(request.contextPath)
printHtmlPart(10)
expressionOut.print(effectifInstance?.prenom)
printHtmlPart(8)
expressionOut.print(effectifInstance?.nom)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(effectifInstance?.equipe.nom)
printHtmlPart(13)
})
invokeTag('link','g',29,['action':("show"),'controller':("Equipe"),'id':(" ${effectifInstance.equipe.id}")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
expressionOut.print(request.contextPath)
printHtmlPart(16)
})
invokeTag('link','g',38,['controller':("effectif"),'action':("information"),'id':(effectifInstance.id),'title':("Informations")],2)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(15)
expressionOut.print(request.contextPath)
printHtmlPart(18)
})
invokeTag('link','g',44,['controller':("effectif"),'action':("show"),'id':(effectifInstance.id),'title':("Journal")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(15)
expressionOut.print(request.contextPath)
printHtmlPart(20)
})
invokeTag('link','g',52,['controller':("kanban"),'action':("obtenirKanbanEffectif"),'id':(effectifInstance.id),'title':("Projets")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(15)
expressionOut.print(request.contextPath)
printHtmlPart(22)
})
invokeTag('link','g',59,['controller':("effectif"),'action':("indicateurEffectif"),'id':(effectifInstance.id),'title':("Indicateurs")],2)
printHtmlPart(23)
invokeTag('remoteFunction','g',125,['controller':("message"),'action':("obtenirMessage"),'update':("newsfeed1")],-1)
printHtmlPart(24)
invokeTag('remoteFunction','g',158,['controller':("message"),'action':("posterMessage"),'params':("\'message=\'+message"),'update':("temp")],-1)
printHtmlPart(25)
invokeTag('remoteFunction','g',167,['controller':("message"),'action':("obtenirMessage"),'update':("newsfeed")],-1)
printHtmlPart(26)
invokeTag('render','g',229,['template':("/menues/mainright")],-1)
printHtmlPart(27)
})
invokeTag('ifLoggedIn','sec',234,[:],1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 2)
invokeTag('link','g',240,['action':("index"),'controller':("login")],2)
printHtmlPart(31)
})
invokeTag('ifNotLoggedIn','sec',1,[:],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1404688874749L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
