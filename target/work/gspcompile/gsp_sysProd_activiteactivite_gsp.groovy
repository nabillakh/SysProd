import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_activiteactivite_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/activite/activite.gsp" }
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
loop:{
int i = 0
for( kanbanInstance in (kanbanInstanceList) ) {
printHtmlPart(6)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(7)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: kanbanInstance, field: "nomKanban"))
})
invokeTag('link','g',89,['controller':("kanban"),'action':("show"),'id':(kanbanInstance.id)],2)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "description"))
printHtmlPart(8)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "phaseActuelle"))
printHtmlPart(8)
invokeTag('formatDate','g',92,['date':(kanbanInstance.dateFinPlanifie)],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "chargePlanifiee"))
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043268L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
