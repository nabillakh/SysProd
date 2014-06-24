import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_kanbanshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/show.gsp" }
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
invokeTag('message','g',99,['code':("kanban.description.label"),'default':("Description : ")],-1)
printHtmlPart(21)
expressionOut.print(kanbanInstance?.description)
printHtmlPart(22)
invokeTag('message','g',104,['code':("kanban.phaseActuelle.label"),'default':("Etat d'avancement du projet : ")],-1)
printHtmlPart(21)
expressionOut.print(kanbanInstance?.phaseActuelle.nom)
printHtmlPart(22)
invokeTag('message','g',109,['code':("kanban.dateFinPlanifie.label"),'default':("Date de fin planifiée : ")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',110,['class':("input-xlarge uneditable-input"),'code':("kanban.dateFinPlanifie.label"),'format':("dd-MM-yyyy"),'date':(kanbanInstance?.dateFinPlanifie)],-1)
printHtmlPart(22)
invokeTag('message','g',114,['code':("kanban.chargePlanifiee.label"),'default':("Charge planifiee : ")],-1)
printHtmlPart(23)
expressionOut.print(kanbanInstance?.chargePlanifiee)
printHtmlPart(22)
invokeTag('message','g',119,['code':("kanban.avancementAgenda.label"),'default':("Charge dans agenda : ")],-1)
printHtmlPart(21)
expressionOut.print(kanbanInstance?.getAvancementAgenda())
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
expressionOut.print(kanbanInstance.chefProjet.nom)
printHtmlPart(25)
expressionOut.print(kanbanInstance.chefProjet.prenom)
printHtmlPart(26)
})
invokeTag('link','g',150,['controller':("Effectif"),'action':("show"),'id':(kanbanInstance.chefProjet.id),'class':("btn-link")],1)
printHtmlPart(27)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(28)
createTagBody(2, {->
expressionOut.print(ofInstance.phase.ordre)
printHtmlPart(29)
expressionOut.print(ofInstance.phase.nom)
printHtmlPart(25)
})
invokeTag('link','g',154,['controller':("OF"),'action':("show"),'id':(ofInstance.id)],2)
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(32)
invokeTag('formatDate','g',157,['format':("dd-MM-yyyy"),'date':(ofInstance.dateFinPlanifie)],-1)
printHtmlPart(33)
i++
}
}
printHtmlPart(34)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(35)
if(true && (ofInstance.affectes)) {
printHtmlPart(36)
loop:{
int j = 0
for( aff in (ofInstance.affectes) ) {
printHtmlPart(37)
createTagBody(4, {->
printHtmlPart(38)
expressionOut.print(aff.effectif.nom)
printHtmlPart(25)
expressionOut.print(aff.effectif.prenom)
printHtmlPart(39)
})
invokeTag('link','g',162,['controller':("Effectif"),'action':("show"),'id':(aff.effectif.id),'class':("btn-link")],4)
printHtmlPart(40)
j++
}
}
}
else {
printHtmlPart(41)
}
printHtmlPart(42)
i++
}
}
printHtmlPart(43)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(44)
i++
}
}
printHtmlPart(45)
expressionOut.print(kanbanInstance.getAvancementRealise())
printHtmlPart(46)
expressionOut.print(kanbanInstance.getAvancementRealise())
printHtmlPart(47)
invokeTag('render','g',225,['template':("/menues/mainright")],-1)
printHtmlPart(48)
expressionOut.print(request.contextPath)
printHtmlPart(49)
expressionOut.print(request.contextPath)
printHtmlPart(50)
expressionOut.print(request.contextPath)
printHtmlPart(51)
expressionOut.print(request.contextPath)
printHtmlPart(52)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401719023178L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
