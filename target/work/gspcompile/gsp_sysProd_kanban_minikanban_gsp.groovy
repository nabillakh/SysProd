import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_kanban_minikanban_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/_minikanban.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (affichageKanban == 1)) {
printHtmlPart(1)
invokeTag('set','g',4,['var':("affichageKanban"),'value':("$affichageKanban+1}")],-1)
printHtmlPart(2)
loop:{
int i = 0
for( monOF in (mesOF) ) {
printHtmlPart(3)
createTagBody(3, {->
printHtmlPart(4)
expressionOut.print(monOF.kanban.nomKanban)
printHtmlPart(5)
expressionOut.print(monOF.phase.nom)
printHtmlPart(6)
expressionOut.print(monOF.getChargeRealisee() / monOF.chargePlanifiee *100)
printHtmlPart(7)
})
invokeTag('link','g',15,['controller':("kanban"),'action':("show"),'id':(monOF.kanban.id)],3)
printHtmlPart(8)
expressionOut.print(monOF.getChargeRealisee() / monOF.chargePlanifiee *100)
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401777797927L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
