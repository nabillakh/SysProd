import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_kanbanindicateurKanban_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/indicateurKanban.gsp" }
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
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(kanbanInstance.nomKanban)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
invokeTag('javascript','g',6,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
invokeTag('render','g',12,['template':("/menues/mainleft")],-1)
printHtmlPart(6)
expressionOut.print(request.contextPath)
printHtmlPart(7)
expressionOut.print(kanbanInstance?.nomKanban)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
expressionOut.print(kanbanInstance?.famille.nom)
printHtmlPart(10)
})
invokeTag('link','g',29,['action':("show"),'controller':("Famille"),'id':(kanbanInstance.famille.id)],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
})
invokeTag('link','g',38,['controller':("kanban"),'action':("show"),'id':(kanbanInstance.id),'title':("Informations")],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(15)
})
invokeTag('link','g',44,['controller':("kanban"),'action':("obtenirJournal"),'id':(kanbanInstance.id),'title':("Journal")],1)
printHtmlPart(16)
expressionOut.print(kanbanInstance.id)
printHtmlPart(17)
expressionOut.print(request.contextPath)
printHtmlPart(18)
createTagBody(1, {->
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(19)
})
invokeTag('link','g',59,['controller':("kanban"),'action':("indicateurKanban"),'id':(kanbanInstance.id),'title':("Indicateurs")],1)
printHtmlPart(20)
invokeTag('hiddenField','g',88,['name':("monId"),'id':("monId"),'value':(kanbanInstance.id)],-1)
printHtmlPart(21)
loop:{
int k = 0
for( ofInstance in (kanbanInstance.of) ) {
printHtmlPart(22)
expressionOut.print(ofInstance.phase.nom)
printHtmlPart(23)
expressionOut.print(ofInstance.chargeAgenda / ofInstance.chargePlanifiee * 100)
printHtmlPart(24)
expressionOut.print(ofInstance.chargeAgenda)
printHtmlPart(25)
expressionOut.print(ofInstance.chargePlanifiee)
printHtmlPart(26)
k++
}
}
printHtmlPart(27)
invokeTag('hiddenField','g',131,['name':("kanban"),'id':("monKanban"),'value':(kanbanInstance.nomKanban)],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',132,['name':("chargePlanifiee"),'id':("chargePlanifiee"),'value':(kanbanInstance.chargePlanifiee)],-1)
printHtmlPart(29)
invokeTag('render','g',164,['template':("/menues/mainright")],-1)
printHtmlPart(30)
expressionOut.print(request.contextPath)
printHtmlPart(31)
expressionOut.print(request.contextPath)
printHtmlPart(32)
expressionOut.print(request.contextPath)
printHtmlPart(33)
expressionOut.print(request.contextPath)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401956629826L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
