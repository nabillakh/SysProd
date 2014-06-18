import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mail_listmessages_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mail/_listmessages.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (listcompteur == 1)) {
printHtmlPart(0)
invokeTag('set','g',2,['var':("listcompteur"),'value':(listcompteur+1)],-1)
printHtmlPart(1)
expressionOut.print(request.contextPath)
printHtmlPart(2)
expressionOut.print(request.contextPath)
printHtmlPart(3)
expressionOut.print(mailNonLu.size())
printHtmlPart(4)
expressionOut.print(mailNonLu.size())
printHtmlPart(5)
loop:{
int i = 0
for( mailEffectifInstance in (mesEffectifsMails) ) {
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
expressionOut.print(mailEffectifInstance.mail.author.username)
printHtmlPart(8)
expressionOut.print(mailEffectifInstance.mail.objet)
printHtmlPart(9)
expressionOut.print(mailEffectifInstance.mail.message)
printHtmlPart(10)
})
invokeTag('link','g',30,['controller':("MailEffectif"),'action':("show"),'id':(mailEffectifInstance.id)],3)
printHtmlPart(11)
i++
}
}
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
loop:{
int i = 0
for( mailInstance in (mesMailsSent) ) {
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
expressionOut.print(mailInstance.recepteur.recepteur.username)
printHtmlPart(16)
expressionOut.print(mailInstance.objet)
printHtmlPart(17)
expressionOut.print(mailInstance.message)
printHtmlPart(18)
})
invokeTag('link','g',52,['controller':("Mail"),'action':("show"),'id':(mailInstance.id)],3)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
expressionOut.print(request.contextPath)
printHtmlPart(21)
loop:{
int i = 0
for( mailEffectifArchiverInstance in (mesEffectifMailsArchiver) ) {
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
expressionOut.print(mailEffectifArchiverInstance.mail.author.username)
printHtmlPart(8)
expressionOut.print(mailEffectifArchiverInstance.mail.objet)
printHtmlPart(9)
expressionOut.print(mailEffectifArchiverInstance.mail.message)
printHtmlPart(10)
})
invokeTag('link','g',70,['controller':("MailEffectif"),'action':("show"),'id':(mailEffectifArchiverInstance.id)],3)
printHtmlPart(11)
i++
}
}
printHtmlPart(22)
expressionOut.print(request.contextPath)
printHtmlPart(23)
loop:{
int i = 0
for( mesmailEffectifFavorisInstance in (mesmailEffectifFavoris) ) {
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
expressionOut.print(mesmailEffectifFavorisInstance.mail.author.username)
printHtmlPart(8)
expressionOut.print(mesmailEffectifFavorisInstance.mail.objet)
printHtmlPart(9)
expressionOut.print(mesmailEffectifFavorisInstance.mail.message)
printHtmlPart(10)
})
invokeTag('link','g',87,['controller':("MailEffectif"),'action':("show"),'id':(mesmailEffectifFavorisInstance.id)],3)
printHtmlPart(11)
i++
}
}
printHtmlPart(24)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043392L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
