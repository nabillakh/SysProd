import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mail_miniMessagerie_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mail/_miniMessagerie.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (calcul == 1)) {
printHtmlPart(1)
invokeTag('set','g',4,['var':("calcul"),'value':("$calcul+1}")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("counteur"),'value':(0)],-1)
printHtmlPart(3)
loop:{
int i = 0
for( mailEffectifInstance in (mesEffectifsMails) ) {
printHtmlPart(4)
invokeTag('set','g',18,['var':("imagenlu"),'value':(mailEffectifInstance.lu)],-1)
printHtmlPart(5)
invokeTag('set','g',20,['var':("counteur"),'value':(counteur+1)],-1)
printHtmlPart(6)
if(true && (counter <= 4)) {
printHtmlPart(7)
createTagBody(4, {->
printHtmlPart(8)
if(true && (imagenlu == false)) {
printHtmlPart(9)
expressionOut.print(request.contextPath)
printHtmlPart(10)
}
else {
printHtmlPart(9)
expressionOut.print(request.contextPath)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(mailEffectifInstance.mail.objet)
printHtmlPart(13)
expressionOut.print(mailEffectifInstance.mail.author.username)
printHtmlPart(14)
})
invokeTag('link','g',32,['controller':("MailEffectif"),'action':("show"),'id':(mailEffectifInstance.id),'style':(" color :#000000;")],4)
printHtmlPart(7)
expressionOut.print(mailEffectifInstance.mail.message)
printHtmlPart(15)
}
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
}
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043395L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
