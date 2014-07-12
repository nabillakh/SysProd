import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_ordonnancementshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ordonnancement/show.gsp" }
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
if(true && (ordonnancementInstance?.nom)) {
printHtmlPart(6)
invokeTag('message','g',62,['code':("ordonnancement.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',62,['bean':(ordonnancementInstance),'field':("nom")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (ordonnancementInstance?.famille)) {
printHtmlPart(9)
invokeTag('message','g',70,['code':("ordonnancement.famille.label"),'default':("Famille : ")],-1)
invokeTag('fieldValue','g',70,['bean':(ordonnancementInstance),'field':("famille")],-1)
printHtmlPart(7)
}
printHtmlPart(10)
if(true && (ordonnancementInstance?.nom)) {
printHtmlPart(6)
invokeTag('message','g',121,['code':("ordonnancement.nom.label"),'default':("Nom : ")],-1)
invokeTag('fieldValue','g',121,['bean':(ordonnancementInstance),'field':("nom")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (ordonnancementInstance?.famille)) {
printHtmlPart(9)
invokeTag('message','g',129,['code':("ordonnancement.famille.label"),'default':("Famille : ")],-1)
invokeTag('fieldValue','g',129,['bean':(ordonnancementInstance),'field':("famille")],-1)
printHtmlPart(7)
}
printHtmlPart(11)
createClosureForHtmlPart(12, 1)
invokeTag('link','g',148,['action':("activite"),'controller':("administration"),'class':("btn medium")],1)
printHtmlPart(13)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401957513542L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
