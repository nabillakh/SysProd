import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_competenceshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/competence/show.gsp" }
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
if(true && (competenceInstance?.nom)) {
printHtmlPart(6)
invokeTag('message','g',61,['code':("Competence.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',61,['bean':(competenceInstance),'field':("nom")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (competenceInstance?.effectifs)) {
printHtmlPart(9)
for( o in (competenceInstance.effectifs) ) {
printHtmlPart(10)
invokeTag('message','g',71,['code':("competence.effectifs.label"),'default':("Effectifs associés : ")],-1)
printHtmlPart(11)
createTagBody(3, {->
expressionOut.print(o?.nom.encodeAsHTML())
})
invokeTag('link','g',71,['controller':("Effectif"),'action':("show"),'id':(o.id)],3)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (competenceInstance?.nom)) {
printHtmlPart(6)
invokeTag('message','g',121,['code':("Competence.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',121,['bean':(competenceInstance),'field':("nom")],-1)
printHtmlPart(7)
}
printHtmlPart(15)
if(true && (competenceInstance?.effectifs)) {
printHtmlPart(9)
for( o in (competenceInstance.effectifs) ) {
printHtmlPart(10)
invokeTag('message','g',130,['code':("competence.effectifs.label"),'default':("Effectifs associés : ")],-1)
printHtmlPart(11)
createTagBody(3, {->
expressionOut.print(o?.nom.encodeAsHTML())
})
invokeTag('link','g',130,['controller':("Effectif"),'action':("show"),'id':(o.id)],3)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(16)
createClosureForHtmlPart(17, 1)
invokeTag('link','g',149,['action':("ressource"),'controller':("administration"),'class':("btn medium")],1)
printHtmlPart(18)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401957150820L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
