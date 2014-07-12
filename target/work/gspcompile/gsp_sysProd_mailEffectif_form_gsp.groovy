import application.communication.MailEffectif
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mailEffectif_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailEffectif/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: mailEffectifInstance, field: 'lu', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("mailEffectif.lu.label"),'default':("Lu")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',10,['name':("lu"),'value':(mailEffectifInstance?.lu)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mailEffectifInstance, field: 'mail', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("mailEffectif.mail.label"),'default':("Mail")],-1)
printHtmlPart(5)
invokeTag('select','g',19,['id':("mail"),'name':("mail.id"),'from':(application.communication.Mail.list()),'optionKey':("id"),'required':(""),'value':(mailEffectifInstance?.mail?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mailEffectifInstance, field: 'recepteur', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("mailEffectif.recepteur.label"),'default':("Recepteur")],-1)
printHtmlPart(5)
invokeTag('select','g',28,['id':("recepteur"),'name':("recepteur.id"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'value':(mailEffectifInstance?.recepteur?.id),'class':("many-to-one")],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043404L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
