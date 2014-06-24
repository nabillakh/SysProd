import application.communication.Commentaire
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_commentaire_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/commentaire/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: commentaireInstance, field: 'auteur', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("commentaire.auteur.label"),'default':("Auteur")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("auteur"),'name':("auteur.id"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'value':(commentaireInstance?.auteur?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: commentaireInstance, field: 'date', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("commentaire.date.label"),'default':("Date")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',19,['name':("date"),'precision':("day"),'value':(commentaireInstance?.date)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: commentaireInstance, field: 'message', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("commentaire.message.label"),'default':("Message")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['id':("message"),'name':("message.id"),'from':(application.communication.Message.list()),'optionKey':("id"),'required':(""),'value':(commentaireInstance?.message?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: commentaireInstance, field: 'texte', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("commentaire.texte.label"),'default':("Texte")],-1)
printHtmlPart(7)
invokeTag('textField','g',37,['name':("texte"),'value':(commentaireInstance?.texte)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403186757519L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
