import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_effectifindicateurEffectif_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/effectif/indicateurEffectif.gsp" }
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
expressionOut.print(effectifInstance?.prenom)
printHtmlPart(9)
expressionOut.print(effectifInstance?.nom)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(effectifInstance?.equipe.nom)
printHtmlPart(12)
})
invokeTag('link','g',23,['action':("show"),'controller':("Equipe"),'id':(" ${effectifInstance.equipe.id}")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(request.contextPath)
printHtmlPart(15)
})
invokeTag('link','g',32,['controller':("effectif"),'action':("information"),'id':(effectifInstance.id),'title':("Informations")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(request.contextPath)
printHtmlPart(17)
})
invokeTag('link','g',38,['controller':("effectif"),'action':("show"),'id':(effectifInstance.id),'title':("Journal")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(request.contextPath)
printHtmlPart(19)
})
invokeTag('link','g',46,['controller':("kanban"),'action':("obtenirKanbanEffectif"),'id':(effectifInstance.id),'title':("Projets")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(request.contextPath)
printHtmlPart(21)
})
invokeTag('link','g',53,['controller':("effectif"),'action':("indicateurEffectif"),'id':(effectifInstance.id),'title':("Indicateurs")],2)
printHtmlPart(22)
invokeTag('hiddenField','g',87,['name':("messagesKanban"),'id':("messagesKanban"),'value':(messagesKanban)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',88,['name':("messagesAutre"),'id':("messagesAutre"),'value':(messagesAutre)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',89,['name':("messagesKanbanMoyen"),'id':("messagesKanbanMoyen"),'value':(messagesKanbanMoyen)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',90,['name':("messagesAutreMoyen"),'id':("messagesAutreMoyen"),'value':(messagesAutreMoyen)],-1)
printHtmlPart(24)
invokeTag('render','g',116,['template':("/menues/mainright")],-1)
printHtmlPart(25)
})
invokeTag('ifLoggedIn','sec',121,[:],1)
printHtmlPart(26)
createTagBody(1, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 2)
invokeTag('link','g',127,['action':("index"),'controller':("login")],2)
printHtmlPart(29)
})
invokeTag('ifNotLoggedIn','sec',128,[:],1)
printHtmlPart(30)
expressionOut.print(request.contextPath)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401719863682L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
