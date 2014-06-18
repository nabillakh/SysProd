import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_activiteportefeuille_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/activite/portefeuille.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
invokeTag('javascript','g',8,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
invokeTag('render','g',12,['template':("/menues/mainleft")],-1)
printHtmlPart(6)
expressionOut.print(monKanban.nomKanban)
printHtmlPart(7)
expressionOut.print(monKanban.description)
printHtmlPart(8)
expressionOut.print(monKanban.famille)
printHtmlPart(9)
loop:{
int i = 0
for( famille in (familleInstanceList) ) {
printHtmlPart(10)
expressionOut.print(famille.id)
printHtmlPart(11)
expressionOut.print(famille.nom)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
expressionOut.print(monKanban.ordo)
printHtmlPart(9)
loop:{
int i = 0
for( ordo in (application.PP.Ordonnancement.list()) ) {
printHtmlPart(10)
expressionOut.print(ordo.id)
printHtmlPart(11)
expressionOut.print(ordo.nom)
printHtmlPart(12)
i++
}
}
printHtmlPart(14)
expressionOut.print(monKanban.dateFinPlanifie)
printHtmlPart(15)
expressionOut.print(monKanban.chargePlanifiee)
printHtmlPart(16)
if(true && (mesOF)) {
printHtmlPart(17)
loop:{
int o = 0
for( unOF in (mesOF) ) {
printHtmlPart(18)
expressionOut.print(unOF.kanban.id)
printHtmlPart(19)
expressionOut.print(unOF.kanban.nomKanban)
printHtmlPart(20)
expressionOut.print(unOF.phase.nom)
printHtmlPart(21)
expressionOut.print(unOF.chargePlanifiee)
printHtmlPart(22)
expressionOut.print(unOF.affectes.nom)
printHtmlPart(23)
o++
}
}
printHtmlPart(17)
}
printHtmlPart(24)
invokeTag('remoteFunction','g',286,['action':("listeKanban"),'update':("listeKanbans")],-1)
printHtmlPart(25)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043271L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
