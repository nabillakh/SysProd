import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_administrationactivite_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/administration/activite.gsp" }
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
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(4)
invokeTag('render','g',10,['template':("/menues/mainleft")],-1)
printHtmlPart(5)
expressionOut.print(request.contextPath)
printHtmlPart(6)
expressionOut.print(request.contextPath)
printHtmlPart(7)
expressionOut.print(request.contextPath)
printHtmlPart(8)
expressionOut.print(request.contextPath)
printHtmlPart(9)
loop:{
int i = 0
for( familleInstance in (familleInstanceList) ) {
printHtmlPart(10)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(11)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: familleInstance, field: "nom"))
})
invokeTag('link','g',117,['action':("show"),'controller':("famille"),'id':(familleInstance.id)],2)
printHtmlPart(12)
expressionOut.print(familleInstance.chargePlanifiee)
printHtmlPart(12)
expressionOut.print(familleInstance.ordo.size())
printHtmlPart(12)
expressionOut.print(familleInstance.nbProjets)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
loop:{
int i = 0
for( ordoInstance in (ordoInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: ordoInstance, field: "nom"))
})
invokeTag('link','g',147,['action':("show"),'controller':("Ordonnancement"),'id':(ordoInstance.id)],2)
printHtmlPart(17)
expressionOut.print(ordoInstance.famille)
printHtmlPart(17)
expressionOut.print(ordoInstance.phases.size())
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
loop:{
int i = 0
for( phaseInstance in (phaseInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: phaseInstance, field: "nom"))
})
invokeTag('link','g',181,['action':("show"),'controller':("phase"),'id':(phaseInstance.id)],2)
printHtmlPart(17)
expressionOut.print(phaseInstance.monOrdo.nom)
printHtmlPart(17)
expressionOut.print(phaseInstance.competence.nom)
printHtmlPart(17)
expressionOut.print(phaseInstance.kanbans.size())
printHtmlPart(18)
i++
}
}
printHtmlPart(20)
loop:{
int i = 0
for( kanbanInstance in (kanbanInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: kanbanInstance, field: "nomKanban"))
})
invokeTag('link','g',217,['action':("show"),'controller':("kanban"),'id':(kanbanInstance.id)],2)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "description"))
printHtmlPart(17)
expressionOut.print(kanbanInstance.phaseActuelle.nom)
printHtmlPart(17)
invokeTag('formatDate','g',220,['format':("dd-MM-yyyy"),'date':(kanbanInstance.dateFinPlanifie)],-1)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "chargePlanifiee"))
printHtmlPart(18)
i++
}
}
printHtmlPart(21)
invokeTag('render','g',251,['template':("/menues/mainright")],-1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043273L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
