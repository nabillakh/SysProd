import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mailindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mail/index.gsp" }
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
createClosureForHtmlPart(6, 1)
invokeTag('link','g',40,['action':("create"),'controller':("mail"),'class':("btn medium btn-primary pull-right")],1)
printHtmlPart(7)
loop:{
int i = 0
for( mesConversationsInstance in (mesConversations) ) {
printHtmlPart(8)
invokeTag('set','g',58,['var':("conv"),'value':(" ${mesConversationsInstance.id}")],-1)
printHtmlPart(9)
loop:{
int j = 0
for( meslastmailInstance in (meslastmail) ) {
printHtmlPart(10)
invokeTag('set','g',60,['var':("last"),'value':(" ${meslastmailInstance.conversation.id}")],-1)
printHtmlPart(11)
if(true && (conv == last)) {
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
expressionOut.print(meslastmailInstance.author.username)
printHtmlPart(14)
expressionOut.print(meslastmailInstance.objet)
printHtmlPart(15)
expressionOut.print(meslastmailInstance.message)
})
invokeTag('link','g',66,['controller':("Mail"),'action':("ShowConversation"),'id':(mesConversationsInstance.id)],4)
printHtmlPart(16)
}
printHtmlPart(17)
j++
}
}
printHtmlPart(18)
expressionOut.print(i)
printHtmlPart(19)
loop:{
int j = 0
for( mailEffectifInstance in (mesEffectifsMails) ) {
printHtmlPart(10)
if(true && (mesConversations.mails.contains(mailEffectifInstance.mail))) {
printHtmlPart(20)
createTagBody(4, {->
printHtmlPart(21)
expressionOut.print(fieldValue(bean: mailEffectifInstance, field: "mail.message"))
printHtmlPart(22)
})
invokeTag('link','g',77,['controller':("MailEffectif"),'action':("show"),'id':(mailEffectifInstance.id)],4)
printHtmlPart(23)
}
printHtmlPart(24)
j++
}
}
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('set','g',95,['var':("listcompteur"),'value':(1)],-1)
printHtmlPart(27)
createClosureForHtmlPart(28, 1)
invokeTag('listMessagerie','messagerie',97,[:],1)
printHtmlPart(29)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1404689077115L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
