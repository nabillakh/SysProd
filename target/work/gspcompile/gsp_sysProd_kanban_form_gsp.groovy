import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_kanban_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(kanbanInstance?.id)
printHtmlPart(1)
invokeTag('message','g',5,['code':("kanban.nomKanban.label"),'default':("Nom du projet")],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['name':("nomKanban"),'class':("span12"),'value':(kanbanInstance?.nomKanban)],-1)
printHtmlPart(3)
invokeTag('message','g',17,['code':("kanban.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',21,['name':("description"),'class':("span12"),'value':(kanbanInstance?.description)],-1)
printHtmlPart(4)
expressionOut.print(kanbanInstance.chefProjet?.id)
printHtmlPart(5)
expressionOut.print(kanbanInstance.chefProjet?.id)
printHtmlPart(6)
expressionOut.print(kanbanInstance.chefProjet?.nom)
printHtmlPart(7)
expressionOut.print(kanbanInstance.chefProjet?.prenom)
printHtmlPart(8)
loop:{
int i = 0
for( ordoInstance in (application.RH.Effectif.list()) ) {
printHtmlPart(9)
expressionOut.print(ordoInstance.id)
printHtmlPart(6)
expressionOut.print(ordoInstance.nom)
printHtmlPart(7)
expressionOut.print(ordoInstance.prenom)
printHtmlPart(8)
i++
}
}
printHtmlPart(10)
expressionOut.print(kanbanInstance.famille?.id)
printHtmlPart(11)
expressionOut.print(kanbanInstance.famille?.id)
printHtmlPart(12)
expressionOut.print(kanbanInstance.famille?.nom)
printHtmlPart(8)
loop:{
int i = 0
for( familleInstance in (application.PP.Famille.list()) ) {
printHtmlPart(9)
expressionOut.print(familleInstance.id)
printHtmlPart(6)
expressionOut.print(familleInstance.nom)
printHtmlPart(8)
i++
}
}
printHtmlPart(13)
expressionOut.print(kanbanInstance.ordo?.id)
printHtmlPart(5)
expressionOut.print(kanbanInstance.ordo?.id)
printHtmlPart(6)
expressionOut.print(kanbanInstance.ordo?.nom)
printHtmlPart(8)
loop:{
int i = 0
for( ordoInstance in (application.PP.Ordonnancement.list()) ) {
printHtmlPart(9)
expressionOut.print(ordoInstance.id)
printHtmlPart(6)
expressionOut.print(ordoInstance.nom)
printHtmlPart(8)
i++
}
}
printHtmlPart(14)
expressionOut.print(dateDeb)
printHtmlPart(15)
expressionOut.print(dateDeb)
printHtmlPart(16)
expressionOut.print(dateFin)
printHtmlPart(15)
expressionOut.print(dateFin)
printHtmlPart(17)
invokeTag('message','g',90,['code':("kanban.charge.label"),'default':("Charge")],-1)
printHtmlPart(2)
invokeTag('field','g',94,['name':("chargePlanifiee"),'value':(kanbanInstance.chargePlanifiee),'class':("span12")],-1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043365L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
