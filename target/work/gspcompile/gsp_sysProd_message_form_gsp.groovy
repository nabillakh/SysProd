import application.communication.Message
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_message_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/message/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: messageInstance, field: 'kanban', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("message.kanban.label"),'default':("Kanban")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("kanban"),'name':("kanban.id"),'from':(application.PP.Kanban.list()),'optionKey':("id"),'value':(messageInstance?.kanban?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: messageInstance, field: 'auteur', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("message.auteur.label"),'default':("Auteur")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("auteur"),'name':("auteur.id"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'value':(messageInstance?.auteur?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: messageInstance, field: 'date', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("message.date.label"),'default':("Date")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',28,['name':("date"),'precision':("day"),'value':(messageInstance?.date)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: messageInstance, field: 'message', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("message.message.label"),'default':("Message")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("message"),'value':(messageInstance?.message)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043412L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
