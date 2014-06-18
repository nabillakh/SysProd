import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_kanban_maToDo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/_maToDo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (affichageToDo == 1)) {
printHtmlPart(1)
invokeTag('set','g',4,['var':("affichageToDo"),'value':("$affichageToDo+1}")],-1)
printHtmlPart(2)
expressionOut.print(maCharge)
printHtmlPart(3)
expressionOut.print(maCharge)
printHtmlPart(4)
loop:{
int i = 0
for( monOF in (maToDo) ) {
printHtmlPart(5)
expressionOut.print(monOF.kanban.nomKanban)
printHtmlPart(6)
expressionOut.print(monOF.phase.nom)
printHtmlPart(7)
expressionOut.print(monOF.getChargeRealisee() / monOF.chargePlanifiee *100)
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
public static final long LAST_MODIFIED = 1401189043369L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
