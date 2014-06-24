import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mailcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mail/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(4)
invokeTag('render','g',9,['template':("/menues/mainleft")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('select','g',51,['name':("recepteur"),'from':(application.RH.Effectif.list(username)),'multiple':("multiple"),'optionKey':("id"),'style':("width: 100%; height: 60px;"),'value':(effectifInstance?.id?.username),'class':("many-to-many")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: mailInstance, field: 'objet', 'error'))
printHtmlPart(8)
expressionOut.print(mailInstance?.objet)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: mailInstance, field: 'message', 'error'))
printHtmlPart(10)
expressionOut.print(mailInstance?.message)
printHtmlPart(11)
invokeTag('submitButton','g',60,['name':("create"),'controller':("Mail"),'class':("btn medium btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(12)
})
invokeTag('form','g',63,['url':([action:'save'])],1)
printHtmlPart(13)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043398L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
