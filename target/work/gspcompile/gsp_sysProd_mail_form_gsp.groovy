import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mail_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mail/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: mailInstance, field: 'message', 'error'))
printHtmlPart(1)
invokeTag('message','g',4,['code':("mail.message.label"),'default':("Message")],-1)
printHtmlPart(2)
invokeTag('textField','g',7,['name':("message"),'value':(mailInstance?.message)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mailInstance, field: 'recepteur', 'error'))
printHtmlPart(4)
invokeTag('message','g',13,['code':("mail.recepteur.label"),'default':("Recepteur")],-1)
printHtmlPart(2)
invokeTag('select','g',16,['name':("recepteur"),'from':(application.RH.Effectif.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(mailInstance?.recepteur*.id),'class':("many-to-many")],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043391L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
