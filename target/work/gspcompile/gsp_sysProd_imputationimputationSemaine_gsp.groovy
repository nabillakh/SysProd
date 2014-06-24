import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_imputationimputationSemaine_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/imputation/imputationSemaine.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( ligne in (lignes) ) {
printHtmlPart(1)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(2)
createTagBody(2, {->
expressionOut.print(ligne.get("Of").kanban.nomKanban)
})
invokeTag('link','g',25,['action':("show"),'controller':("Kanban"),'id':(ligne.get("Of").kanban.id),'class':("btn-link"),'data-toggle':("tooltip"),'title':("afficher le projet")],2)
printHtmlPart(3)
expressionOut.print(ligne.get("Of").phase.nom)
printHtmlPart(4)
expressionOut.print(ligne.get("Lundi")*.eventEffectif.event.dureeHeures.sum())
printHtmlPart(5)
expressionOut.print(i)
printHtmlPart(6)
expressionOut.print(ligne.get("Lundi").id)
printHtmlPart(7)
expressionOut.print(i)
printHtmlPart(8)
expressionOut.print(ligne.get("Mardi")*.eventEffectif.event.dureeHeures.sum())
printHtmlPart(9)
expressionOut.print(i)
printHtmlPart(6)
expressionOut.print(ligne.get("Mardi").id)
printHtmlPart(10)
expressionOut.print(i)
printHtmlPart(8)
expressionOut.print(ligne.get("Mercredi")*.eventEffectif.event.dureeHeures.sum())
printHtmlPart(11)
expressionOut.print(i)
printHtmlPart(6)
expressionOut.print(ligne.get("Mercredi").id)
printHtmlPart(12)
expressionOut.print(i)
printHtmlPart(8)
expressionOut.print(ligne.get("Jeudi")*.eventEffectif.event.dureeHeures.sum())
printHtmlPart(13)
expressionOut.print(i)
printHtmlPart(6)
expressionOut.print(ligne.get("Jeudi").id)
printHtmlPart(14)
expressionOut.print(i)
printHtmlPart(8)
expressionOut.print(ligne.get("Vendredi")*.eventEffectif.event.dureeHeures.sum())
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(6)
expressionOut.print(ligne.get("Vendredi").id)
printHtmlPart(16)
expressionOut.print(i)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
expressionOut.print(lignes.size())
printHtmlPart(19)
createClosureForHtmlPart(20, 1)
invokeTag('link','g',70,['action':("imputer"),'controller':("imputation"),'class':(" btn btn-warning pull-right")],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043359L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
