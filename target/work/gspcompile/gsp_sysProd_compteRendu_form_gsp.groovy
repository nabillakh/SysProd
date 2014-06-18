import application.PP.CompteRendu
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_compteRendu_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/compteRendu/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: compteRenduInstance, field: 'of', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("compteRendu.of.label"),'default':("Of")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("of"),'name':("of.id"),'from':(application.PP.OF.list()),'optionKey':("id"),'value':(compteRenduInstance?.of?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: compteRenduInstance, field: 'kanban', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("compteRendu.kanban.label"),'default':("Kanban")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("kanban"),'name':("kanban.id"),'from':(application.PP.Kanban.list()),'optionKey':("id"),'value':(compteRenduInstance?.kanban?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: compteRenduInstance, field: 'author', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("compteRendu.author.label"),'default':("Author")],-1)
printHtmlPart(6)
invokeTag('select','g',28,['id':("author"),'name':("author.id"),'from':(application.RH.Effectif.list()),'optionKey':("id"),'required':(""),'value':(compteRenduInstance?.author?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: compteRenduInstance, field: 'message', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("compteRendu.message.label"),'default':("Message")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("message"),'value':(compteRenduInstance?.message)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043285L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
