import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_equipeobtenirKanbanEquipe_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/equipe/obtenirKanbanEquipe.gsp" }
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
createTagBody(2, {->
expressionOut.print(fieldValue(bean: kanbanInstance, field: "nomKanban"))
})
invokeTag('link','g',19,['action':("show"),'controller':("Kanban"),'id':(kanbanInstance.id)],2)
printHtmlPart(3)
expressionOut.print(fieldValue(bean: kanbanInstance, field: "description"))
printHtmlPart(3)
expressionOut.print(kanbanInstance.phaseActuelle?.nom)
printHtmlPart(3)
invokeTag('formatDate','g',22,['date':(kanbanInstance.dateFinPlanifie)],-1)
printHtmlPart(4)
i++
}
}
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043333L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
