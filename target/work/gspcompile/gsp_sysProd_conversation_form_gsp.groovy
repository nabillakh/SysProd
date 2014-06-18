import application.communication.Conversation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_conversation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/conversation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: conversationInstance, field: 'mails', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("conversation.mails.label"),'default':("Mails")],-1)
printHtmlPart(2)
for( m in (conversationInstance?.mails) ) {
printHtmlPart(3)
createTagBody(2, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',13,['controller':("mail"),'action':("show"),'id':(m.id)],2)
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'mail.label', default: 'Mail')]))
})
invokeTag('link','g',16,['controller':("mail"),'action':("create"),'params':(['conversation.id': conversationInstance?.id])],1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: conversationInstance, field: 'lastDate', 'error'))
printHtmlPart(7)
invokeTag('message','g',25,['code':("conversation.lastDate.label"),'default':("Last Date")],-1)
printHtmlPart(8)
invokeTag('datePicker','g',28,['name':("lastDate"),'precision':("day"),'value':(conversationInstance?.lastDate)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043291L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
