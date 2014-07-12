import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_pdpindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pdp/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
invokeTag('javascript','g',9,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(5)
invokeTag('render','g',15,['template':("/menues/mainleft")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(request.contextPath)
printHtmlPart(8)
})
invokeTag('link','g',38,['controller':("kanban"),'action':("show"),'title':("Informations")],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(request.contextPath)
printHtmlPart(10)
})
invokeTag('link','g',44,['controller':("kanban"),'action':("obtenirJournal"),'title':("Journal")],1)
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(request.contextPath)
printHtmlPart(13)
})
invokeTag('link','g',59,['controller':("kanban"),'action':("indicateurKanban"),'title':("Indicateurs")],1)
printHtmlPart(14)
invokeTag('hiddenField','g',86,['name':("kanban"),'id':("monKanban"),'value':("ok")],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',87,['name':("chargePlanifiee"),'id':("chargePlanifiee"),'value':("40")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',105,['name':("monId"),'id':("monId"),'value':("1")],-1)
printHtmlPart(17)
invokeTag('render','g',140,['template':("/menues/mainright")],-1)
printHtmlPart(18)
expressionOut.print(request.contextPath)
printHtmlPart(19)
expressionOut.print(request.contextPath)
printHtmlPart(20)
expressionOut.print(request.contextPath)
printHtmlPart(21)
expressionOut.print(request.contextPath)
printHtmlPart(22)
expressionOut.print(request.contextPath)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1404870539983L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
