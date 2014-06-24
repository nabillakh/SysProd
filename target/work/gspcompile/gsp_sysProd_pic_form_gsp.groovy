import application.pilotage.Pic
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_pic_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pic/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: picInstance, field: 'dateVersion', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("pic.dateVersion.label"),'default':("Date Version")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("dateVersion"),'precision':("day"),'value':(picInstance?.dateVersion),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: picInstance, field: 'dateMaj', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("pic.dateMaj.label"),'default':("Date Maj")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',19,['name':("dateMaj"),'precision':("day"),'value':(picInstance?.dateMaj),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: picInstance, field: 'annee', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("pic.annee.label"),'default':("Annee")],-1)
printHtmlPart(6)
invokeTag('field','g',28,['name':("annee"),'type':("number"),'value':(picInstance.annee),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: picInstance, field: 'picFamille', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("pic.picFamille.label"),'default':("Pic Famille")],-1)
printHtmlPart(2)
invokeTag('select','g',37,['name':("picFamille"),'from':(application.pilotage.PicFamille.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(picInstance?.picFamille*.id),'class':("many-to-many")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043444L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
