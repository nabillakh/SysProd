import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_OF_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/OF/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: OFInstance, field: 'phase', 'error'))
printHtmlPart(1)
expressionOut.print(OFInstance?.phase?.nom)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: OFInstance, field: 'chargePlanifiee', 'error'))
printHtmlPart(3)
invokeTag('message','g',15,['code':("OF.chargePlanifiee.label"),'default':("Charge Planifiee")],-1)
printHtmlPart(4)
invokeTag('field','g',18,['name':("chargePlanifiee"),'value':(fieldValue(bean: OFInstance, field: 'chargePlanifiee'))],-1)
printHtmlPart(5)
invokeTag('message','g',24,['code':("OF.affectes.label"),'default':("Affectes")],-1)
printHtmlPart(6)
invokeTag('select','g',28,['id':("multiSelect"),'name':("chefProjet"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'class':("span12 with-search")],-1)
printHtmlPart(7)
invokeTag('select','g',29,['id':("multiSelect"),'name':("affectes"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'value':(OFInstance?.affectes*.id),'class':("span12 with-search")],-1)
printHtmlPart(8)
invokeTag('field','g',45,['type':("date"),'name':("dateDebutPlanifie"),'default':(new Date()),'precision':("day")],-1)
printHtmlPart(9)
invokeTag('field','g',58,['type':("date"),'name':("dateFinPlanifie"),'default':(new Date()),'precision':("day")],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043263L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
