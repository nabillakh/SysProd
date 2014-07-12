import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_kanbaninformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/information.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(request.contextPath)
printHtmlPart(1)
expressionOut.print(request.contextPath)
printHtmlPart(2)
invokeTag('message','g',19,['code':("kanban.description.label"),'default':("Description : ")],-1)
printHtmlPart(3)
expressionOut.print(kanbanInstance?.description)
printHtmlPart(4)
invokeTag('message','g',24,['code':("kanban.phaseActuelle.label"),'default':("Etat d'avancement du projet : ")],-1)
printHtmlPart(3)
expressionOut.print(kanbanInstance?.phaseActuelle.nom)
printHtmlPart(4)
invokeTag('message','g',29,['code':("kanban.dateFinPlanifie.label"),'default':("Date de fin planifiée : ")],-1)
printHtmlPart(5)
invokeTag('formatDate','g',30,['class':("input-xlarge uneditable-input"),'code':("kanban.dateFinPlanifie.label"),'format':("dd-MM-yyyy"),'date':(kanbanInstance?.dateFinPlanifie)],-1)
printHtmlPart(4)
invokeTag('message','g',34,['code':("kanban.chargePlanifiee.label"),'default':("Charge planifiee : ")],-1)
printHtmlPart(5)
expressionOut.print(kanbanInstance?.chargePlanifiee)
printHtmlPart(4)
invokeTag('message','g',39,['code':("kanban.avancementAgenda.label"),'default':("Charge dans agenda : ")],-1)
printHtmlPart(3)
expressionOut.print(kanbanInstance?.getAvancementAgenda())
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(kanbanInstance.chefProjet.nom)
printHtmlPart(7)
expressionOut.print(kanbanInstance.chefProjet.prenom)
printHtmlPart(8)
})
invokeTag('link','g',70,['controller':("Effectif"),'action':("show"),'id':(kanbanInstance.chefProjet.id),'class':("btn-link")],1)
printHtmlPart(9)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(10)
createTagBody(2, {->
expressionOut.print(ofInstance.phase.ordre)
printHtmlPart(11)
expressionOut.print(ofInstance.phase.nom)
printHtmlPart(7)
})
invokeTag('link','g',74,['controller':("OF"),'action':("show"),'id':(ofInstance.id)],2)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(14)
invokeTag('formatDate','g',77,['format':("dd-MM-yyyy"),'date':(ofInstance.dateFinPlanifie)],-1)
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(17)
if(true && (ofInstance.affectes)) {
printHtmlPart(18)
loop:{
int j = 0
for( aff in (ofInstance.affectes) ) {
printHtmlPart(19)
createTagBody(4, {->
printHtmlPart(20)
expressionOut.print(aff.effectif.nom)
printHtmlPart(7)
expressionOut.print(aff.effectif.prenom)
printHtmlPart(21)
})
invokeTag('link','g',82,['controller':("Effectif"),'action':("show"),'id':(aff.effectif.id),'class':("btn-link")],4)
printHtmlPart(22)
j++
}
}
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
loop:{
int i = 0
for( ofInstance in (ofs) ) {
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
expressionOut.print(kanbanInstance.getAvancementRealise())
printHtmlPart(28)
expressionOut.print(kanbanInstance.getAvancementRealise())
printHtmlPart(29)
expressionOut.print(request.contextPath)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401716443673L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
