import application.communication.Event
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_event_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/event/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',6,['code':("Event.TitleKanban.label"),'default':("Titre : ")],-1)
printHtmlPart(1)
invokeTag('textField','g',9,['name':("title"),'value':(eventInstance?.title),'class':("span12")],-1)
printHtmlPart(2)
invokeTag('message','g',14,['code':("Event.location.label"),'default':("Lieu : ")],-1)
printHtmlPart(1)
invokeTag('textField','g',17,['name':("location"),'value':(eventInstance?.location),'class':("span12")],-1)
printHtmlPart(3)
invokeTag('message','g',23,['code':("Event.description.label"),'default':("Description : ")],-1)
printHtmlPart(1)
invokeTag('textField','g',26,['name':("description"),'value':(eventInstance?.description),'class':("span12")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: eventInstance, field: 'startTime', 'error'))
printHtmlPart(5)
invokeTag('message','g',41,['code':("event.startTime.label"),'default':("Start Time")],-1)
printHtmlPart(6)
invokeTag('datePicker','g',42,['name':("startTime"),'precision':("day"),'value':(eventInstance?.startTime)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: eventInstance, field: 'endTime', 'error'))
printHtmlPart(8)
invokeTag('message','g',58,['code':("event.startTime.label"),'default':("End Time")],-1)
printHtmlPart(6)
invokeTag('datePicker','g',59,['name':("endTime"),'precision':("day"),'value':(eventInstance?.endTime)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043337L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
