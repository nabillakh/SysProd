import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_phaseshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/phase/show.gsp" }
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
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(4)
invokeTag('render','g',9,['template':("/menues/mainleft")],-1)
printHtmlPart(5)
if(true && (phaseInstance?.nom)) {
printHtmlPart(6)
invokeTag('message','g',61,['code':("phase.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',61,['bean':(phaseInstance),'field':("nom")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (phaseInstance?.cleRepartition)) {
printHtmlPart(9)
invokeTag('message','g',69,['code':("phase.cleRepartition.label"),'default':("cleRepartition : ")],-1)
invokeTag('fieldValue','g',69,['bean':(phaseInstance),'field':("cleRepartition")],-1)
printHtmlPart(7)
}
printHtmlPart(10)
if(true && (phaseInstance?.competence)) {
printHtmlPart(11)
invokeTag('message','g',77,['code':("phase.competence.label"),'default':("competence : ")],-1)
invokeTag('fieldValue','g',77,['bean':(phaseInstance),'field':("competence.nom")],-1)
printHtmlPart(7)
}
printHtmlPart(12)
if(true && (phaseInstance?.monOrdo.nom)) {
printHtmlPart(13)
invokeTag('message','g',84,['code':("phase.monOrdo.label"),'default':("monOrdo : ")],-1)
invokeTag('fieldValue','g',84,['bean':(phaseInstance),'field':("monOrdo.nom")],-1)
printHtmlPart(7)
}
printHtmlPart(14)
if(true && (phaseInstance?.kanbans)) {
printHtmlPart(15)
for( o in (phaseInstance.kanbans) ) {
printHtmlPart(16)
invokeTag('message','g',92,['code':("phase.kanbans.label"),'default':("Kanban : ")],-1)
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(o?.nomKanban.encodeAsHTML())
})
invokeTag('link','g',92,['controller':("kanbans"),'action':("show"),'id':(o.id)],3)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (phaseInstance?.ordre)) {
printHtmlPart(21)
invokeTag('message','g',101,['code':("phase.ordre.label"),'default':("monOrdo : ")],-1)
invokeTag('fieldValue','g',101,['bean':(phaseInstance),'field':("ordre")],-1)
printHtmlPart(7)
}
printHtmlPart(22)
if(true && (phaseInstance?.nom)) {
printHtmlPart(6)
invokeTag('message','g',151,['code':("phase.nom.label"),'default':("Nom : ")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (phaseInstance?.cleRepartition)) {
printHtmlPart(9)
invokeTag('message','g',159,['code':("phase.cleRepartition.label"),'default':("cleRepartition : ")],-1)
printHtmlPart(7)
}
printHtmlPart(10)
if(true && (phaseInstance?.competence)) {
printHtmlPart(11)
invokeTag('message','g',167,['code':("phase.competence.label"),'default':("competence : ")],-1)
printHtmlPart(7)
}
printHtmlPart(12)
if(true && (phaseInstance?.monOrdo.nom)) {
printHtmlPart(13)
invokeTag('message','g',174,['code':("phase.monOrdo.label"),'default':("monOrdo : ")],-1)
printHtmlPart(7)
}
printHtmlPart(14)
if(true && (phaseInstance?.kanbans)) {
printHtmlPart(15)
for( o in (phaseInstance.kanbans) ) {
printHtmlPart(16)
invokeTag('message','g',182,['code':("phasekanbans.label"),'default':("Kanban : ")],-1)
printHtmlPart(17)
invokeTag('link','g',182,['controller':("kanbans"),'action':("show"),'id':(o.id)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (phaseInstance?.ordre)) {
printHtmlPart(21)
invokeTag('message','g',191,['code':("phase.ordre.label"),'default':("monOrdo : ")],-1)
printHtmlPart(7)
}
printHtmlPart(23)
createClosureForHtmlPart(24, 1)
invokeTag('link','g',209,['action':("activite"),'controller':("administration"),'class':("btn medium")],1)
printHtmlPart(25)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401957521164L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
