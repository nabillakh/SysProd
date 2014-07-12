import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_kanban_formOf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/_formOf.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(OFInstance?.phase?.nom)
printHtmlPart(1)
if(true && (flash.message)) {
printHtmlPart(2)
expressionOut.print(flash.message)
printHtmlPart(3)
}
printHtmlPart(4)
expressionOut.print(OFInstance?.phase?.id)
printHtmlPart(5)
invokeTag('message','g',18,['code':("OF.chargePlanifiee.label"),'default':("Charge Planifiee")],-1)
printHtmlPart(6)
invokeTag('field','g',21,['name':("chargePlanifiee"),'value':(fieldValue(bean: OFInstance, field: 'chargePlanifiee'))],-1)
printHtmlPart(7)
invokeTag('message','g',27,['code':("OF.affectes.label"),'default':("Affectes")],-1)
printHtmlPart(8)
invokeTag('select','g',30,['id':("multiSelect"),'multiple':("multiple"),'name':("affectes"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'value':(OFInstance?.affectes*.id),'class':("span12 with-search")],-1)
printHtmlPart(9)
invokeTag('field','g',43,['type':("date"),'name':("dateDebutPlanifie"),'default':(new Date()),'precision':("day")],-1)
printHtmlPart(10)
invokeTag('field','g',53,['type':("date"),'name':("dateFinPlanifie"),'default':(new Date()),'precision':("day")],-1)
printHtmlPart(11)
invokeTag('remoteFunction','g',74,['controller':("message"),'action':("obtenirMessage"),'params':("\'kanban=\' + kanban"),'update':("chatMessages")],-1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043368L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
