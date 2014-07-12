import application.PP.Imputation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_imputation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/imputation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: imputationInstance, field: 'event', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("imputation.event.label"),'default':("Event")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("event"),'name':("event.id"),'from':(application.communication.Event.list()),'optionKey':("id"),'required':(""),'value':(imputationInstance?.event?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: imputationInstance, field: 'of', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("imputation.of.label"),'default':("Of")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("of"),'name':("of.id"),'from':(application.PP.OF.list()),'optionKey':("id"),'required':(""),'value':(imputationInstance?.of?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: imputationInstance, field: 'realise', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("imputation.realise.label"),'default':("Realise")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',28,['name':("realise"),'value':(imputationInstance?.realise)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043354L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
