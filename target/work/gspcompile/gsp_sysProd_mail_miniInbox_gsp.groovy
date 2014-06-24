import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mail_miniInbox_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mail/_miniInbox.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (affichage == 1)) {
printHtmlPart(1)
invokeTag('set','g',4,['var':("affichage"),'value':("$affichage+1}")],-1)
printHtmlPart(2)
expressionOut.print(request.contextPath)
printHtmlPart(3)
expressionOut.print(mailNonLu.size())
printHtmlPart(4)
expressionOut.print(mailNonLu.size())
printHtmlPart(5)
invokeTag('set','g',22,['var':("counter"),'value':(0)],-1)
printHtmlPart(6)
loop:{
int i = 0
for( mailEffectifInstance in (mesEffectifsMails) ) {
printHtmlPart(7)
invokeTag('set','g',24,['var':("imagenlu"),'value':(mailEffectifInstance.lu)],-1)
printHtmlPart(7)
invokeTag('set','g',25,['var':("counter"),'value':(counter+1)],-1)
printHtmlPart(8)
if(true && (counter <= 4)) {
printHtmlPart(9)
if(true && (imagenlu == false)) {
printHtmlPart(10)
expressionOut.print(request.contextPath)
printHtmlPart(11)
}
else {
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
expressionOut.print(mailEffectifInstance.mail.objet)
printHtmlPart(16)
expressionOut.print(mailEffectifInstance.mail.author.username)
printHtmlPart(17)
expressionOut.print(mailEffectifInstance.mail.message)
printHtmlPart(18)
})
invokeTag('link','g',45,['controller':("MailEffectif"),'action':("show"),'id':(mailEffectifInstance.id)],4)
printHtmlPart(19)
}
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
createClosureForHtmlPart(22, 2)
invokeTag('link','g',53,['action':("index"),'controller':("mail"),'id':("go-to-inbox")],2)
printHtmlPart(23)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043394L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
