import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_activitelisteKanban_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/activite/listeKanban.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( kanbanInstance in (kanbanInstanceList) ) {
printHtmlPart(1)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(2)
expressionOut.print(i)
printHtmlPart(3)
expressionOut.print(kanbanInstance.id)
printHtmlPart(4)
expressionOut.print(kanbanInstance.id)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "nomKanban"))
printHtmlPart(7)
})
invokeTag('link','g',15,['action':("show"),'controller':("kanban"),'id':(kanbanInstance.id)],2)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "description"))
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043270L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
