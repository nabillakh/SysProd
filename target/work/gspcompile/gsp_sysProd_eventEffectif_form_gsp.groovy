import application.communication.EventEffectif
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_eventEffectif_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventEffectif/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: eventEffectifInstance, field: 'dateCreation', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("eventEffectif.dateCreation.label"),'default':("Date Creation")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("dateCreation"),'precision':("day"),'value':(eventEffectifInstance?.dateCreation)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventEffectifInstance, field: 'event', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("eventEffectif.event.label"),'default':("Event")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("event"),'name':("event.id"),'from':(application.communication.Event.list()),'optionKey':("id"),'required':(""),'value':(eventEffectifInstance?.event?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventEffectifInstance, field: 'participe', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("eventEffectif.participe.label"),'default':("Participe")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',28,['name':("participe"),'value':(eventEffectifInstance?.participe)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: eventEffectifInstance, field: 'recepteur', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("eventEffectif.recepteur.label"),'default':("Recepteur")],-1)
printHtmlPart(2)
invokeTag('select','g',37,['id':("recepteur"),'name':("recepteur.id"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'value':(eventEffectifInstance?.recepteur?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043343L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
